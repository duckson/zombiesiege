package ZombieSiege;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 02/09/2013
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void guiStuff() {
        JFrame frame = new JFrame("ZombieSiege");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello world");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                guiStuff();
            }
        });
    }
}
