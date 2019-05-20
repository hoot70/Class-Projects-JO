import java.awt.*;

public class lab {
    public static void main(String[] args) {

        //Step 1
        int firstInt = 6;
        int secondInt = 20;
        int thirdInt = 0;
        float noName = 4.4f;
        boolean isCold = false;
        double sup = 10_000_000.00;

        System.out.println(firstInt);
        System.out.println(secondInt);
        System.out.println(thirdInt);
        System.out.println(noName);
        System.out.println(isCold);
        System.out.println(sup);

        //Step 2

        int newValue = firstInt + secondInt;
        System.out.println(newValue);
        int newerValue = firstInt + thirdInt;
        System.out.println(newerValue);
        System.out.println(secondInt / firstInt);
        System.out.println(secondInt % firstInt);
        int remainder = firstInt + (secondInt % firstInt);
        System.out.println(++remainder);

        //Step 3

        int x = 100;
        boolean test = (x == 100);
        int y = 106;
        System.out.println(x > y);
        System.out.println(y>x);
        System.out.println(x >= y-6);
        int z = 92;
        System.out.println(x < y && y < z);
        System.out.println(y < z && x >= y);
        System.out.println(z > y + x || x - y < z);
        System.out.println(x > y == !(x > y));

        //Step 4
        int n = 64;
        System.out.println((n>>1) == (n / 2));
        System.out.println((n<<1) == (n * 2));
        n = 40;
        System.out.println((n>>1) == (n / 2));
        System.out.println((n<<1) == (n * 2));
        System.out.println((n>>2) == (n / 4));
        System.out.println((n<<2) == (n * 4));
        n = 33;
        System.out.println((n>>1) == (n / 2));
        System.out.println((n<<1) == (n * 2));
        System.out.println((n>>2) == (n / 4));
        System.out.println((n<<2) == (n * 4));

        //Step 5
        anotherMethod();
        playWithStrings();
    }

    //Step 5
    public static void anotherMethod()
    {
        Integer v = Integer.valueOf(1500);
        Integer compare = Integer.valueOf("1000");
        //no you would not be able to call this
        int stuff = v.compareTo(compare);
        if (stuff >= 0){
            System.out.println(v + " is a Big Value");
            int num = v / 2;
            System.out.println(num + " is half a Big Value");
        } else {
            System.out.println(v + " is Not a Big Value");
            //wouldn't be able to call that half value here because the scope has it inside the if statement
        }

    }

    //Step 7
    public static void playWithStrings()
    {
        String firstName = "Jon";
        String lastName = new String("Osterhout");
        String greeting = "Hello ".concat(firstName).concat(" ").concat(lastName);
        System.out.println(greeting);
        System.out.println("Hello " + firstName + " " + lastName);
        String fullName = firstName.concat(" ").concat(lastName);
        System.out.println(String.format("The length of %s is %d", fullName, fullName.length()));

        if (fullName.indexOf("o") == -1){
            System.out.println(String.format("%s does not contain an 'o'", fullName));
        }else {
            System.out.println(String.format("The index of the first 'o' in %s is %d", fullName, fullName.indexOf("o")));
        }

        if (fullName.length() >= 8) {
            System.out.println(String.format("The letter in position 7 of %s is %s", fullName, fullName.charAt(7)));
        } else {
            System.out.println(String.format("%s is not long enough", fullName));
        }

        if (fullName.contains("son")){
            System.out.println(String.format("%s contains the word 'son'", fullName));
        } else {
            System.out.println(String.format("%s does not contain the word 'son'", fullName));
        }

        System.out.println(String.format("The last 5 letters in %s are %s", fullName, fullName.substring(fullName.length()-5)));

        if(fullName.contains("-") || fullName.contains("'")) {
            System.out.println(String.format("%s contains an apostrophe or a dash", fullName));
        } else {
            System.out.println(String.format("%s does not contain an apostrophe or a dash", fullName));
    }
    }
}
