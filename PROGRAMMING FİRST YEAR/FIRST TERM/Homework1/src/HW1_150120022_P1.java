//Tolga Fehmio�lu 150120022
import java.util.Scanner;

public class HW1_150120022_P1 {

	public static void main(String[] args) {
		//creating a scanner object to prompt the user for taking different inputs
		Scanner input=new Scanner(System.in);
		//OUTPUT THE MESSAGE WH�CH �S ASK�NG D�STANCE
		System.out.print("enter the driving distance:");
		// TAKE THE �NPUT OF D�STANCE VALUE
		double distance=input.nextDouble();
		//OUTPUT THE MESSAGE WH�CH �S ASK�NG D�STANCE
		System.out.print("enter miles per gallon:");
		// taking the input value of miles per gallon
		double miles=input.nextDouble();
		//output the message
		System.out.print("Enter price per gallon:");
		//taking the input value of price
		double price=input.nextDouble();
		//the calculation of cost value
		double cost= distance/miles*price;
		// turning the double number into a decimal number
		float cost1=(int)(cost*100);
		float cost2=cost1/100;
		System.out.print("The cost of driving is"+" $"+cost2);
		
		

	}

}
