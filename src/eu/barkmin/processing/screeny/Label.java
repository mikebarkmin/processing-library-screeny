package eu.barkmin.processing.screeny;

import processing.core.PFont;

import java.awt.*;

public class Label extends InteractiveElement {
    /**
     * Creates a new Label
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param width  width
     * @param height height
     * @param String label
     * @þaram Color color
     * @param int size
     */

    private String label;
    private Color color = Color.BLACK;
    private PFont font;
    private int size;


    public Label(float x, float y, float width, float height, String label, Color color, int size) {
        super(x, y, width, height);

        this.size = size;
        this.label = label;
        if (color != null) {
            this.color = color;
        }

        this.font = Screeny.parent.createFont("Arial", size);
    }

    /**
     * Creates a new Label
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param label
     * @param color
     * @param size
     * @param font
     */
    public Label(float x, float y, float width, float height, String label, Color color, int size, PFont font) {
        this(x, y, height, width, label, color, size);

        this.font = font;
    }

    public void draw() {
        Screeny.parent.textAlign(Screeny.parent.CENTER);
        Screeny.parent.textFont(this.font, size);
        Screeny.parent.fill(color.getRed(), color.getGreen(), color.getBlue());
        Screeny.parent.text(label, x, y, x + width, y + height);
        Screeny.parent.noFill();
    }
}
