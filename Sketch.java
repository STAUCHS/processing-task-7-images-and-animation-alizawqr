import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage imgPenguin;

  // x and y coordinates for penguin
  float fltPenguinX = 1;
  float fltPenguinY = -1;

  // penguin speed
  float fltPenguinXSpeed = 1;
  float fltPenguinYSpeed = 1;

  // add gravity
  double fltGravity = 0.25;

  // x and y coordinates for circle
  float fltCircleX = 50;
  float fltCircleY = 50;

  // circle speed
  float fltCircleXSpeed = 1;
  float fltCircleYSpeed = 1;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255, 255, 255);

    // load penguin picture
    imgPenguin = loadImage("penguin.png");

    // resize penguin
    imgPenguin.resize(imgPenguin.width / 15, imgPenguin.height / 15);
  }

  public void draw() {
    background(255, 255, 255);
    
    // draw circle and animate
    ellipse(fltCircleX, fltCircleY, 50, 50);
    fill(229, 180, 240);

    fltCircleX += fltCircleXSpeed;
    fltCircleY += fltCircleYSpeed;

    if (fltCircleX > width - 25 || fltCircleX < 25) {
      fltCircleXSpeed *= -1;
    }

    if (fltCircleY > height - 25 || fltCircleY < 25) {
      fltCircleYSpeed *= -1;
    }

    // draw penguin and animate
    image(imgPenguin, fltPenguinX, fltPenguinY);

    fltPenguinX += fltPenguinXSpeed;
    fltPenguinY += fltPenguinYSpeed;

    fltPenguinYSpeed += fltGravity;

    if (fltPenguinX > width - imgPenguin.width || fltPenguinX < 0) {
      fltPenguinXSpeed *= -1;
    }

    if (fltPenguinY > height - imgPenguin.height || fltPenguinY < 0) {
      fltPenguinYSpeed *= -1;
    }

  }

}