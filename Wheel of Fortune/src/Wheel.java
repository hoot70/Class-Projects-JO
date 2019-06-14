import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Wheel {

    private ArrayList<String> spun = new ArrayList<>();
    Wheel() {
    }

    String spin(){
        loadTitles();
        Random rand = new Random();
        return spun.get(rand.nextInt(spun.size()));
    }

    private void loadTitles()
    {
        try
        {
            Utils.loadStringsToArray(this.spun);
        }
        catch (IOException e)
        {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");

        }
    }
}
