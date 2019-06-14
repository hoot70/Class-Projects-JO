import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Words {
    private ArrayList<String> puzzle = new ArrayList<>();
    private Random rand = new Random();
    private String word;
    private ArrayList played;
    private String categoryName;


    String[] Words() {
        loadPuzzles();
        setPlayed(Game.getPlayed());

        String[] ans = new String[0];
        if (played.containsAll(puzzle)) {
            System.out.println("Well it looks like you've played all the puzzles. Get a new game");
            System.exit(1);
        } else {
            randWord();
            ans = new String[2];
            ans[0] = getCategoryName();
            ans[1] = getWord();
        }
        return ans;
    }




    private void randWord() {
        int x = rand.nextInt(puzzle.size());
        String phrase = puzzle.get(x);
        if (played.contains(phrase)) {
            Words();
        } else {
            Game.setPlayed(phrase);
            String[] arrOfStr = phrase.split(":");
            setWord(arrOfStr[0].toUpperCase());
            setCategoryName(arrOfStr[1]);
                }
    }

    private void loadPuzzles() {
        try {
            Utils.loadPuzzlesToArray(this.puzzle);
        } catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");

        }
    }

    private String getWord() {
        return word;
    }

    private void setWord(String word) {
        this.word = word;
    }

    private String getCategoryName() {
        return categoryName;
    }

    private void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private void setPlayed(ArrayList played) {
        this.played = played;
    }
}