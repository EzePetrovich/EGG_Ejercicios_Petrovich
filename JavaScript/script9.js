const prompt = require('prompt-sync')();

let word = prompt('> Ingrese una palabra: ');

let monoWord = '';

for(let i = 0; i < word.length; i++) {
    monoWord += word.substring(i, i + 1) + ' ';
}

console.clear();
console.log(monoWord);