import java.util.Scanner;

public class HW2_150120022_P1 {

   
	// Tolga Fehmioðlu 

// the aim of this code is to checks ISBN-10.The user will enter nine digits and the tenth digit will be determined according to given formula. If the formula gives a digit, it 
// will be added to user's number but if the formula gives 10, then the character X will be added to the user's number

	
     public static void main(String[] args) {
		
		 // Declaring the variables that will be used for output
			int first_digit;
			int second_digit;
			int third_digit;
			int fourth_digit;
			int fifth_digit;
			int sixth_digit;
			int seventh_digit;
			int eight_digit;
			int nineth_digit;
	        
			// Creating a scanner object to prompt the user to enter nine digits
			Scanner input=new Scanner(System.in);
			System.out.print("Enter the first 9 digits of an ISBN as integer: ");
			
			// Taking all the digits of number one by one
			 int number=input.nextInt();
			int value= number;
		     nineth_digit=number%10;
		    number/=10;
		    eight_digit=number%10;
			 number/=10;
			seventh_digit=number%10;
			number/=10;
			sixth_digit=number%10;
			number/=10;
			fifth_digit=number%10;
			number/=10;
			fourth_digit=number%10;
			number/=10;
			third_digit=number%10;
			number/=10;
			second_digit=number%10;
			number/=10;
			first_digit=number;
			 
			
	       // The calculation part according to given formula
			int calculation=((first_digit*1)+(second_digit*2)+(third_digit*3)+(fourth_digit*4)+(fifth_digit*5)+(sixth_digit*6)+(seventh_digit*7)+(eight_digit*8)+(nineth_digit*9))%11;
			
			// Output the all nine digits and the last digit according to the condition of calculation
			
			System.out.print("The ISBN-10 number is "+first_digit+second_digit+third_digit+fourth_digit+fifth_digit+sixth_digit+seventh_digit+eight_digit+nineth_digit);
			
			if(calculation==10)
				System.out.println("X");
			else
			System.out.println(calculation);	
		}

	


}


