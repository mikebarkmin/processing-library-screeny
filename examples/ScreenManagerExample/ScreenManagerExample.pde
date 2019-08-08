import eu.barkmin.processing.screeny.*;

void setup() {
  Screeny.init(this);
  
  ScreenManager m = new ScreenManager();
}

void draw() {
}

class MyScreen extends Screen {
  
  Button b;
  
  public void start() {
    b = new Button(0, 0, 200, 20, "To Screen 2", null, null, 16);
  }
  
  public void restart() {
  }
  
  public void draw() {
  }
  
  public void stop() {
  }
  
  public void destroy() {
  }
}
