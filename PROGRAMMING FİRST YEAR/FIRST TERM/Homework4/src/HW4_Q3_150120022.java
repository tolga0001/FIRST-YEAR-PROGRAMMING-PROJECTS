import java.util.Scanner;

// 1501200222 Tolga Fehmioðlu
public class HW4_Q3_150120022 {

     // The aim of the  program is to print alphabets diamond.


    public static void main(String args[]) {
        //Get user input using scanner
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a letter: ");

        String str = sc.nextLine();

        //Check for invalid input
        if (!((str != null) && str.length() == 1 && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")))) {
            System.out.println("Invalid Input !");
            System.exit(1);

        }


        //Call construct diamond method
        char[][] diamond = constructDiamond(str.toUpperCase().charAt(0));

        //Print diamond
        printDiamond(diamond);
    }

    //This  Method is used to construct diamond
    public static char[][] constructDiamond(char letter) {
        int let = letter;
        int indexOfChar = let - 65;
        int Rows = (2 * indexOfChar) + 1;
        int Cols = Rows;
        char alphabet = 65;
        char[][] diamond = new char[Rows][Cols];
        int count = 0;
        boolean Reverse = false;
        for (int i = 0; i < Rows; i++) {
            if (indexOfChar == 0)
                count = 0;
            else if (count < indexOfChar && Reverse == false)
                count = i;
            else {
                count--;
                Reverse = true;
            }
            for (int j = 0; j < Cols; j++) {
                if (j == indexOfChar - count || j == indexOfChar + count) {
                    diamond[i][j] = alphabet;
                } else {
                    diamond[i][j] = '.';
                }

            }
            if (i >= indexOfChar) {
                alphabet--;
            } else {
                alphabet++;
            }

        }
        return diamond;
    }

    //This Method is used to print diamond
    public static void printDiamond(char[][] diamond) {
        for (int i = 0; i < diamond.length; i++) {
            for (int j = 0; j < diamond.length; j++) {

                System.out.print(diamond[i][j]);
            }
            System.out.println();
        }
    }
}
