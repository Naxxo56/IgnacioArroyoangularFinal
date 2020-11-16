public class Entrada {
    public static void main(String[] argrs) {

        Hilo h = null;
        for (int i = 0; i < 3; i++) {
            h = new Hilo(i + 1); // Se crea el hijo
            h.start(); // Se inicia el hijo
        }
        System.out.println("3 HILOS CREADOS...");

    }
}


