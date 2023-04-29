import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
    // sales: ArrayList< Product> numberOfSalesEmployees: int
    private ArrayList<Product> sales = new ArrayList<>();
    public static int numberOfSalesEmployees;

    public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Product> s) throws Exception {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
        sales = s;
        numberOfSalesEmployees++;
    }

    public SalesEmployee(RegularEmployee re, ArrayList<Product> s) throws Exception {
        super(re, re.getPerformanceScore());
        sales = s;
        numberOfSalesEmployees++;
    }

    public boolean addSale(Product s) {
        if (!sales.contains(s)) {
            sales.add(s);
            return true;
        }
        return false;

    }

    public boolean removeSale(Product s) {
        if (sales.contains(s)) {
            sales.remove(s);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }


    @Override
    public String toString() {
        return  super.toString() + "\n\t\t\t\t" +
                sales;
    }

}
