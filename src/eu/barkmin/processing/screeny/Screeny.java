package eu.barkmin.processing.screeny;

import processing.core.PApplet;

public class Screeny {

    public static PApplet parent;
    private static Screeny instance;

    private Screeny(PApplet parent) {
        Screeny.parent = parent;
    }

    public static void init(PApplet parent) {
        Screeny.instance = new Screeny(parent);
    }

    /**
     * Gets the only Screeny Instance
     * @return the Screeny Object
     */
    public static Screeny getInstance() {
        return Screeny.instance;
    }
}
