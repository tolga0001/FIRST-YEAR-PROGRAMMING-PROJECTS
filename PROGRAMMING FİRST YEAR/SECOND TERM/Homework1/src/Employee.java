import java.awt.*;
import java.util.Calendar;

public class Employee extends Person {

    // salary: double hireDate: java.util.Calendar department: Department numberofEmployees: int
    private double salary;
    private Calendar hireDate;
    private Department department;
    public static int numberOfEmployees;

    public Employee(int id, String firstName, String lastName, String gender,
                    Calendar birthDate, String maritalStatus, String hasDriverLicence,
                    double salary, Calendar hireDate, Department department) throws Exception {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
        this.salary = salary;
        this.hireDate = hireDate;
        this.department=department;

        numberOfEmployees++;
    }

    public Employee(Person person, double salary, Calendar hireDate, Department department) throws Exception {
        this(person.getId(), person.getFirstName(), person.getLastName(),
                person.getGender(), person.getBirthDate(), person.getMaritalStatus(),
                person.isHasDriverLicence(), salary, hireDate, department);
    }

    //raiseSalary(percent: double): double raiseSalary(amount: int): double
    public double raiseSalary(double percent) throws Exception {
        if (percent >= 0 && percent <= 1) {
            salary += profit(percent);
            return salary;
        } else
            throw new Exception("Invalid percent!!");
    }

    public double raiseSalary(int amount) {
        salary += amount;
        return salary;
    }

    private double profit(double percent) {
        return salary * percent;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        Employee.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return  super.toString() + "\n\t\t\t\tEmployee Info [" +
                "salary=" + salary +
                ", hireDate=" + getDateFormatted(hireDate) +
                ']';
    }


}
