const prompt = require('prompt-sync')();

let ok = ['S', 'N'];

let letter = prompt('Ingrese una letra: ');

if(ok.includes(letter)) { console.log('\nCORRECTO'); }
else { console.log('\nINCORRECTO'); }