import java.awt.*;

public class RPS {
    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();

        int playerOneScore = 0;
        int playerTwoScore = 0;

        while (playerOneScore < 5 && playerTwoScore < 5) {

            int plyOneNum = random.nextInt(3);
            int plyTwoNum = random.nextInt(3);
            String plyOneHand;
            String plyTwoHand;

            if (plyOneNum == 0) {
                plyOneHand = "Rock";
            } else if (plyOneNum == 1) {
                plyOneHand = "Paper";
            } else {
                plyOneHand = "Scissors";
            }

            if (plyTwoNum == 0) {
                plyTwoHand = "Rock";
            } else if (plyTwoNum == 1) {
                plyTwoHand = "Paper";
            } else {
                plyTwoHand = "Scissors";
            }

            if ((plyOneNum == 0 && plyTwoNum == 1) || (plyOneNum == 1 && plyTwoNum == 2) || (plyOneNum == 2 && plyTwoNum == 0)) {
                System.out.println("NEXT GAME");
                System.out.println("Player One plays " + plyOneHand + " and Player Two plays " + plyTwoHand);
                System.out.println("Player One Wins");
                playerOneScore++;
                System.out.println("Player One Score is " + playerOneScore + " and Player Two Score is " + playerTwoScore);

            } else if ((plyTwoNum == 0 && plyOneNum == 1) || (plyTwoNum == 1 && plyOneNum == 2) || (plyTwoNum == 2 && plyOneNum == 0)) {
                System.out.println("NEXT GAME");
                System.out.println("Player One plays " + plyOneHand + " and Player Two plays " + plyTwoHand);
                System.out.println("Player Two Wins");
                playerTwoScore++;
                System.out.println("Player One Score is " + playerOneScore + " and Player Two Score is " + playerTwoScore);

            } else {
                System.out.println("NEXT GAME");
                System.out.println("Player One plays " + plyOneHand + " and Player Two plays " + plyTwoHand);
                System.out.println("Its a Tie");
                System.out.println("Player One Score is " + playerOneScore + " and Player Two Score is " + playerTwoScore);
            }
        }

        System.out.println("THAT'S YOUR BALLGAME!");

            if (playerOneScore == 5){
                System.out.println("Player One Wins the Tournament");
                System.out.println("The Score Was " + playerOneScore + " to " + playerTwoScore);
            } else{
                System.out.println("Player Two Wins the Tournament");
                System.out.println("The Score Was " + playerTwoScore + " to " + playerOneScore);
            }

    }
}
