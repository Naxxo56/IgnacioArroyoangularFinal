import java.util.Scanner;

public class zonasEntradas {
    static int salaPrincipal = 1000;
    static int zonaCompraVenta = 200;
    static int vip = 25;
    static String zonaUno = "salaprincipal";
    static String zonaDos = "zonacompraventa";
    static String zonaTres = "vip";
    static String opcionZona = "";
    static int numeroEntradasPrincipal = 0;
    static int numeroEntradasCompraVenta = 0;
    static int numeroEntradasVip = 0;
    static Scanner teclado = new Scanner(System.in);

    public static int getNumeroEntradasPrincipal() {
        return numeroEntradasPrincipal;
    }

    public static int getNumeroEntradasCompraVenta() {
        return numeroEntradasCompraVenta;
    }

    public static int getNumeroEntradasVip() {
        return numeroEntradasVip;
    }

    public static String getZonaUno() {
        return zonaUno;
    }

    public static String getZonaDos() {
        return zonaDos;
    }

    public static String getZonaTres() {
        return zonaTres;
    }

    public static int getSalaPrincipal() {
        return salaPrincipal;
    }

    public static void setSalaPrincipal(int salaPrincipal) {
        zonasEntradas.salaPrincipal = salaPrincipal;
    }

    public static int getZonaCompraVenta() {
        return zonaCompraVenta;
    }

    public static void setZonaCompraVenta(int zonaCompraVenta) {
        zonasEntradas.zonaCompraVenta = zonaCompraVenta;
    }

    public static int getVip() {
        return vip;
    }

    public static void setVip(int vip) {
        zonasEntradas.vip = vip;
    }

    public static void mostrarEntradas() {
        System.out.printf("Sala principal:%d%n--------%nZona compra venta:%d%n--------%nVip:%d%n--------%n",
                getSalaPrincipal(), getZonaCompraVenta(), getVip());
    }

    public static void venderEntradas() {
        System.out.printf("Que entradas quieres escriba una de las siguientes:%nsalaprincipal%n---%nzonacompraventa%n---%nvip %n");
        opcionZona = teclado.next();
        if (opcionZona.equals("salaprincipal")) {
            System.out.println("Has elegido sala principal");

            System.out.printf("¿Cuantas entradas quieres?, nos quedan %d entradas%n", getSalaPrincipal());
            numeroEntradasPrincipal = teclado.nextInt();
        if (numeroEntradasPrincipal > salaPrincipal) {
                System.out.println("No disponemos de tantas entradas");
            } else if (numeroEntradasPrincipal < salaPrincipal) {
                System.out.printf("Has comprado %d entradas %n", getNumeroEntradasPrincipal());
                salaPrincipal -= numeroEntradasPrincipal;
                System.out.printf("Quedan %d entradas de la sala principal", getSalaPrincipal());
            }
        }
        if (opcionZona.equals("zonacompraventa")) {
            System.out.println("Has elegido zona compraventa");

            System.out.printf("¿Cuantas entradas quieres?, nos quedan %d entradas%n",getZonaCompraVenta());
            numeroEntradasCompraVenta=teclado.nextInt();
          if(numeroEntradasCompraVenta>zonaCompraVenta){
            System.out.println("No disponemos de tantas entradas");
        }else if (numeroEntradasCompraVenta<zonaCompraVenta){
            System.out.printf("Has comprado %d entradas %n", getNumeroEntradasCompraVenta());
            zonaCompraVenta -= numeroEntradasCompraVenta;

        }}
        if (opcionZona.equals("vip")) {
            System.out.println("Has elegido vip");

            System.out.printf("¿Cuantas entradas quieres?, nos quedan %d entradas%n", getVip());
            numeroEntradasVip = teclado.nextInt();
          if (numeroEntradasVip > vip) {
                System.out.println("No disponemos de tantas entradas");
            } else if (numeroEntradasVip < vip) {
                System.out.printf("Has comprado %d entradas %n", getNumeroEntradasVip());
                vip -= numeroEntradasVip;
            }
        }
    }
}
