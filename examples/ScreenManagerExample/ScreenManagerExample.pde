import eu.barkmin.processing.screeny.*;

void setup() {
  size(500, 500);
  Screeny.init(this);
  
  ScreenManager m = new ScreenManager();
  m.start(new MyScreen(m, 0));
}

void draw() {
  background(0);
}

class MyScreen extends Screen {
  
  int id;
  Button b;
  Button c;
  ScreenManager screenManager;
  
  public MyScreen(ScreenManager m, int id) {
    this.screenManager = m;
    this.id = id;
  }
  
  public void start() {
    println("Started: " + id);
    b = new Button(0, 0, 200, 20, "To Screen " + (id + 1), null, null, 16);
    c = new Button(0, 30, 200, 20, "Back to Screen " + (id - 1), null, null, 16);
  }
  
  public void restart() {
    println("Restarted: " + id);
  }
  
  public void draw() {
    if (b.isClicked()) {
      screenManager.start(new MyScreen(screenManager, id + 1));
    }
    if (c.isClicked()) {
      println("Back");
      screenManager.back();
    }
    b.draw();
    c.draw();
  }
  
  public void stop() {
    println("Stopped: " + id);
  }
  
  public void destroy() {
    println("Destroyed: " + id);
  }
}
