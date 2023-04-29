// Tolga Fehmioðlu 150120022 
//in this part of homework, we are implementing an Factory class using the following UML diagram


public class Factory {

    // Data Fields

    private String name;
    private Employee[] employees;
    private Storage storage;
    private Payroll[] payrolls;
    private double itemPrice;

    // Creating the factory constructor given parameters

    public Factory(String name, int capacity, double itemPrice) {
        this.name = name;
        this.itemPrice = itemPrice;
        this.storage = new Storage(capacity);
//        
    }

    // Get methods
    public double getRevenue() {
        double Revenue = (itemPrice) * storage.getItems().length;
        return Revenue;
    }

    public double getPaidSalaries() {
        double paidsalaries = 0;
        for (int i = 0; i < payrolls.length; i++) {
            paidsalaries += payrolls[i].calculateSalary();
        }
        return paidsalaries;
    }

    //  method adds an employee to the employees array.
    public void addEmployee(Employee employee) {

        // creating our array to avoid NullPointException error.
        if (employees == null)
            employees = new Employee[0];

        // Resizing our employees array.
        Employee[] copyemployee = new Employee[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            copyemployee[i] = employees[i];
        }
        copyemployee[copyemployee.length - 1] = employee;
        employees = copyemployee;


        // Taking the items from employees
        Item[] items = employee.startShift();

        //  Adding these items into storage object
        for (int i = 0; i < items.length; i++) {
            storage.addItem(items[i]);

        }


    }


    public Employee removeEmployee(int id) {

        // if there are no employees, it prints an appropriate error message.
        if (employees == null) {
            System.out.println("There are no employees!");

        } else {

            // try to find employee with the given id
            Employee emp = findEmployee(id);

            // if the employee with a given id is not found, it prints an appropriate error message.
            if (emp == null) {
                System.out.println("Employee does not exist!");

            } else if (employees.length == 0) {
                System.out.println("Employee does not exist!");

            } else {
                removeEmployeeAndResizeEmployeesArray(emp);
                // we need to call endShift() method of the newly removed employee and call


                // call endShift() method of the newly removed employee
                Payroll payroll = emp.endShift();

                // call addPayroll(payroll:Payroll) method with the returned payroll by the endShift() method.
                addPayroll(payroll);
                return emp;
            }
        }
        return null;
    }

    private void addPayroll(Payroll payroll) {
        // This method adds the payroll passed as the parameter to the
        // payrolls data field. We need to resize the payrolls array for this.

        // first element
        if (payrolls == null) {
            payrolls = new Payroll[1];
            payrolls[0] = payroll;
        } else {

            // resize
            Payroll[] newPayrolls = new Payroll[payrolls.length + 1];

            // 1 2 3 4 5 -> payrolls
            // 1 2 3 4 5 null -> newPayrolls

            for (int i = 0; i < payrolls.length; i++) {
                newPayrolls[i] = payrolls[i];
            }
            newPayrolls[newPayrolls.length - 1] = payroll;
            payrolls = newPayrolls;
        }

    }


    private void removeEmployeeAndResizeEmployeesArray(Employee emp) {

        // Calling a method to find the employee's size.

        int empIndex = getEmployeeIndex(emp.getId());
        // 1 2 3 4 5 6 7 8 9
        // 1 2 3 4 6 7 8 9

        // Copying our newEmployees into employees array

        Employee[] newEmployees = new Employee[employees.length - 1];
        for (int i = 0; i < empIndex; i++) {
            newEmployees[i] = employees[i];
        }
        int j = empIndex;
        for (int i = empIndex + 1; i < employees.length; i++) {
            newEmployees[j] = employees[i];
            j++;
        }
        employees = newEmployees;
    }

    // Obtaining employee's index in the method

    private int getEmployeeIndex(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id)
                return i;
        }
        return -1;
    }

       // The method is used for find the Employee
    private Employee findEmployee(int id) {
        Employee emp = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                emp = employees[i];
                break;
            }
        }
        return emp;
    }


}




