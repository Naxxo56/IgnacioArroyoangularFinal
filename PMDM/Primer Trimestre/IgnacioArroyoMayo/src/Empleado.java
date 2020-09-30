public class Empleado {
    private int numEmpleado;
    private String nombre, dni, clave;
     public static double salario = 1200;

    public Empleado(int numEmpleado, String nombre, String dni, String clave) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.dni = dni;
        this.clave = clave;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


}
