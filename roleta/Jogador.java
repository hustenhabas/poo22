
package roleta;


public class Jogador {
    private int fichas = 100;

	public int getFichas() {
		return fichas;
	}

	public void descontar(int fichas) {
		this.fichas -= fichas;
		if (this.fichas < 0) {
			this.fichas = 0;	
		}
	}
	public void setFichas(int fichas) {
		this.fichas = fichas;
	}
	public void receber(int valor) {
		this.fichas += valor;
	}
}
