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

target=CreatePivot(cbody)
PositionEntity target,-3,5,-8




;-------kola-----------------


Global kola[4]
cnt=1
For z#=-8 To 9.5 Step 17.5
For x#=-3.5 To 13.5 Step 10
kola[cnt]=LoadMesh("kolo.b3d",cbody)
PositionEntity kola[cnt],x,-3,z
EntityType kola[cnt],wheel
cnt=cnt+1
Next
Next











;-----petla glowna-----------

While Not KeyDown(1)

	zx#=(EntityX( kola[2],True )+EntityX( kola[4],True ))/2
	zx=zx-(EntityX( kola[1],True )+EntityX( kola[3],True ))/2
	zy#=(EntityY( kola[2],True )+EntityY( kola[4],True ))/2
	zy=zy-(EntityY( kola[1],True )+EntityY( kola[3],True ))/2
	zz#=(EntityZ( kola[2],True )+EntityZ( kola[4],True ))/2
	zz=zz-(EntityZ( kola[1],True )+EntityZ( kola[3],True ))/2
	AlignToVector cbody,zx,zy,zz,1

	zx#=(EntityX( kola[1],True )+EntityX( kola[2],True ))/2
	zx=zx-(EntityX( kola[3],True )+EntityX( kola[4],True ))/2
	zy#=(EntityY( kola[1],True )+EntityY( kola[2],True ))/2
	zy=zy-(EntityY( kola[3],True )+EntityY( kola[4],True ))/2
	zz#=(EntityZ( kola[1],True )+EntityZ( kola[2],True ))/2
	zz=zz-(EntityZ( kola[3],True )+EntityZ( kola[4],True ))/2
	AlignToVector cbody,zx,zy,zz,3


cnt=1
	MoveEntity kola[1],0,-0.1,0
	MoveEntity kola[2],0,-0.1,0
	MoveEntity kola[3],0,-0.1,0
	MoveEntity kola[4],0,-0.1,0
cnt=c+1


	If KeyDown(44) MoveEntity cam,0,+0.5,0	;cursors to move
	If KeyDown(45) MoveEntity cam,0,-0.5,0
	If KeyDown(30) TurnEntity cam,0,+0.5,0
	If KeyDown(32) TurnEntity cam,0,-0.5,0

	If KeyDown(31) MoveEntity cam,0,0,-1	;A - fly foward
	If KeyDown(17) MoveEntity cam,0,0,1		;Z - fly backward

If KeyDown(200) MoveEntity cbody,0,0,1
If KeyDown(208) MoveEntity cbody,0,0,-1




	UpdateWorld
	RenderWorld
	
	Flip
Wend
EndGraphics
End



;KONIEC
