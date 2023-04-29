import java.util.Scanner;
//  150120022 Tolga Fehmioðlu

public class HW4_Q2_150120022 {
    // The aim for this program is to check whether a number is valid or not according to the Luhn formula.

    public static void main(String[] args) {


        // Creating the scanner object
        Scanner input = new Scanner(System.in);

        //Taking the string from the user
        String str = input.nextLine();

        // Creating boolean method to check if the number is validate or not.

        if (validateNumber(str)) {


            //Initializing our arrays that are need to find the calculation of sum and the variables which will  be displayed on the screen.

            int[] digits = initializeDigits(str);
            int[] dNumbers = getDNumbers(digits);
            int[] remainingNumbers = getRemainingNumbers(digits);
            int[] doubledNumbers = applyDoubling(dNumbers);
            String lNumbers = initializeLNumbers(doubledNumbers, remainingNumbers);
            int totalSum = getSumOf(doubledNumbers, remainingNumbers);

            //Printing the Dnumber and Lnumber by calling these methods.
            printDNumbers(dNumbers, digits);
            printLNumbers(lNumbers);

            // Checking if our sum is evenly divisible or not and output the message according to it
            if (isTotalSumEvenlyDivisible(totalSum)){
                System.out.println("Number is Valid");
            }
            else{
                System.out.println("Number is Invalid");

            }
        } else {
            System.out.println("Invalid input");
        }
    }

    //This method is printing L numbers
    public static void printLNumbers(String lNumbers) {
        System.out.println("LNumber:" + lNumbers);

    }

    // This method is used for creating our Lnumbers.
    public static String initializeLNumbers(int[] doubledNumbers, int[] remainingNumbers) {
        int size = doubledNumbers.length + remainingNumbers.length;
        String lNumbers = "";
        if (size % 2 == 0){
            for (int i = doubledNumbers.length-1; i >= 0; i--) {
                lNumbers += doubledNumbers[i] + "" + remainingNumbers[i];
            }

        } else{
            lNumbers += remainingNumbers[remainingNumbers.length-1];
            for (int i = doubledNumbers.length-1; i >= 0; i--) {
                lNumbers += remainingNumbers[i] + "" + doubledNumbers[i];
            }

        }
        return lNumbers;
    }

    //This method is checking whether sum is evenly divisible or not and return true or false according to calculation

    public static boolean isTotalSumEvenlyDivisible(int totalSum) {
        double quotient = totalSum % 10;
        return quotient % 2 == 0;

    }
// This method is used to calculate the sum and return the value to the main method

    public static int getSumOf(int[] doubledNumbers, int[] remainingNumbers) {
        int sum = 0;
        for (int i = 0; i < doubledNumbers.length; i++) {
            sum += doubledNumbers[i];
        }
        for (int i = 0; i < remainingNumbers.length; i++) {
            sum += remainingNumbers[i];
        }
        return sum;
    }

    // This method is used to double dNumbers according to the rule.
    public static int[] applyDoubling(int[] dNumbers) {
        int[] doubledNumbers = new int[dNumbers.length];
        int doubled;
        for (int i = 0; i < dNumbers.length; i++) {
            doubled = dNumbers[i] * 2;
            if (doubled > 9)
                doubled -= 9;
            doubledNumbers[i] = doubled;
        }
        return doubledNumbers;
    }

    // This method is used to print dNumbers
    public static void printDNumbers(int[] dNumbers, int[] digits) {
        System.out.print("DNumber:");
        if (digits.length % 2 == 0) {
            for (int i = dNumbers.length-1; i >= 0; i--) {
                System.out.print(dNumbers[i] + "_");
            }
        }
        else{
            System.out.print("_");
            for (int i = dNumbers.length-1; i >= 0; i--) {
                System.out.print(dNumbers[i] + "_");
            }
        }
        System.out.println();
    }

    // This method is used to get remaining numbers which are not used for doubling
    public static int[] getRemainingNumbers(int[] digits) {
        int remainingNumbersCount = getRemainingNumbersCount(digits);
        int[] remainingNumbers = new int[remainingNumbersCount];
        int lastIndex = digits.length - 1;
        int j = 0;
        for (int i = lastIndex; i >= 0; i -= 2) {
            remainingNumbers[j] = digits[i];
            j++;
        }

        return remainingNumbers;
    }


    //This method is used to count the remaining numbers to find the size the number's array.
    public static int getRemainingNumbersCount(int[] digits) {
        int remainingNumbersCount;
        if (digits.length % 2 == 0)
            remainingNumbersCount = digits.length / 2;
        else
            remainingNumbersCount = digits.length / 2 + 1;
        return remainingNumbersCount;
    }


    //This method is used to create the dNumber's array.
    public static int[] getDNumbers(int[] digits) {
        int[] dNumbers = new int[digits.length / 2];
        int lastIndex = digits.length - 1;
        int j = 0;
        for (int i = lastIndex - 1; i >= 0; i -= 2) {
            dNumbers[j] = digits[i];
            j++;
        }

        return dNumbers;
    }

    // This method is used to find the all digits in the string and return the array to main method.
    public static int[] initializeDigits(String str) {
        int digitCount = getDigitCount(str);
        int[] digits = new int[digitCount];
        getDigits(str, digits);
        return digits;
    }

    // In this part we obtain digits in the string to be able to return digits in the previous method.
    public static void getDigits(String str, int[] digits) {
        char ch;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                digits[j] = Integer.parseInt(ch + "");
                j++;
            }
        }
    }

    // We are counting the digits in the string

    public static int getDigitCount(String str) {
        int digitCount = 0;
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isDigit(ch))
                digitCount++;
        }

        return digitCount;
    }

    // We are checking if the string is validate or not and return the boolean value.

    public static boolean validateNumber(String number) {
        if (number.length() <= 1)
            return false;
        if (doesStringContainNonDigitCharacter(number))
            return false;

        return true;
    }
    // We use this method to check if the string contains non digit character except space to use it in the previous method

    public static boolean doesStringContainNonDigitCharacter(String str) {
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (!(Character.isDigit(ch)  || Character.isSpaceChar(ch)))
                return true;
        }

        return false;

    }


}
