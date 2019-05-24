public class AsciiChars {
    public static void printNumbers()
    {
        // TODO: print valid numeric input
//        int ascii;
//        for(char i =  'A'; i <= 'Z'; i++){
//            ascii = i;
//            System.out.print(ascii + " ");
//        }
//        System.out.println();
//        for(char i =  'a'; i <= 'z'; i++){
//            ascii = i;
//            System.out.print(ascii + " ");
//        }
        for ( int i = 1; i <= 99; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printLowerCase()
    {
        // TODO: print valid lowercase alphabetic input
        for(char i =  'a'; i <= 'z'; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printUpperCase()
    {
        // TODO: print valid uppercase alphabetic input
        for(char i =  'A'; i <= 'Z'; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}