/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deathscratchgame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author NK
 */
public class Obstacles {
    ImageIcon enemy;
    Image img;
    public int x = (int) (1000+(Math.random() *200));
    public int y = 400;
    public int count = 0;

    Obstacles(){
        enemy = new ImageIcon(this.getClass().getResource("img/En.gif"));
        randc.start();
    }

    Thread randc = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x -= 15;
                if (x < -5) {
                    img = null;
                    randc = null;
                    x = (int) (1000+(Math.random() *200));
                    x = -10;
                }
                try {
                     randc.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    });


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,70,70));
    }
}
