
package roleta;
import java.util.Random;
public class Europeia extends Roleta {
    // 0 = 0
    // 1 = 1
    // ...
    // 36 = 36
    //37 = Par
    //38 = Impar
    //39 = high
    //40 = low
    //41 = to12
    //42 = to24
    //43 = to36
    //44 = red
    //45 = black
    @Override
    int aposta(int id, int valor) {
        int resultado = roletaGira();
        for (int i = 0; i < 36; i++) {
            if (id == i && resultado == i) {
                return valor * 36;
            }
        }
        if (id == 37 && resultado % 2 == 0 ||
            id == 38 && resultado % 2 != 0 ||
            id == 39 && resultado >= 18    ||
            id == 40 && resultado < 18     ||
            id == 44 && resultado % 2 == 0 ||
            id == 45 && resultado % 2 != 0) {
                return valor * 2;
            } else if (id == 41 && resultado < 12 ||
                       id == 42 && 12 <= resultado && resultado <= 24 ||
                       id == 43 && resultado > 24) {
                return valor * 3;
            }
        return 0;
    }
    
    private int roletaGira() {
        Random rd = new Random();
        return rd.nextInt(36) ;
    }
}
