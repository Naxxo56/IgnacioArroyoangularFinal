class Partido {
    local;
    golesLocal;
    visitante;
    golesVisitante;
    constructor(local, golesLocal, visitante, golesVisitante) {
        this.local = local;
        this.golesLocal = golesLocal;
        this.visitante = visitante;
        this.golesVisitante = golesVisitante;
    }

    mostrarDatos() {
        console.log(`${this.local} ${this.golesLocal} - ${this.golesVisitante} ${this.visitante}`);
    }
}

