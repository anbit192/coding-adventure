	
	SUBROUTINE PROTEIN_ADDH
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	CHARACTER LINE*100
	LOGICAL PERMIT
	PARAMETER (MXPR=100000,MXAA=1000,MXCH=10)
	CHARACTER CHN*1,AAN*3,PRN*3
      COMMON /PROTEIN/ CHN(MXCH),
	*                 AAN(MXCH,MXAA),IAS(MXCH,MXAA),IAE(MXCH,MXAA),
	*                 AAFX(MXCH,MXAA),AAFY(MXCH,MXAA),AAFZ(MXCH,MXAA),
	*                 PRN(MXPR),PRX(MXPR),PRY(MXPR),PRZ(MXPR),
	*                 IFOCH,IFOAA(MXCH)
	COMMON /HIDROPR/ IHS(MXCH,MXAA),IHE(MXCH,MXAA),
	*                 HPX(MXPR),HPY(MXPR),HPZ(MXPR)

	DIMENSION H(3,3),A(4,3)
	BL=1.1000
$debug
	IHS(1,1)=1
	DO I=1,IFOCH
	 IF (I.GT.1) THEN
	  IHS(I,1)=IHE(I-1,IFOAA(I-1))+1
	 ENDIF
	 DO J=1,IFOAA(I)
	  IF (J.GT.1) THEN
	   IHS(I,J)=IHE(I,J-1)+1
	  ENDIF
c    $$$$$$$$$$-OPEN DATA FILE-$$$$$$$$$$
	  OPEN(UNIT=21,FILE='Data/'//AAN(I,J)//'.dat')
c    $$-N TER OF THE FIRST AA IN NEW CHAIN-$$
	   IF (J.EQ.1) THEN
	    IF (AAN(I,J).EQ.'PRO') THEN
	     IHE(I,J)=IHS(I,J)+1
	     A(1,1)=PRX(IAS(I,J))
	     A(1,2)=PRY(IAS(I,J))
	     A(1,3)=PRZ(IAS(I,J))
	     A(2,1)=PRX(IAS(I,J)+1)
	     A(2,2)=PRY(IAS(I,J)+1)
	     A(2,3)=PRZ(IAS(I,J)+1)
	     A(3,1)=PRX(IAS(I,J)+6)
	     A(3,2)=PRY(IAS(I,J)+6)
	     A(3,3)=PRZ(IAS(I,J)+6)
	     CALL AA_2H(BL,H,A)
	     DO K=1,2
	      HPX(IHS(I,J)+K-1)=H(K,1)
	      HPY(IHS(I,J)+K-1)=H(K,2)
	      HPZ(IHS(I,J)+K-1)=H(K,3)
	     END DO	     
	    ELSE
	     IHE(I,J)=IHS(I,J)+2
	     A(1,1)=PRX(IAS(I,J))
	     A(1,2)=PRY(IAS(I,J))
	     A(1,3)=PRZ(IAS(I,J))
	     A(2,1)=PRX(IAS(I,J)+2)
	     A(2,2)=PRY(IAS(I,J)+2)
	     A(2,3)=PRZ(IAS(I,J)+2)
	     A(3,1)=PRX(IAS(I,J)+1)
	     A(3,2)=PRY(IAS(I,J)+1)
	     A(3,3)=PRZ(IAS(I,J)+1)
	     CALL AA_3H(BL,H,A)
	     DO K=1,3
	      HPX(IHS(I,J)+K-1)=H(K,1)
	      HPY(IHS(I,J)+K-1)=H(K,2)
	      HPZ(IHS(I,J)+K-1)=H(K,3)
	     END DO
	    ENDIF
c    $$-N PEPTIT FOR PROTEIN-$$
	   ELSE
	    IF (AAN(I,J).EQ.'PRO') THEN
	     IHE(I,J)=IHS(I,J)-1           
		ELSE 
		 IHE(I,J)=IHS(I,J)
	     NA=3
	     A(1,1)=PRX(IAS(I,J))
	     A(1,2)=PRY(IAS(I,J))
	     A(1,3)=PRZ(IAS(I,J))
	     A(2,1)=PRX(IAS(I,J)+1)
	     A(2,2)=PRY(IAS(I,J)+1)
	     A(2,3)=PRZ(IAS(I,J)+1)
	     A(3,1)=PRX(IAS(I,J-1)+2)
	     A(3,2)=PRY(IAS(I,J-1)+2)
	     A(3,3)=PRZ(IAS(I,J-1)+2)
	     CALL AA_H(BL,H,A,NA)
	     HPX(IHS(I,J))=H(1,1)
	     HPY(IHS(I,J))=H(1,2)
	     HPZ(IHS(I,J))=H(1,3)
	    ENDIF
	   ENDIF
c    $$-ADD HIDRO FOR PROTEIN-$$
	 DO
	  READ(21,'(A100)',ERR=100) LINE
	  CALL ADD_PERMIT(LINE,I,J,PERMIT)
	IF (PERMIT) THEN
	! nhap lieu
	NP=0
	 DO K=7,16,3
	  IF (LINE(K:K+1).NE.'  ') THEN
	   READ(LINE(K:K+1),'(I2)') IP
ct	   write(*,*) LINE(K:K),IP
	   A(NP+1,1)=PRX(IAS(I,J)+IP-1)
	   A(NP+1,2)=PRY(IAS(I,J)+IP-1)
	   A(NP+1,3)=PRZ(IAS(I,J)+IP-1)
	   NP=NP+1
	  ENDIF
	 END DO
	 READ(LINE(20:26),*) BL
	! xay hidro
	 IF ((LINE(1:1).EQ.'1').AND.(LINE(10:11).NE.'  ')) THEN
	  IHE(I,J)=IHE(I,J)+1
	  CALL AA_H(BL,H,A,NP)
	  HPX(IHE(I,J))=H(1,1)
	  HPY(IHE(I,J))=H(1,2)
	  HPZ(IHE(I,J))=H(1,3)	   
	 ENDIF
	 IF ((LINE(1:1).EQ.'1').AND.(LINE(10:11).EQ.'  ')) THEN
	  IHE(I,J)=IHE(I,J)+1
	  CALL AA_1H(BL,H,A)
	  HPX(IHE(I,J))=H(1,1)
	  HPY(IHE(I,J))=H(1,2)
	  HPZ(IHE(I,J))=H(1,3)	   
	 ENDIF
	 IF (LINE(1:1).EQ.'2') THEN
	  IHE(I,J)=IHE(I,J)+2
	  CALL AA_2H(BL,H,A)
	  HPX(IHE(I,J)-1)=H(1,1)
	  HPY(IHE(I,J)-1)=H(1,2)
	  HPZ(IHE(I,J)-1)=H(1,3)
	  HPX(IHE(I,J))=H(2,1)
	  HPY(IHE(I,J))=H(2,2)
	  HPZ(IHE(I,J))=H(2,3)	   
	 ENDIF
	 IF (LINE(1:1).EQ.'3') THEN
	  IHE(I,J)=IHE(I,J)+3
	  CALL AA_3H(BL,H,A)
	  HPX(IHE(I,J)-2)=H(1,1)
	  HPY(IHE(I,J)-2)=H(1,2)
	  HPZ(IHE(I,J)-2)=H(1,3)
	  HPX(IHE(I,J)-1)=H(2,1)
	  HPY(IHE(I,J)-1)=H(2,2)
	  HPZ(IHE(I,J)-1)=H(2,3)
	  HPX(IHE(I,J))=H(3,1)
	  HPY(IHE(I,J))=H(3,2)
	  HPZ(IHE(I,J))=H(3,3)	   
	 ENDIF
	ENDIF
	 END DO
c    $$$$$$$$$$-CLOSE DATA FILE-$$$$$$$$$$
100	  CLOSE(21)
	 END DO
	END DO
 
	RETURN
	END

	SUBROUTINE ADD_PERMIT(LINE,ICH,IAA,PERMIT)
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	CHARACTER LINE*100
	LOGICAL PERMIT
	PARAMETER (MXPR=100000,MXAA=1000,MXCH=10)
	CHARACTER CHN*1,AAN*3,PRN*3
      COMMON /PROTEIN/ CHN(MXCH),
	*                 AAN(MXCH,MXAA),IAS(MXCH,MXAA),IAE(MXCH,MXAA),
	*                 AAFX(MXCH,MXAA),AAFY(MXCH,MXAA),AAFZ(MXCH,MXAA),
	*                 PRN(MXPR),PRX(MXPR),PRY(MXPR),PRZ(MXPR),
	*                 IFOCH,IFOAA(MXCH)
	COMMON /SBRIDGE/ NBR,ICB(MXAA),IAB(MXAA),JCB(MXAA),JAB(MXAA)

	PERMIT=.TRUE.
	IF (LINE(7:8).EQ.'  ') THEN
	 PERMIT=.FALSE.
	ENDIF

	DO I=1,NBR
	 IF ((ICB(I).EQ.ICH).AND.(IAB(I).EQ.IAA)) THEN
	  READ(LINE(7:8),'(I2)') IP
	  IF (IP.EQ.6) THEN
	   PERMIT=.FALSE.
	  ENDIF
	 ENDIF
	END DO

ct	IF (LINE(7:8).NE.'  ') THEN
ct	 READ(LINE(7:8),'(I2)') IP
ct	 IF (PRN(IAS(ICH,IAA)+IP-1)(:1).EQ.'C') THEN
ct	  PERMIT=.FALSE.
ct	 ENDIF
ct	ENDIF

	RETURN
	END

	SUBROUTINE AA_H(BL,H,A,NA)
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	DIMENSION H(3,3),A(4,3)
	 
c    $$
	DO I=2,NA
	 A(I,1)=A(1,1)-A(I,1)
	 A(I,2)=A(1,2)-A(I,2)
	 A(I,3)=A(1,3)-A(I,3)
	END DO
c    $$
	DO I=2,NA
	 VL=DSQRT(A(I,1)**2+A(I,2)**2+A(I,3)**2)
	 A(I,1)=A(I,1)/VL
	 A(I,2)=A(I,2)/VL
	 A(I,3)=A(I,3)/VL
	END DO
c    $$
	H(1,1)=0
	H(1,2)=0
	H(1,3)=0
	DO I=2,NA
	 H(1,1)=H(1,1)+A(I,1)
	 H(1,2)=H(1,2)+A(I,2)
	 H(1,3)=H(1,3)+A(I,3)
	END DO
c    $$
	VL=DSQRT(H(1,1)**2+H(1,2)**2+H(1,3)**2)
	VL=VL/BL
	H(1,1)=A(1,1)+H(1,1)/VL
	H(1,2)=A(1,2)+H(1,2)/VL
	H(1,3)=A(1,3)+H(1,3)/VL

	RETURN
	END

	SUBROUTINE AA_1H(BL,H,A)
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	DIMENSION H(3,3),A(4,3)
	 
c    $$
	H(1,1)=A(3,1)-A(2,1)
	H(1,2)=A(3,2)-A(2,2)
	H(1,3)=A(3,3)-A(2,3)
c    $$
	VL=DSQRT(H(1,1)**2+H(1,2)**2+H(1,3)**2)
	VL=VL/BL
	H(1,1)=A(1,1)+H(1,1)/VL
	H(1,2)=A(1,2)+H(1,2)/VL
	H(1,3)=A(1,3)+H(1,3)/VL

	RETURN
	END

	SUBROUTINE AA_2H(BL,H,A)
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	DIMENSION H(3,3),A(4,3)
	
c    $$
	DO I=2,3
	 A(I,1)=A(1,1)-A(I,1)
	 A(I,2)=A(1,2)-A(I,2)
	 A(I,3)=A(1,3)-A(I,3)
	END DO
c    $$
	DO I=2,3
	 VL=DSQRT(A(I,1)**2+A(I,2)**2+A(I,3)**2)/BL
	 A(I,1)=A(I,1)/VL
	 A(I,2)=A(I,2)/VL
	 A(I,3)=A(I,3)/VL
	END DO      
c    $$
	A(4,1)=(A(2,1)+A(3,1))/2
	A(4,2)=(A(2,2)+A(3,2))/2
	A(4,3)=(A(2,3)+A(3,3))/2
c    $$
	A(3,1)=A(3,1)-A(2,1)
	A(3,2)=A(3,2)-A(2,2)
	A(3,3)=A(3,3)-A(2,3)
c    $$
	A(2,1)=A(3,2)*A(4,3)-A(4,2)*A(3,3)
	A(2,2)=A(3,3)*A(4,1)-A(4,3)*A(3,1)
	A(2,3)=A(3,1)*A(4,2)-A(4,1)*A(3,2)
	VL=(A(2,1)**2+A(2,2)**2+A(2,3)**2)/(A(3,1)**2+A(3,2)**2+A(3,3)**2)
	VL=2*DSQRT(VL)
	A(2,1)=A(2,1)/VL
	A(2,2)=A(2,2)/VL
	A(2,3)=A(2,3)/VL
c    $$
	H(1,1)=A(1,1)+A(4,1)+A(2,1)
	H(1,2)=A(1,2)+A(4,2)+A(2,2)
	H(1,3)=A(1,3)+A(4,3)+A(2,3)
 
	H(2,1)=A(1,1)+A(4,1)-A(2,1)
	H(2,2)=A(1,2)+A(4,2)-A(2,2)
	H(2,3)=A(1,3)+A(4,3)-A(2,3)

	RETURN
	END

	SUBROUTINE AA_3H(BL,H,A)
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	DIMENSION H(3,3),A(4,3)
	
c    $$
	CALL AA_1H(BL,H,A)
	H(3,1)=H(1,1)
	H(3,2)=H(1,2)
	H(3,3)=H(1,3) 
c    $$
     	A(2,1)=H(3,1)
	A(2,2)=H(3,2)
	A(2,3)=H(3,3)
	CALL AA_2H(BL,H,A) 

	RETURN
	END


	SUBROUTINE PROTEIN_PDB
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	PARAMETER (MXPR=100000,MXAA=1000,MXCH=10)
	CHARACTER CHN*1,AAN*3,PRN*3
      COMMON /PROTEIN/ CHN(MXCH),
	*                 AAN(MXCH,MXAA),IAS(MXCH,MXAA),IAE(MXCH,MXAA),
	*                 AAFX(MXCH,MXAA),AAFY(MXCH,MXAA),AAFZ(MXCH,MXAA),
	*                 PRN(MXPR),PRX(MXPR),PRY(MXPR),PRZ(MXPR),
	*                 IFOCH,IFOAA(MXCH)
	COMMON /HIDROPR/ IHS(MXCH,MXAA),IHE(MXCH,MXAA),
	*                 HPX(MXPR),HPY(MXPR),HPZ(MXPR)
	
	OPEN(UNIT=21,FILE='GAMM/ATOM.pdb')

	L=0
	N=0
	 DO I=1,IFOCH
	  DO J=1,IFOAA(I)
	   L=L+1
	   DO K=IAS(I,J),IAE(I,J)
		N=N+1
	    write(21,'(A6,I5,A5,A4,A2,I4,A4,3F8.3)')
	*    'ATOM  ',N,PRN(K),AAN(I,J),CHN(I),L,'    ',
     *     PRX(K),PRY(K),PRZ(K)
	   END DO
	   DO K=IHS(I,J),IHE(I,J)
		N=N+1
	    write(21,'(A6,I5,A5,A4,A2,I4,A4,3F8.3)')
	+    'ATOM  ',N,'H  ',AAN(I,J),CHN(I),L,'    ',
     +     HPX(K),HPY(K),HPZ(K)
	   END DO
	   IF (J.EQ.IFOAA(I)) THEN
		N=N+1
	    write(21,'(A6,I5,A9,A2,I4)')
	+    'TER   ',N,AAN(I,J),CHN(I),L
	   ENDIF
	  END DO
	 END DO

	CLOSE(21)

	RETURN
	END
