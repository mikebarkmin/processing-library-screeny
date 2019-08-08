package eu.barkmin.processing.screeny;

public abstract class Screen {

    /**
     * Called, when a Screen is first added to the history.
     */
    public abstract void start();

    /**
     * Called, when a Screen move to the top of the history and will be drawn again.
     */
    public abstract void restart();

    /**
     * Called, when a Screen is at the top of the history. Like the draw method of processing, it is called x-times as second depending on the frame rate.
     */
    public abstract void draw();

    /**
     * Called, when a Screen moves to the second place of the history.
     */
    public abstract void stop();

    /**
     * Called, when a Screen is removed from the history.
     */
    public abstract void destroy();
}
