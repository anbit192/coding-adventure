	
	SUBROUTINE INPUT_PROTEIN
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	CHARACTER*8 PRFN,SUBFN
	COMMON /INPUT/ PRFN,SUBFN
	PARAMETER (MXPR=100000,MXAA=1000,MXCH=10)
	CHARACTER CHN*1,AAN*3,PRN*3
      COMMON /PROTEIN/ CHN(MXCH),
	*                 AAN(MXCH,MXAA),IAS(MXCH,MXAA),IAE(MXCH,MXAA),
	*                 AAFX(MXCH,MXAA),AAFY(MXCH,MXAA),AAFZ(MXCH,MXAA),
	*                 PRN(MXPR),PRX(MXPR),PRY(MXPR),PRZ(MXPR),
	*                 IFOCH,IFOAA(MXCH)
	PARAMETER (MXHAT=100,MXMOL=1000)
	CHARACTER*3 HAMN,HATN
	COMMON /HETATM/ NMOL,HAMN(MXMOL),IAM(MXMOL),
	*                HAFX(MXMOL),HAFY(MXMOL),HAFZ(MXMOL),
	*                HATN(MXMOL,MXHAT),HATX(MXMOL,MXHAT),
     *                HATY(MXMOL,MXHAT),HATZ(MXMOL,MXHAT)

	CALL PDB_File
	CALL AA_FOCUS
	CALL HETATM_FOCUS
	CALL SUB_File

	RETURN
	END

	SUBROUTINE PDB_File
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	CHARACTER*8 PRFN,SUBFN
	COMMON /INPUT/ PRFN,SUBFN
	CHARACTER LINE*100,CONTENT*6
	CHARACTER*10 COMP(20)
	PARAMETER (MXPR=100000,MXAA=1000,MXCH=10)
	CHARACTER CHN*1,AAN*3,PRN*3
      COMMON /PROTEIN/ CHN(MXCH),
	*                 AAN(MXCH,MXAA),IAS(MXCH,MXAA),IAE(MXCH,MXAA),
	*                 AAFX(MXCH,MXAA),AAFY(MXCH,MXAA),AAFZ(MXCH,MXAA),
	*                 PRN(MXPR),PRX(MXPR),PRY(MXPR),PRZ(MXPR),
	*                 IFOCH,IFOAA(MXCH)
	PARAMETER (MXHAT=100,MXMOL=1000)
	CHARACTER*3 HAMN,HATN
	COMMON /HETATM/ NMOL,HAMN(MXMOL),IAM(MXMOL),
	*                HAFX(MXMOL),HAFY(MXMOL),HAFZ(MXMOL),
	*                HATN(MXMOL,MXHAT),HATX(MXMOL,MXHAT),
     *                HATY(MXMOL,MXHAT),HATZ(MXMOL,MXHAT)

	OPEN(UNIT=11, FILE='PDB_File/'//PRFN, STATUS='UNKNOWN')
	REWIND 11

	IAT=0
	DO I=1,NMOL
	 IAM(I)=0
	END DO
C    $$$$$$$$$$-LOOP FOR READ DATA-$$$$$$$$$$
	DO
	 READ(11,'(A100)',ERR=100) LINE		   ! Read LINE
	 READ(LINE,*) CONTENT			       ! Read CONTENT

	 IF (CONTENT.EQ.'ATOM  ') THEN		   !%%%%%-Block ATOM-%%%%%
	  COMP(10)=COMP(5)					      !$ Luu COMP5 de so sanh
	  READ(LINE,*) CONTENT,(COMP(I),I=1,8)    !///////////////////////////////
	  IF (LINE(22:22).EQ.' ') THEN			  !// Trong truong hop
	   COMP(8)=COMP(7)						  !// chi co mot CHAIN
	   COMP(7)=COMP(6)						  !// thi xap xep lai 
	   COMP(6)=COMP(5)						  !// cac COMP duoc
	   COMP(5)=COMP(4)						  !// hinh thanh
	   COMP(4)=' '							  !// va dat ten CHAIN
	  ENDIF									  !// duy nhat la ' ' 
	  IAT=IAT+1         				      !// Nhap toa do 
	  READ(COMP(2),*) PRN(IAT)			      !// va Ten cac
	  READ(COMP(6),*) PRX(IAT)			      !// nguyen tu trong
	  READ(COMP(7),*) PRY(IAT)			      !// phan tu PROTEIN
	  READ(COMP(8),*) PRZ(IAT)			      !///////////////////////////////
	  IF (IFOCH.EQ.0) THEN					  !\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	   IFOCH=1								  !\\ Thiet dat cac
	   IFOAA(1)=1							  !\\ giai tri ban dau
	   CHN(1)=COMP(4)						  !\\ cua COMMON
	   AAN(1,1)=COMP(3)						  !\\ PROTEIN
	   IAS(1,1)=IAT							  !\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	  ELSE									  !///////////////////////////////
	   IF (COMP(5).NE.COMP(10)) THEN		  !//$ Neu co su thay doi AA thi
	    IAE(IFOCH,IFOAA(IFOCH))=IAT-1		  !//$  Xd IAE cua AA cu
	    IF (COMP(4)(:1).NE.CHN(IFOCH)) THEN	  !//$  Neu co CHAIN moi thi
	     IFOCH=IFOCH+1						  !//$   Tang IFOCH
	     CHN(IFOCH)=COMP(4)	                  !//$   Xd ten CHAIN moi
	    ENDIF								  !//$  ***
	    IFOAA(IFOCH)=IFOAA(IFOCH)+1			  !//$  Tang IFOAA
	    AAN(IFOCH,IFOAA(IFOCH))=COMP(3)		  !//$  Xd ten AA moi
	    IAS(IFOCH,IFOAA(IFOCH))=IAT			  !//$  Xd IAS cua AA moi	   
	   ENDIF								  !//$ ***
	  ENDIF									  !//$***
	 ENDIF								 	  !///////////////////////////////
	 IF (CONTENT.EQ.'TER   ') THEN
	  IAE(IFOCH,IFOAA(IFOCH))=IAT			  !$ Het CHAIN, dat IAE cho AA cu
	 ENDIF								   !%%%%%-Block ATOM-%%%%%

	 IF(CONTENT.EQ.'HETATM') THEN		   !%%%%%-Block HETATM-%%%%%
	  COMP(10)=COMP(4)					      !$ Luu COMP4 de so sanh
	  READ(LINE,*) CONTENT,(COMP(I),I=1,7)	  !///////////////////////////////
	  IF (NMOL.EQ.0) THEN					  !// Nhap toa do,
	   NMOL=1								  !// ten phan tu
	   IAM(1)=1								  !// ten nguyen tu
	   HAMN(1)=COMP(3)						  !// ban dau
	   HATN(1,1)=COMP(2)					  !//$ Nhap toa do X
	   READ(COMP(5),*) HATX(1,1)			  !//$ Nhap toa do Y
	   READ(COMP(6),*) HATY(1,1)			  !//$ Nhap toa do Z
	   READ(COMP(7),*) HATZ(1,1)			  !///////////////////////////////
	  ELSE									  !\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	   IF (COMP(4).NE.COMP(10)) THEN		  !\\$ Neu co su thay doi phan tu
	    NMOL=NMOL+1							  !\\$  Tang so luong phan tu
	    HAMN(NMOL)=COMP(3)					  !\\$	Xd ten phan tu moi
	   ENDIF								  !\\$ ***
	   IAM(NMOL)=IAM(NMOL)+1				  !\\$ Tang so luong nguyen tu
	   HATN(NMOL,IAM(NMOL))=COMP(2)			  !\\$ Xd ten nguen tu moi
	   READ(COMP(5),*) HATX(NMOL,IAM(NMOL))	  !\\$ Nhap toa do X 
	   READ(COMP(6),*) HATY(NMOL,IAM(NMOL))	  !\\$ Nhap toa do Y 
	   READ(COMP(7),*) HATZ(NMOL,IAM(NMOL))	  !\\$ Nhap toa do Z 
	  ENDIF	  	  							  !\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 ENDIF								   !%%%%%-Block HETATM-%%%%%

	END DO
C    $$$$$$$$$$$$$$$-END LOOP-$$$$$$$$$$$$$$$
100	CLOSE(11)

	RETURN
	END

	SUBROUTINE AA_FOCUS
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	PARAMETER (MXPR=100000,MXAA=1000,MXCH=10)
	CHARACTER CHN*1,AAN*3,PRN*3
      COMMON /PROTEIN/ CHN(MXCH),
	*                 AAN(MXCH,MXAA),IAS(MXCH,MXAA),IAE(MXCH,MXAA),
	*                 AAFX(MXCH,MXAA),AAFY(MXCH,MXAA),AAFZ(MXCH,MXAA),
	*                 PRN(MXPR),PRX(MXPR),PRY(MXPR),PRZ(MXPR),
	*                 IFOCH,IFOAA(MXCH)

	DO I=1,IFOCH
	 DO J=1,IFOAA(I)
	  DO K=IAS(I,J),IAE(I,J)
	   AAFX(I,J)=AAFX(I,J)+PRX(K)
	   AAFY(I,J)=AAFY(I,J)+PRY(K)
	   AAFZ(I,J)=AAFZ(I,J)+PRZ(K)
	  END DO
	  NPR=IAE(I,J)-IAS(I,J)+1
	  AAFX(I,J)=AAFX(I,J)/NPR
	  AAFY(I,J)=AAFY(I,J)/NPR
	  AAFZ(I,J)=AAFZ(I,J)/NPR
	 END DO
	END DO

	RETURN
	END

	SUBROUTINE HETATM_FOCUS
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	PARAMETER (MXHAT=100,MXMOL=1000)
	CHARACTER*3 HAMN,HATN
	COMMON /HETATM/ NMOL,HAMN(MXMOL),IAM(MXMOL),
	*                HAFX(MXMOL),HAFY(MXMOL),HAFZ(MXMOL),
	*                HATN(MXMOL,MXHAT),HATX(MXMOL,MXHAT),
     *                HATY(MXMOL,MXHAT),HATZ(MXMOL,MXHAT)


	DO I=1,NMOL
	 DO J=1,IAM(I)
	  HAFX(I)=HAFX(I)+HATX(I,J)
	  HAFY(I)=HAFY(I)+HATY(I,J)
	  HAFZ(I)=HAFZ(I)+HATZ(I,J)
	 END DO
	  HAFX(I)=HAFX(I)/IAM(I)
	  HAFY(I)=HAFY(I)/IAM(I)
	  HAFZ(I)=HAFZ(I)/IAM(I)
	END DO

	RETURN
	END

	SUBROUTINE SUB_File
	IMPLICIT DOUBLE PRECISION (A-H,O-Z)
	CHARACTER*8 PRFN,SUBFN
	COMMON /INPUT/ PRFN,SUBFN
	PARAMETER (MXHAT=100,MXMOL=1000)
	CHARACTER*3 HAMN,HATN,SATN
	COMMON /HETATM/ NMOL,HAMN(MXMOL),IAM(MXMOL),
	*                HAFX(MXMOL),HAFY(MXMOL),HAFZ(MXMOL),
	*                HATN(MXMOL,MXHAT),HATX(MXMOL,MXHAT),
     *                HATY(MXMOL,MXHAT),HATZ(MXMOL,MXHAT)
	COMMON /SUBSTANCE/ NSA,SATFX,SATFY,SATFZ,SATN(MXHAT),
	*                   SATX(MXHAT),SATY(MXHAT),SATZ(MXHAT)

	IF (SUBFN.NE.'        ') THEN

	 OPEN(UNIT=12, FILE='PDB_File/'//SUBFN, STATUS='UNKNOWN')
	  READ(12,*) NSA
	  READ(12,*)
	  DO I=1,NSA
	   READ(12,*) SATN(I),SATX(I),SATY(I),SATZ(I)
ct	   WRITE(*,*) SATN(I),SATX(I),SATY(I),SATZ(I)
	  END DO
	 CLOSE(12)

	SATFX=0
	SATFY=0
	SATFZ=0
	 DO I=1,NSA
	  SATFX=SATFX+SATX(I)
	  SATFY=SATFY+SATY(I)
	  SATFZ=SATFZ+SATZ(I)
	 END DO
	  SATFX=SATFX/NSA
	  SATFY=SATFY/NSA
	  SATFZ=SATFZ/NSA
	 DO I=1,NSA
	  SATX(I)=SATX(I)-SATFX
	  SATY(I)=SATY(I)-SATFY
	  SATZ(I)=SATZ(I)-SATFZ
	 END DO
	 	 
	ELSE

	 NSA=IAM(1)
	 DO I=1,NSA
	  SATN(I)=HATN(1,I)
	  SATX(I)=HATX(1,I)-HAFX(1)
	  SATY(I)=HATY(1,I)-HAFY(1)
	  SATZ(I)=HATZ(1,I)-HAFZ(1)
	 END DO
	 SATFX=HAFX(1)
	 SATFY=HAFY(1)
	 SATFZ=HAFZ(1)

	OPEN(UNIT=20,FILE='GAGM/HET1.xyz')
	write(20,'(I4)') NSA
	write(20,*)
	 DO I=1,NSA
	  write(20,'(A1,3F16.4)') SATN(I),SATX(I),SATY(I),SATZ(I)
	 END DO
	CLOSE(20)

	ENDIF

	RETURN
	END
