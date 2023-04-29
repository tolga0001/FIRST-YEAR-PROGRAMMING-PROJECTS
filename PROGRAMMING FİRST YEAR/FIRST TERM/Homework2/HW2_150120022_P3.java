import java.util.Scanner;

public class HW2_150120022_P3 {
	
	// Tolga Fehmioðlu
	
	// The aim of this program is to calculate the tax amount, income after tax and real tax rate of Turkey according the data of 2017, 2018, 2019 and 2020's incomes.

	public static void main(String[] args) {
		
		// Declaring the variables
	
		int year;
		double income;
		double tax_amount ;
		double ýncome_after_tax;
		double real_tax_rate;
		
		// Creating a scanner object 
	      Scanner input=new Scanner(System.in);
		
	   // taking the values of year and income from the user
	   
	     year=input.nextInt();
		income=input.nextDouble();
		
		// the condition if income is less or equal than zero
	if(income<=0) {
		 System.out.println("Income must be > 0");
		}
		 
	     // The condition if income is greater than zero
	else  {
		
		// The calculation of  tax amount for 2020
		
		if(year==2020 ) {
		
		  if(income<22000){	
		tax_amount=income*0.15;
		}
		  else if(income<49000) {
	    tax_amount=3300+(income-22000)*0.20;
		}
		  else if(income<180000){	
		tax_amount=8700+(income-49000)*0.27;
		}
		  else if(income<600000){	
		tax_amount=44070 + (income-180000)*0.35;
		}
		  else {
		tax_amount=191070 + (income-600000)*0.40;
		}
		  
		  // The other variables which should be on console for 2020
		 
		   ýncome_after_tax=income-tax_amount;
		   real_tax_rate=(int)(tax_amount)/income;
		   real_tax_rate*=100;
		
		   // Output the values of income, tax amount, Income, after tax and real tax rate for 2020
			System.out.println("income: "+income);
		    System.out.println("tax amount: "+(int)(tax_amount*100)/100.0);
		    System.out.println("Income after tax: "+(int)(ýncome_after_tax*100)/100.0);
		    System.out.println("real tax rate: "+(int)(real_tax_rate*100)/100.0+"%");
	            

		}
		
		// The calculation of  tax amount for 2019
		
		else if(year==2019 ){
		
		  if(income<18000) {
		tax_amount=income*0.15;
		}
		  else if(income<40000){
	   tax_amount=2700 + (income-18000)*0.20;
		}
		  else if(income<148000){
		tax_amount=7100 +(income-40000)*0.27;
		}
		  else if(income<500000){
		tax_amount=	36260 + (income-148000)*0.35;
		}
		   else {
		tax_amount=	159460 + (income-500000)*0.40;
		}
		  
		  // The other variables which should be on console for 2019
		
		  ýncome_after_tax=income-tax_amount;
		  real_tax_rate=(int)(tax_amount)/income;
		   real_tax_rate*=100;
		   
		   // Output the values of income, tax amount, Income, after tax and real tax rate for 2019
		  
	      System.out.println("income: "+income);
		  System.out.println("tax amount: "+(int)(tax_amount*100)/100.0);
		  System.out.println("ýncome after tax: "+(int)(ýncome_after_tax*100)/100.0);
	      System.out.println("real tax rate: "+(int)(real_tax_rate*100)/100.0+"%");
	            

		}
		
		// The calculation of  tax amount for 2018
		 
		else if(year==2018 ) {
		
			if(income<14800) {
		tax_amount=income*0.15;	
		}
		    else if(income < 34000) {
	    tax_amount=2220 +(income-14800)*0.20;
		}
		    else if(income<120000) {
		tax_amount=6060 + (income-34000)*0.27;
		}
		    else {
		tax_amount=	29280 + (income-120000)*0.35;
		}
			  
			 // The other variables which should be on console for 2018
			
		   ýncome_after_tax=income-tax_amount;
		   real_tax_rate=(int)(tax_amount)/income;
		   real_tax_rate*=100;
		  
			 
		// Output the values of income, tax amount, Income, after tax and real tax rate for 2018
		    
		  System.out.println("income: "+income);
		  System.out.println("tax amount: "+(int)(tax_amount*100)/100.0);
		  System.out.println("ýncome after tax: "+(int)(ýncome_after_tax*100)/100.0);
		 System.out.println("real tax rate: "+(int)(real_tax_rate*100)/100.0+"%");
	         

		  
		
		}
		
		// The calculation of  tax amount for 2017
		
		else if(year==2017 ) {
		
		   if(income<13000) {	
		 tax_amount=income*0.15;
		 }
		   else if(income<30000) {
	     tax_amount= 1950 + (income-13000)*0.20;
		 }
	       else if(income<110000) {
	     tax_amount=5350 + (income-30000)*0.27;
	     }
	        else {
	     tax_amount=26950 + (income-110000)*0.35;
	     }
		
		 // The other variables which should be on console for 2017
		   
		    ýncome_after_tax=income-tax_amount;
		   real_tax_rate=(int)(tax_amount)/income;
		   real_tax_rate*=100;
		   
	
		 // Output the values of income, tax amount, Income, after tax and real tax rate for 2017
	 
		   System.out.println("income: "+income);
	    System.out.println("tax amount: "+(int)(tax_amount*100)/100.0);
	    System.out.println("Income after tax: "+(int)(ýncome_after_tax*100)/100.0);
	    System.out.println("real tax rate: "+(int)(real_tax_rate*100)/100.0+"%");
	            

		 
		}
		 // if the year is not 2017, 2018, 2019 or 2020 then we need to output the message for undefined years
		   else {
			System.out.println("Undefined year value");
			}
		 
		 
	   
		
		 
		 
		
		 
		
		 
		
		
		
		
		
	
		 }
	 }
	}
	
		
	
		
	
	
    

  
		
		
			
		
	
	 
		
		 
		
		
	
	     
		
		
		 
		 
		
		
		
		
		
		
		
		

	


