import java.util.ArrayList;
import java.util.Scanner;

class Game {
    private static int oneTotal;
    private static String playerOne;
    private static String playerTwo;
    private static String playerThree;
    private static int twoTotal = 0;
    private static int threeTotal = 0;
    private static ArrayList<String> players = new ArrayList<>();
    private static ArrayList<String> played = new ArrayList<>();

    Game() {
        System.out.println("Player 1 what is your name?");
        Scanner scanner = new Scanner(System.in);
        playerOne = scanner.next();
        System.out.println("Player 2 what's your name?");
        playerTwo = scanner.next();
        System.out.println("Player 3 what's your name?");
        playerThree = scanner.next();


        players.add(playerOne);
        players.add(playerTwo);
        players.add(playerThree);

        System.out.println("Let's Play Wheel of Fortune!");
        new Round(playerOne, playerTwo, playerThree, players);
    }


    static void setOneTotal(int newTotal) { oneTotal =  oneTotal + newTotal; }

    static void setTwoTotal(int newTotal) {
        twoTotal = twoTotal + newTotal;
    }

    static void setThreeTotal(int newTotal) {
        threeTotal = threeTotal + newTotal;
    }

    static void runItBack(){
        nextPlayer();
        System.out.println("The money totals for the game are " + playerOne + ": " + "$" + oneTotal + " / " + playerTwo + ": " + "$" + twoTotal + " / " + playerThree + ": " + "$" + threeTotal);
        System.out.println("Would you like to play again?");
        System.out.println("Type 1 for 'yes' or 2 for 'no'");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equals("1")){
            System.out.println("Let's Play Wheel of Fortune!");
            new Round(playerOne, playerTwo, playerThree, players);
        } else if(answer.equals("2")){
            System.out.println("Well thanks for playing. Hope to see you again soon");
            System.exit(1);
        } else {
            System.out.println("That's not an appropriate response");
            runItBack();
        }
    }

    private static void nextPlayer(){
        players.add(players.remove(0));
    }

    static ArrayList<String> getPlayed() {
        return played;
    }

    static void setPlayed(String played) {
       Game.played.add(played);
    }
}
