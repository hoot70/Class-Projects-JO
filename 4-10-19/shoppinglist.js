document.getElementById('list').children[1].innerHTML = 'Free Trade Coffee';

document.getElementById('list').children[3].remove();

const newLI = document.createElement('li');
newLI.innerHTML = "Cheese Whiz";

const list = document.querySelector('ul');
list.appendChild(newLI);

var newList = document.getElementsByTagName('li');
var length = newList.length;

while (length != 0){
    document.getElementById('list').children[length-1].remove();
    length--;
}

const arr = ['protein powder', 'muscle milk', 'power bars']

for(var i = 0; i < arr.length; i++) {
    const newLI = document.createElement('li');
    newLI.innerHTML = arr[i];

const list = document.querySelector('ul');
list.appendChild(newLI);
}

const sup = document.getElementById('list').children[1];
sup.className = 'important';