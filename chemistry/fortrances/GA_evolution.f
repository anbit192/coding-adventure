cccccccccccccccccccc THIS CODE FROM David L. Carroll cccccccccccccccccccccccccccc

      SUBROUTINE GADNA
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension parent(nparmax,indmax),child(nparmax,indmax)
      dimension fitness(indmax),nposibl(nparmax),nichflg(nparmax)
      dimension iparent(nchrmax,indmax),ichild(nchrmax,indmax)
      dimension g0(nparmax),g1(nparmax),ig2(nparmax)
      dimension ibest(nchrmax)
      dimension parmax(nparmax),parmin(nparmax),pardel(nparmax)
      dimension geni(1000000),genavg(1000000),genmax(1000000)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga4   / fitness
      common / ga5   / g0,g1,ig2
      common / ga6   / parmax,parmin,pardel,nposibl
      common / ga7   / child,ichild
      common / ga8   / nichflg
	common /ga10   / best0,irand
	common /ga11   / parentold(nparmax,indmax),fitnessold(indmax),kelite
      common /inputga/ pcross,pmutate,pcreep,maxgen,idum,irestrt,
     +                 itourny,ielite,icreep,iunifrm,iniche,
     +                 iskip,iend,nchild,microga,kountmx
      common/GA/ betas(100),ichange(21),icall
	
	COMMON /GARUN/ MSTATUS,NSTATUS
	COMMON /GAFUN/ NFV,BFUNC(100)        
	CHARACTER*20 DINP,DOUT
	COMMON /DIRGA/ DINP,DOUT,LCINP,LCOUT
	COMMON /RESULT/ fbest,jfbest,nbest,nloop
	nbest=1

      call INPUT_GA
	icall=0
	do i=1,indmax
		do k=1,nparmax
			parentold(k,i)=0.d0
		end do
		fitnessold(i)=0.d0
	end do 
c  Perform necessary initialization and read the ga.restart file.
      call initial(istart,npossum,ig2sum)
	nloop=istart-1
	open(unit=21,file=DOUT(:LCOUT)//'funcval.out')
	open(unit=27,file=DOUT(:LCOUT)//'random.out')	   !random next
c  $$$$$ Main generational processing loop. $$$$$
      kount=0
      do 20 i=istart,maxgen+istart-1
         write (6,1111) i
         write (24,1111) i
         write(24,1050)
c  Evaluate the population, assign fitness, establish the best
c  individual, and write output information.
         call evalout(iskip,iend,ibest,fbar,best)
         geni(i)=float(i)
         genavg(i)=fbar
         genmax(i)=best
	   write(*,'(i6,F20.12,2i5)') i,genmax(i),jfbest,nbest

         if(npopsiz.eq.1 .or. iskip.ne.0) then
            close(24)
            stop
         endif
c  Implement "niching".
         if (iniche.ne.0) call niche
c  Enter selection, crossover and mutation loop.
         ncross=0
         ipick=npopsiz
         do 45 j=1,npopsiz,nchild
c  Perform selection.
            call selectn(ipick,j,mate1,mate2)
c  Now perform crossover between the randomly selected pair.
            call crosovr(ncross,j,mate1,mate2)
 45      continue
         write(6,1225) ncross
         write(24,1225) ncross
c  Now perform random mutations.  If running micro-GA, skip mutation.
         if (microga.eq.0) call mutate
c  Write child array back into parent array for new generation.  Check
c  to see if the best parent was replicated.
         call newgen(ielite,npossum,ig2sum,ibest)
c  Implement micro-GA if enabled.
         if (microga.ne.0) call gamicro(i,npossum,ig2sum,ibest)
c  Write to restart file.
         call restart(i,kount)
 20   continue
c  $$$$$ End of main generational processing loop. $$$$$

      BFUNC(NSTATUS)=best				 ! The Last 
	call possibl(parent,iparent)	 ! The Last
	IF (MSTATUS.EQ.1) THEN
	 CALL GAGM_LASTCONFIG(irand)	 ! The Last
	ENDIF
	IF (MSTATUS.EQ.2) THEN
	 CALL GAMM_LASTCONFIG(irand)	 ! The Last
	ENDIF

	CLOSE (24)
	close(21)
	close(27)   !random next
	close(6)
	WRITE(*,*) 'GA Loop completed'
 1050 format(1x,
     *' #      Binary Code',16x,'Param1  Param2        Fitness')
 1111 format(//'#################  Generation',i8,'  #################')
 1225 format(/'  Number of Crossovers      =',i8)
 3000 format(2x//'Summary of Output'/
     +       2x,'Generation   Evaluations   Avg.Fitness   Best Fitness')
 3100 format(2x,3(e10.4,4x),e11.5)
      end

c
c#######################################################################
      subroutine INPUT_GA
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension nposibl(nparmax),nichflg(nparmax)
      dimension parmax(nparmax),parmin(nparmax),pardel(nparmax)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga6   / parmax,parmin,pardel,nposibl
      common / ga8   / nichflg
      common /inputga/ pcross,pmutate,pcreep,maxgen,idum,irestrt,
     +                 itourny,ielite,icreep,iunifrm,iniche,
     +                 iskip,iend,nchild,microga,kountmx

	CHARACTER*20 DINP,DOUT
	COMMON /DIRGA/ DINP,DOUT,LCINP,LCOUT
c
      namelist / ga   / irestrt,npopsiz,pmutate,maxgen,idum,pcross,
     +                  itourny,ielite,icreep,pcreep,iunifrm,iniche,
     +                  iskip,iend,nchild,nparam,parmin,parmax,nposibl,
     +                  nowrite,nichflg,microga,kountmx
c
      kountmx=100 !gia tri khoi tao, doc ga.inp se tu thay doi theo input
      irestrt=0 !gia tri khoi tao, doc ga.inp se tu thay doi theo input
      itourny=0
      ielite=0
      iunifrm=0
      iniche=0
      iskip=0
      iend=0
      nchild=1
      do 2 i=1,nparmax
         nichflg(i)=1
 2    continue
      microga=0		   
c
      OPEN (UNIT=24, FILE=DOUT(:LCOUT)//'ga.out', STATUS='UNKNOWN')
      rewind 24
      OPEN (UNIT=23, FILE=DINP(:LCINP)//'ga.inp', STATUS='OLD')
      READ (23, NML = ga)
      CLOSE (23)

      itourny=1
      if (npopsiz.gt.indmax) then
         write(6,1600) npopsiz
         write(24,1600) npopsiz
         close(24)
         stop
      endif
      if (nparam.gt.nparmax) then
         write(6,1700) nparam
         write(24,1700) nparam
         close(24)
         stop
      endif
c  If using the microga option, reset some input variables
	 write(*,*) ' microga = ',microga
      if (microga.ne.0) then
         pmutate=0.0d0
         pcreep=0.0d0
         itourny=1
         ielite=1
         iniche=0
         nchild=1
         if (iunifrm.eq.0) then
            pcross=1.0d0
         else
            pcross=0.5d0
         endif
      endif
c
 1600 format(1x,'ERROR: npopsiz > indmax.  Set indmax = ',i6)
 1700 format(1x,'ERROR: nparam > nparmax.  Set nparmax = ',i6)
c
      return
      end
c
c#######################################################################
      subroutine initial(istart,npossum,ig2sum)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)

      dimension parent(nparmax,indmax),iparent(nchrmax,indmax)
      dimension nposibl(nparmax)
      dimension g0(nparmax),g1(nparmax),ig2(nparmax)
      dimension parmax(nparmax),parmin(nparmax),pardel(nparmax)
c
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga5   / g0,g1,ig2
      common / ga6   / parmax,parmin,pardel,nposibl
      common /inputga/ pcross,pmutate,pcreep,maxgen,idum,irestrt,
     +                 itourny,ielite,icreep,iunifrm,iniche,
     +                 iskip,iend,nchild,microga,kountmx

	CHARACTER*20 DINP,DOUT
	COMMON /DIRGA/ DINP,DOUT,LCINP,LCOUT
      common /random/ inext,inextp,hj,ha(55)       !random next
c
      do 3 i=1,nparam
         g0(i)=parmin(i)
         pardel(i)=parmax(i)-parmin(i)
         g1(i)=pardel(i)/dble(nposibl(i)-1)
 3    continue
      do 6 i=1,nparam
         do 7 j=1,30
            n2j=2**j
            if (n2j.ge.nposibl(i)) then
               ig2(i)=j
               goto 8
            endif
            if (j.ge.30) then
               write(6,2000)
               write(24,2000)
               close(24)
               stop
            endif
 7       continue
 8       continue
 6    continue
c  Count the total number of chromosomes (bits) required
      nchrome=0
      npossum=0
      ig2sum=0
      do 9 i=1,nparam
         nchrome=nchrome+ig2(i)
         npossum=npossum+nposibl(i)
         ig2sum=ig2sum+(2**ig2(i))
 9    continue
	write(*,*) ' nchrome = ',nchrome
	write(*,*)
      if (nchrome.gt.nchrmax) then
         write(6,1800) nchrome
         write(24,1800) nchrome
         close(24)
         stop
      endif

      if (npossum.lt.ig2sum .and. microga.ne.0) then
         write(6,2100)
         write(24,2100)
      endif
c  Initialize random number generator
      call ran3(idum,rand)

      if(irestrt.eq.0) then
         istart=1
         do 10 i=1,npopsiz
            do 15 j=1,nchrome
               call ran3(1,rand)
               iparent(j,i)=1
               if(rand.lt.0.5d0) iparent(j,i)=0
 15         continue
 10      continue
         if (npossum.lt.ig2sum) call possibl(parent,iparent)
      else
c  If irestrt.ne.0, read from restart file.
         OPEN(UNIT=25,FILE=DOUT(:LCOUT)//'ga.restart',STATUS='UNKNOWN')
         rewind 25
         read(25,*) istart,npopsiz
         do 1 j=1,npopsiz
            read(25,*) k,(iparent(l,j),l=1,nchrome)
 1       continue
         read(25,*) inext,inextp,hj,(ha(l),l=1,55)      !random next
	   idum=1										  !random next
         CLOSE (25)
      endif

 1800 format(1x,'ERROR: nchrome > nchrmax.  Set nchrmax = ',i6)
 2000 format(1x,'ERROR: You have a parameter with a number of '/
     +       1x,'   possibilities > 2**30!  If you really desire this,'/
     +       1x,'   change the DO loop 7 statement and recompile.'//
     +       1x,'   You may also need to alter the code to work with'/
     +       1x,'   REAL numbers rather than INTEGER numbers; Fortran'/
     +       1x,'   does not like to compute 2**j when j>30.')
 2100 format(1x,'WARNING: for some cases, a considerable performance'/
     +       1x,'   reduction has been observed when running a non-'/
     +       1x,'   optimal number of bits with the micro-GA.'/
     +       1x,'   If possible, use values for nposibl of 2**n,'/
     +       1x,'   e.g. 2, 4, 8, 16, 32, 64, etc.  See ReadMe file.')
      return
      end
c
c#######################################################################
      subroutine evalout(iskip,iend,ibest,fbar,best)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension parent(nparmax,indmax),iparent(nchrmax,indmax)
      dimension fitness(indmax)
      dimension paramsm(nparmax),paramav(nparmax),ibest(nchrmax)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga4   / fitness
	common /ga10   / best0,irand
	common /ga11/parentold(nparmax,indmax),fitnessold(indmax),kelite
	COMMON /RESULT/ fbest,jfbest,nbest,nloop

      fitsum=0.0d0
      best=-1.0d10
      do 29 n=1,nparam
         paramsm(n)=0.0d0
 29   continue
      jstart=1
      jend=npopsiz
      if(iskip.ne.0) jstart=iskip
      if(iend.ne.0) jend=iend

      do 30 j=jstart,jend
         call decode(j,parent,iparent)
         if(iskip.ne.0 .and. iend.ne.0 .and. iskip.eq.iend)
     +   write(6,1075) j,(iparent(k,j),k=1,nchrome),
     +                   (parent(kk,j),kk=1,nparam),0.0

          call func(j,funcval)
	
c		if (j.eq.irand) then
c			if ((funcval.lt.best0).and.(kelite.eq.0)) funcval=best0
c		endif

 1111     fitness(j)=funcval

		write(24,'(i3,1x,50i1)')j,(iparent(k,j),k=1,nchrome)
		write(24,'(1x,10f10.4)')(parent(kk,j),kk=1,nparam),fitness(j)
		
         fitsum=fitsum+fitness(j)
         do 22 n=1,nparam
            paramsm(n)=paramsm(n)+parent(n,j)
 22      continue
c  Check to see if fitness of individual j is the best fitness.
         if (fitness(j).gt.best) then
            best=fitness(j)
            jbest=j
            do 24 k=1,nchrome
               ibest(k)=iparent(k,j)
 24         continue
         endif
 30   continue
	 best0=best

	if (best.EQ.fbest) then			 ! Advance
	 nbest=nbest+1					 ! Advance	 
	else							 ! Advance
	 nbest=1						 ! Advance
	 fbest=best		                 ! Advance
	endif							 ! Advance
	jfbest=jbest	  				 ! Advance
	nloop=nloop+1					 ! Advance
c  Compute parameter and fitness averages.
      fbar=fitsum/dble(npopsiz)
      do 23 n=1,nparam
         paramav(n)=paramsm(n)/dble(npopsiz)
 23   continue
c  Write output information
      if (npopsiz.eq.1) then
	   write(24,'(i3,1x,50i1)')1,(iparent(k,1),k=1,nchrome)
	   write(24,'(1x,10f10.4)')(parent(k,1),k=1,nparam),fitness(1)
         write(24,*) ' Average Values:'
         write(24,1275) (parent(k,1),k=1,nparam),fbar
      else
         write(24,1275) (paramav(k),k=1,nparam),fbar
      endif
      write(6,1100) fbar
      write(24,1100) fbar
      write(6,1200) best, jbest
      write(24,1200) best, jbest	 
	write(21,'(i5,2E25.15,2i5)') nloop,fbar, best, jbest, nbest

 1075 format(i3,1x,31i1,3(1x,f7.4),1x,f12.5)
			   !
 1100 format(1x,'Average Function Value of Generation=',f12.5)
 1200 format(1x,'Maximum Function Value              =',f12.5,i7/)
 1275 format(/' Average Values:',5x,11(1x,f10.4)/)
      return
      end
c
c#######################################################################
      subroutine niche
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension parent(nparmax,indmax),iparent(nchrmax,indmax)
      dimension fitness(indmax),nposibl(nparmax),nichflg(nparmax)
      dimension parmax(nparmax),parmin(nparmax),pardel(nparmax)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga4   / fitness
      common / ga6   / parmax,parmin,pardel,nposibl
      common / ga8   / nichflg

      sigshar=0.1d0
      nniche=0
      do 33 jj=1,nparam
         nniche=nniche+nichflg(jj)
 33   continue
      if (nniche.eq.0) then
         write(6,1900)
         write(24,1900)
         close(24)
         stop
      endif
      do 34 ii=1,npopsiz
         sumshar=0.0d0
         do 35 j=1,npopsiz
            del2=0.0d0
            do 36 k=1,nparam
               if (nichflg(k).ne.0) then
                  del2=del2+((parent(k,j)-parent(k,ii))/pardel(k))**2
               endif
 36         continue
            del=(dsqrt(del2))/dble(nniche)
            if (del.lt.sigshar) then
               share=1.0d0-(del/sigshar)
            else
               share=0.0d0
            endif
            sumshar=sumshar+share/dble(npopsiz)
 35      continue
         if (sumshar.ne.0.0d0) fitness(ii)=fitness(ii)/sumshar
 34   continue

 1900 format(1x,'ERROR: iniche=1 and all values in nichflg array = 0'/
     +       1x,'       Do you want to niche or not?')
      return
      end
c
c#######################################################################
      subroutine selectn(ipick,j,mate1,mate2)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension parent(nparmax,indmax),child(nparmax,indmax)
      dimension fitness(indmax)
      dimension iparent(nchrmax,indmax),ichild(nchrmax,indmax)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga4   / fitness
      common / ga7   / child,ichild
      common /inputga/ pcross,pmutate,pcreep,maxgen,idum,irestrt,
     +                 itourny,ielite,icreep,iunifrm,iniche,
     +                 iskip,iend,nchild,microga,kountmx

      if(itourny.eq.1) then
         call select(mate1,ipick)
         call select(mate2,ipick)
         do 46 n=1,nchrome
            ichild(n,j)=iparent(n,mate1)
            if(nchild.eq.2) ichild(n,j+1)=iparent(n,mate2)
 46      continue
      endif
c
      return
      end
c
c#######################################################################
      subroutine crosovr(ncross,j,mate1,mate2)
      implicit real*8 (a-h,o-z)
      save
c
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension parent(nparmax,indmax),child(nparmax,indmax)
      dimension iparent(nchrmax,indmax),ichild(nchrmax,indmax)
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga7   / child,ichild
      common /inputga/ pcross,pmutate,pcreep,maxgen,idum,irestrt,
     +                 itourny,ielite,icreep,iunifrm,iniche,
     +                 iskip,iend,nchild,microga,kountmx

      if (iunifrm.eq.0) then
c  Single-point crossover at a random chromosome point.
         call ran3(1,rand)
         if(rand.gt.pcross) goto 69
         ncross=ncross+1
         call ran3(1,rand)
         icross=2+dint(dble(nchrome-1)*rand)
         do 50 n=icross,nchrome
            ichild(n,j)=iparent(n,mate2)
            if(nchild.eq.2) ichild(n,j+1)=iparent(n,mate1)
 50      continue
      else
c  Perform uniform crossover between the randomly selected pair.
         do 60 n=1,nchrome
            call ran3(1,rand)
            if(rand.le.pcross) then
               ncross=ncross+1
               ichild(n,j)=iparent(n,mate2)
               if(nchild.eq.2) ichild(n,j+1)=iparent(n,mate1)
            endif
 60      continue
      endif
 69   continue

      return
      end
c
c#######################################################################
      subroutine mutate
c
      implicit real*8 (a-h,o-z)
      save
c
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension nposibl(nparmax)
      dimension child(nparmax,indmax),ichild(nchrmax,indmax)
      dimension g0(nparmax),g1(nparmax),ig2(nparmax)
      dimension parmax(nparmax),parmin(nparmax),pardel(nparmax)
c
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga5   / g0,g1,ig2
      common / ga6   / parmax,parmin,pardel,nposibl
      common / ga7   / child,ichild
      common /inputga/ pcross,pmutate,pcreep,maxgen,idum,irestrt,
     +                 itourny,ielite,icreep,iunifrm,iniche,
     +                 iskip,iend,nchild,microga,kountmx
      nmutate=0
      ncreep=0
      do 70 j=1,npopsiz
         do 75 k=1,nchrome
c  Jump mutation
            call ran3(1,rand)
            if (rand.le.pmutate) then
               nmutate=nmutate+1
               if(ichild(k,j).eq.0) then
                  ichild(k,j)=1
               else
                  ichild(k,j)=0
               endif
               if (nowrite.eq.0) write(6,1300) j,k
               if (nowrite.eq.0) write(24,1300) j,k
            endif
 75      continue
c  Creep mutation (one discrete position away).
         if (icreep.ne.0) then
            do 76 k=1,nparam
               call ran3(1,rand)
               if(rand.le.pcreep) then
                  call decode(j,child,ichild)
                  ncreep=ncreep+1
                  creep=1.0d0
                  call ran3(1,rand)
                  if (rand.lt.0.5d0) creep=-1.0d0
                  child(k,j)=child(k,j)+g1(k)*creep
                  if (child(k,j).gt.parmax(k)) then
                     child(k,j)=parmax(k)-1.0d0*g1(k)
                  elseif (child(k,j).lt.parmin(k)) then
                     child(k,j)=parmin(k)+1.0d0*g1(k)
                  endif
                  call code(j,k,child,ichild)
                  if (nowrite.eq.0) write(6,1350) j,k
                  if (nowrite.eq.0) write(24,1350) j,k
               endif
 76         continue
         endif
 70   continue
      write(6,1250) nmutate,ncreep
      write(24,1250) nmutate,ncreep
c
 1250 format(/'  Number of Jump Mutations  =',i8/
     +        '  Number of Creep Mutations =',i8)
 1300 format('*** Jump mutation performed on individual  ',i4,
     +       ', chromosome ',i3,' ***')
 1350 format('*** Creep mutation performed on individual ',i4,
     +       ', parameter  ',i3,' ***')
c
      return
      end
c
c#######################################################################
      subroutine newgen(ielite,npossum,ig2sum,ibest)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension parent(nparmax,indmax),child(nparmax,indmax)
      dimension iparent(nchrmax,indmax),ichild(nchrmax,indmax)
      dimension ibest(nchrmax)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga7   / child,ichild
	common /ga10   / best,irand
	common /ga11/parentold(nparmax,indmax),fitnessold(indmax),kelite

      if (npossum.lt.ig2sum) call possibl(child,ichild)
      kelite=0
      do 94 j=1,npopsiz
         jelite=0
         do 95 n=1,nchrome
            iparent(n,j)=ichild(n,j)
            if (iparent(n,j).eq.ibest(n)) jelite=jelite+1
            if (jelite.eq.nchrome) kelite=1
 95      continue
 94   continue
	 write(24,*) ' kelite =',kelite
	 write(6,*)  ' kelite =',kelite
      if (ielite.ne.0 .and. kelite.eq.0) then
         call ran3(1,rand)
         irand=1d0+dint(dble(npopsiz)*rand)
         do 96 n=1,nchrome
            iparent(n,irand)=ibest(n)
 96      continue
         write(24,1260) irand
	WRITE(6,1260) IRAND
      endif

 1260 format('  Elitist Reproduction on Individual ',i4)

      return
      end
c
c#######################################################################
      subroutine gamicro(i,npossum,ig2sum,ibest)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      dimension parent(nparmax,indmax),iparent(nchrmax,indmax)
      dimension ibest(nchrmax)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent

      icount=0
      do 81 j=1,npopsiz
         do 82 n=1,nchrome
            if(iparent(n,j).ne.ibest(n)) icount=icount+1
 82      continue
 81   continue

      diffrac=dble(icount)/dble((npopsiz-1)*nchrome)
      if (diffrac.lt.0.05d0) then
      do 87 n=1,nchrome
         iparent(n,1)=ibest(n)
 87   continue
      do 88 j=2,npopsiz
         do 89 n=1,nchrome
            call ran3(1,rand)
            iparent(n,j)=1
            if(rand.lt.0.5d0) iparent(n,j)=0
 89      continue
 88   continue
      if (npossum.lt.ig2sum) call possibl(parent,iparent)
      write(6,1375) i
      write(24,1375) i
      endif

 1375 format(//'%%%%%%%  Restart micro-population at generation',
     +       i8,'  %%%%%%%')

      return
      end
c
c#######################################################################
      subroutine select(mate,ipick)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga4   / fitness
      dimension parent(nparmax,indmax),iparent(nchrmax,indmax)
      dimension fitness(indmax)

      if(ipick+1.gt.npopsiz) call shuffle(ipick)
      ifirst=ipick
      isecond=ipick+1
      ipick=ipick+2
      if(fitness(ifirst).gt.fitness(isecond)) then
         mate=ifirst
      else
         mate=isecond
      endif

      return
      end
c
c#######################################################################
      subroutine shuffle(ipick)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common / ga4   / fitness
      dimension parent(nparmax,indmax),iparent(nchrmax,indmax)
      dimension fitness(indmax)

      ipick=1
      do 10 j=1,npopsiz-1
         call ran3(1,rand)
         iother=j+1+dint(dble(npopsiz-j)*rand)
         do 20 n=1,nchrome
            itemp=iparent(n,iother)
            iparent(n,iother)=iparent(n,j)
            iparent(n,j)=itemp
 20      continue
         temp=fitness(iother)
         fitness(iother)=fitness(j)
         fitness(j)=temp
 10   continue

      return
      end
c
c#######################################################################
      subroutine decode(i,array,iarray)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      common / ga2   / nparam,nchrome
      common / ga5   / g0,g1,ig2
      dimension array(nparmax,indmax),iarray(nchrmax,indmax)
      dimension g0(nparmax),g1(nparmax),ig2(nparmax)

      l=1
      do 10 k=1,nparam
         iparam=0
         m=l
         do 20 j=m,m+ig2(k)-1
            l=l+1
            iparam=iparam+iarray(j,i)*(2**(m+ig2(k)-1-j))
 20      continue
         array(k,i)=g0(k)+g1(k)*dble(iparam)
 10   continue

      return
      end
c
c#######################################################################
      subroutine code(j,k,array,iarray)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      common / ga2   / nparam,nchrome
      common / ga5   / g0,g1,ig2
      dimension array(nparmax,indmax),iarray(nchrmax,indmax)
      dimension g0(nparmax),g1(nparmax),ig2(nparmax)

      istart=1
      do 10 i=1,k-1
         istart=istart+ig2(i)
 10   continue

      m=ig2(k)-1
      if (g1(k).eq.0.0d0) return
      iparam=nint((array(k,j)-g0(k))/g1(k))
      do 20 i=istart,istart+ig2(k)-1
         iarray(i,j)=0
         if ((iparam+1).gt.(2**m)) then
            iarray(i,j)=1
            iparam=iparam-2**m
         endif
         m=m-1
 20   continue

      return
      end
c
c#######################################################################
      subroutine possibl(array,iarray)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga5   / g0,g1,ig2
      common / ga6   / parmax,parmin,pardel,nposibl
      dimension array(nparmax,indmax),iarray(nchrmax,indmax)
      dimension g0(nparmax),g1(nparmax),ig2(nparmax),nposibl(nparmax)
      dimension parmax(nparmax),parmin(nparmax),pardel(nparmax)

      do 10 i=1,npopsiz
         call decode(i,array,iarray)
         do 20 j=1,nparam
            n2ig2j=2**ig2(j)
            if(nposibl(j).ne.n2ig2j .and. array(j,i).gt.parmax(j)) then
               call ran3(1,rand)
               irand=dint(dble(nposibl(j))*rand)
               array(j,i)=g0(j)+dble(irand)*g1(j)
               call code(i,j,array,iarray)
               if (nowrite.eq.0) write(6,1000) i,j
               if (nowrite.eq.0) write(24,1000) i,j
            endif
 20      continue
 10   continue

 1000 format('*** Parameter adjustment to individual     ',i4,
     +       ', parameter  ',i3,' ***')

      return
      end
c
c#######################################################################
      subroutine restart(i,kount)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7)
      common / ga1   / npopsiz,nowrite
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      dimension parent(nparmax,indmax),iparent(nchrmax,indmax)
      common /inputga/ pcross,pmutate,pcreep,maxgen,idum,irestrt,
     +                 itourny,ielite,icreep,iunifrm,iniche,
     +                 iskip,iend,nchild,microga,kountmx
      common /random/ inext,inextp,hj,ha(55)       !random next
	CHARACTER*20 DINP,DOUT
	COMMON /DIRGA/ DINP,DOUT,LCINP,LCOUT		

      kount=kount+1
      if(kount.eq.kountmx) then
         OPEN(UNIT=25,FILE=DOUT(:LCOUT)//'ga.restart',STATUS='UNKNOWN')
         rewind 25
         write(25,*) i+1,npopsiz
         do 80 j=1,npopsiz
            write(25,1500) j,(iparent(l,j),l=1,nchrome)
 80      continue
 	   write(25,*) inext,inextp,hj,(ha(l),l=1,55)      !random next
         CLOSE (25)
	   write(27,*) i+1								   !random next
	   write(27,*) inext,inextp,hj,(ha(l),l=1,55)      !random next
         kount=0
      endif

 1500 format(i5,3x,30i2)

      return
      end
c
c#######################################################################
      subroutine ran3(idum,rand)
      implicit real*8 (a-h,m,o-z)
      save
      parameter (mbig=4000000.,mseed=1618033.,mz=0.,fac=1./mbig)
      data iff /0/
	common /random/ inext,inextp,mj,ma(55)    !random next 

      if (idum.lt.0 .or. iff.eq.0) then
         iff=1
         mj=mseed-dble(iabs(idum))
         mj=dmod(mj,mbig)
         ma(55)=mj
         mk=1
         do 11 i=1,54
            ii=mod(21*i,55)
            ma(ii)=mk
            mk=mj-mk
            if(mk.lt.mz) mk=mk+mbig
            mj=ma(ii)
 11      continue
         do 13 k=1,4
            do 12 i=1,55
               ma(i)=ma(i)-ma(1+mod(i+30,55))
               if(ma(i).lt.mz) ma(i)=ma(i)+mbig
 12         continue
 13      continue
	   inext=0
         inextp=31
         idum=1
      endif
      inext=inext+1
      if(inext.eq.56) inext=1
      inextp=inextp+1
      if(inextp.eq.56) inextp=1
      mj=ma(inext)-ma(inextp)
      if(mj.lt.mz) mj=mj+mbig
      ma(inext)=mj
      rand=mj*fac
      return
      end
c
c#######################################################################

      subroutine func(j,funcval)
      implicit real*8 (a-h,o-z)
      save
      parameter (indmax=200,nchrmax=180,nparmax=7,MXATM=500)
      dimension parent(nparmax,indmax)
      dimension iparent(nchrmax,indmax)
      common / ga2   / nparam,nchrome
      common / ga3   / parent,iparent
      common /GA/ betas(100),ichange(21),icall
	COMMON /COEFFICIENT/ CET(NPARMAX)
	COMMON /GARUN/ MSTATUS,NSTATUS

	do i=1,7 
       CET(i)=parent(i,j)
	end do

	IF (MSTATUS.EQ.1) THEN
	 CALL GAGM_CONFIG(NSTATUS)
	 CALL GAGM_ANALYST(TARV)
	 funcval=TARV
	ENDIF

	IF (MSTATUS.EQ.2) THEN
	 CALL GAMM_CONFIG(NSTATUS)
	 CALL GAMM_ANALYST(TARV)
	 funcval=-TARV
	ENDIF

      return
      end

c
c***********************************************************************
