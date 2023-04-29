// Tolga Fehmioðlu 150120022 
//in this part of homework, we are implementing an Payroll class using the following UML diagram

public class Payroll {


    // Data Fields
    private int workHour;
    private int itemCount;

    // creating the constructor given parameters
    public Payroll(int workHour, int itemcount) {
        this.workHour = workHour;
        this.itemCount = itemCount;
    }

    // The method for calculating of salary of each employees.
    public int calculateSalary() {
        return workHour * 3 + itemCount * 2;
    }

    // toString method to output the work hour and itemCount of employees.
    public String toString() {
        return "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";
    }
}
