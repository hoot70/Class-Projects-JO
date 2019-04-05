const player1 = 'Jon'
const player2 = 'Mike'
let player1Score = 0
let player2Score = 0
const weapons = ['rock', 'paper', 'scissors']

const winConditions = {
  rock: 'scissors',
  scissors: 'paper',
  paper: 'rock'
}

while (player1Score < 3 && player2Score < 3) {
  const player1Weapon = weapons[Math.floor(Math.random() * weapons.length)]
  const player2Weapon = weapons[Math.floor(Math.random() * weapons.length)]

  console.log(player1, 'plays', player1Weapon)
  console.log(player2, 'plays', player2Weapon)

  if (player1Weapon === player2Weapon) {
    console.log('Tie')
  } else if (winConditions[player1Weapon] === player2Weapon) {
    console.log(player1 + ' Wins')
    player1Score++
  } else {
    console.log(player2 + ' Wins')
    player2Score++
  }
  console.log('Score is ' + player1 + ' - ' + player1Score + ' vs ' + player2 + ' - ' + player2Score)
}

let winner
if (player1Score === 3) {
  winner = player1
} else {
  winner = player2
}

console.log(winner, 'Wins the Game!')

// 1.  Using a switch statement create a program that has a variable myVar that can be changed resulting in the following console outputs when run.
// when myVar = "a" it logs:
// "Hey"
// when myVar = "b" it logs:
// "Foo"
// "Bar"
// when myVar = "c" it logs:
// "Bar"

let myVar = 'c'

switch (myVar) {
  case 'a':
    console.log('Hey')
    break

  case 'b':
    console.log('foo')

  case 'c':
    console.log('Bar')
}
