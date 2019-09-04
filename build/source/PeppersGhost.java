import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PeppersGhost extends PApplet {

int angle;    //角度を設定するための変数
int fileCounter = 0;
boolean flag = true;
boolean rotateX = true;

float boxsize = 60;

float theta = 0;

float R = 255;

public void setup(){
  
  angle = 0;    //60度を設定
}

public void draw(){
  background(0);
  //stroke( 255, 0, 0 );
  //strokeWeight( 5 );
  //line(0, height/2, width , height/2);
  //line(width/2, 0, width/2, height);
  //ellipse(height/2, width/2,120,120);
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

  //translate(0,0,0);    //立体の中心を画面中央に移動
  //box(boxsize, boxsize, boxsize);    //150 x 150 x 150pxの立方体を描く

  rotateX(180);

  rotateX = false;
  fill(R, 0, 0);
  rotateY(radians(-1*angle));    //Y軸に対してangleの数値分だけ回転



  boxsize = 60 + 20 * sin(theta);

  theta = theta + 0.05f;

  R = 255 + 75*sin(theta);

  if(flag){
    //saveFrame("frames/"+fileCounter+".png");
    fileCounter++;
  }

     //println(fileCounter);

}
  public void settings() {  size(400, 400, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PeppersGhost" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
