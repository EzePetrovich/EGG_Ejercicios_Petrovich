// ---- ENVIRONMENT ----

const prompt = require('prompt-sync')();

function printBook() {
    console.clear();
    console.log(`<- LIBRO ->
> ISBN: ${this.isbn}
> Titulo: ${this.title}
> Autor: ${this.author}
> Paginas: ${this.pages}`)
}

function loadBook(thing) {
    console.clear();
    console.log('<- CARGA DE LIBRO ->');
    thing.isbn = parseInt(prompt('> ISBN: '));
    thing.title = prompt('> Titulo: ');
    thing.author = prompt('> Autor: ');
    thing.pages = prompt('> Paginas: ');
    thing.printAll = printBook;
}

// ---- PROCESS ----

let book = {};
loadBook(book);
book.printAll();
