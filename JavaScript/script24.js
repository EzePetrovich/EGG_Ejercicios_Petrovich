
function processRad() {

    let radForm = parseFloat(document.getElementById('radio').value);

    if(!Number.isNaN(radForm)) {
        let circunf = 2 * Math.PI * radForm;
        let area = Math.PI * Math.pow(parseFloat(radForm), 2);

        let values = [radForm, circunf, area];

        let tr = document.getElementById('result-table');
        let td = tr.getElementsByTagName('td');

        for(let i = 0; i < td.length; i++) { td[i].innerHTML = values[i].toFixed(2); }
        tr.setAttribute('style', 'color: black;');
    }
    else { window.location.reload(); }

}



