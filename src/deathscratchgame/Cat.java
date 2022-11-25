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
import javax.swing.JPanel;

/**
 *
 * @author NK
 */
public class Cat extends JPanel {
    public int x=0,y=290,width=120,height=120;
    public Image imgCat;

    Cat(){
        String imageLocation = "img/CG.gif";
        URL imageURL = this.getClass().getResource(imageLocation);
        imgCat = Toolkit.getDefaultToolkit().getImage(imageURL);
    }
    public Image getCat(){
        return imgCat;
    }
    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,width,height));
    }

}
