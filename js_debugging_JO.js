// var woolOwners = [
//     {
//         "master": 1
//     },
//     {
//         "dame": 1
//     },
//     {
//       "little boy": 1,
//       "location": "down the lane"
//     }
//   ];
  
  
//   var bags = haveYouAnyWool;
  
//   var haveYouAnyWool = function() {
//       for (var i = 0; i < woolOwners.length; i++) {
//       var totalBags = totalBags + i;
//       }
//       return (i);
//   };
  
  
//   function baabaaBlackSheep() {
//       console.log("BaaBaa BlackSheep have you any wool?");
//       if (bags > 0) {
//           console.log("yes sir, yes sir " + totalBags + " bags full");
//     }
//   }
  
//   function oneForMy() {
//       for (var i = 0; i < 2; i++) {
//           people = Object.keys(woolOwners);
//           var person = people.toString();
//           console.log("one for my " + person);
//       }
//   }
  
//   baabaaBlackSheep();
//   oneForMy();
  
//   var boy = Object.keys(woolOwners[2]);
//   var littleBoy = boy[2];
  
//   var whereHeLives = littleBoy.location;
//   console.log("one for the " + littleBoy + " that lives " + whereHeLives);

var bags = haveYouAnyWool();
  
function haveYouAnyWool() {
     var totalBags = 0;
   for (var i = 0; i < woolOwners.length; i++) {
       totalBags = totalBags + i;
       }
       return totalBags;
   };
 
 
 function baabaaBlackSheep() {
     console.log("BaaBaa BlackSheep have you any wool?");
     if (bags > 0) {
         console.log("yes sir, yes sir " + bags + " bags full");
   }
 }
 
 function oneForMy() {
     for (var i = 0; i < 2; i++) {
         people = Object.keys(woolOwners[i]);
         var person = people;
         console.log("one for my " + person);
     }
 }
 
 baabaaBlackSheep();
 oneForMy();
 
 var boy = Object.keys(woolOwners[2]);
 
 console.log("one for the " + boy[0] + " that lives " + woolOwners[2].location);