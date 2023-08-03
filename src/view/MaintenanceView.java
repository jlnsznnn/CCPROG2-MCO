package src.view;
import javax.swing.*;

import src.controller.MaintenanceController;

import java.awt.*;


/**
 * 	This MaintenanceView displays the maintenance menu of the vending machine
 */
public class MaintenanceView {
    private ImageIcon icon;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel buttonPanel;

    private JFrame restockFrame;
    private JFrame setPriceFrame;
    private JFrame collectMoneyFrame;
    private JFrame replenishMoneyFrame;
    private JFrame startingInventoryFrame;
    private JFrame endingInventoryFrame;
    private JFrame transactionsFrame;

    /**
     * 	Constructs a MaintenanceView object
     */
    public MaintenanceView() {
        // Set up the main frame
        this.icon = new ImageIcon(getClass().getResource("VM ICON.png"));
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
                ImageIcon bgImageIcon = new ImageIcon(getClass().getResource("MAINTENANCE BG.png"));
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

    /**
     * 	Gets the restockFrame
     * 
     *  @return             restockFrame
     */
    public JFrame getRestockFrame() {
        return restockFrame;
    }

    /**
     * 	Gets the setPriceFrame
     * 
     *  @return             setPriceFrame
     */
    public JFrame getSetPriceFrame() {
        return setPriceFrame;
    }

    /**
     * 	Gets the collectMoneyFrame
     * 
     *  @return             collectMoneyFrame
     */
    public JFrame getCollectMoneyFrame() {
        return collectMoneyFrame;
    }

    /**
     * 	Gets the replenishMoneyFrame
     * 
     *  @return             replenishMoneyFrame
     */
    public JFrame getReplenishMoneyFrame() {
        return replenishMoneyFrame;
    }

    /**
     * 	Gets the startingInventoryFrame
     * 
     *  @return             startingInventoryFrame
     */
    public JFrame getStartingInventoryFrame() {
        return startingInventoryFrame;
    }

    /**
     * 	Gets the endingInventoryFrame
     * 
     *  @return             endingInventoryFrame
     */
    public JFrame getEndingInventoryFrame() {
        return endingInventoryFrame;
    }

    /**
     * 	Gets the transactionsFrame
     * 
     *  @return             transactionsFrame
     */
    public JFrame getTransactionsFrame() {
        return transactionsFrame;
    }

}
