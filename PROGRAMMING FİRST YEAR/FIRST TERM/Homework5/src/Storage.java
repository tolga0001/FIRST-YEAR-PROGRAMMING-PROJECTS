// Tolga Fehmioðlu 150120022
//in this part of homework, we are implementing an Storage class using the following UML diagram


public class Storage {
	

    // Data Fields

    private int capacity;
    private Item[] Items = new Item[0];

    //Creating the constructor given capacity

    public Storage(int capacity) {
        this.capacity = capacity;
    }

    // get methods for capacity and items

    public int getCapacity() {
        return capacity;
    }


    public Item[] getItems() {
        return Items;
    }


    // addItem(item:Item) method adds the item passed as the parameter to the items data field.

    public Item[] addItem(Item item) {
        Item[] ItemList = new Item[Items.length + 1];
        for (int i = 0; i < Items.length; i++) {
            ItemList[i] = Items[i];
        }
        ItemList[ItemList.length - 1] = item;
        Items = ItemList;


        return Items;


    }
}
