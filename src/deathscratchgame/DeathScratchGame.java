/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deathscratchgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


/**
 *
 * @author NK
 */
public class DeathScratchGame extends JFrame implements ActionListener{
    Home Homegame = new Home();
    PlayState State = new PlayState();
    public DeathScratchGame(){
        this.setSize(1000,600);
        this.add(Homegame);
        Homegame.BStart.addActionListener(this);
       
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Homegame.BStart){
            this.setLocationRelativeTo(null);
            this.remove(Homegame);
            this.setSize(1000,600);
            this.add(State);
            State.requestFocusInWindow();
            
        }
        this.validate();
        this.repaint();
    }
    public static void main(String[] args) {
        JFrame frame = new DeathScratchGame();
        frame.setTitle("Death Scratch");
        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }

}
