package roletinha;

import java.awt.Dimension;
import javax.swing.JFrame;

class Frame extends JFrame {
   
    public Frame() {
    }

    public static void main(String[] args) {
        
        Frame ex = new Frame();
        ex.setSize(new Dimension(800, 600));
        Panel panel = new Panel();
        ex.add(panel);
        ex.setLocationRelativeTo(null);
        ex.setVisible(true);
        ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
    }
}
