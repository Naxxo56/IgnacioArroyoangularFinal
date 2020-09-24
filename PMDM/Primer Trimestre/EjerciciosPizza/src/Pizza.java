public class Pizza {
    String tamaño, tipo;
    String estado = "pedida";
    static int pizzasServidas = 0;
    static int pizzasPedidas = 0;

    public Pizza(String tamaño, String tipo) {
        this.tamaño = tamaño;
        this.tipo = tipo;
        pizzasPedidas++;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static int getPizzasServidas() {
        return pizzasServidas;
    }

    public static int getPizzasPedidas() {
        return pizzasPedidas;
    }

    public void mostrarPizza() {
        System.out.printf("Has pedido una pizza: %s. %nCon este tamaño: %s.%n" +
                "El estado de la pizza es: %s.%n---------------------%n", getTipo(), getTamaño(), getEstado());
    }

    public void sirve() {
        if (estado == "pedida") {
            setEstado("servida");
            pizzasServidas++;
            pizzasPedidas--;
        } else {
            System.out.println("Su pizza ya esta servida");
        }
    }

    public static void totalPedidas() {
        System.out.printf("El numero total de pizzas pedidas es de %d.%n------------------%n", getPizzasPedidas());
    }

    public static void totalServidas() {
        System.out.printf("El numero total de pizzas servidas es de %d.%n------------------%n", getPizzasServidas());
    }
}
