//Tolga Fehmioðlu 150120022
import java.util.Scanner;
public class HW1_150120022_P3 {

	public static void main(String[] args) {
		// creating a scanner object
		
		Scanner input=new Scanner(System.in);
		System.out.print("Enter initial principal amount:");
		//taking the values that are defined in the question from the user 
		double initialamount=input.nextDouble();
		System.out.print("Enter annual interest rate:");
		double annualrate=input.nextDouble();
		System.out.print("Enter number of time periods in months:");
		// The calculation part according to the formula
		double time=input.nextDouble();
		double monthlyrate=annualrate/12;
		//obtaining monthly rate,final balance and total interest as a decimal number 
		float monthlyrate1=(int)(monthlyrate*100);
		float monthlyrate2=monthlyrate1/100;
		double finalbalance=initialamount*Math.pow(1+annualrate/1200, time);
		float finalbalance1=(int)(finalbalance*100);
		float finalbalance2=finalbalance1/100;
		double totalinterest=finalbalance-initialamount;
		float totalinterest1=(int)(totalinterest*100);
		float totalinterest2=totalinterest1/100;
		//Output all the values
		System.out.println("Initial principal amount:"+initialamount);
		System.out.println("Monthly interest rate:"+monthlyrate2);
		System.out.println("Total compound interest amount:"+totalinterest2 );
		System.out.print("Final balance amount:"+finalbalance2);
				
	}

}
