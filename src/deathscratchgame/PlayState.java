/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deathscratchgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author NK
 */
public class PlayState extends JPanel {

    public boolean over = false;
    Home hg = new Home();
    private final ImageIcon fieldOver = new ImageIcon(this.getClass().getResource("img/StateBG.jpg "));
    private final ImageIcon field = new ImageIcon(this.getClass().getResource("img/HomeBG.jpg"));
    private final ImageIcon cloud = new ImageIcon(this.getClass().getResource("img/Cloud.gif"));
    private final ImageIcon floor = new ImageIcon(this.getClass().getResource("img/floor.gif"));
    private Cat cat = new Cat();
    private Obstacles enemy = new Obstacles();

    public ArrayList<Obstacles> obs = new ArrayList<Obstacles>();
    private int score = 0;
    private int count = 100;
    Thread addenemy = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {

                    obs.add(new Obstacles());
                    Thread.sleep(4250);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    PlayState() {
        this.setBounds(0, 0, 1000, 600);
        this.setFocusable(true);
        this.setLayout(null);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                    if (cat.y == 290) {
                        cat.y -= 150;
                        Timer jump = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (cat.y < 250) {
                                    cat.width = 90;
                                    cat.y = 290;
                                }
                            }
                        });
                        jump.setRepeats(false);
                        jump.start();
                        cat.width = 80;
                    
                    }
                }
            }

        });

        addenemy.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fieldOver.getImage(), 0, 0, 990, 590, this);
        g.drawImage(cloud.getImage(), 0, 0, 990, 550, this);
        g.drawImage(floor.getImage(), 0, -15, 990, 600, this);
        g.drawImage(cat.getCat(), cat.x, cat.y, 150, 220, this);

        for (int i = 0; i < obs.size(); i++) {
            g.drawImage(obs.get(i).enemy.getImage(), obs.get(i).getX(), obs.get(i).getY(), 100, 113, this);
        }
        score+=1;
        g.setColor(Color.WHITE);
        g.setFont(new Font("TH Chakra Petch", Font.CENTER_BASELINE, 40));
        g.drawString("Score " + score, 50,50);
        for (int j = 0; j < obs.size(); j++) {       
            if (Intersect(cat.getbound(), obs.get(j).getbound()) | obs.get(j).getY() > 900) {
                this.setLayout(null);
                over = true;
                System.out.println(over);
            }
            
        }
        
        
        if (over) {
            this.setLayout(null);
            g.drawImage(field.getImage(), 0, 0, 1000, 813, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("TH Chakra Petch", Font.CENTER_BASELINE, 80));
            g.drawString("Game Over", 280, 300);
            g.drawString("Score " + score, 280, 400);
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }


}
