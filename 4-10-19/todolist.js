function add() {
    var newLI = document.createElement('li');
    
   var newAdd = document.getElementById("listitem").value;
   
   var list = document.querySelector('ul');
   newLI.innerHTML = newAdd;
   var added = list.appendChild(newLI);
   document.getElementById("listitem").value = "";
   
   
    added.onclick = function(){
       this.parentNode.removeChild(this);
    }

      }