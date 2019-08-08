import eu.barkmin.processing.screeny.*;
import java.awt.Color;

size(400, 400);
Screeny.init(this);
  
Label l = new Label(0, 0, 50, 20, "Label", Color.RED, 16);

background(255);
l.draw();
