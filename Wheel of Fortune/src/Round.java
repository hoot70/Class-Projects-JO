import java.util.*;

class Round {
    private int oneRound = 0;
    private int twoRound = 0;
    private int threeRound = 0;
    private String playerOne;
    private String playerTwo;
    private String playerThree;
    private String category;
    private String word;
    private ArrayList<String> guessed = new ArrayList<>();
    private ArrayList<String> vowels = new ArrayList<>();
    private ArrayList<String> players;
    private ArrayList<String> wordVowels = new ArrayList<>();
    private ArrayList<String> wordReference = new ArrayList<>();

    Round(String name1, String name2, String name3, ArrayList<String> players) {
        Words x = new Words();
        guessed.add(" ");
        this.playerOne = name1;
        this.playerTwo = name2;
        this.playerThree = name3;
        String[] words = x.Words();
        this.category = words[0];
        this.word = words[1];
        addVowels();
        addWordVowels();
        addWordReference();
        this.players = players;
        menu();
    }

    private void menu(){
            showBoard();
            Scanner scanner = new Scanner(System.in);
            System.out.println("The money totals for this round are " + this.playerOne + ": " + "$" + this.oneRound + " / " + this.playerTwo + ": " + "$" + this.twoRound + " / " + this.playerThree + ": " + "$" + this.threeRound);
            if (guessed.containsAll(wordReference)){
                System.out.println("Well, " + this.players.get(0) + " I think you should solve the puzzle");
                solvePuzzle(this.players.get(0));
            } else {
                System.out.println(this.players.get(0) + " its your turn");
                System.out.println("What would you like to do?");
                System.out.println("Enter number of your Choice");
                System.out.println("1. Spin the Wheel");
                System.out.println("2. Buy a Vowel");
                System.out.println("3. Solve the Puzzle");
                System.out.println("4. Quit");
                String response = scanner.next();
                switch (response) {
                    case "1":
                        spin(this.players.get(0));
                        break;
                    case "2":
                        buyVowel(this.players.get(0));
                        break;
                    case "3":
                        solvePuzzle(this.players.get(0));
                        break;
                    case "4":
                        boardClear();
                        break;
                    default:
                        System.out.println("That's not an appropriate response");
                        menu();
                        break;
                }
            }
    }

    private void spin(String contestant){
        Wheel z = new Wheel();
        String spun = z.spin();

        if (spun.equals("bankrupt")){
            System.out.println("Oh sorry, " + contestant + " you went bankrupt");
            if (contestant.equals(this.playerOne)){
            this.oneRound = 0;
            } else if (contestant.equals(this.playerTwo)){
                this.twoRound = 0;
            } else {
                this.threeRound = 0;
            }
            nextPlayer();
        } else if (spun.equals("lose_turn")){
            System.out.println("Oh sorry, " + contestant + " looks like you're losing this turn");
            nextPlayer();
        } else {
            showBoard();
            System.out.println("Your spin was " + "$" + spun);
            int money = Integer.valueOf(spun);
            char letter = guess();
            int total = countChar(this.word, letter);
            if (total > 0){
                System.out.println("Great Guess");
                showBoard();
                int winnings = money * total;
                System.out.println("You won $" + winnings );
                if (contestant.equals(this.playerOne)){
                    this.oneRound = this.oneRound + winnings;
                } else if (contestant.equals(this.playerTwo)){
                    this.twoRound = this.twoRound + winnings;
                } else {
                    this.threeRound = this.threeRound + winnings;
                }
            } else {
                System.out.println("Well that was a bad guess");
                nextPlayer();
            }
        }
        menu();
    }

    private void buyVowel(String contestant){
        Scanner scanner = new Scanner(System.in);
        if (contestant.equals(this.playerOne) && this.oneRound == 0){
            System.out.println("You need to have money first to buy a vowel. Spin the wheel");
        } else if (contestant.equals(this.playerTwo) && this.twoRound == 0){
            System.out.println("You need to have money first to buy a vowel. Spin the wheel");
        } else if (contestant.equals(this.playerThree) && this.threeRound == 0){
            System.out.println("You need to have money first to buy a vowel. Spin the wheel");
        }
        else if (guessed.containsAll(wordVowels)){
            System.out.println("All of the vowels have been guessed");
        }
       else {
        char y;
        showBoard();
        System.out.println("Guess a vowel");
        String a = scanner.next();
        String z = a.toUpperCase();
        if (this.guessed.contains(z)) {
            System.out.println("Oh sorry looks like that letter's already been guessed");
            nextPlayer();
        } else if (!this.vowels.contains(z)){
            System.out.println("That's not a vowel");
            nextPlayer();
        }
        else {
                this.guessed.add(z);
                y = z.charAt(0);
                int total = countChar(this.word, y);
                if (total > 0) {
                    System.out.println("Great Guess");
                    showBoard();
                    int loss = 50 * total;
                    System.out.println("That will cost you " + "$" + loss);
                    if (contestant.equals(this.playerOne)){
                        this.oneRound = this.oneRound - loss;
                    } else if (contestant.equals(this.playerTwo)){
                        this.twoRound = this.twoRound - loss;
                    } else {
                        this.threeRound = this.threeRound - loss;
                    }
                } else {
                    System.out.println("Well that was a bad guess");
                    nextPlayer();
                }
            }
        }
            menu();
    }

    private void solvePuzzle(String contestant){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Well what's your guess?");
        String z = scanner.nextLine();
        String guess = z.toUpperCase();
        String base = this.word;
        if (base.contains(guess)){
            System.out.println("Congrats you got it right!");
            System.out.println("This correct answer is:");
            System.out.println(this.word);
            if (contestant.equals(this.playerOne)){
                System.out.println("You won $" + this.oneRound);
            } else if (contestant.equals(this.playerTwo)){
                System.out.println("You won $" + this.twoRound);
            } else {
                System.out.println("You won $" + this.threeRound);
            }
            endGame(contestant);
        } else {
            System.out.println("Ooh not a great guess");
            nextPlayer();
            menu();
        }
    }

        private char guess(){
           Scanner scanner = new Scanner(System.in);
           char y = 'a';
           System.out.println("Guess a letter");
           String x = scanner.next();
           boolean validate = Character.isLetter(x.charAt(0));
           String z = x.toUpperCase();
           if (!validate){
               System.out.println("No numbers or symbols, you have to guess a letter");
               guess();
           } else if (x.length() > 1){
               System.out.println("Ha. Nice try. No guessing more than one letter");
               nextPlayer();
               menu();
               } else {
               if (this.guessed.contains(z)) {
                   System.out.println("Oh sorry looks like that letter's already been guessed");
                   nextPlayer();
                   menu();
               } else if (this.vowels.contains(z)) {
                   System.out.println("Oh sorry, you can't guess vowels");
                   nextPlayer();
                   menu();
               } else {
                   this.guessed.add(z);
                   y = z.charAt(0);
               }
           }
           return y;
        }


    private int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }

    private void addVowels(){
        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");
    }

    private void endGame(String contestant){
        if (contestant.equals(this.playerOne)) Game.setOneTotal(this.oneRound);
        else if (contestant.equals(this.playerTwo)) Game.setTwoTotal(this.twoRound);
        else Game.setThreeTotal(this.threeRound);
        boardClear();
    }

    private void showBoard(){
        System.out.println("----------------------------------------------------------------------");
        Board x = new Board();
        System.out.println("The Category is " + this.category);
        System.out.println(x.Board(this.word, this.guessed));
    }

    private void boardClear(){
        Game.runItBack();
        this.oneRound = 0;
        this.twoRound = 0;
        this.threeRound = 0;
        this.category = "";
        this.word = "";
        this.guessed.clear();
        this.players.clear();
    }

    private void nextPlayer(){
        this.players.add(this.players.remove(0));
    }

    private void addWordVowels(){
        var arr = word.split("");
        for (String a: arr){
            if (vowels.contains(a)){
                wordVowels.add(a);
            }
        }
    }

    private void addWordReference(){
        var arr  = word.split("");
        wordReference.addAll(Arrays.asList(arr));
        Set<String> set = new HashSet<>(wordReference);
        wordReference.clear();
        wordReference.addAll(set);
    }


}
