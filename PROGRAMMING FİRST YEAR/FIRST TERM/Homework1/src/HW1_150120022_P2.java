//Tolga Fehmioðlu 150120022
import java.util.Scanner;
public class HW1_150120022_P2 {

	public static void main(String[] args) {
	// creating a scanner object
		Scanner input=new Scanner(System.in);
	System.out.print("Number of days:");
	//calculating the month and day with some basic operations
	int number=input.nextInt();
	int year=number/365;
	int remain1= number-365*year;
	int month=remain1/31;
	int remain2=remain1-31*month;
	int day=remain2;
	// output the message
	System.out.println("Year:"+year+" "+"Month:"+month+" "+"Day:"+day);

	}

}
