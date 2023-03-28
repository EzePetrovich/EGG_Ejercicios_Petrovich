const prompt = require('prompt-sync')();

let num = parseInt(prompt('» Ingrese un numero: '));

if(num % 2 === 0 && num !== 0) { console.log('El numero es par.'); }
else if(num !== 0) { console.log('El numero es impar.'); }
else { console.log('El numero no es par ni impar.'); }