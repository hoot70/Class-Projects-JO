// Let's revisit Rock Paper Scissors...
//     Define a hands array with the values 'rock', 'paper', and 'scissors';
//     Define a function called getHand() that returns a hand from the array using parseInt(Math.random()*10)%3
//     Define two objects for two players. Each player has name and getHand() properties.
//     Define a function called playRound() that
//         Takes two player objects as arguments
//         Gets hands from each
//         Determines the winner
//         Logs the hands played and name of the winner.
//         If its a tie, log the hands played and "it's a tie".
//         Returns the winner object (null if no winner)
//     Define a function called playGame() that takes arguments player1, player2, and playUntil.
//         Play rounds until one of the players wins playUntil hands
//         When one player has won enough games, return the winning player object
//     Play a game to 5 wins
// !!!!Bonus!!!!!
//     Define a function caled playTournament()
//         Take 4 players and playUntil as arguments
//         Play a game between the first two players, and the second two players
//         Play a game between the winners of the first round.
//         Announce the tournament winner's name "[name] is the world champion";

var hands = ['rock', 'paper', 'scissors']

function getHand () {
  return hands[parseInt(Math.random() * 10) % 3]
}

var playerOne = {
  name: 'Jon',
  getHands: null,
  score: 0
}

var playerTwo = {
  name: 'Joey',
  getHands: null,
  score: 0
}

var playerThree = {
  name: 'Bert',
  getHands: null,
  score: 0
}

var playerFour = {
  name: 'Chazzo',
  getHands: null,
  score: 0
}

const winConditions = {
  rock: 'scissors',
  scissors: 'paper',
  paper: 'rock'
}

function playRound (playerOne, playerTwo) {
  playerOne.getHands = getHand()
  playerTwo.getHands = getHand()

  if (playerOne.getHands === playerTwo.getHands) {
    console.log(
      playerOne.name +
        ' plays ' +
        playerOne.getHands +
        '. ' +
        playerTwo.name +
        ' plays ' +
        playerTwo.getHands +
        '. '
    )
    console.log('Its a Tie')
  } else if (winConditions[playerOne.getHands] === playerTwo.getHands) {
    console.log(
      playerOne.name +
        ' plays ' +
        playerOne.getHands +
        '. ' +
        playerTwo.name +
        ' plays ' +
        playerTwo.getHands +
        '. '
    )
    console.log(playerOne.name + ' Wins')
    playerOne.score++
  } else {
    console.log(
      playerOne.name +
        ' plays ' +
        playerOne.getHands +
        '. ' +
        playerTwo.name +
        ' plays ' +
        playerTwo.getHands +
        '. '
    )
    console.log(playerTwo.name + ' Wins')
    playerTwo.score++
  }

  hasWinner(playerOne, playerTwo)
}

function hasWinner (playerOne, playerTwo) {
  if (playerOne.score === 5) {
    console.log(playerOne.name + ' wins the game!')
  } else if (playerTwo.score === 5) {
    console.log(playerTwo.name + ' wins the game!')
  } else {
    winner = null
  }
}

function playGame (playerOne, playerTwo) {
  while (playerOne.score != 5 && playerTwo.score != 5) {
    playRound(playerOne, playerTwo)
  }
}



function playTournament (playerOne, playerTwo, playerThree, playerFour) {
    playGame(playerOne, playerTwo)
    playGame(playerThree, playerFour)

    if (playerOne.score == 5){
        var newPlayer1 = playerOne;
    }else{
        var newPlayer1 = playerTwo;
    }
    if (playerThree.score == 5){
        var newPlayer2 = playerThree;
    }else{
        var newPlayer2 = playerFour;
    }
    newPlayer1.score = 0;
    newPlayer2.score = 0;
    playGame(newPlayer1, newPlayer2)
    if (newPlayer1.score == 5){
        console.log(`${newPlayer1.name} is the champion of the world!`);
    }else{
        console.log(`${newPlayer2.name} is the champion of the world!`);
    }
}


playTournament(playerOne, playerTwo, playerThree, playerFour)