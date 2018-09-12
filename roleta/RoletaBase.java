package roleta;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

abstract class RoletaBase extends JPanel implements ActionListener {
	JLabel valor;
	JSlider slider;
	Jogador jogador;
	JLabel fichasMax;
	JPanel panel;
	JPanel panel2;
	JPanel panel3;
	Listener v;
	Passar p;
	FlowLayout fl; 
	ArrayList<JCheckBox> cb = new ArrayList<>();
	Random rd;
	JLabel erro;
	JLabel passe;
	Font font;
	ArrayList<Integer> apostados = new ArrayList<>();
	private int passadas = 0;
	abstract boolean podeApostar();
	private static final long serialVersionUID = 1L;
	abstract void desenharCheckbox();
	@Override
	public void actionPerformed(ActionEvent e) {
		desenhaFrame();
		desenhaSlider();
		desenhaLabels();
		desenhaBotao();
		desenhaLabels2();
		desenharCheckbox();
		//
	}
	public class Listener implements ChangeListener , ActionListener{ 
		@Override
		public void stateChanged(ChangeEvent v) {
			valor.setText("Valor: " + slider.getValue());
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			int fichas;
			if (podeApostar()) {
				jogador.descontar(slider.getValue());
				erro.setVisible(false);
				passadas = 0;
				passe.setText("Passadas: 0");  
			} else if (jogador.getFichas() == 0) {
				erro.setText("Você perdeu");
				erro.setFont(font);
				erro.setBounds(panel.getWidth()/2 , panel.getHeight()/2, 300,110);
				erro.setVisible(true);
			} else {
				erro.setVisible(true);
			}
			fichas = jogador.getFichas();
			slider.setMaximum(fichas);
			fichasMax.setText("Fichas: " + fichas);
		}
	}
	public class Passar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			passadas += 1;
			passe.setText("Passadas: " + passadas);
			if(passadas > 3) {
				passadas = 3;
				passe.setText("Você não pode mais passar");
			}
		}
	}
	public void desenhaLabels2() {
		erro = new JLabel("Não foi possivel apostar");
		erro.setVisible(false);
		erro.setBounds(200, 270, 300, 100);//panel.getWidth()/2 , panel.getHeight()/2, 80,10);
		panel.add(erro);
		//passadas
		passe = new JLabel("Passadas: 0");
		passe.setBounds(720, 370, 300, 100);
		panel.add(passe);
	}
	public void desenhaBotao() {
		JButton apostar = new JButton("Apostar");
		apostar.setBounds(200, 400, 110, 30);;
		apostar.addActionListener(v);
		panel.add(apostar);
		JButton passar = new JButton("Passar");
		passar.setBounds(600, 400, 110, 30);;
		passar.addActionListener(p);
		panel.add(passar);
	}
	public void desenhaLabels() {
		valor = new JLabel("Valor: 25");
		valor.setBounds(340, 360, 70, 10);
		fichasMax = new JLabel("Fichas: " + jogador.getFichas());
		font = new Font("Serif", Font.BOLD, 40);
		fichasMax.setFont(font);
		fichasMax.setBounds(10, 50, 200, 40);
		panel.add(fichasMax);
		panel.add(valor);
	}
	public void desenhaSlider() {
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		slider.setBounds(185, 350, 150, 40);
		panel.add(slider);
		v = new Listener();
		p = new Passar();
		slider.addChangeListener(v);
	}
	public void desenhaFrame() {
		jogador = new Jogador();
		rd = new Random();
		JFrame frame = new JFrame();
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocation(400, 300);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(fl);
	}
}