// crear un objeto partido (local,goleslocal,visitante,golesvisitante)

// Sacar en consola los equipos y resultados de todos los partidos
// Sevilla 4-2 Getafe
// Alineacion Sevilla: wfwefwef,fwrfwqr,wqfwrf
// Alineacion Getafe: wefdwer,wrferf,rger,dq

/*
let listaPartidos = [];
fetch("https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020")
    .then((data) => data.json())
    .then((dataJson) => {
        let partidos = dataJson.events;


        partidos.forEach(({ strHomeTeam, strAwayTeam, intHomeScore, intAwayScore,
            strHomeLineupGoalkeeper, strHomeLineupDefense, strHomeLineupMidfield, strHomeLineupForward,
            strAwayLineupGoalkeeper, strAwayLineupDefense, strAwayLineupMidfield, strAwayLineupForward }) => {
            console.log(`${strHomeTeam} ${intHomeScore} - ${intAwayScore} ${strAwayTeam}
              - Alineacion equipo local ${strHomeTeam}: ${strHomeLineupGoalkeeper},${strHomeLineupDefense},${strHomeLineupMidfield},${strHomeLineupForward}
              - Alineacion equipo visitante ${strAwayTeam}: ${strAwayLineupGoalkeeper},${strAwayLineupDefense},${strAwayLineupMidfield},${strAwayLineupForward}`);

            //listaPartidos.push(new Partido({strHomeTeam}, {intHomeScore}, {strAwayTeam}, {intAwayScore}));
        });


    })
    .catch(() => console.log("No ha cargado correctamente"));


listaPartidos.forEach(partido => {
    partido.mostrarDatos();
});
*/


function mostrarPartdo(equipo) {
    fetch("https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020")
        .then((data) => data.json())
        .then((dataJson) => {
            let partidos = dataJson.events;

            if (equipo.length == 0) {
                alert("Por favor introduce algo")
            } else {
                let contador = 0;

                partidos.forEach(({ strHomeTeam, strAwayTeam, intHomeScore, intAwayScore,
                    strHomeLineupGoalkeeper, strHomeLineupDefense, strHomeLineupMidfield, strHomeLineupForward,
                    strAwayLineupGoalkeeper, strAwayLineupDefense, strAwayLineupMidfield, strAwayLineupForward }) => {
                    if (strHomeTeam == equipo || strAwayTeam == equipo) {
                        contador++;
                        console.log(`${strHomeTeam} ${intHomeScore} - ${intAwayScore} ${strAwayTeam}
              - Alineacion equipo local ${strHomeTeam}: ${strHomeLineupGoalkeeper},${strHomeLineupDefense},${strHomeLineupMidfield},${strHomeLineupForward}
              - Alineacion equipo visitante ${strAwayTeam}: ${strAwayLineupGoalkeeper},${strAwayLineupDefense},${strAwayLineupMidfield},${strAwayLineupForward}`);

                    }

                    //listaPartidos.push(new Partido({strHomeTeam}, {intHomeScore}, {strAwayTeam}, {intAwayScore}));
                });
                contador < 0 && alert("Partidos no encontrados");
            }
        })
        .catch(() => console.log("No ha cargado correctamente"));

    let
}

let misPartidos = [];

function cargarPartidos(equipo) {
    fetch("https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020")
        .then((data) => data.json())
        .then((dataJson) => {
            let partidos = dataJson.events;

            if (equipo.length == 0) {
                alert("Por favor introduce algo")
            } else {
                let contador = 0;

                partidos.forEach(({ strHomeTeam, strAwayTeam, intHomeScore, intAwayScore,
                    strHomeLineupGoalkeeper, strHomeLineupDefense, strHomeLineupMidfield, strHomeLineupForward,
                    strAwayLineupGoalkeeper, strAwayLineupDefense, strAwayLineupMidfield, strAwayLineupForward }) => {
                    if (strHomeTeam == equipo || strAwayTeam == equipo) {
                        contador++;
                        let partidoIndividual = new Partido({ strHomeTeam }, { intHomeScore }, { strAwayTeam }, { intAwayScore });
                        misPartidos.push(partidoIndividual);

                    }

                });
                contador < 0 && alert("Partidos no encontrados");
            }
        })
        .catch(() => console.log("No ha cargado correctamente"));

    let
}

function mostrarCargados() {
    if (misPartidos.length > 0) {
        misPartidos.forEach(element => {
            element.mostrarDatos();
        });
    }

}








