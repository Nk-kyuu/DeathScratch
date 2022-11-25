/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deathscratchgame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.*;
/**
 *
 * @author NK
 */
public class Home extends JPanel {
    private final ImageIcon field = new ImageIcon(this.getClass().getResource("img/HomeBG.jpg"));
    private ImageIcon Start = new ImageIcon(this.getClass().getResource("img/hd.png"));
    public JButton BStart = new JButton("Start");
    Home(){
        setLayout(null);
        add(BStart);
        BStart.setBounds(420,450,150,70);
        add(BStart);
   }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(field.getImage(),0,0,990,590,this);

   }
}
