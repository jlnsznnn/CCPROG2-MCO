import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceView {
    private JFrame frame;
    private ImageIcon icon;
    private JTextField textField;

    public MaintenanceView() {
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        this.frame = new JFrame("Customize Your Regular Vending Machine");

        this.frame.setSize(480, 680); // Set the size of the frame
        this.frame.setIconImage(icon.getImage());

        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void createGUI() {
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/MAINTENANCE BG.png"));
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        frame.getContentPane().add(mainPanel);

        // Left part: buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Create buttons with specified text and add ActionListener to each button
        String[] buttonTexts = {
                "Restock Item", "Set Price", "Collect Money", "Replenish Money",
                "Starting Inventory", "Ending Inventory", "Transactions", "Exit"
        };

        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            buttonPanel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Call the specific method for each button
                    if (text.equals("Restock Item")) {
                        restockItem();
                    } else if (text.equals("Set Price")) {
                        setPrice();
                    } else if (text.equals("Collect Money")) {
                        collectMoney();
                    } else if (text.equals("Replenish Money")) {
                        replenishMoney();
                    } else if (text.equals("Starting Inventory")) {
                        startingInventory();
                    } else if (text.equals("Ending Inventory")) {
                        endingInventory();
                    } else if (text.equals("Transactions")) {
                        transactions();
                    } else if (text.equals("Exit")) {
                        exit();
                    }
                }
            });

            // Set button background as transparent
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
        }

        // Right part: additional panel
        JPanel rightPanel = new JPanel();
        mainPanel.add(rightPanel, BorderLayout.LINE_END);

        // Customize right panel as needed
        // Add components, set layout, etc.

        // Uneditable text field at the bottom
        textField = new JTextField("Displaying text only", 20);
        textField.setEditable(false);
        mainPanel.add(textField, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    // Define the methods for each button functionality
    public void restockItem() {
        textField.setText("Restocking Item...");
    }

    public void setPrice() {
        textField.setText("Setting Price...");
    }

    public void collectMoney() {
        textField.setText("Collecting Money...");
    }

    public void replenishMoney() {
        textField.setText("Replenishing Money...");
    }

    public void startingInventory() {
        textField.setText("Starting Inventory...");
    }

    public void endingInventory() {
        textField.setText("Ending Inventory...");
    }

    public void transactions() {
        textField.setText("Viewing Transactions...");
    }

    public void exit() {
        textField.setText("Exiting...");
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MaintenanceView example = new MaintenanceView();
            example.createGUI();
        });
    }
}
