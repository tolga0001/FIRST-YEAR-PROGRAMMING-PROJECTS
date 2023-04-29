 import java.util.Scanner;

 public class HW2_150120022_P2 {
	
	// Tolga Fehmioðlu
	
	// The aim of this program is to decide the exact day according to the year and month which is taken from the user.

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		// Prompt the user to enter a year,
		System.out.print("Enter year (e.g. 2012): ");
		int year=input.nextInt();
		
		// Prompt the user to enter a month
		System.out.print("Enter month (e.g. 1-12): ");
		int month=input.nextInt();
		
		// Converting January and February to months 13 and 14 of the previous year
		if(month==1 || month==2) {
		
		 month+=12;
		  year-=1;
		}
		
		// Prompt the user to enter a day of the month
		System.out.print("Enter the day of the month (e.g. 1-31): ");
		int day_of_the_month=input.nextInt();
		
		
		// The other variables which are necessary for applying the formula
		int century=year/100;
		int year_of_the_century=year%100;
		
		
		// The calculation part of the day according to given values
		int Day=((day_of_the_month)+(26*(month+1)/10)+(year_of_the_century)+(year_of_the_century/4)+century/4+5*century)%7;
		
		// Display the results by using switch case method
		  switch(Day) {
		  case(0):
		  System.out.println("Day of the week is Saturday");
		  break;
		  case(1):
	     System.out.println("Day of the week is Sunday");
		  break;
		  case(2):
		 System.out.println("Day of the week is Monday");
		  break;
		  case(3):
		 System.out.println("Day of the week is Tuesday");
		  break;
		  case(4):
		 System.out.println("Day of the week is Wednesday");  
		  break;
		  case(5):
	     System.out.println("Day of the week is Thursday"); 
		  break;
		  case(6):
		 System.out.println("Day of the week is Friday");

			  
		  }
		  
		  
		  
		 
		  

	}

}
