While Not KeyHit(1)

If KeyDown(203) TurnEntity cam,0,1,0
If KeyDown(205) TurnEntity cam,0,-1,0
If KeyDown(208) MoveEntity cam,0,0,-0.5
If KeyDown(200) MoveEntity cam,0,0,0.5

UpdateWorld
RenderWorld
Flip

Wend
