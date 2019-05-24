import java.util.*;

public class Questions {
    public static void play() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Object> answers = new ArrayList<Object>();
        String answer;
        int number;
        do {
            do {
                do{
                    System.out.println("Do you have a red car? (y/n)");
                    answer = scanner.next().toLowerCase() ;
                } while (!(answer.charAt(0) == 'y') && !(answer.charAt(0) == 'n'));
                answers.add(answer);

                System.out.println("Name of your fav pet: ");
                answer = scanner.next().toLowerCase();
                answers.add(answer);

                do {
                    System.out.println("Age of your fav pet: (1-20)");
                    number = scanner.nextInt();
                } while (number < 0 || number > 20);
                answers.add(number);

                do {
                    System.out.println("Your lucky number: (1-99)");
                    number = scanner.nextInt();
                } while (number < 0 || number > 99);
                answers.add(number);

                do{
                    System.out.println("Do you have a favorite quarterback? If so what is their jersey number? (1-20) ");
                    number = scanner.nextInt();
                } while (number < 0 || number > 20);
                answers.add(number);

                do{
                    System.out.println("What is two-digit model year of your car? (01-99) ");
                    number = scanner.nextInt();
                } while (number < 01 || number > 99);
                answers.add(number);

                System.out.println("What is the first name of your favorite actor or actress? ");
                answer = scanner.next().toLowerCase();
                answers.add(answer);

                do{
                    System.out.println("How old are you?");
                    number = scanner.nextInt();
                } while (number < 0 || number > 99);
                answers.add(number);

                do {
                    System.out.println("Enter a random number between 1 and 50: ");
                    number = scanner.nextInt();
                } while (number < 0 || number > 50);

                answers.add(number);


                System.out.println("Would you like to change your answers? (Y/N)");

            } while (scanner.next().toLowerCase().charAt(0) == 'y');


            //magic number

            int magicNumber = ((Integer) answers.get(4) * 6) / 2;
            if (magicNumber > 75){
                magicNumber = magicNumber / 2;
            }
            int firstNum = ((Integer) answers.get(3) / 3) * 2;
            if (firstNum > 75){
                firstNum = firstNum / 2;
            }
            int secondNum = ((Integer) answers.get(5) / 5) * 4;
            if (secondNum > 75){
                secondNum = secondNum / 2;
            }
            int thirdNum = ((Integer) answers.get(8) / 2) * 3;
            if (thirdNum > 75){
                thirdNum = thirdNum / 2;
            }
            int fourthNum = ((Integer) answers.get(2) * 5) / 2;
            if (fourthNum > 75){
                fourthNum = fourthNum / 2;
            }
            int fifthNum = ((Integer) answers.get(7) / 4) * 3;
            if (fifthNum > 75){
                fifthNum = fifthNum / 2;
            }

            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(firstNum);
            nums.add(secondNum);
            nums.add(thirdNum);
            nums.add(fourthNum);
            nums.add(fifthNum);

            Collections.sort(nums);

            Object[] arrayNums = nums.toArray();

            System.out.println("Here are your lottery numbers!");
            System.out.println((Arrays.toString(arrayNums).replace("[", "").replace("]", "")) + ", Magic Number: " + magicNumber);


            System.out.println("Would you like to play again? (Y/N)");

        } while (scanner.next().toLowerCase().charAt(0) == 'y');

        System.out.println("Have a great day!");
    }



}
