//let elementos = document.querySelectorAll("div");
//console.log(elementos);
let inputUno = document.querySelector("#inputColl");
let inputDos = document.querySelector("#inputColl2");
let inputTres = document.querySelector("#inputColl3");
let botonUno = document.querySelector("#botonColl");

/*
botonUno.addEventListener("click",()=>{
    console.log(inputUno.value);
    console.log(arg1);
    
});
*/



/*
function botonUnoPulsado(){
    console.log(inputUno.nodeValue);
}
function botonDosPulsado() {
    console.log(inputDos.nodeValue);
    
}
function botonTresPulsado() {
    console.log(inputTres.nodeValue);
}
*/

$("#botonColl").click(()=>{
console.log(inputUno.value);
});

