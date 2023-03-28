const prompt = require('prompt-sync')();
function sumar(a, b) { return a + b; }
function restar(a, b) { return a - b; }
function multiplicar(a, b) { return a * b; }
function dividir(a, b) { return (a / b).toFixed(2); }

let operVals = ['S', 'R', 'M', 'D'];

let operations = new Map();

operations.set('S', sumar);
operations.set('R', restar);
operations.set('M', multiplicar);
operations.set('D', dividir);

console.log('CALCULADORA\n');
let operLetter = prompt('Que operacion desea realizar? [S|R|M|D]: ').toUpperCase();
if(operVals.includes(operLetter)) {
    let operation = operations.get(operLetter);
    let a = parseInt(prompt('Ingrese A: '));
    let b = parseInt(prompt('Ingrese B: '));
    console.log(`El resultado es ${operation(a, b)}`);
}
else { console.log('ERROR: la operacion ingresada no es valida.'); }


