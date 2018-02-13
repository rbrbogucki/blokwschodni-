Graphics3D 1024,768,32,2
SetBuffer BackBuffer()

piv=CreatePivot(cam)
cam=CreateCamera()
PositionEntity cam,10,1,0

l1=CreateLight()

ter=LoadTerrain("data/2d/heightmap_256.bmp")
tex=LoadTexture("data/2d/terrain-1.jpg")
EntityTexture ter,tex

Include "cfphys.bb"
Include "main.bb"


End
