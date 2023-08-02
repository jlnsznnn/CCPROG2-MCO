import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceView {
    private ImageIcon icon;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel buttonPanel;

    private JButton restockBtn;
    private JButton setPriceBtn;
    private JButton collectMoneyBtn;
    private JButton replenishMoneyBtn;
    private JButton startingInventoryBtn;
    private JButton endingInventoryBtn;
    private JButton transactionsBtn;
    private JFrame exitBtn;

    private JFrame restockFrame;
    private JFrame setPriceFrame;
    private JFrame collectMoneyFrame;
    private JFrame replenishMoneyFrame;
    private JFrame startingInventoryFrame;
    private JFrame endingInventoryFrame;
    private JFrame transactionsFrame;

    public MaintenanceView() {
        // Set up the main frame
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        frame = new JFrame("Perform Vending Machine Maintenance");
        frame.setSize(480, 680); // Set the size of the frame
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Create the main panel and set layout
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon bgImageIcon = new ImageIcon(getClass().getResource("/Images/MAINTENANCE BG.png"));
                Image bgImage = bgImageIcon.getImage();
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new BorderLayout());

        // Create the button panel on the left
        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the button panel transparent
        buttonPanel.setLayout(new GridLayout(8, 1, 10, 10));

        // Add buttons to the button panel
        String[] buttonNames = {
                "Restock Item", "Set Price", "Collect Money", "Replenish Money",
                "Starting Inventory", "Ending Inventory", "Transactions", "Exit"
        };
        for (String name : buttonNames) {
            JButton button = new JButton(name);
            button.addActionListener(new MaintenanceController(this));
            buttonPanel.add(button);
        }

        // Create separate frames for each option
        restockFrame = new JFrame("Restock Item");
        setPriceFrame = new JFrame("Set Price");
        collectMoneyFrame = new JFrame("Collect Money");
        replenishMoneyFrame = new JFrame("Replenish Money");
        startingInventoryFrame = new JFrame("Staring Inventory");
        endingInventoryFrame = new JFrame("Ending Inventory");
        transactionsFrame = new JFrame("Transactions");

        // Add button panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.WEST);

        // Add main panel to the frame
        frame.add(mainPanel);

        // Show the GUI
        frame.setVisible(true);
    }

    public JFrame getRestockFrame() {
        return restockFrame;
    }

    public JFrame getSetPriceFrame() {
        return setPriceFrame;
    }

    public JFrame getCollectMoneyFrame() {
        return collectMoneyFrame;
    }

    public JFrame getReplenishMoneyFrame() {
        return replenishMoneyFrame;
    }

    public JFrame getStartingInventoryFrame() {
        return startingInventoryFrame;
    }

    
    public JFrame getEndingInventoryFrame() {
        return endingInventoryFrame;
    }

    public JFrame getTransactionsFrame() {
        return transactionsFrame;
    }

    // ... Other getter methods for remaining frames ...

    public static void main(String[] args) {
        // Create a new instance of MaintenanceView to display the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MaintenanceView maintenanceView = new MaintenanceView();
            }
        });
    }
}
