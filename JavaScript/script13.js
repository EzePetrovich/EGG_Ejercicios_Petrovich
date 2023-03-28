function printPerson() {
    console.log(`PERSONA\n
> Nombre: ${this.name}
> Apellido: ${this.surname}
> Edad: ${this.old}
> Sexo: ${this.sex}
> Peso: ${this.weight}
> Altura: ${this.height}`);
}

let person = {};

person.name = 'J Ezequiel';
person.surname = 'Petrovich';
person.old = 23;
person.sex = 'Hombre';
person.weight = 68;
person.height = 174;
person.printAttrs = printPerson;

person.printAttrs();