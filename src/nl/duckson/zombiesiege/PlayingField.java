package nl.duckson.zombiesiege;

import nl.duckson.zombiesiege.bullet.Bullet;
import nl.duckson.zombiesiege.entity.*;
import nl.duckson.zombiesiege.weapon.Weapon;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

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

    protected JLabel currentWeaponLabel;

    public PlayingField() {
        addKeyListener(new TAdapter());
        addMouseListener(new MCAdapter());
        addMouseMotionListener(new MAdapter());
        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setDoubleBuffered(true);

        drawLabels();

        entities = new ArrayList<Entity>();

        spawnPlayer();
        spawnZombies(20);

        timer = new Timer(25, this);
        timer.start();
    }

    private void spawnPlayer()  {
        player = new Player();
        player.moveTo(Game.GAME_WIDTH / 2 - 32, Game.GAME_HEIGHT / 2 - 32);
    }

    private void spawnZombies(int n) {
        for(int i = 0; i < n; i++) {
            Zombie z = new Zombie();
            z.moveTo((int) (Math.random() * 180), (int) (Math.random() * 180));
            entities.add(z);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        if(player.isVisible()) {
            g2d.drawImage(player.getImage(), player.getAffineTransform(), this);
        }

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

        checkPlayerFire();
        player.move();
        checkCollisions();
        checkRespawn();
        updateLabels();
        repaint();
    }

    private void checkPlayerFire() {
        if(player.isFiring()) {
            // Only fire automatic weapons every other tick
            if(weapon_tick == 1) {
                player.fire();
                player.getWeapon().playFireSound();

                weapon_tick = 0;
            } else {
                weapon_tick++;
            }
        }
    }
    private int weapon_tick = 0;

    private void checkRespawn() {
        if(entities.size() < 2) {
            spawnZombies(8);
        }
    }

    /**
     * Check if any bullet clips an entity, and remove both if so.
     */
    public void checkCollisions() {
        for(Bullet b : player.bullets) {
            if(!b.isVisible()) continue;
            Rectangle bullet_rect = b.getBounds();

            for(Entity e : entities) {
                if(!e.isVisible()) continue;
                Rectangle entity_rect = e.getBounds();

                if(bullet_rect.intersects(entity_rect)) {
                    System.out.printf("Collision detected! %s %s\n", b.toString(), e.toString());
                    b.setVisible(false);
                    e.setVisible(false);
                }
            }
        }
    }

    public void drawLabels() {
        // Player name
        currentWeaponLabel = new JLabel("", JLabel.CENTER);
        add(currentWeaponLabel);
        // Weapon name
//        add(new JLabel(player.getWeapon().getName(), JLabel.LEFT));
    }

    public void updateLabels() {
        Weapon w = player.getWeapon();
        // @todo: Change this, it's terrible
        currentWeaponLabel.setText(
                player.getName() +
                        " | " +
                        w.getName() +
                        " | " +
                        player.getHitpoints() + "HP" +
                        " | " +
                        w.remainingAmmunition() + "/" + w.maximumAmmunition() +
                        " bullets"
        );
    }

    // Adapters & listeners
    private class MAdapter extends MouseMotionAdapter {
        public void mouseMoved(MouseEvent e) {
            player.watch(e.getX(), e.getY());
        }
    }

    private class MCAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if(player.getWeapon().isAutomatic()) {
                // Start firing
                player.setFiring(true);
                player.getWeapon().playStartFiringSound();
            } else {
                // Fire the non-automatic once
                player.fire();
                if(!player.getWeapon().isOutOfAmmunition())
                    player.getWeapon().playFireSound();
                else
                    player.getWeapon().playEmptyFireSound();
            }
        }

        public void mouseReleased(MouseEvent e) {
            if(player.getWeapon().isAutomatic()) {
                // Stop firing
                player.setFiring(false);
                player.getWeapon().playStopFiringSound();
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
