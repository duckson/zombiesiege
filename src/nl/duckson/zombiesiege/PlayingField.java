package nl.duckson.zombiesiege;

import nl.duckson.zombiesiege.entity.*;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 02/09/2013
 * Time: 17:25
 */
public class PlayingField extends JPanel implements ActionListener {

    protected Timer timer;
    protected Player player;
    protected ArrayList<Entity> entities;

    public PlayingField() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setDoubleBuffered(true);

        entities = new ArrayList<Entity>();

        spawnPlayer();
        spawnZombies();

        timer = new Timer(25, this);
        timer.start();
    }

    private void spawnPlayer()  {
        player = new Player();
        player.moveTo(Game.GAME_WIDTH / 2 - 32, Game.GAME_HEIGHT / 2 - 32);
    }

    private void spawnZombies() {
        for(int i = 0; i < 10; i++) {
            Zombie z = new Zombie();
            z.moveTo((int) (Math.random() * 180), (int) (Math.random() * 180));
            entities.add(z);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        if(player.isVisible())
            g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);

        for(Entity e : entities) {
            if(e.isVisible())
                g2d.drawImage(e.getImage(), e.getX(), e.getY(), this);
        }

        for(Bullet b : player.bullets) {
            if(b.isVisible())
                g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent event) {
        for(int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            if(e.isVisible()) {
                e.move();
            } else {
                System.out.printf("Removing entity %s\n", e.toString());
                entities.remove(i);
            }
        }

        for(int i = 0; i < player.bullets.size(); i++) {
            Bullet b = player.bullets.get(i);

            if(b.isVisible()) {
                b.move();
            } else {
                System.out.printf("Removing bullet %s\n", b.toString());
                player.bullets.remove(i);
            }
        }

        player.move();
        checkCollisions();
        repaint();
    }

    /**
     * Check if any bullet clips an entity, and remove both if so.
     */
    public void checkCollisions() {
        for(Bullet b : player.bullets) {
            Rectangle bullet_rect = b.getBounds();

            for(Entity e : entities) {
                Rectangle entity_rect = e.getBounds();

                if(bullet_rect.intersects(entity_rect)) {
                    System.out.printf("Collision detected! %s %s\n", b.toString(), e.toString());
                    b.setVisible(false);
                    e.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}
