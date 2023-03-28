// -- ENVIRONMENT --

const prompt = require('prompt-sync')();

function printAll() {
    console.clear();
    console.log(` <- CIRCULO ->
Radio: ${this.rad} 
Area: ${this.area}
Circunferencia: ${this.circunference}`);
}
function area(rad) { return Math.PI * Math.pow(rad, 2); }
function perim(rad) { return 2 * Math.PI * rad; }

function Circle(rad) {
    this.rad = rad.toFixed(2);
    this.area = area(rad).toFixed(2);
    this.circunference = perim(rad).toFixed(2);
    this.printCirc = printAll;
}

// -- AMBIENCE --

console.clear();

let rad = parseInt(prompt('> Ingrese el radio del circulo: '));

let circ = new Circle(rad);

circ.printCirc();