package eu.barkmin.processing.screeny;

import java.util.Stack;

public class ScreenManager {

    private Stack<Screen> history;

    /**
     * Creates a new ScreenManager with an empty history.
     */
    public ScreenManager() {
        this.history = new Stack<>();
        Screeny.parent.registerMethod("draw", this);
    }

    /**
     * Adds a Screen to the top of the history and calls its start method. The previous Screen, which was at the top of the history, will be stopped.
     * @param screenyScreen a new Screen
     */
    public void start(Screen screenyScreen) {
        if (!history.empty()) {
            Screen currentScreenyScreen = history.peek();
            currentScreenyScreen.stop();
        }
        this.history.push(screenyScreen);
        screenyScreen.start();
    }

    /**
     * Removes the top of the history and calling its destroy method. The restart method of the new top will be called.
     */
    public void back() {
        if (!history.empty()) {
            Screen screenyScreen = this.history.pop();
            screenyScreen.destroy();
        }
        if (!history.empty()) {
            Screen newScreenyScreen = this.history.peek();
            newScreenyScreen.restart();
        }
    }

    /**
     * Calls the draw method of the top of the history.
     */
    public void draw() {
        if (!history.empty()) {
            Screen currentScreenyScreen = history.peek();
            currentScreenyScreen.draw();
        }
    }
}
