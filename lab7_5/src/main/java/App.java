import view.panels.CrossPanel;
import view.panels.Fig4_20;
import view.panels.Fig4_21;

/**
 * Tim Malko
 * Creates windows with drawing for assigment
 */
public class App {
    public static void main(String[] args) {
        // window with "Simple 2-D Drawing" Fig. 4.21
        new Window(new Fig4_21(40), 1440, 720);
        // window with "Simple 2-D Drawing" Fig. 4.20
        new Window(new Fig4_20(40), 1440, 720);
        // window with two cross
        new Window(new CrossPanel(), 1440, 720);
    }
}
