
package roleta;


public class Jogador {
    private int fichas = 100;
    public void receber(int valor) {
        fichas += valor;
    }   
    public int apostarFichas(int apostadas, int id) {
        if (apostadas > fichas) {
            System.out.println("Fichas insuficientes");
            return -1;
        }
        fichas -= apostadas;
        return id;
    }
    public void isZerado() {
        if (fichas == 0) {
            System.out.println("acabou o jogo");
        }
    }
    public int getFichas() {
        return fichas;
    }

}
