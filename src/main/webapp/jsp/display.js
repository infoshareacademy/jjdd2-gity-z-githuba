var sentences = document.querySelector('#sentences');
var keywords = document.querySelector('#keywords');

keywords.addEventListener('click', function(event){
    var target = event.target;
    var text = sentences.textContent;
    var regex = new RegExp('('+target.textContent+')', 'ig');
    text = text.replace(regex, '<span class="highlight">$1</span>');
    sentences.innerHTML = text;
}, false);