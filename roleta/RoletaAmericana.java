package roleta;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoletaAmericana extends RoletaBase{
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
		
		for (int i = 0; i < 47; i++) {
			JCheckBox checkBox = new JCheckBox();
			String l = "";
			
			if (i >= 1 && i < 38) {
				l = Integer.toString((i - 1));
			} else if (i == 0) {
				l = "00";
			}
			if (i == 38) {
			    l = "par";
			} else if (i == 39) {
			    l = "ímpar";
			} else if (i == 40) {
			    l = "vermelho";
			} else if (i == 41) {
			    l = "preto";
			} else if (i == 42) {
			    l = "1 a 18";
			} else if (i == 43) {
			    l = "19 a 36";
			} else if (i == 44) {
			    l = "1 a 12";
			} else if (i == 45) {
			    l = "13 a 24";
			} else if (i == 46) {
			    l = "25 a 36";
			}
			JLabel label = new JLabel(l);
			
			cb.add(checkBox);
			panel2.add(checkBox);
			panel2.add(label);
		}
		
	}
	
}


