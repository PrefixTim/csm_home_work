import panels.CrossPanel;
import panels.SievePanel;

/**
 * Tim Malko
 * Creates windows with drawing for assigment
 */
public class App {
    public static void main(String[] args) {
        //window with "Simple 2-D Drawing" Fig. 4.20
        new Window(new SievePanel(40), 1440, 720);
        new Window(new CrossPanel(),1440, 720);
    }
}
