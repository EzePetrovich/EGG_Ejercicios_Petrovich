let matrix = [];
let vector;
let n = 0;

for(let i = 0; i < 5; i++) {
    n += 3;
    matrix.push([n]);
}

console.log(matrix);

vector = matrix.map((n) => parseInt(n) + 3);

console.log(vector);
