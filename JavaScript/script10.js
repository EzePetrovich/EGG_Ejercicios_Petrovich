const prompt = require('prompt-sync')();

let mirror = (word) => {
    let wordInv = '';
    for(let i = word.length; i > 0; i--) {
        wordInv += word.substring(i - 1, i)
    }
    return wordInv;
};

let word = prompt('> Ingrese una palabra: ');

console.clear();

console.log(mirror(word));