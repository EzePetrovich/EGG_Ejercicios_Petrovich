function getFormValues() {
    let person = {};
    let formValues = document.getElementById('form1');
    for(let v of formValues) {
        switch(v.name) {
            case 'nombre':
                person.name = v.value;
                break;
            case 'apellido':
                person.surname = v.value;
                break;
            case 'sexo':
                if(v.value === 'Masculino' && v.checked) { person.sex = v.value; }
                else if(v.value === 'Femenino' && v.checked) { person.sex = v.value; }
                break;
        }
    }
    if(person.sex === 'Masculino') { alert(`Bienvenido ${person.name} ${person.surname}`); }
    else if(person.sex === 'Femenino') { alert(`Bienvenida ${person.name} ${person.surname}`); }
}