const prompt = require('prompt-sync')();

let old = parseInt(prompt('Cuantos anios tiene?: '));

if(old >= 18) { console.log('\nUsted es mayor de edad.'); }
else { console.log('\nUsted todavia come queso.'); }