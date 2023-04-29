// Tolga Fehmioðlu 150120022 
//in this part of homework, we are implementing an Employee class using the following UML diagram

public class Employee {


    // Data field
    private int id;
    private String name;
    private String surname;
    private int workHour;
    private int speed;
    private Item[] items;
    private Payroll payroll;


    // creating our Constructor given parameters
    public Employee(int id, String name, String surname, int workHour, int speed) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workHour = workHour;
        this.speed = speed;
    }

    /* This method finds how many items this employee should produce according to
    speed and workHour values. After that, it creates appropriate number of items with
    randomly generated id's between 1-100 and put them into items array.*/

    public Item[] startShift() {
        int id;
        Item random_Item;
        int NumberOfItems = speed * workHour;
        items = new Item[NumberOfItems];
        for (int i = 0; i < NumberOfItems; i++) {
            id = (int) (Math.random() * 100 + 1);
            random_Item = new Item(id);
            items[i] = random_Item;


        }
        return items;
    }


        /*endShift() method creates a Payroll object with employee's work hour and the number
        of items s/he creates. it assigns this object to payroll data field. it then returns payroll
        object.*/

    public Payroll endShift() {
        int itemcount = speed * workHour;
        payroll = new Payroll(workHour, itemcount);
        return payroll;
    }

    
    /* toString() method returns a String with employees id and the return value of the payroll
      object toString() method.*/
     

    public String toString() {
        return "This is the employee with id " + id + " speed " + speed +
                "." + " The work hour is " + workHour + " and the " + "produced\nitem count is " + workHour * speed + ".";


    }

// Get method of id

    public int getId() {
        return id;
    }
}
