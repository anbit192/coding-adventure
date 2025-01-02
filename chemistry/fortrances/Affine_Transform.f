	
      SUBROUTINE ADVANCE(X0,Y0,Z0,X,Y,Z)
      IMPLICIT real*8 (A-H,O-Z)
      RX   = X+X0
      RY   = Y+Y0
      RZ   = Z+Z0
      X    = RX
      Y    = RY
      Z    = RZ
      RETURN
      END
	
      SUBROUTINE ROTATE(A,B,C,X,Y,Z)
      IMPLICIT real*8 (A-H,O-Z)
      DIMENSION Q(4)
      Q(1)=DSIND(A)*DSIND(B-C)
      Q(2)=DSIND(A)*DCOSD(B-C)
      Q(3)=DCOSD(A)*DSIND(B+C)
      Q(4)=DCOSD(A)*DCOSD(B+C)
      SIGN = -1.D0
      AA   = Q(1)*Q(1)
      BB   = Q(2)*Q(2)
      CC   = Q(3)*Q(3)
      DD   = Q(4)*Q(4)
      AB   = Q(1)*Q(2)
      AC   = Q(1)*Q(3)
      AD   = Q(1)*Q(4)*SIGN
      BC   = Q(2)*Q(3)
      BD   = Q(2)*Q(4)*SIGN
      CD   = Q(3)*Q(4)*SIGN
      RX   = X*(-AA+BB-CC+DD)+Y*(+CD-AB)*2.D0 +Z*(+BC+AD)*2.D0
      RY   = X*(-AB-CD)*2.D0 +Y*(+AA-BB-CC+DD)+Z*(+BD-AC)*2.D0
      RZ   = X*(+BC-AD)*2.D0 +Y*(-AC-BD)*2.D0 +Z*(-AA-BB+CC+DD)
      X    = RX
      Y    = RY
      Z    = RZ
      RETURN
      END

   