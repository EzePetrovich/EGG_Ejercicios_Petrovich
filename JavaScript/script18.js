// -- ENVIRONMENT --

const prompt = require('prompt-sync')();

let values = [true, 5, false, 'hola', 'adios', 2];

function allOperations(a, b) {
     console.clear();
     console.log(`b) <- OPERACIONES MATEMATICAS ->\n
SUMA: ${a + b}
RESTA: ${a - b}
MULTIPLICACION: ${a * b}
DIVISION: ${a / b}
POTENCIA: ${Math.floor(Math.pow(a, b))}`);
}

// -- PROCESS --

let tamMax = 0;
let strMax = '';
let numbers = [];
let booleans = [];

for(let v of values) {
    if(typeof v === 'string') {
        if(v.length > tamMax) {
            tamMax = v.length;
            strMax = v;
        }
    } else if(typeof v === 'number') { numbers.push(v); }
            else if(typeof v === 'boolean') { booleans.push(v); }
}

console.clear();
console.log(`a) La cadena mas larga es: ${strMax}`);
prompt('\nPresione intro para seguir...');

if(numbers.length > 1) {
    let n2 = numbers.pop();
    let n1 = numbers.pop();
    allOperations(n1, n2);
    prompt('\nPresione intro para seguir...');
}

if(booleans.length > 1) {
    console.clear();
    console.log('c)');
    let b2 = booleans.pop();
    let b1 = booleans.pop();
    console.log(b1 || b2);
    console.log(b1 && b2);
    prompt('\nPresione intro para seguir...');
}
