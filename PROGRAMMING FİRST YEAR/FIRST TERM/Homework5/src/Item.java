// Tolga Fehmioðlu 150120022 

// The purpose of the program is to  implement a factory simulator program with object-oriented  approach.

//in this part of homework, we are implementing an Item class using the following UML diagram

public class Item {


    // Data Fields

    private int id;
    public static int numberOfItems;

    // increasing the number of items
    public Item(int id) {
        this.id = id;
        numberOfItems++;
    }

    // get method of id and NumberofItems

    public int getId() {
        return id;
    }

    public static int numberOfItems() {
        return numberOfItems;
    }
}
