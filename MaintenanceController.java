import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 	This MaintenanceController implements the ActionListener interface
 */
public class MaintenanceController implements ActionListener {
    private MaintenanceView maintenanceView;
    private VendingMachine vendingMachineModel;
    private MainMenuView mainMenuView;

    /**
     * 	Constructs a MaintenanceController object
     */
    public MaintenanceController(MaintenanceView maintenanceView, VendingMachine vendingMachineModel, MainMenuView mainMenuView) {
        this.maintenanceView = maintenanceView;
        this.vendingMachineModel = vendingMachineModel;
        this.mainMenuView = mainMenuView;
    }

    /**
     * Performs actions based on the chosen button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();

        // Check which button was clicked and show the corresponding frame
        if (buttonName.equals("Restock Item")) {
            maintenanceView.getRestockFrame();
            String selectedItem = maintenanceView.getSlotComboBox().getSelectedItem().toString();

            if(searchItem(selectedItem) != null) { // search item
                Slot slot = searchItem(selectedItem);
                Maintenance itemMaintenance = new Maintenance(slot);
                int quantity = (int)maintenanceView.getQuantitySpinner().getValue();

                itemMaintenance.restockItem(quantity); // restock item

                JOptionPane.showMessageDialog(maintenanceView.getFrame(), quantity + " stocks of " + selectedItem +" are added succesfully.", "Restock Item",
                JOptionPane.INFORMATION_MESSAGE); 
            } 

        } else if (buttonName.equals("Set Price")) {
            maintenanceView.getSetPriceFrame();
        } else if (buttonName.equals("Collect Money")) {
            maintenanceView.getCollectMoneyFrame();
        } else if (buttonName.equals("Replenish Money")) {
            maintenanceView.getReplenishMoneyFrame();
        } else if (buttonName.equals("Starting Inventory")) {
            maintenanceView.getStartingInventoryFrame();
        } else if (buttonName.equals("Ending Inventory")) {
            maintenanceView.getEndingInventoryFrame();
        } else if (buttonName.equals("Transactions")) {
            maintenanceView.getTransactionsFrame();
        } else if (buttonName.equals("Exit")) {
            maintenanceView.getFrame().setVisible(false); // Hide the maintenance frame
            mainMenuView.getFrame().setVisible(true);
        }
    }

    public Slot searchItem(String nameToFind) {
        int i;
        boolean isFound = false;
        Slot slot = null;

        for(i = 0; i < vendingMachineModel.getSlotList().size() && !isFound; i++) {
            String itemName = vendingMachineModel.getSlotList().get(i).getSpecificItem().getName();
            if(itemName.compareTo(nameToFind) == 0) {
                isFound = true;
                slot = vendingMachineModel.getSlotList().get(i); // get slot where the item is stored
            }
        }

        return slot;
    }

}
