/**
 * The purpose of program is implementing a simple company system with the following OOP class hierarchy.
 * Name and Surname: Tolga Fehmioğlu
 * Student ID: 150120022
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Test {


    public static void main(String[] args) throws Exception {
        FileOperator fileOperator = new FileOperator("input.txt");
        fileOperator.createScannerWithFile();
        ObjectMaker objectMaker = new ObjectMaker();


        while (fileOperator.hasNextLine()) {
            Object o = objectMaker.createObject(fileOperator.getNextLine());
            objectMaker.addObject(o);
        }


        objectMaker.assignRegEmpsToManagers();
        objectMaker.distributeBudgets();
        objectMaker.raiseSalaries();
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write(objectMaker.printObjects());
        fileWriter.close();


    }


}
/** This class will be used to scan the file */
class FileOperator {
    private File file;
    private Scanner scanner;

    FileOperator(String fileName) {
        file = new File(fileName);
    }

    FileOperator(File file) {
        this.file = file;
    }

    public void createScannerWithFile() throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    public void createScannerWith(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    public String getNextLine() {
        if (scanner != null && scanner.hasNextLine())
            return scanner.nextLine();
        return null;
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }


}
/** ObjectMaker has all the tools that enable us to implement the test.*/

class ObjectMaker {
    private final ArrayList<Product> products;
    private final ArrayList<Project> projects;
    private final ArrayList<Person> people;
    private final ArrayList<Department> departments;

    public ObjectMaker() {
        products = new ArrayList<>();
        projects = new ArrayList<>();
        people = new ArrayList<>();
        departments = new ArrayList<>();
    }

    public Object createObject(String inputLine) throws Exception {
        String[] lineSplit = inputLine.split(" ");
        String type = lineSplit[0];
        switch (type) {
            case "Product":
                return createProduct(lineSplit);
            case "Project":
                return createProject(lineSplit);
            case "Department":
                return createDepartment(lineSplit);
            default:
                return createPerson(lineSplit);
        }
    }

    private Department createDepartment(String[] lineSplit) {
        int id = Integer.parseInt(lineSplit[1]);
        String departmentName = lineSplit[2];
        return new Department(id, departmentName);
    }

    private Project createProject(String[] lineSplit) throws Exception {
        String projectName = lineSplit[1];
        Calendar startDate = parseDate(lineSplit[2]);
        String state = lineSplit[3];
        return new Project(projectName, startDate, state);
    }

    private Product createProduct(String[] lineSplit) throws Exception {
        String productName = lineSplit[1];
        Calendar saleDate = parseDate(lineSplit[2]);
        double price = Double.parseDouble(lineSplit[3]);
        return new Product(productName, saleDate, price);
    }

    private Person createPerson(String[] lineSplit) throws Exception {
        String type = lineSplit[0];
        switch (type) {
            case "Person":
                return getPerson(lineSplit);
            case "Customer":
                return getCustomer(lineSplit);
            case "Employee":
                return getEmployee(lineSplit);
            case "Manager":
                return getManager(lineSplit);
            case "RegularEmployee":
                return getRegularEmployee(lineSplit);
            case "SalesEmployee":
                return getSalesEmployee(lineSplit);
            case "Developer":
                return getDeveloper(lineSplit);
            default:
                throw new Exception("Type is not defined");
        }
    }

    private Person getDeveloper(String[] lineSplit) throws Exception {
        int id = Integer.parseInt(lineSplit[1]);
        Person person = findPersonById(id);
        String[] projectNames = Arrays.copyOfRange(lineSplit, 2, lineSplit.length);
        ArrayList<Project> projects = getCorrespondingProjects(projectNames);
        return new Developer((RegularEmployee) person, projects);
    }

    private ArrayList<Project> getCorrespondingProjects(String[] projectNames) {
        ArrayList<Project> projectList = new ArrayList<>();
        for (String projectName :
                projectNames) {
            for (Project project :
                    this.projects) {
                if (project.getProjectName().equals(projectName))
                    projectList.add(project);
            }
        }
        return projectList;
    }

    private Person getSalesEmployee(String[] lineSplit) throws Exception {
        int id = Integer.parseInt(lineSplit[1]);
        Person person = findPersonById(id);
        String[] productNames = Arrays.copyOfRange(lineSplit, 2, lineSplit.length);
        ArrayList<Product> products = getCorrespondingProducts(productNames);
        return new SalesEmployee((RegularEmployee) person, products);
    }

    private ArrayList<Product> getCorrespondingProducts(String[] productNames) {
        ArrayList<Product> productList = new ArrayList<>();
        for (String productName :
                productNames) {
            for (Product product :
                    this.products) {
                if (product.getProductName().equals(productName))
                    productList.add(product);
            }
        }
        return productList;
    }

    private Person getRegularEmployee(String[] lineSplit) throws Exception {
        int id = Integer.parseInt(lineSplit[1]);
        double perfScore = Double.parseDouble(lineSplit[2]);
        Person person = findPersonById(id);
        return new RegularEmployee((Employee) person, perfScore);
    }

    private Person getManager(String[] lineSplit) throws Exception {
        int id = Integer.parseInt(lineSplit[1]);
        double bonusBudget = Double.parseDouble(lineSplit[2]);
        Person person = findPersonById(id);
        return new Manager((Employee) person, bonusBudget);
    }

    private Person getEmployee(String[] lineSplit) throws Exception {
        double salary = Double.parseDouble(lineSplit[2]);
        Calendar hireDate = parseDate(lineSplit[3]);
        Department department = getDepartment(lineSplit[4]);
        int id = Integer.parseInt(lineSplit[1]);
        Person person = findPersonById(id);
        return new Employee(person, salary, hireDate, department);
    }

    private Person findPersonById(int id) {
        for (Person p :
                people) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    private Department getDepartment(String departmentName) {
        for (Department dep :
                departments) {
            if (dep.getDepartmentName().equals(departmentName))
                return dep;
        }
        return null;
    }

    private Person getCustomer(String[] lineSplit) throws Exception {
        String[] productNames = Arrays.copyOfRange(lineSplit, 2, lineSplit.length);
        ArrayList<Product> products = getCorrespondingProducts(productNames);
        int id = Integer.parseInt(lineSplit[1]);
        Person person = findPersonById(id);
        return new Customer(person, products);
    }

    private Person getPerson(String[] lineSplit) throws Exception {
        int id = Integer.parseInt(lineSplit[3]);
        String firstName = lineSplit[1];
        String lastName = lineSplit[2];
        String gender = lineSplit[4];
        Calendar birthDate = parseDate(lineSplit[5]);
        String maritalStatus = lineSplit[6];
        String hasDriverLicence = lineSplit[7];
        return new Person(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
    }

    private Calendar parseDate(String date) throws Exception {
        String[] dateSplit = date.split("/");
        Calendar calendar = Calendar.getInstance();
        int year = Integer.parseInt(dateSplit[2]);
        int month = Integer.parseInt(dateSplit[1]);
        int day = Integer.parseInt(dateSplit[0]);
        calendar.set(year, getMonth(month), day);

        return calendar;
    }

    private int getMonth(int month) throws Exception {
        switch (month) {
            case 1:
                return Calendar.JANUARY;
            case 2:
                return Calendar.FEBRUARY;
            case 3:
                return Calendar.MARCH;
            case 4:
                return Calendar.APRIL;
            case 5:
                return Calendar.MAY;
            case 6:
                return Calendar.JUNE;
            case 7:
                return Calendar.JULY;
            case 8:
                return Calendar.AUGUST;
            case 9:
                return Calendar.SEPTEMBER;
            case 10:
                return Calendar.OCTOBER;
            case 11:
                return Calendar.NOVEMBER;
            case 12:
                return Calendar.DECEMBER;
            default:
                throw new Exception();
        }
    }

    public void addObject(Object o) throws Exception {
        if (o instanceof Project)
            addProject((Project) o);
        else if (o instanceof Product)
            addProduct((Product) o);
        else if (o instanceof Department)
            addDepartment((Department) o);
        else if (o instanceof Person)
            addPerson((Person) o);
        else
            throw new Exception("Undefined object in addObject method.");

    }

    private void addPerson(Person person) {
        Person personToRemove = findPersonById(person.getId());
        people.remove(personToRemove);
        people.add(person);
    }

    private void addProject(Project project) {
        projects.add(project);
    }

    private void addProduct(Product product) {
        products.add(product);
    }

    private void addDepartment(Department department) {
        departments.add(department);
    }

    private Manager findManagerByDepartment(Department department) {
        for (Person p :
                people) {
            if (p instanceof Manager) {
                if (((Manager) p).getDepartment() == department)
                    return (Manager) p;
            }
        }
        return null;
    }

    public String printObjects() {
        String printObjects = "";

        printObjects += printDepartments();
        printObjects += printCustomers();
        printObjects += printPeople();

        return printObjects;
    }

    private String printPeople() {
        String printPeople = "";
        ArrayList<Person> people = findRestOfPeople();
        System.out.println("\n\n**********************PEOPLE************************");
        printPeople += "\n\n**********************PEOPLE************************" + "\n";
        for (Person p :
                people) {
            printPeople += p.printInfo();
        }
        return printPeople;
    }

    private String printCustomers() {
        String printCustomers = "";
        ArrayList<Customer> customers = findCustomers();
        System.out.println("\n\n**********************CUSTOMERS************************");
        printCustomers += "\n\n**********************CUSTOMERS************************" + "\n";
        for (Customer c :
                customers) {
            System.out.println(c);
            printCustomers += c.toString() + "\n";
        }
        return printCustomers;
    }

    private String printDepartments() {
        String departmanPrints = "";
        for (Department department : departments) {
            System.out.println("************************************************");
            departmanPrints += "************************************************\n";
            System.out.println(department);
            departmanPrints += department + "\n";
            Manager manager = findManagerByDepartment(department);
            System.out.println(manager);
            departmanPrints += manager.toString() + "\n";
            ArrayList<RegularEmployee> employees = findRegEmpsByDepartment(department);
            System.out.println("\t\t # of Employees: " + employees.size() + "]");
            departmanPrints += "\t\t # of Employees: " + employees.size() + "]" + "\n";
            departmanPrints += printEmployees(employees);
            System.out.println();
            departmanPrints += "\n";
        }
        return departmanPrints;

    }


    private String printEmployees(ArrayList<RegularEmployee> employees) {
        String empInfo = "";
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("\t\t\t" + (i + 1) + ". " +
                    sortEmployees(employees).get(i).getClass().getSimpleName() + "\n" + sortEmployees(employees).get(i));

            empInfo += "\t\t\t" + (i + 1) + ". " +
                    sortEmployees(employees).get(i).getClass().getSimpleName() + "\n" + sortEmployees(employees).get(i) + "\n";
        }
        return empInfo;
    }

    private ArrayList<RegularEmployee> sortEmployees(ArrayList<RegularEmployee> employees) {
        ArrayList<RegularEmployee> regEmps = new ArrayList<>();
        for (RegularEmployee re : employees) {
            if (re instanceof Developer) {
                regEmps.add(re);
            }
        }
        for (RegularEmployee re : employees) {
            if (re instanceof SalesEmployee) {
                regEmps.add(re);
            }
        }
        for (RegularEmployee re : employees) {
            if (!(re instanceof Developer || re instanceof SalesEmployee)) {
                regEmps.add(re);
            }

        }
        return regEmps;
    }


    private ArrayList<RegularEmployee> findRegEmpsByDepartment(Department department) {
        ArrayList<RegularEmployee> employees = new ArrayList<>();
        for (Person person :
                people) {
            if (person instanceof RegularEmployee && ((RegularEmployee) person).getDepartment() == department)
                employees.add((RegularEmployee) person);
        }
        return employees;
    }

    private ArrayList<Person> findRestOfPeople() {
        ArrayList<Person> people = new ArrayList<>();
        for (Person p :
                this.people) {
            if (!(p instanceof Customer || p instanceof Employee))
                people.add(p);
        }
        return people;
    }

    private ArrayList<Customer> findCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        for (Person p :
                this.people) {
            if (p instanceof Customer)
                customers.add((Customer) p);
        }
        return customers;
    }

    public void distributeBudgets() {
        ArrayList<Manager> managers = findManagers();
        for (Manager m :
                managers) {
            m.distributeBonusBudget();
        }
    }

    private ArrayList<Manager> findManagers() {
        ArrayList<Manager> managers = new ArrayList<>();
        for (Person p :
                people) {
            if (p instanceof Manager)
                managers.add((Manager) p);
        }
        return managers;
    }

    public void raiseSalaries() throws Exception {
        raiseManagerSalaries();
        raiseRegularEmployeeSalaries();
        raiseDeveloperSalaries();
        raiseSalesEmployeeSalaries();
        fixSalaryOfMaxEarnedSalesEmp();

    }

    private void fixSalaryOfMaxEarnedSalesEmp() {
        ArrayList<SalesEmployee> salesEmployees = findSalesEmployees();
        SalesEmployee maxEarnedSalesEmp = findMaxEarnedSalesEmp(salesEmployees);
        maxEarnedSalesEmp.raiseSalary(1000);
    }

    private SalesEmployee findMaxEarnedSalesEmp(ArrayList<SalesEmployee> salesEmployees) {
        SalesEmployee maxEarnedSalesEmp = salesEmployees.get(0);
        for (SalesEmployee se :
                salesEmployees) {
            if (getTotalValue(se.getSales()) > getTotalValue(maxEarnedSalesEmp.getSales()))
                maxEarnedSalesEmp = se;
        }
        return maxEarnedSalesEmp;
    }

    private double getTotalValue(ArrayList<Product> products) {
        double sum = 0;
        for (Product p :
                products) {
            sum += p.getPrice();
        }
        return sum;
    }


    private void raiseManagerSalaries() throws Exception {
        ArrayList<Manager> managers = findManagers();
        for (Manager m :
                managers) {
            m.raiseSalary(0.2);
        }
    }

    private void raiseRegularEmployeeSalaries() throws Exception {
        ArrayList<RegularEmployee> regularEmployees = findJustRegularEmployees();
        for (RegularEmployee re :
                regularEmployees) {
            re.raiseSalary(0.3);
        }
    }

    private void raiseDeveloperSalaries() throws Exception {
        ArrayList<Developer> developers = findDevelopers();
        for (Developer d :
                developers) {
            d.raiseSalary(0.23);
        }
    }

    private void raiseSalesEmployeeSalaries() throws Exception {
        ArrayList<SalesEmployee> salesEmployees = findSalesEmployees();
        for (SalesEmployee se :
                salesEmployees) {
            se.raiseSalary(0.18);
        }
    }

    private ArrayList<SalesEmployee> findSalesEmployees() {
        ArrayList<SalesEmployee> salesEmployees = new ArrayList<>();
        for (Person p :
                people) {
            if (p instanceof SalesEmployee)
                salesEmployees.add((SalesEmployee) p);
        }
        return salesEmployees;
    }

    private ArrayList<Developer> findDevelopers() {
        ArrayList<Developer> developers = new ArrayList<>();
        for (Person p :
                people) {
            if (p instanceof Developer)
                developers.add((Developer) p);
        }
        return developers;
    }

    private ArrayList<RegularEmployee> findRegularEmployees() {
        ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
        for (Person p :
                people) {
            if (p instanceof RegularEmployee)
                regularEmployees.add((RegularEmployee) p);
        }
        return regularEmployees;
    }

    public void assignRegEmpsToManagers() {
        ArrayList<Manager> managers = findManagers();
        ArrayList<RegularEmployee> regularEmployees = findRegularEmployees();
        for (Manager manager : managers) {
            for (RegularEmployee re : regularEmployees) {
                if (manager.getDepartment() == re.getDepartment()) {
                    manager.addEmployee(re);
                }

            }

        }
    }

    private ArrayList<RegularEmployee> findJustRegularEmployees() {
        ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
        for (Person p :
                people) {
            if (p instanceof RegularEmployee && !(p instanceof SalesEmployee || p instanceof Developer))
                regularEmployees.add((RegularEmployee) p);
        }
        return regularEmployees;
    }

}






