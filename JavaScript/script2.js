const prompt = require('prompt-sync')();

let rad = parseInt(prompt('Radio de la circunferencia: '));

let area = (Math.PI * Math.pow(rad, 2)).toFixed(2);
let perim = (2 * Math.PI * rad).toFixed(2);

console.log(`\nArea: ${area}
Perimetro: ${perim}`);