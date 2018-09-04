
package roleta;
import java.util.Random;
public class Bot {
    private int fichas = 100;
    private boolean zerado = false;
    Random rd = new Random();
    public int apostar() {
        
        return rd.nextInt(45);
    }
    public int quantidadeFichas() {
        return rd.nextInt(fichas/2);
    }
}
