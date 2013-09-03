package nl.duckson.zombiesiege;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 02/09/2013
 * Time: 17:25
 */
public class PlayingField extends JPanel {

    private static int PARTICLE_COUNT = 1024 * 20;
    private Random random;

    public PlayingField() {
        // Random is geen singleton vanwege de (optionele?) seeding
        random = new Random();
        // En wat is het verschil tussen `this.random` en `random`?
        // Heeft het iets met getters en setters te doen?
    }

    private void drawGraphicSomething(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.darkGray);

        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        for(int i = 0; i < PARTICLE_COUNT; i++) {
            int x = Math.abs(random.nextInt()) % w;
            int y = Math.abs(random.nextInt()) % h;

            g2d.drawLine(x, y, x, y); // Want een lijn die nergens naartoe gaat
                                      // is in principe een stipje...
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Wat houdt het type `Graphics` eigenlijk in? :/
        drawGraphicSomething(g);
    }

    public int getParticleCount() {
        return PARTICLE_COUNT;
    }
}
