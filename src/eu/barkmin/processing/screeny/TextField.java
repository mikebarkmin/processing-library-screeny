package eu.barkmin.processing.screeny;

import processing.core.PFont;
import processing.event.KeyEvent;

import javax.xml.soap.Text;
import java.awt.*;

public class TextField extends InteractiveElement {

    private Color fontColor;
    private Color backgroundColor;
    private Color backgroundFocusedColor;
    private Color borderColor;
    private int size;
    private String text;
    private PFont font;

    private static TextField focused;

    /**
     * Creates a new InteractiveElement
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param width  width
     * @param height height
     */
    public TextField(float x, float y, float width, float height, Color fontColor, Color backgroundColor, Color borderColor, int size) {
        super(x, y, width, height);

        this.fontColor = fontColor;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.size = size;
        this.text = "";

        this.font = Screeny.parent.createFont("Arial", size);
    }

    public void handleFocus() {
        TextField.focused = this;
    }

    public void handleBlur() {
        TextField.focused = null;
    }

    public String getText() {
        return text;
    }

    public boolean isTextInt() {
        try {
            Integer.parseInt(this.text);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public int getTextAsInt() {
        try {
            int i = Integer.parseInt(this.text);
            return i;
        } catch(NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }

    public float getTextAsFloat() {
        try {
            float f = Float.parseFloat(this.text);
            return f;
        } catch(NumberFormatException e) {
            return Float.MIN_NORMAL;
        }
    }

    public boolean isTextFloat() {
        try {
            Float.parseFloat(this.text);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public void handleChange(char key) {
        if (key == Screeny.parent.ESC) {
            this.text = "";
            this.handleBlur();
        } else if (key == Screeny.parent.BACKSPACE) {
            this.text = this.text.substring(0, Screeny.parent.max(0, this.text.length() - 1));
        } else if (key == Screeny.parent.ENTER || key == Screeny.parent.RETURN) {
            this.handleBlur();
        } else if (key == Screeny.parent.TAB) {
            this.text += "    ";
        } else if (key == Screeny.parent.DELETE || key == Screeny.parent.SHIFT) {
            // do nothing
        } else if (key >= ' ') {
            this.text += key;
        }
    }

    public void keyTyped(char key, int keyCode) {
        if (TextField.focused == this) {
            handleChange(key);
        }
    }

    public void draw() {
        if (isPressed() && TextField.focused != this) {
            if (TextField.focused != null) {
                TextField.focused.handleBlur();
            }
            this.handleFocus();
        }
        float alpha = 255;
        if (isHovered() || TextField.focused == this) {
            alpha = 150.0f;
        }
        Screeny.parent.strokeWeight(1);
        Screeny.parent.stroke(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue());
        Screeny.parent.fill(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue(), alpha);
        Screeny.parent.rect(x, y, width, height);
        Screeny.parent.textAlign(Screeny.parent.LEFT);
        Screeny.parent.textFont(font, size);
        Screeny.parent.fill(fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue());
        Screeny.parent.text(text, x+2, y-2, width-4, height-4);
    }
}
