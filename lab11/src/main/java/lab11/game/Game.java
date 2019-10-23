package lab11.game;

import javax.swing.*;

public class Game implements Runnable{
    private boolean running = false;
    private JFrame jFrame = new JFrame();
    private JButton button1;

    private void init() {

        jFrame = new JFrame();
    }

    private void gameLoop(){
        while (running){

        }
    }

    @Override
    public void run() {
        running = true;
        init();
        gameLoop();
    }
}
