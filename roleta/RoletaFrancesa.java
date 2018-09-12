package roleta;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoletaFrancesa extends RoletaBase{
	private static final long serialVersionUID = 1L;
	@Override
	boolean podeApostar() {
		int especiais = 0;
		int normais = 0;
		if (jogador.getFichas() > 0) {
			for(int i = 0; i < 46; i++) {
				if (cb.get(i).isSelected()) {
					if(i > 36) {
						especiais++;
					} else {
						normais++;
					}
				}
			}
			if (especiais > 1) {
				return false;
			} else if (normais > 0 && especiais == 1) {
				return false;
			} else if (normais > 6 ) {
				return false;
			} else if (normais + especiais == 0) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	@Override
	void desenharCheckbox() {
		fl = new FlowLayout();
		panel2 = new JPanel();
		panel2.setLayout(fl);
		panel2.setBounds(300, 60,505, 700);
		fl.setHgap(10);
		panel.add(panel2);
		
		for (int i = 0; i < 46; i++) {
			JCheckBox checkBox = new JCheckBox();
			String l = " ";
			if (i >= 0 && i < 37) {
				l = Integer.toString(i);
			}if (i == 37) {
			    l = "par";
			} else if (i == 38) {
			    l = "ímpar";
			} else if (i == 39) {
			    l = "vermelho";
			} else if (i == 40) {
			    l = "preto";
			} else if (i == 41) {
			    l = "1 a 18";
			} else if (i == 42) {
			    l = "19 a 36";
			} else if (i == 43) {
			    l = "1 a 12";
			} else if (i == 44) {
			    l = "13 a 24";
			} else if (i == 45) {
			    l = "25 a 36";
			}
			JLabel label = new JLabel(l);
			
			cb.add(checkBox);
			panel2.add(checkBox);
			panel2.add(label);
		}
		
	}
	
}
/*
package roleta;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class RoletaFrancesa extends JPanel implements ActionListener {
	JLabel valor;
	JSlider slider;
	Jogador jogador;
	JLabel fichasMax;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	FlowLayout fl; 
	ArrayList<JCheckBox> cb = new ArrayList<>();
	Random rd;
	
	private int resultado;
	private int apostado;
	private boolean podeApostar = true;
	private static final long serialVersionUID = 1L;
	public RoletaFrancesa() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jogador = new Jogador();
		rd = new Random();
		JFrame frame = new JFrame();
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Francesa");
        frame.setSize(900, 600);
        frame.setLocation(400, 300);
        // panel
		panel = new JPanel();
        frame.add(panel);
        panel.setLayout(fl);
        // slider
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		slider.setBounds(185, 350, 150, 40);
		panel.add(slider);
		Valor v = new Valor();
		slider.addChangeListener(v);
		// label
		valor = new JLabel("Valor: 25");
		valor.setBounds(340, 360, 70, 10);
		fichasMax = new JLabel("Fichas: " + jogador.getFichas());
		fichasMax.setBounds(10, 50, 70, 10);
		panel.add(fichasMax);
		panel.add(valor);
		// Jbutton
		JButton apostar = new JButton("apostar");
		apostar.setBounds(200, 400, 110, 30);;
		apostar.addActionListener(v);
		panel.add(apostar);
		//
		fl = new FlowLayout();
		panel2 = new JPanel();
		panel2.setLayout(fl);
		panel2.setBounds(300, 60,505, 700);
		fl.setHgap(10);
		panel.add(panel2);
		
		for (int i = 0; i < 46; i++) {
			JCheckBox checkBox = new JCheckBox();
			String l = " ";
			if(i >= 0 && i < 37) {
				l = Integer.toString(i);
			} else if (i >= 37) {
				l = "tey";
			}
			JLabel label = new JLabel(l);
			
			cb.add(checkBox);
			panel2.add(checkBox);
			panel2.add(label);
		}
		
	}
	public class Valor implements ChangeListener , ActionListener{ 
		@Override
		public void stateChanged(ChangeEvent v) {
			valor.setText("Valor: " + slider.getValue());
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int fichas = jogador.getFichas();
			if (podeApostar) {
				jogador.descontar(slider.getValue());
			}
			slider.setMaximum(fichas);
			fichasMax.setText("Fichas: " + fichas);
		}
	}
}
*/