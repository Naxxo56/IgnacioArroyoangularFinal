export class Tecnologia {
    nombre: string = "";
    descripcion: string = "";
    imagen: string = "";

    constructor(nombre: string, descripcion: string, imagen: string) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    get getNombre(){
        return this.nombre;
    }
    get getDesc(){
        return this.descripcion;
    }
    get getImagen(){
        return this.imagen;
    }
}

