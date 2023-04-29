import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Employee {
    //regularEmployees: ArrayList<RegularEmployee> bonusBudget: double

    private ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
    private double bonusBudget;

    public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) throws Exception {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
        this.bonusBudget = bonusBudget;
    }

    public Manager(Employee employee, double bonusBudget) throws Exception {
        super(employee, employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        this.bonusBudget = bonusBudget;
    }

    public void addEmployee(RegularEmployee e) {
        regularEmployees.add(e);
    }

    public void removeEmployee(RegularEmployee e) {
        regularEmployees.remove(e);
    }

    public void distributeBonusBudget() {
        double unit = calculateUnit();
        double bonus;
        for (RegularEmployee re :
                regularEmployees) {
            bonus = unit * re.getSalary() * re.getPerformanceScore();
            re.setBonus(bonus);
        }

    }

    private double calculateUnit() {
        double sum = 0;
        for (RegularEmployee re :
                regularEmployees) {
            sum += re.getSalary() * re.getPerformanceScore();
        }
        return bonusBudget / sum;
    }


    public ArrayList<RegularEmployee> getRegularEmployees() {
        return regularEmployees;
    }

    public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
        this.regularEmployees = regularEmployees;
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }


    @Override
    public String toString() {
        return "\tManager [id: " + super.getId() + ", " +
                super.getFirstName() + " " + super.getLastName();
    }
}

