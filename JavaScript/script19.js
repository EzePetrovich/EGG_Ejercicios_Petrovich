const prompt = require('prompt-sync')();

function generateRandomDouble(lim) { return (Math.random() * lim + 1).toFixed(2); }

let vectA = [];
let vectB = [];

for(let i = 0; i < 50; i++) {
    vectA.push(generateRandomDouble(100));
}

vectA.sort(function(a, b) { return a - b; });

for(let i = 0; i < 20; i++) {
    if(i < 10) { vectB[i] = vectA[i]; }
    else { vectB[i] = 0.5; }
}

console.log(vectA);

console.log(vectB);