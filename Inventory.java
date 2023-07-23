import java.util.ArrayList;

/**
 * 	This Inventory class handles and shows the inventory of the vending machine in the program 
 */
public class Inventory {
    private final ArrayList<Item> startingInventory;

    /**
     * Constructs an Inventory class
     * 
     */
    public Inventory() {
        this.startingInventory = new ArrayList<>();
    }

    /**
     * Updates the starting inventory by
     * 
     * @param name        Name of the item
     * @param calories    Calories the item has
     * @param price       Price of the item
     * @param quantity    Quantity of the item
     */
    public void updateStartingInventory(String name, double calories, double price, int quantity) {
        Item tempItem = new Item(name, calories, price, quantity);
        this.startingInventory.add(tempItem);
    }

    /**
     * Gets the starting inventory of the vending machine
     * 
     * @return  List of items the vending machine has from its creation
     */
    public ArrayList<Item> getStartingInventory() {
        return this.startingInventory;
    }

}