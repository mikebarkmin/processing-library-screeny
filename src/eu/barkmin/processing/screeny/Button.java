package eu.barkmin.processing.screeny;

import java.awt.Color;

public class Button extends InteractiveElement {
    /**
     * Creates a new Button
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param width  width
     * @param height height
     * @param label Label
     * @param Color
     * @param Color
     * @param int
     */

    private String label;
    private Color backgroundColor = Color.YELLOW;
    private Color fontColor = Color.BLACK;
    private int size;

    public Button(float x, float y, float width, float height, String label, Color fontColor, Color backgroundColor, int size) {
        super(x, y, width, height);

        this.fontColor = fontColor;
        this.size = size;
        this.label = label;
        if (backgroundColor != null) {
            this.backgroundColor = backgroundColor;
        }
    }

    public void setFontColor(Color color) {
        this.fontColor = fontColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public void clicked() {}

    public void draw() {
        float alpha = 255;
        if (isHovered()) {
            alpha = 150.0f;
        }
        Screeny.parent.fill(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue(), alpha);
        Screeny.parent.rect(x, y, width, height);
        Screeny.parent.noFill();
        if (isClicked()) {
            this.clicked();
        }
        new Label(x, y, width, height, label, fontColor, size).draw();
    }
}
