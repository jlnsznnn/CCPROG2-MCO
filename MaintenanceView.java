import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceView extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel contentPanel;

    public MaintenanceView() {
        // Set up the main frame
        setTitle("Maintenance");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 680);
        setLocationRelativeTo(null);

        // Create the main panel and set layout
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon bgImageIcon = new ImageIcon("Images/MAINTENANCE BG.png");
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
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Create the content panel on the right
        contentPanel = new JPanel();
        contentPanel.setOpaque(false); // Make the content panel transparent
        contentPanel.setLayout(new BorderLayout());

        // Add button panel and content panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add main panel to the frame
        add(mainPanel);

        // Show the GUI
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        // Perform specific method based on the clicked button
        switch (buttonName) {
            case "Restock Item":
                // Add code to execute "Restock Item" method
                // contentPanel.add(new JLabel("Restock Item Method"));
                break;
            case "Set Price":
                // Add code to execute "Set Price" method
                // contentPanel.add(new JLabel("Set Price Method"));
                break;
            case "Collect Money":
                // Add code to execute "Collect Money" method
                // contentPanel.add(new JLabel("Collect Money Method"));
                break;
            case "Replenish Money":
                // Add code to execute "Replenish Money" method
                // contentPanel.add(new JLabel("Replenish Money Method"));
                break;
            case "Starting Inventory":
                // Add code to execute "Starting Inventory" method
                // contentPanel.add(new JLabel("Starting Inventory Method"));
                break;
            case "Ending Inventory":
                // Add code to execute "Ending Inventory" method
                // contentPanel.add(new JLabel("Ending Inventory Method"));
                break;
            case "Transactions":
                // Add code to execute "Transactions" method
                // contentPanel.add(new JLabel("Transactions Method"));
                break;
            case "Exit":
                // Handle exit action
                System.exit(0);
                break;
            default:
                break;
        }

        // Refresh the content panel to show the changes
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MaintenanceView::new);
    }
}