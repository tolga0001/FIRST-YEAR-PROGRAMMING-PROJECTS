
import java.util.Scanner;
// 150120022 Tolga Fehmio�lu

public class HW4_Q1_150120022 {
    public static void main(String[] args) {
     // The aim of this program is to  calculate the invoice of each flat in an apartment building.

        // Creating a scanner object
        Scanner input = new Scanner(System.in);

        //Taking the information of flats from the user.(Number of Flats,Flat consumption,Total bill)

        int NumberofFlats = input.nextInt();
        double[] flatconsumption = new double[NumberofFlats];
        for (int i = 0; i < flatconsumption.length; i++) {
            flatconsumption[i] = input.nextDouble();
        }

        double Totalbill = input.nextDouble();
     
       
        // Calling a method to calculate each flat of apartment
        double[] eachflatbill = calculateTheInvoice(flatconsumption, Totalbill);

        // The method will be used to display each flat's bill
        printBills(eachflatbill);


    }

    // This method is used to calculate the Invoice of each flat bill and return it

    public static double[] calculateTheInvoice(double[] flats, double totalBill) {
        int n = flats.length;
        double[] eachflatbill = new double[n];
        double totalflat = 0;
        for (int i = 0; i < n; i++) {
            totalflat += flats[i];
        }
        for (int i = 0; i < n; i++)
            eachflatbill[i] = ((totalBill * 0.3) / n) + ((flats[i] / totalflat) * 0.7 * totalBill);

        return eachflatbill;


    }


    // This method is used to print the bills of each flat one by one.
    public static void printBills(double[] bills) {

        for (int i = 0; i < bills.length; i++) {

            double bill = (int) (bills[i] * 100) / 100.0;

            System.out.println( "Flat #"+(i+1) + ": "+bill);
        }


    }
}
