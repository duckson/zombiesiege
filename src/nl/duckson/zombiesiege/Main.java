package nl.duckson.zombiesiege;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 02/09/2013
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
class Main {
    private static void guiStuff() {
        JFrame frame = new JFrame("ZombieSiege");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PlayingField pf = new PlayingField();

        frame.getContentPane().add(pf);
        pf.setVisible(true);

        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                guiStuff();

            }
        });
    }
}
