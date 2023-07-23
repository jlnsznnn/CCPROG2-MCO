import java.util.Scanner;

/**
 * 	This MainMenu class displays and executes the features of a vending machine
 */
public class MainMenu {
    private Scanner sc;
    private VendingMachine vendingMachine;

    /**
     * Constructs a main menu object of the vending machine, which is set to null
     */
    public MainMenu() {
        this.sc = new Scanner(System.in);
        vendingMachine = null;

        System.out.println();
        System.out.println("=============================================");
        System.out.println("\tV E N  D I N G   M A C H I N E");
        System.out.println("---------------------------------------------");
        System.out.println("             Factory Simulator");
        System.out.println("=============================================");
        System.out.println();
    }

    /**
     * Displays the main menu
     */
    public void displayMainMenu() {
        int input;
        
        System.out.println("[1] Create a Regular Vending Machine");
        System.out.println("[2] Create a Special Vending Machine");
        System.out.println("[3] Exit \n");
        System.out.print("Input Choice: ");

        input = getUserInput(1, 3);

        switch (input) {
            case 1:
                createVendingMachine();
                break;
            case 2:
                System.out.println("\n(i) Special Vending Machine is not yet available\n");
                displayMainMenu();
                break;
            case 3:
                System.out.println("\nExiting program...\n");
                System.exit(0);
                break;
        }
    }

    /**
     * Creates a Regular Vending Machine
     */
    public void createVendingMachine() {
        System.out.println("\nRegular Vending Machine is successfully created!");

        vendingMachine = new VendingMachine();
        vendingMachine.displayMenu();
        testVendingMachine(); 
    }
    
    /**
     * Allows the user to test the vending machine's vending feature or maintenance feature
     */
    public void testVendingMachine() {
        int input;

        System.out.println();
        System.out.println("=============================================");
        System.out.println("            TEST VENDING MACHINE");
        System.out.println("=============================================\n");
        System.out.println("[1] Vending Features");
        System.out.println("[2] Maintenance Features");
        System.out.println("[3] Exit\n");
        System.out.print("Input Choice: ");

        input = getUserInput(1, 3);

        switch (input) {
            case 1:
                testVendingFeatures();
                break;
            case 2:
                testMaintenanceFeatures();
                break;
            case 3:
                System.out.println("\nRedirecting to Main Menu...\n");
                displayMainMenu();
                break;
        }
    }

    /**
     * Tests the vending features of the machine
     */
    private void testVendingFeatures() {
        int i;
        int payment = 0;
        int input;
        int itemChoice;
        double price;
        Item dispense;

        System.out.println();
        System.out.println("=============================================");
        System.out.println("\t\tW E L C O M E");
        System.out.println("\t\t    T O");
        System.out.println(" \tG R E E N S  &  G R A I N S !");
        System.out.println("---------------------------------------------");
        System.out.println("         - A Salad Vending Machine -");
        System.out.println("=============================================");

        for(i = 0; i < vendingMachine.getSlotList().size(); i++) {
            System.out.println();
            System.out.println("[ " + (i+1) + " ] " + vendingMachine.getSlotList().get(i).getSpecificItem().getName());

            if(vendingMachine.getSlotList().get(i).getItemList().size() > 0) {
                System.out.println("Stock: " + vendingMachine.getSlotList().get(i).getItemList().size()); 
                System.out.println("Calories: " + vendingMachine.getSlotList().get(i).getSpecificItem().getCalories());
                System.out.println("Price: PHP " + vendingMachine.getSlotList().get(i).getSpecificItem().getPrice() + '0');
            } else 
                System.out.println("OUT OF STOCK");
            

            System.out.println();
        } 
        
        System.out.print("Choose item to dispense: ");
        itemChoice = getUserInput(1, vendingMachine.getSlotList().size()); 
        price = vendingMachine.getSlotList().get(itemChoice-1).getSpecificItem().getPrice();

        System.out.println();
        System.out.println("---------------------------------------------\n");
        System.out.println("The total amount is PHP " + price);
        System.out.println();
        System.out.println("[1] Proceed with Transaction");
        System.out.println("[2] Cancel Transaction"); 
        System.out.println("[3] Exit Menu"); 
        System.out.print("\nInput Choice: ");

        input = getUserInput(1, 3);
        System.out.println();

        switch (input) {
            case 1: 
                System.out.println("Please pay PHP " + price);

                do {
                    payment += vendingMachine.insertPayment();

                    if(payment == -1)
                        testVendingMachine();

                    if(payment < price)
                        System.out.println("\nError: Insufficient Payment. Please pay the remaining price of PHP " + (price-payment));
                        
                } while (payment < price);

                vendingMachine.getPayment().produceChange(price, (double)payment);
                dispense = vendingMachine.dispenseItem(itemChoice);
                vendingMachine.displayDispensedItem(dispense);
                break; 
            case 2:
                System.out.println("Cancelling Transaction...\n");
                testVendingFeatures();
                break;
            case 3:
                System.out.println("\nRedirecting to Main Menu...\n");
                testVendingMachine();
                break;
        }

        System.out.println();
        System.out.println("[1] Dispense Again");
        System.out.println("[2] Exit");
        System.out.print("\nInput Choice: ");
        input = getUserInput(1, 2);

        if(input == 1) {
            System.out.println();
            testVendingFeatures();
         }else {
            testVendingMachine();
        }
    }

    /**
     * Tests the maintenance features of the machine
     */
    public void testMaintenanceFeatures() {
        int input;
        int quantity;
        int total = 0;
        int collectAgain = 0;
        Item item;
        Maintenance itemMaintenance;
        Maintenance itemPriceMaintenance;
        Maintenance moneyMaintenance;
        Maintenance replenishMoneyMaintenance;
        int currentStock;
        int remainingStocks;
        int newStock;
        double price;

        System.out.println();
        System.out.println("============================================");
        System.out.println("             MAINTENANCE FEATURES");
        System.out.println("============================================\n");
        System.out.println("[1] Restock Item");
        System.out.println("[2] Set Price"); 
        System.out.println("[3] Collect Money"); 
        System.out.println("[4] Replenish Money");
        System.out.println("[5] View Starting Inventory");
        System.out.println("[6] View Ending Inventory");
        System.out.println("[7] Print Summary of Transactions");
        System.out.println("[8] Exit Menu");
        System.out.print("\nInput Choice: ");

        input = getUserInput(1, 8);

        switch (input) {
            case 1: 
                System.out.println("---------------------------------------------");
                System.out.println("              CURRENT SLOT LIST");
                item = getItem();
                itemMaintenance = new Maintenance(item);
                currentStock = item.getQuantity();
                remainingStocks = 20 - currentStock;

                if(remainingStocks == 0)
                    System.out.println("\nThe stocks of this item is already at its maximum capacity.\n");
                else {
                    do {
                        System.out.print("Enter the amount of stocks to add: ");
                        quantity = sc.nextInt(); 
                        newStock = currentStock + quantity;
                        
                        if(newStock > 20)
                            System.out.println("\nThis will exceed the maximum stock of 20. Please try again.\n");
                        
                    } while(newStock > 20);

                    itemMaintenance.restockItem(quantity); 
                    System.out.println();
                    System.out.println("[ " + quantity + "pcs of " + item.getName() + " are successfully added! ]");
                    System.out.println();
                    System.out.println("---------------------------------------------");
                    System.out.println("              UPDATED SLOT LIST");
                    System.out.println("---------------------------------------------");
                    vendingMachine.displaySlots();
                }
                break; 
            case 2:
                System.out.println("\n---------------------------------------------");
                System.out.println("              SET NEW PRICE");

                item = getItem();
                itemPriceMaintenance = new Maintenance(item);

                System.out.print("Input new price: ");
                price = sc.nextDouble();
                itemPriceMaintenance.setNewPrice(price);

                System.out.println();
                System.out.println("[ Price of " + item.getName() + " is successfully updated to PHP " + item.getPrice() + " ]");
                System.out.println();
                System.out.println("---------------------------------------------");
                System.out.println("             UPDATED NEW PRICE");
                System.out.println("---------------------------------------------");

                vendingMachine.displaySlots();

                break;
           case 3:
                moneyMaintenance = new Maintenance(vendingMachine.getPayment());
                moneyMaintenance.displayMoney();

                do{
                    System.out.print("\nEnter choice: ");
                    input = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    total += moneyMaintenance.collectMoney(input, quantity);
                    moneyMaintenance.displayMoney();
                    System.out.println("\nDo you want to collect more money?\n");
                    System.out.println("[1] Yes");
                    System.out.println("[2] No");
                    System.out.print("\nInput choice: ");
                    collectAgain = getUserInput(1, 2);
                } while(collectAgain == 1);

                System.out.println("\nTotal Collected Money: PHP " + total);
                
                break;
            case 4:
                replenishMoneyMaintenance = new Maintenance(vendingMachine.getPayment());

                System.out.println("\n---------------------------------------------");
                System.out.print("              REPLENISH MONEY");

                input = vendingMachine.displayDenominations();

                System.out.print("Enter Quantity: ");
                quantity = sc.nextInt();

                replenishMoneyMaintenance.replenishMoney(input, quantity);
                System.out.println("\n[ Inserted amount is successfully replenished! ]");
                replenishMoneyMaintenance.displayMoney();
                break;
            case 5: 
                System.out.println();
                vendingMachine.displayStartingInventory(); 
                break;
            case 6:
                System.out.println();
                vendingMachine.displayEndingInventory();
                break;
            case 7: 
                System.out.println();
                vendingMachine.printSummaryOfTransactions();
                break;
            case 8:
                System.out.println("\nRedirecting to Main Menu...\n");
                testVendingMachine();
                break;
        }
        
        testMaintenanceFeatures();
    }

    /**
     * Gets the Item inside a slot list
     * 
     * @return          The retrieved item from the slot list
     */
    private Item getItem() {
        int input;
        int i;
        for (i = 0; i < vendingMachine.getSlotList().size(); i++) {
            System.out.println("---------------------------------------------");
            System.out.println();
            System.out.println("Slot Number: " + vendingMachine.getSlotList().get(i).getSlotNumber());
            System.out.println("Item Name: " + vendingMachine.getSlotList().get(i).getSpecificItem().getName());
            System.out.println("Calories: " + vendingMachine.getSlotList().get(i).getSpecificItem().getCalories());
            System.out.println("Price: " + vendingMachine.getSlotList().get(i).getSpecificItem().getPrice());
            System.out.println("Quantity: " + vendingMachine.getSlotList().get(i).getSpecificItem().getQuantity());
            System.out.println();
        }

        System.out.println("---------------------------------------------");
        System.out.print("Enter slot number: ");
        input = sc.nextInt();

        return vendingMachine.getSlotList().get((input-1)).getSpecificItem();
    }

    /**
     * Gets and validates the user input by checking if the input is among the choices
     * 
     * @param min        Minimum value to be inputted
     * @param max        Maximum value to be inputted
     * @return           Valid Input
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
