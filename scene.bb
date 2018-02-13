Graphics3D 1024,768,32,2
SetBuffer BackBuffer()

piv=CreatePivot(cam);tmp
cam=CreateCamera();tmp
PositionEntity cam,10,1,0;tmp

l1=CreateLight();tmp

;-------------------tmp-level loading depending from menu choice
ter=LoadTerrain("data/2d/heightmap_256.bmp")
ScaleEntity ter,1000/TerrainSize(ter),70,1000/TerrainSize(ter)
tex=LoadTexture("data/2d/terrain-1.jpg")
ScaleTexture tex,50,50
EntityTexture ter,tex

;----------car loading, depending from menu choice


;include "cfscript.bb" - script stuff, 
Include "cfphys.bb";variables, phys stuff
Include "main.bb";mainloop, controls 


End
