/**
 * @author Tada Tomoya
 * @version 2.0.1
 */

int angle;    //角度を設定するための変数
int fileCounter = 0;
boolean flag = true;
boolean rotateX = true;

float boxsize = 60;

float theta = 0;

float R = 255;

void setup(){
  size(400, 400, P3D);
  angle = 0;    //60度を設定
}

void draw(){
  background(0);

  angle += 1;    //角度を1ずつ足していく
  if(angle > 3600) {
    angle = 0;    //360度を超えたら0に戻す
    flag = false;
  }

  stroke(255,255,255);
  strokeWeight( 12 );

  translate(width/2, height/2 + 120,0);    //立体の中心を画面中央に移動
  box(boxsize, boxsize, boxsize);    //150 x 150 x 150pxの立方体を描く

  translate(0,-(height/2 + 40),0);    //立体の中心を画面中央に移動
  box(boxsize, boxsize, boxsize);    //150 x 150 x 150pxの立方体を描く

  translate(width/2- 80,height/2 - 80,0);    //立体の中心を画面中央に移動
  box(boxsize, boxsize, boxsize);    //150 x 150 x 150pxの立方体を描く

  translate(-2*(width/2- 80),0,0);    //立体の中心を画面中央に移動
  box(boxsize, boxsize, boxsize);    //150 x 150 x 150pxの立方体を描く

  rotateX(180);

  rotateX = false;
  fill(R, 0, 0);
  rotateY(radians(-1*angle));    //Y軸に対してangleの数値分だけ回転

  boxsize = 60 + 20 * sin(theta);

  theta = theta + 0.05;

  R = 255 + 75*sin(theta);

  if(flag){
    saveFrame("frames/"+fileCounter+".png");
    fileCounter++;
  }

     //println(fileCounter);

}
