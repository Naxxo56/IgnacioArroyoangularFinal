import utils.Persona;

public class Entrada {

    public static void main(String[] args) {
        Persona persona = new Persona("Nacho", "1234141e", 1234, 601285149);
        Persona persona2 = new Persona("Gerne", "1234141e", 1234, 601285149);
        Persona persona3 = new Persona("Roberto", "1234141e", 1234, 601285149);
        Persona persona4 = new Persona("Victor", "1234141e", 1234, 601285149);
        /*

        Ejecuta toda la persona y te da todos los parámetros dados en el constructor.
         System.out.println(persona.toString());

        Con los getter lo que hacemos es acceder a algo en concreto.
        System.out.println(persona.getNombre());

         */

        /*

        //Se ejecutan metodos
        persona.correr(5);
        persona.andar(6.5);

        //Se ve en pasos como han aumentado
        System.out.println(persona.toString());

        */

        Persona[] personas = {persona, persona2, persona3, persona4};

        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < personas.length; i++) {
                personas[i].correr((int) (Math.random() * 10));

            }
        }
    }
}
