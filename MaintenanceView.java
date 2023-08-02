import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceView {
    private ImageIcon icon;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel contentPanel;

    public MaintenanceView() {
        // Set up the main frame
        icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        frame = new JFrame("Perform Vending Machine Maintenance");
        frame.setSize(480, 680); // Set the size of the frame
        frame.setIconImage(icon.getImage());

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
            button.addActionListener(new MaintenanceController(this, name));
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
        frame.add(mainPanel);

        // Show the GUI
        frame.setVisible(true);
    }

    public void setContentPanel(Component component) {
        contentPanel.removeAll();
        contentPanel.add(component, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MaintenanceView::new);
    }
}
