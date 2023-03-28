
function say() { alert('¡Hola!, ¿Como te va?'); }

let bttn = document.createElement('button');
bttn.innerHTML = 'Clickeame';
bttn.type = 'button';
bttn.name = 'msg';
bttn.onclick = say;
document.body.appendChild(bttn);