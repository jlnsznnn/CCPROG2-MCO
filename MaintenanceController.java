import java.awt.event.*;

public class MaintenanceController implements ActionListener {
    private MaintenanceView view;

    public MaintenanceController(MaintenanceView view, String buttonName) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        // Perform specific method based on the clicked button
        switch (buttonName) {
            case "Restock Item":
                System.out.println("Restock Item");
                // Add code to execute "Restock Item" method
                // view.setContentPanel(new JLabel("Restock Item Method"));
                break;
            case "Set Price":
                // Add code to execute "Set Price" method
                // view.setContentPanel(new JLabel("Set Price Method"));
                break;
            case "Collect Money":
                // Add code to execute "Collect Money" method
                // view.setContentPanel(new JLabel("Collect Money Method"));
                break;
            case "Replenish Money":
                // Add code to execute "Replenish Money" method
                // view.setContentPanel(new JLabel("Replenish Money Method"));
                break;
            case "Starting Inventory":
                // Add code to execute "Starting Inventory" method
                // view.setContentPanel(new JLabel("Starting Inventory Method"));
                break;
            case "Ending Inventory":
                // Add code to execute "Ending Inventory" method
                // view.setContentPanel(new JLabel("Ending Inventory Method"));
                break;
            case "Transactions":
                // Add code to execute "Transactions" method
                // view.setContentPanel(new JLabel("Transactions Method"));
                break;
            case "Exit":
                // Handle exit action
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
