const prompt = require('prompt-sync')();
let max = Number.MIN_SAFE_INTEGER;
let min = Number.MAX_SAFE_INTEGER;
let cont = 0;
let acm = 0;
let input = 0;

do {
    console.clear();
    input = parseInt(prompt('» Ingrese un numero [0 para salir]: '));
    if(!Number.isNaN(input)) {
        cont++;
        acm += input;
        if(input > max) { max = input; }
        else if(input < min) { min = input; }
    }
} while(input !== 0 || Number.isNaN(input));

console.clear();

let prom = Math.trunc(acm / cont);

console.log(`Maximo: ${max}
Minimo: ${min}
Promedio: ${prom}`);