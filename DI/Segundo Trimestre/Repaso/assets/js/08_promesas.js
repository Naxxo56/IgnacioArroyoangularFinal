
/*
let promesa = new Promise(function (resolve, reject) {

    let numero = 6;
    if (numero > 0) {
        //la promesa se resuelve bien
        resolve();
    } else {
        //la promesa no se resuelve
        reject();
    }

});
// promesa.then() -- ejecutando cuando la promesa ha terminado con resultado correcto
//romesa.catch -- ejecutado cuando la promesa ha terminado con un resultado incorrecto

promesa.then(function () {
    //se ejecuta cuando se ha cumplido el resolve
}, function () {
    //se ejecuta cuando ha cumplido el reject
}
).catch(function () {
    //se ejecuta cuando ha ocurrido algun problema o la promesa no contesta
});




let promesaFlecha = new Promise((resolve, reject) => {

    let numero = 6;

    numero > 0 ? resolve('acierto', 1) : reject('fallo', 5);
    //numero > 0 && resolve();

});

promesaFlecha.then(
    (mensaje, numero) => console.log("Ejecutado correctamente con mensaje" + mensaje + " y numero " + numero),
    (mensaje, numero) => console.log("Ejecutado con reject")
).catch(() => console.log("Ejecutado con error"));

*/


fetch('https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain'
).then((data) => data.json())
    .then((data) => {
        //console.log(data.teams)
        let equipos = data.teams;
        equipos.forEach(({ strTeam, intFormedYear }) => {
            //console.log(equipo);
            console.log(`Nombre: ${strTeam} Fundacion ${intFormedYear}`);
        });
    }
    ).catch(() => { console.log("Conexion erronea"); });
