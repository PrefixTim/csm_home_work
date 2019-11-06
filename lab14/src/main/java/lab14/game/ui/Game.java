package lab14.game.ui;

import lab14.App;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class Game extends JFrame {
    private JPanel mainPanel;
    private JButton playBtn;
    private JTextPane gameLog;
    private JLabel score;
    private JPanel gamePanel;
    private JLabel stateLabel;
    private JPanel table;
    private JPanel statistic;
    private JList dices;

    public Game() throws IOException {
        Properties prop = new Properties();
        prop.loadFromXML(App.class.getResourceAsStream("prop.xml"));
        this.setTitle(prop.getProperty("ui.title"));
        this.setIconImage(new ImageIcon(App.class.getResource(prop.getProperty("ui.icon"))).getImage());
        playBtn = new JButton(prop.getProperty("ui.play_btn.start"));
        mainPanel = new JPanel();
        mainPanel.add(playBtn);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
