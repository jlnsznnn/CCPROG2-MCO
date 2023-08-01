package SourceCode.Model;

import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine {
    /**
     * Constructs a special vending machine object
     */
    public SpecialVendingMachine() {
        super();
    }

    @Override
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
            int isSellable;

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

            System.out.println("Can be sold alone?");
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            isSellable = sc.nextInt();
            
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
                
                if(isSellable == 1) {
                    item.setIsSellable(true);
                } else if(isSellable == 2) {
                    item.setIsSellable(false);
                }
                
                Slot slot = new Slot(i+1, item); 
                
                slotList.add(slot); 
                slotList.get(i).addItem(quantity);

                startingInventory.updateStartingInventory(slot);
                System.out.println("\nItems are successfully added!"); 
            } 

        System.out.println();
        System.out.println("[ " + slots + " slots are successfully added! ]\n");
        System.out.println("---------------------------------------------");
        System.out.println("                SLOT LIST");
        System.out.println("---------------------------------------------\n");
        super.displaySlots();
    }

    public void displayDispensedItems(ArrayList<Item> item) {

    }

    @Override
    public void testVendingFeatures() {
        int i;
        int payment = 0;
        int input;
        int itemChoice;
        double price;
        Item dispense;
        ArrayList<Item> itemCombo = new ArrayList<>();

        System.out.println();
        System.out.println("=============================================");
        System.out.println("\t\tW E L C O M E");
        System.out.println("\t\t    T O");
        System.out.println(" \tG R E E N S  &  G R A I N S !");
        System.out.println("---------------------------------------------");
        System.out.println("         - A Salad Vending Machine -");
        System.out.println("=============================================");

        System.out.println("[1] Dispense An Item");
        System.out.println("[2] Dispense a Combo");
        
        input = super.getUserInput(1,2);
        System.out.println();

        if(input == 1) {    // Dispense an item

            do{
                System.out.println();

                for(i = 0; i < slotList.size(); i++) {
                    System.out.println();
                    System.out.println("[ " + (i+1) + " ] " + slotList.get(i).getSpecificItem().getName());
        
                    if(slotList.get(i).getItemList().size() > 0) {
                        System.out.println("Stock: " + slotList.get(i).getItemList().size()); 
                        System.out.println("Calories: " + slotList.get(i).getSpecificItem().getCalories());
                        System.out.println("Price: PHP " + slotList.get(i).getSpecificItem().getPrice() + '0');
                    } else 
                        System.out.println("OUT OF STOCK");
                    
        
                    System.out.println();
                } 
                System.out.print("Choose item to dispense: ");
                itemChoice = getUserInput(1, slotList.size()); 

                // check if item is dispensable as an individual item
                if(slotList.get(itemChoice-1).getSpecificItem().getIsSellable() == false)
                    System.out.println("This item cannot be dispensed alone. Please choose another item");
            
            } while(slotList.get(itemChoice-1).getSpecificItem().getIsSellable() == false);
            
            // get price of item
            price = slotList.get(itemChoice-1).getSpecificItem().getPrice();

            super.displayPaymentOptions(price);

            input = super.getUserInput(1, 3);
            System.out.println();

            switch (input) {
                case 1: 
                    System.out.println("Please pay PHP " + price);

                    do {
                        payment += insertPayment();

                        if(payment == -1)
                            testVendingMachine();

                        if(payment < price)
                            System.out.println("\nError: Insufficient Payment. Please pay the remaining price of PHP " + (price-payment));
                            
                    } while (payment < price);

                    getPayment().produceChange(price, (double)payment);
                    dispense = dispenseItem(itemChoice);
                    displayDispensedItem(dispense);
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
            } else {
                super.testVendingMachine();
            }

        } else if (input == 2) {    // Dispense a combo
            price = 0;

            /* add choices */
            System.out.println("[1] Hail Caesar Salad");
            System.out.println("[2] Cobb Salad");
            System.out.println("Input: ");
            
            itemChoice = super.getUserInput(1, 5); // edit max if needed
            
            if(itemChoice == 1) {
                // Hail Caesar Ingredient List
                itemCombo = dispenseItems("Lettuce", "Croutons", "Chicken", "Greek Yogurt", "Olive Oil");
            } // else Insert other salads

            for(i = 0; i < slotList.size(); i++) {
                price += itemCombo.get(i).getPrice();
            }

            super.displayPaymentOptions(price);

            input = super.getUserInput(1, 3);
            System.out.println();

            switch (input) {
                case 1: 
                    System.out.println("Please pay PHP " + price);

                    do {
                        payment += insertPayment();

                        if(payment == -1)
                            testVendingMachine();

                        if(payment < price)
                            System.out.println("\nError: Insufficient Payment. Please pay the remaining price of PHP " + (price-payment));
                            
                    } while (payment < price);

                    getPayment().produceChange(price, (double)payment);
                    dispense = dispenseItem(itemChoice);
                    displayDispensedItem(dispense);
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
    }

    private ArrayList<Item> dispenseItems(String item1, String item2, String item3, String item4, String item5) {
        ArrayList<Item> itemCombo = new ArrayList<>();
        int i;

        for(i = 0; i < slotList.size(); i++) {
            // Dispense each ingredient and add the prices of each item
            if(slotList.get(i).getSpecificItem().getName().compareTo(item1) == 0) {
                itemCombo.add(slotList.get(i).getSpecificItem());
                dispenseItem(i+1);
                System.out.println("Preparing " + item1 + "...");
            }

            if(slotList.get(i).getSpecificItem().getName().compareTo(item2) == 0) {
                itemCombo.add(slotList.get(i).getSpecificItem());
            }

            if(slotList.get(i).getSpecificItem().getName().compareTo(item3) == 0) {
                itemCombo.add(slotList.get(i).getSpecificItem());
            }

            if(slotList.get(i).getSpecificItem().getName().compareTo(item4) == 0) {
                itemCombo.add(slotList.get(i).getSpecificItem());
            }

            if(slotList.get(i).getSpecificItem().getName().compareTo(item5) == 0) {
                itemCombo.add(slotList.get(i).getSpecificItem());
            }
        }

        return itemCombo;
        
    }

}
