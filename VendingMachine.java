import java.util.ArrayList;
import java.util.Scanner;

/**
 * 	This VendingMachine class allows for creating slots, dispensing an item, 
 *  collecting payment, producing change, and performing maintenance
 */
public class VendingMachine {
    private Scanner sc;
    private ArrayList<Slot> slotList;
    private Denominations payment;
    private Inventory startingInventory;

    /**
     * Constructs a vending machine object
     */
    public VendingMachine() {
        this.slotList = new ArrayList<>();
        this.sc = new Scanner(System.in); 
        this.payment = new Denominations();
        this.startingInventory = new Inventory();
    }
    
    /**
     * Displays the starting menu of the vending machine
     */
    public void displayMenu() {
        int slots;
        int i;

        System.out.print("\nEnter the number of slots for the items: ");
        slots = sc.nextInt();

        if (slots > 12) {
            System.out.println();
            System.out.println("Error: The machine should have at most 12 slots. Try Again.");
            displayMenu();
            return;
        }

        if (slots < 8) { 
            System.out.println();
            System.out.println("Error: The machine should have at least 8 slots. Try Again.");
            displayMenu();
            return;
        }

        for (i = 0; i < slots; i++) {
            String name;
            double calories;
            double price;
            int quantity;
            int isValid = 0;

            System.out.println();
            System.out.println("[ Slot #" + (i+1) +" ]"); 
            System.out.println();

            System.out.print("Enter Salad Item: "); 
            sc.nextLine();
            name = sc.nextLine();

            System.out.print("Enter Calories: ");
            calories = sc.nextDouble();

            System.out.print("Enter Price: ");
            price = sc.nextDouble();
            
            do {
                System.out.print("Enter Quantity: ");
                quantity = sc.nextInt();

                if(quantity < 10) 
                    System.out.println("\nError: The slot should have at least 10 items. Try Again.\n");
                else if(quantity > 20)
                    System.out.println("\nError: The slot should have at most 20 items. Try Again.\n");
                else
                    isValid = 1;

            } while (isValid == 0);
            
                Item item = new Item(name, calories, price, quantity); 
                Slot slot = new Slot(i+1, item); 
                
                slotList.add(slot); 
                slotList.get(i).addItem(quantity);

                startingInventory.updateStartingInventory(name, calories, price, quantity);
                System.out.println("\nItems are successfully added!"); 
            } 

            System.out.println();
            System.out.println("[ " + slots + " slots are successfully added! ]\n");
            System.out.println("---------------------------------------------");
            System.out.println("                SLOT LIST");
            System.out.println("---------------------------------------------\n");
            displaySlots();
        }

    /**
     * Displays a list of slots
     */
    public void displaySlots() {
        for (Slot slot : slotList) {
            System.out.println();
            System.out.println("Slot Number: " + slot.getSlotNumber());
            System.out.println("Item Name: " + slot.getSpecificItem().getName());
            System.out.println("Calories: " + slot.getSpecificItem().getCalories());
            System.out.println("Price: " + slot.getSpecificItem().getPrice());
            System.out.println("Quantity: " + slot.getSpecificItem().getQuantity());
            System.out.println();
        }
    }

    /**
     * Displays the different denominations to choose from
     * 
     * @return input        Chosen denomination by the user
     */
    public int displayDenominations() {
        int input;
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("[1] 1 PHP");
        System.out.println("[2] 5 PHP");
        System.out.println("[3] 10 PHP");
        System.out.println("[4] 20 PHP");
        System.out.println("[5] 50 PHP");
        System.out.println("[6] 100 PHP");
        System.out.println("[7] 200 PHP");
        System.out.println("[8] 500 PHP");
        System.out.println("[9] 1000 PHP");
        System.out.println("---------------------------------------------");
        System.out.print("\nInsert Choice: ");
        input = getUserInput(1, 9);
        return input;
    }

    /**
     * Adds a slot to a slot list
     * 
     * @param slot              Slot object to be added to the slot list
     * @return value            True if add slot is valid and false if invalid 
     */
    public boolean addSlot(Slot slot) {
        boolean value = false;

        if(slotList.size() <= 12) {     // 12 is the slot limit
            slotList.add(slot);
            value = true;
        }

        return value;
    }

    /**
     * Inserts payment in the machine
     * 
     * @return total            Total amount of payment inserted, otherwise -1 if invalid
     */
    public int insertPayment() {
        Denominations change = new Denominations();
        int input;
        int quantity;
        int total = 0;
        int insert = 1; // 1 - insert again ; 2 - done

        if(!change.isEnoughChange()) {
            System.out.println("\nError: Not enough change on vending machine. Sorry for the inconvenience.\n");
            System.out.println("Cancelling Transaction...\n");
            System.out.println("Redirecting to main menu...\n");
            
            return -1;
        }

        while(insert == 1) {
                
            input = displayDenominations(); 
            System.out.print("Enter Quantity: ");
            quantity = sc.nextInt();
                
            switch(input) {
                case 1: total += this.payment.insertOnePesoCoin(quantity); break;
                case 2: total += this.payment.insertFivePesoCoin(quantity); break;
                case 3: total += this.payment.insertTenPesoCoin(quantity); break;
                case 4: total += this.payment.insertTwentyPesoBill(quantity); break;
                case 5: total += this.payment.insertFiftyPesoBill(quantity); break;
                case 6: total += this.payment.insertOneHundredPesoBill(quantity); break;
                case 7: total += this.payment.insertTwoHundredPesoBill(quantity); break;
                case 8: total += this.payment.insertFiveHundredPesoBill(quantity); break;
                case 9: total += this.payment.insertOneThousandPesoBill(quantity); break;
            }

            System.out.println();
            System.out.println("[1] Insert Again");
            System.out.println("[2] Done");
            System.out.print("\nInput Choice: ");
            insert = getUserInput(1, 2);
        }

        return total;   // return total amount

    }

    /**
     * Dispenses an item from the vending machine
     * 
     * @param slotNumber            Slot number of the item to be dispensed
     * @return                      Specifictem to be dispensed
     */
    public Item dispenseItem(int slotNumber) {
        Item specificItem = slotList.get(slotNumber-1).getSpecificItem();

        // dispense item
        slotList.get(slotNumber-1).removeItem(specificItem);
        slotList.get(slotNumber-1).addSales();

        slotList.get(slotNumber-1).getSpecificItem().setQuantity(specificItem.getQuantity()-1);
        
        return specificItem;
    }

    /**
     * Displays the dispensed item
     *
     * @param item           Item to display
     */
    public void displayDispensedItem(Item item) {
        System.out.println("Dispensing Item: " + item.getName() + "...");
        System.out.println();
        System.out.println("[ Item dispensed successfully! ]");
    }

    /**
     * Gets the slot list
     * 
     * @return               List of slots inside the vending machine
     */
    public ArrayList<Slot> getSlotList() {
        return this.slotList;
    }

    /**
     * Displays the starting inventory
     */
    public void displayStartingInventory() {
        int i;
        System.out.println("\n---------------------------------------------");
        System.out.println("               STARTING INVENTORY");
        System.out.println("---------------------------------------------\n");

        for(i = 0; i < startingInventory.getStartingInventory().size(); i++) {
            System.out.println("[ Slot #" + (i+1) +" ]");
            System.out.println();
            System.out.println("Item Name: " + startingInventory.getStartingInventory().get(i).getName());
            System.out.println("Price: " + startingInventory.getStartingInventory().get(i).getPrice());
            System.out.println("Quantity: " + startingInventory.getStartingInventory().get(i).getQuantity());
            System.out.println();
        }
    }

    /**
     * Displays the ending inventory
     */
    public void displayEndingInventory() {
        int i;

        System.out.println("\n---------------------------------------------");
        System.out.println("               ENDING INVENTORY");
        System.out.println("---------------------------------------------\n");

        for(i = 0; i < slotList.size(); i++) {
            System.out.println("[ Slot #" + slotList.get(i).getSlotNumber() +" ]");
            System.out.println();
            System.out.println("Item Name: " + slotList.get(i).getSpecificItem().getName());
            System.out.println("Price: " + slotList.get(i).getSpecificItem().getPrice());
            System.out.println("Quantity : " + slotList.get(i).getSpecificItem().getQuantity());
            System.out.println();
        }
    }

    /**
     * Prints a summary of transactions
     */
    public void printSummaryOfTransactions() {
        int i;
        double totalEarnings = 0;

        System.out.println("\n---------------------------------------------");
        System.out.print("            SUMMARY OF TRANSACTIONS\n");
        System.out.println("---------------------------------------------\n");
        
        for(i = 0; i < slotList.size(); i++) {
            System.out.println("Item Name : " + slotList.get(i).getSpecificItem().getName());
            System.out.println("Quantity of Item Sold : " + slotList.get(i).getSales());
            System.out.println("Total Sales : PHP " + slotList.get(i).getSales() * slotList.get(i).getSpecificItem().getPrice());
            System.out.println();
            totalEarnings += slotList.get(i).getSales() * slotList.get(i).getSpecificItem().getPrice();
        }

        System.out.println("Total Earnings: PHP " + totalEarnings);
    }

    /**
     * Gets the payment 
     * 
     * @return                 Payment represented in denominations
     */
    public Denominations getPayment() {
        return this.payment;
    }

    /**
     * Gets user input given a maximum and minimum range
     * 
     * @param min               Minimum value limit
     * @param max               Maximum value limit
     * @return                  Input of user
     */
    private int getUserInput(int min, int max) {
        int input;

        while (true) {
            input = sc.nextInt();

            if (input >= min && input <= max) {
                break;
            }

            System.out.println("\nInvalid Input! Please try again.\n");
            System.out.print("Input Choice: ");
        }

        return input;
    }
    
}
