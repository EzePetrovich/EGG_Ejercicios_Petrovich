// -- AMBIENCE --

function getRandomInt(lim) { return Math.floor(Math.random() * lim) + 1; }

function loadArrays(array1, array2) {
    for(let i = 0; i < 5; i++) {
        array1[i] = getRandomInt(50);
        array2[i] = getRandomInt(50);
    }
}

// -- ENVIRONMENT --

let vect1 = [];
let vect2 = [];

loadArrays(vect1, vect2);

console.log(`Vector 1: ${vect1}
Vector 2: ${vect2}`);