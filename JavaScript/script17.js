// -- ENVIRONMENT --

const prompt = require('prompt-sync')();
function getRandomInt(lim) { return Math.floor(Math.random() * lim) + 1; }

function popElements(thing, n) {
    for(let i = 0; i < n; i++) { thing.pop(); }
}

// -- AMBIENCE --

let dim = 6;

let vector = [];

for(let i = 0; i < dim; i++) { vector.push(getRandomInt(50)); }

let n =  parseInt(prompt('\n> Cantidad de elementos que quitara: '));

if(!(n > vector.length)) {
    popElements(vector, n);
    console.log(vector);
}
else {
    console.clear();
    console.warn('ERROR: no puede quitar mas elementos de los que posee el vector.');
}


