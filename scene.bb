Graphics3D 1024,768,32,2
SetBuffer BackBuffer()



piv=CreatePivot();tmp
cam=CreateCamera(piv);tmp

PositionEntity cam,-25,15,-15;tmp
RotateEntity cam,30,-60,0

l1=CreateLight();tmp
PositionEntity l1,0,0,0

;-------------------tmp-level loading depending from menu choice
CLevel=CreatePlane()
PositionEntity Clevel,0,-5,0
tex=LoadTexture("data/2d/terrain-1.jpg")
ScaleTexture tex,50,50
EntityTexture clevel,tex


;----------car loading, depending from menu choice
CBody=LoadMesh("Data/650E/maluch4.x")	

;--frontright
CW1=CreateCylinder(16,CBody)
PositionEntity cw1,9,0.8,5
RotateEntity cw1,0,90,90
ScaleEntity cw1,2.3,0.5,2.3
EntityColor cw1,0,0,254

;--frontleft
cw2=CopyEntity(cw1)
PositionEntity cw2,9,0.8,-5
ScaleEntity cw2,2.3,0.5,2.3
RotateEntity cw2,90,0,0

;--rearright
cw3=CopyEntity(cw1)
PositionEntity cw3,-9.2,0.8,5
ScaleEntity cw3,2.3,0.5,2.3
RotateEntity cw3,90,0,0

;--rearleft
cw4=CopyEntity(cw1)
PositionEntity cw4,-9.2,0.8,-5
ScaleEntity cw4,2.3,0.5,2.3
RotateEntity cw4,90,0,0


EntityParent cw1,cbody
EntityParent cw2,cbody
EntityParent cw3,cbody
EntityParent cw4,cbody

;include "cfscript.bb" - script stuff, 
Include "cfphys.bb";variables, phys stuff
Include "main.bb";mainloop, controls 


End
