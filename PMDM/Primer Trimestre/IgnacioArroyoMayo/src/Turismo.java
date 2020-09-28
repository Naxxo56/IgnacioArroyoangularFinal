public class Turismo extends Coche{
    protected int cv;
    public Turismo(String modelo, String matricula, double precio,int cv) {
        super(modelo, matricula, precio);
        this.cv=cv;
    }

    @Override
    public String toString() {
        return "Turismo{" +
                "cv=" + cv +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precio=" + precio +
                '}';
    }
}
