const prompt = require('prompt-sync')();

let lim = parseInt(prompt('» Ingrese un numero: '));

let nums = 0;
let rsg = 0;

while(nums <= lim) {
    console.clear();
    console.log('Limite: ' + lim + '\nNumeros acumulados: ' + nums + '\n');
    rsg = nums;
    nums += parseInt(prompt('» Ingrese otro: '));
    if(Number.isNaN(nums)) { nums = rsg; }
}

console.clear();
console.log(`Limite: ${lim}
Numeros acumulados: ${nums}
\nYa supero el limite.`);