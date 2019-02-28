;unfinished and fckn messy
Const level=1
Const body=2
Const wheel=3

Global wheeljump=0.2
Global springheight=3
Global speed=0



Graphics3D 1024,748
SetBuffer BackBuffer()

Collisions wheel,level,2,3
Collisions body, scene,2,3
;---------------env-----------------------------
lit=CreateLight()
cam=CreateCamera()
CameraRange cam,1,25000
PositionEntity cam,0,5,-31



;-----poziom----------------
sky=LoadMesh("skybox.b3d")
PositionEntity sky,0,0,0
levmesh=LoadMesh("testlevel.b3d")
PositionEntity levmesh,0,-1,0
EntityType levmesh,level



;--------auto-------------

cbody=LoadMesh("body.b3d")
PositionEntity cbody,0,springheight,0
EntityType cbody,body

;-------kola-----------------
cFLwheel=LoadMesh("kolo.b3d")
PositionEntity cFLwheel,5,0,0
cFRwheel=LoadMesh("kolo.b3d")
PositionEntity cFRwheel,-5,0,0
cRLwheel=LoadMesh("kolo.b3d")
PositionEntity cRLwheel,1,0,2
cRRwheel=LoadMesh("kolo.b3d")
PositionEntity cRRwheel,-1,0,2

EntityParent cbody,cflwheel

EntityType cFLwheel,wheel
EntityType cFRwheel,wheel
EntityType cRLwheel,wheel
EntityType cRRwheel,wheel





;-----petla glowna-----------

While Not KeyDown(1)


MoveEntity cFLwheel,0,-0.01,0
MoveEntity cFRwheel,0,-0.01,0
MoveEntity cRLwheel,0,-0.01,0
MoveEntity cRRwheel,0,-0.01,0

	If KeyDown(30) TurnEntity cam,0,+0.5,0	;cursors to move
	If KeyDown(32) TurnEntity cam,0,-0.5,0
	If KeyDown(17) TurnEntity cam,+0.5,0,0
	If KeyDown(31) TurnEntity cam,-0.5,0,0

	If KeyDown(45) MoveEntity cam,0,0,-1	;A - fly foward
	If KeyDown(44) MoveEntity cam,0,0,1		;Z - fly backward

If KeyDown(200) MoveEntity cflwheel,0,0,1

	UpdateWorld
	RenderWorld
	
	Flip
Wend
EndGraphics
End



;KONIEC
