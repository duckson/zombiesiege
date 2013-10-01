package nl.duckson.zombiesiege;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 23/09/2013
 * Time: 17:58
 */
public class Game extends JFrame {
    public static final int GAME_WIDTH = 800,
                            GAME_HEIGHT = 600;
    public Game() {
        add(new PlayingField());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("ZombieSiege");
        setResizable(false);
        setVisible(true);
    }

    // Sound playing helper method
    public static void playSound(final String path) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            this.getClass().getResourceAsStream("/res/" + path));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println("Sound error!");
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new Game();
    }
}
