package roleta;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JButton;
public class Roleta {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		//frame
		JFrame frame = new JFrame();
		JPanel panel2;
		FlowLayout fl;
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Roleta");
        frame.setSize(800, 600);
        frame.setLocation(400, 300);
        //Panel
        fl = new FlowLayout();
        panel2 = new JPanel();
        JButton Francesa = new JButton("Francesa");
		panel2.add(Francesa);
		JButton Europeia = new JButton("Europeia");
		panel2.add(Europeia);
		JButton Americana = new JButton("Americana");
		panel2.add(Americana);
		Francesa.addActionListener(new RoletaFrancesa());
		Americana.addActionListener(new RoletaAmericana());
		Europeia.addActionListener(new RoletaEuropeia());
		panel2.setLayout(fl);
		
        frame.add(panel2);
        //-------

    }
}
