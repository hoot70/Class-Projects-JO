import java.util.*;

public class project {
    public static void main(String[] args) {
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();
        AsciiChars.printNumbers();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scanner.next();
        System.out.println("Hello " + name);
        System.out.println("Would you like to continue to the interactive portion? (Y/N)");
        if(scanner.next().toLowerCase().charAt(0) == 'y'){
            Questions.play();

        } else{
            System.out.println("Please return later to complete the survey");

        }



    }
}


