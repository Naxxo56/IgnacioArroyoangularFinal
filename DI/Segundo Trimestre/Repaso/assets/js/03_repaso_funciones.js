//public void nombre(parametros){
// ejecuciones
//}

function funcionInicial() {
    console.log("Funcion inicial del repaso de JS");
}

function funcionParametros(parametro1,parametro2) {
    //console.log(parametro1);
    //console.log(parametro2);
    /*
    console.log(`La suma de los dos parámetros es ${parametro1+parametro2}`);

    if(arguments[2]){
        console.log(`Tengo parámetro adicional que es ${arguments[2]}`);
    }
    */

    /*
    for (let index = 0; index < arguments.length; index++) {
        const element = arguments[index];
        console.log(`El parametro en la posicion ${index} es:`);
        console.log(element);
    }
    */

    console.log(`Parametro1 ${parametro1}`);
    console.log(`Parametro2 ${parametro2}`);
    console.log(`Parametro adicional ${arguments[4]}`);
}

function funcionParametrosDefecto(parametro1,parametro2) {
    if (typeof parametro2 == "undefined") {
        parametro2 = "por defecto";
    }
    console.log(`${parametro1}`);
    console.log(`${parametro2}`);
}

function funcionConRetorno(parametro1=0,parametro2=0) {
    return parametro1+parametro2
}
//funciones anónimas
let variableFuncion = function (p1,p2,p3){
    console.log(`${p1}`);
    console.log(`${p2}`);
    console.log(`${p3}`);
}

let variableFuncionFlecha = () => console.log(`Llamada a la funcion de flecha`);
let variableFuncionFlechaAdicional = (p1,p2) => {
    console.log(`${p1}`);
    console.log(`${p2}`);
};

let variableFuncionFlechaRetorno = (p1,p2) => p1+p2; 
let variableFuncionFlechaRetornoAdicional = (p1,p2) => {
   return p1+p2;
};

function funcionConCallback(param1,param2,param3) {
    console.log(`El resultado de sumar ${param1} y ${param2} es ${param3(param1,param2)}`);
}

function funcionCallBackRetorno(param1,param2) {
    return (param1,param2) => {
        console.log(`La suma de los dos parametros es ${param1+param2}`);
    }
}



//funcionInicial();
//funcionParametros();
//funcionParametros(1,4);
//funcionParametros("adaq","ga",4)
//funcionParametros("stgw",23,5,"ga",false,true,5.3);
//funcionParametrosDefecto("hola",false);
/*
let suma = funcionConRetorno(4,7);
console.log(suma);
*/
variableFuncion();
//variableFuncionFlecha();
//variableFuncionFlechaAdicional(3,"asd");
//console.log(variableFuncionFlechaRetorno(2,6));
//console.log(variableFuncionFlechaRetornoAdicional(4,7));
funcionConCallback(1,5,(param1,param2)=>{
    let suma = param1+param2;
    return suma;
});