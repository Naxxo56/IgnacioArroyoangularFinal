//let elementos = document.querySelectorAll("div");
//console.log(elementos);
let inputUno = document.querySelector("#inputColl");
let inputDos = document.querySelector("#inputColl2");
let inputTres = document.querySelector("#inputColl3");


//let botonUno = document.querySelector("#botonColl");

/*
botonUno.addEventListener("click",()=>{
    console.log(inputUno.value);
    console.log(arg1);
    
});
*/



/*
function botonUnoPulsado(){
    console.log(inputUno.value);
}
function botonDosPulsado() {
    console.log(inputDos.value);
    
}
function botonTresPulsado() {
    console.log(inputTres.value);
}
*/



$("#botonColl").click(() => {
    console.log(inputUno.value);
});

$("#botonColl2").click(() => {
    console.log(inputDos.value);
});


$("#botonColl3").click(() => {
    console.log(inputTres.value);
});

/*
function inputPulsado(){
    console.log( document.querySelector("#inputColl2").value);
  
}
*/

function inputPulsado(evento) {
    console.log(evento.target.value);
}
