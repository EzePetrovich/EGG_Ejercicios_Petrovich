const prompt = require('prompt-sync')();
let maxLength = Number.MIN_SAFE_INTEGER;

let phrase = prompt('> Ingrese una frase: ');
let arrayPhrase = phrase.split(' ');
let maxWord = '';

for(let word of arrayPhrase) {
    if(word.length > maxLength) {
        maxLength = word.length;
        maxWord = word;
    }
}

console.log(`\nFrase: ${phrase}
Palabra mas larga: ${maxWord}`);