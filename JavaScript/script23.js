
let paragraphs = document.getElementsByTagName('p');
let text;
let arrayWords;


for(let i = 0; i < paragraphs.length; i++) {
    text = paragraphs[i].textContent;
    arrayWords= text.split(' ');
    for(let j = 0; j < arrayWords.length; j++) {
        if(arrayWords[j].length > 8) {
            arrayWords[j] = `<a style="background-color: lawngreen; font-style: italic">${arrayWords[j]}</a>`;
        }
    }
    text = arrayWords.join(' ');
    paragraphs[i].innerHTML = text;
}
