import java.awt.*;
import java.util.Scanner;

public class lab {
    public static void main(String args[])
    {
            // scanner reads input from the command line through various methods
            Scanner scanner = new Scanner(System.in);
            do {
                // prompt and read a string
                System.out.print("Enter your name: ");
                String username = scanner.next();

                // prompt and read an int
                System.out.print("Enter your age: ");
                int age = scanner.nextInt();





                System.out.println(String.format("Hello %s, your age is %d", username, age));

                //Step 1
                if (age >= 16) {
                    System.out.println("You are old enough to drive");
                }
                if (age >= 18) {
                    System.out.println("You are old enough to vote");
                }
                if (age >= 21) {
                    System.out.println("You are old enough to drink");
                }
                if (age >= 35) {
                    System.out.println("You are old enough to be President");
                }
                if (age >= 55) {
                    System.out.println("You can join AARP");
                }
                if (age >= 67) {
                    System.out.println("You can starting drawing Social Security");
                }
                System.out.println("Do you want to answer the questions again? (Y/N)");

            } while(scanner.next().toLowerCase().charAt(0) == 'y');
        //Step 2

        System.out.println("What is your employment status?");
        System.out.println("Enter 'e' for employed, 'u' for unemployed, or 's' for student....");
        String emp = scanner.next().toLowerCase();

        System.out.println("What kind of car do you have?");
        System.out.println("Enter 's' for SUV, 'c' for car, 't' for truck, or 'n' for no car....");
        String car = scanner.next().toLowerCase();
        switch (emp) {
            case "e":
                System.out.println("You are employed");
                break;
            case "u":
                System.out.println("You are unemployed");
                break;
            case "s":
                System.out.println("You are a student");
                break;
            default:
                System.out.println("You must be unemployed because you didn't answer the question correctly");
                        }

        switch (car) {
            case "s":
                System.out.println("You have a SUV");
                break;
            case "c":
                System.out.println("You have a car");
                break;
            case "t":
                System.out.println("You have a truck");
                break;
            case "n":
                System.out.println("You don't have a car");
                break;
            default:
                System.out.println("You couldn't pass a drivers test anyways because you didn't answer the question correctly");
        }



        //step 3
        int[] myArray = new int[30];

        for (int i = 0; i < myArray.length; i++){
            myArray[i] = i;
        }

        for (int item: myArray){
            System.out.println(item);
        }

        int even = 2;
        for (int i = 0; i < myArray.length; i++){
            myArray[i] = even;
            even+=2;
        }

        for (int item: myArray){
            System.out.println(item);
        }

        for(int num=myArray.length - 1; num >= 0;num--){
            System.out.println(myArray[num]);
        }

        //step 4
        int i = 0;
        while (i < myArray.length){
            System.out.println(myArray[i]);
            i++;
        }

        int sup = myArray.length - 1;
        while(sup > -1){
            System.out.println(myArray[sup]);
            sup--;
        }

       System.out.println(newMethod(myArray, 30));
    }
    static int newMethod(int[] array, int a){
        int even = 0;

        for(int item: array)
        {
        if (item % 2 == 0){
             even += item;
         }
        if (item % 2 != 0){
            System.out.println(item);
        }
        if (item == a){
            break;
        }
        }
        return even;
    }
}
