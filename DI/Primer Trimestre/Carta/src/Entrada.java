import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Entrada {

    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();
        String[]palos ={"Oros","Bastos","Copas","Espadas"};
        for (int i = 0; i < 10; i++) {
            int posicionPalo = (int)(Math.random()*4);
            cartas.add(new Carta((int)(Math.random()*10),palos[posicionPalo]));
        }
        for (Carta item:cartas) {
            System.out.println(item);
        }
    }
}
