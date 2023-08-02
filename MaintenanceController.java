import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceController implements ActionListener {
    //private MainMenuView mainMenuView;
    private MaintenanceView maintenanceView;

    public MaintenanceController(MaintenanceView maintenanceView) {
        //this.mainMenuView = mainMenuView;
        this.maintenanceView = maintenanceView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();

        // Check which button was clicked and show the corresponding frame
        if (buttonName.equals("Restock Item")) {
            maintenanceView.getRestockFrame().setSize(300, 200);
            maintenanceView.getRestockFrame().add(new JLabel("Restock Item Frame"));
            maintenanceView.getRestockFrame().setVisible(true);
        } else if (buttonName.equals("Set Price")) {
            maintenanceView.getSetPriceFrame().setSize(300, 200);
            maintenanceView.getSetPriceFrame().add(new JLabel("Set Price Frame"));
            maintenanceView.getSetPriceFrame().setVisible(true);
        } else if (buttonName.equals("Collect Money")) {
            maintenanceView.getCollectMoneyFrame().setSize(300, 200);
            maintenanceView.getCollectMoneyFrame().add(new JLabel("Collect Money Frame"));
            maintenanceView.getCollectMoneyFrame().setVisible(true);
        } else if (buttonName.equals("Replenish Money")) {
            maintenanceView.getReplenishMoneyFrame().setSize(300, 200);
            maintenanceView.getReplenishMoneyFrame().add(new JLabel("Replenish Money Frame"));
            maintenanceView.getReplenishMoneyFrame().setVisible(true);
        } else if (buttonName.equals("Starting Inventory")) {
            maintenanceView.getStartingInventoryFrame().setSize(300, 200);
            maintenanceView.getStartingInventoryFrame().add(new JLabel("Replenish Money Frame"));
            maintenanceView.getStartingInventoryFrame().setVisible(true);
        } else if (buttonName.equals("Ending Inventory")) {
            maintenanceView.getEndingInventoryFrame().setSize(300, 200);
            maintenanceView.getEndingInventoryFrame().add(new JLabel("Collect Money Frame"));
            maintenanceView.getEndingInventoryFrame().setVisible(true);
        } else if (buttonName.equals("Transactions")) {
            maintenanceView.getTransactionsFrame().setSize(300, 200);
            maintenanceView.getTransactionsFrame().add(new JLabel("Replenish Money Frame"));
            maintenanceView.getTransactionsFrame().setVisible(true);
        } else if (buttonName.equals("Exit")) {
            //new MainMenuController(mainMenuView);
        }
    }

    // ... Your other custom frame creation methods ...
}
