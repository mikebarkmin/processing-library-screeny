package eu.barkmin.processing.screeny;

import processing.event.KeyEvent;
import processing.event.MouseEvent;

public abstract class InteractiveElement {

    protected float x;
    protected float y;
    protected float height;
    protected float width;
    protected boolean hovered;
    protected boolean pressed;
    protected boolean dragged;
    protected boolean clicked;

    /**
     * Creates a new InteractiveElement
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param width  width
     * @param height height
     */
    public InteractiveElement(float x, float y, float width, float height) {
        Screeny.parent.registerMethod("keyEvent", this);
        Screeny.parent.registerMethod("mouseEvent", this);

        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Gets the x-coordinate
     *
     * @return x-coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the x-coordinate
     *
     * @param x x-coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate
     *
     * @return y-coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the y-coordinate
     *
     * @param y y-coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Gets the height
     *
     * @return height
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the height
     *
     * @param height height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Gets the width
     *
     * @return width
     */
    public float getWidth() {
        return width;
    }

    /**
     * Sets the width
     *
     * @param width width
     */
    public void setWidth(float width) {
        this.width = width;
    }

    private void checkMouseOver(float mouseX, float mouseY) {
        if (mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height) {
            hovered = true;
        } else {
            hovered = false;
        }
    }

    /**
     * Is true when the mouse is over the element. Depending on x, y, height and width.
     *
     * @return hovered
     */
    public boolean isHovered() {
        return hovered;
    }

    /**
     * Is true when the element is pressed.
     *
     * @return pressed
     */
    public boolean isPressed() {
        return hovered && pressed;
    }

    /**
     * Is true when the element is dragged.
     *
     * @return dragged
     */
    public boolean isDragged() {
        return hovered && dragged;
    }

    /**
     * Is true when the element is clicked.
     *
     * @return clicked
     */
    public boolean isClicked() {
        if (hovered && clicked) {
            clicked =  false;
            return true;
        }
        return false;
    }

    public void keyEvent(KeyEvent e) {
        char key = e.getKey();
        int keyCode = e.getKeyCode();

        switch (e.getAction()) {
            case KeyEvent.PRESS:
                this.keyPressed(key, keyCode);
                break;
            case KeyEvent.RELEASE:
                this.keyReleased(key, keyCode);
                break;
            case KeyEvent.TYPE:
                this.keyTyped(key, keyCode);
                break;
        }
    }

    public void mouseEvent(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int count = e.getCount();

        checkMouseOver(x, y);

        pressed = false;
        clicked = false;
        dragged = false;

        switch (e.getAction()) {
            case MouseEvent.PRESS:
                this.mousePressed(x, y);
                pressed = true;
                break;
            case MouseEvent.RELEASE:
                this.mouseReleased(x, y);
                break;
            case MouseEvent.CLICK:
                this.mouseClicked(x, y);
                clicked = true;
                break;
            case MouseEvent.DRAG:
                this.mouseDragged(x, y);
                dragged = true;
                break;
            case MouseEvent.MOVE:
                this.mouseMoved(x, y);
                break;
            case MouseEvent.WHEEL:
                this.mouseScrolled(x, y, count);
                break;
        }
    }

    /**
     * Called when a key is pressed.
     *
     * @param key     the character
     * @param keyCode the key code
     */
    protected void keyPressed(char key, int keyCode) {
    }

    /**
     * Called when a key is released.
     *
     * @param key     the character
     * @param keyCode the key code
     */
    protected void keyReleased(char key, int keyCode) {
    }

    /**
     * Called when a key is typed.
     *
     * @param key     the character
     * @param keyCode the key code
     */
    protected void keyTyped(char key, int keyCode) {
    }

    /**
     * Called when the mouse button is pressed
     *
     * @param x x-coordinate of the mouse
     * @param y y-coordinate of the mouse
     */
    protected void mousePressed(float x, float y) {
    }

    /**
     * Called when the mouse button is released
     *
     * @param x x-coordinate of the mouse
     * @param y y-coordinate of the mouse
     */
    protected void mouseReleased(float x, float y) {
    }

    /**
     * Called when the mouse button is clicked
     *
     * @param x x-coordinate of the mouse
     * @param y y-coordinate of the mouse
     */
    protected void mouseClicked(float x, float y) {
    }

    /**
     * Called when the mouse button is dragged
     *
     * @param x x-coordinate of the mouse
     * @param y y-coordinate of the mouse
     */
    protected void mouseDragged(float x, float y) {
    }

    /**
     * Called when the mouse button is moved
     *
     * @param x x-coordinate of the mouse
     * @param y y-coordinate of the mouse
     */
    protected void mouseMoved(float x, float y) {
    }

    /**
     * Called when the mouse wheel is scrolled
     *
     * @param x     x-coordinate of the mouse
     * @param y     y-coordinate of the mouse
     * @param steps steps of the mouse wheel
     */
    protected void mouseScrolled(float x, float y, int steps) {
    }
}
