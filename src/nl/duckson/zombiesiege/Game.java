package nl.duckson.zombiesiege;

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

    public static void main(String[] args) {
        new Game();
    }
}
