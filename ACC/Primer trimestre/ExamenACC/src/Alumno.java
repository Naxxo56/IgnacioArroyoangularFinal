import java.io.Serializable;

public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre, especialidad;
    private int id, curso;

    public Alumno(String nombre, String especialidad, int id, int curso) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.id = id;
        this.curso = curso;
    }

    public Alumno() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", id=" + id +
                ", curso=" + curso +
                '}';
    }
}
