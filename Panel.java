
package roleta;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {
    int x;
    int y;
    int r = 250;
    Thread runner;
    public Panel() {
        this.setBackground(Color.BLACK);
        start();
    }
 
   public void start() {
     if (runner == null) {
       runner = new Thread( this);
       runner.start();
     }
   }

  
    @Override
   public void run() {
     while (true) {
       for (int i = 0; i < 360; i++) {
            x =  (int) (Math.cos(Math.toRadians(i)) * r);
            y = (int) (Math.sin(Math.toRadians(i)) * r);
            System.out.println(x + " " + y);        
            repaint();
            try { Thread.sleep(20); }
             catch (InterruptedException e) { }
            }
        }
     
   }

    private void doDrawing(Graphics g) {
       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.rotate(90);
        g.setColor(Color.white);
        g.drawLine(0,0, x, y);
        
        
        
    }

    
}
