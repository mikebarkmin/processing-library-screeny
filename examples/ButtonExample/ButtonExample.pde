import eu.barkmin.processing.screeny.*;
import java.awt.Color;

Button b;

int bg = 255;

void setup() {
  size(400, 400);
  Screeny.init(this);
  b = new BGButton(0, 0, 100, 20, "Click Me!", Color.BLACK, Color.RED, 16);
}

void draw() {
  background(bg);
  b.draw();
}

class BGButton extends Button {
  public BGButton(float x, float y, float width, float height, String label, Color fontColor, Color bgColor, int size) {
    super(x,y,width,height,label,fontColor,bgColor,size);
  }
  
  public void clicked() {
    bg -= 100;
  }
}
