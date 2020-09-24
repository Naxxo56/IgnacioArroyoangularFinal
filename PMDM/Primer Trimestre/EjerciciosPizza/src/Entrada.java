public class Entrada {

    public static void main(String[] args) {
        Pizza p1 = new Pizza("mediana","margarita");
        Pizza p2= new Pizza("familiar","funghi");
        Pizza p3 = new Pizza("mediana","cuatro quesos");
        p1.mostrarPizza();
        p2.mostrarPizza();//Muestra todos los datos de la pizza, su tamaño, su tipo y su estado.
        p3.mostrarPizza();

        p1.sirve();//Sirve la pizza y aumenta el contador de servidas y disminuye el de pedidas.
        p3.sirve();


        p1.sirve();//Dira que la pizza esta servida porque ya la hemos servido arriba.

        Pizza.totalPedidas();//Muestra el total de pizzas pedidas.
        Pizza.totalServidas();//Muestra el total de pizzas servidas.


    }

}
