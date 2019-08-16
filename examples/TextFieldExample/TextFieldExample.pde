import eu.barkmin.processing.screeny.*;
import java.awt.Color;

Button b;
TextField f1, f2;

int bg = 255;

void setup() {
  size(400, 400, P2D);
  Screeny.init(this);
  b = new BGButton(0, 0, 100, 20, "Click Me!", Color.BLACK, Color.RED, 16);
  f1 = new TextField(0, 50, 100, 48, Color.BLACK, Color.GRAY, Color.BLUE, 16);
  f2 = new TextField(0, 100, 100, 50, Color.BLACK, Color.GRAY, Color.BLUE, 16);
}

void draw() {
  background(bg);
  b.draw();
  f1.draw();
  f2.draw();
}

class BGButton extends Button {
  public BGButton(float x, float y, float width, float height, String label, Color fontColor, Color bgColor, int size) {
    super(x,y,width,height,label,fontColor,bgColor,size);
  }
  
  public void clicked() {
    bg -= 100;
  }
}
