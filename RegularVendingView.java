

import javax.swing.*;
import java.awt.*;

public class RegularVendingView {
    private ImageIcon icon;
    private JFrame frame;
    private JComboBox<String> nameOptions;
    private JTextField textField;
    private JComboBox<String> quantityOptions;
    private JTextArea caloriesInput, priceInput;
    private JButton chooseButton, saveButton;
    private GridBagConstraints gbc;

    public RegularVendingView(){
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        this.frame = new JFrame("Customize Your Regular Vending Machine");

        this.frame.setSize(480, 680); // Set the size of the frame
        this.frame.setIconImage(icon.getImage());

        this.gbc = new GridBagConstraints();

        String[] availableItems = {"Lettuce", "Tomato", "Cucumber", "Onion", "Roasted Chicken", 
                                   "Boiled Egg", "Spinach", "Grapes", "Croutons", "Fresh Herbs", 
                                   "Dressing", "Crushed Penuts", "Olive Oil", "Olives", "Tuna"};

        this.chooseButton = new JButton("Choose");
        this.nameOptions = new JComboBox<>(availableItems);
        this.textField = new JTextField(30);

        this.saveButton = new JButton("Save");

        String[] itemQuantity = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        this.quantityOptions = new JComboBox<>(itemQuantity);

        this.caloriesInput = new JTextArea(2, 10);
        this.priceInput = new JTextArea(2, 10);

        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
    }

    // Regular Vending Machine GUI
    public void CustomRVM() {
        frame.setSize(480, 680);
    
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/ASK USER RVM.png"));
        JPanel regVMBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };
    
        JPanel panel = new JPanel(new GridBagLayout());

        // ITEM NAME
        JLabel nameLabel = new JLabel("Item Name: ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        nameLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 17, 5, 17);
        panel.add(nameLabel, gbc);

        textField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nameOptions, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(chooseButton, gbc);

        // ITEM QUANTITY
        JLabel quantityLabel = new JLabel("Item Quantity: ");
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 12));
        quantityLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(quantityLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(quantityOptions, gbc);

        // ITEM CALORIES
        JLabel caloriesLabel = new JLabel("Item Calories: ");
        caloriesLabel.setFont(new Font("Arial", Font.BOLD, 12));
        caloriesLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(caloriesLabel, gbc);

        JScrollPane caloriesScrollPane = new JScrollPane(caloriesInput);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(caloriesScrollPane, gbc);

        // ITEM PRICE
        JLabel priceLabel = new JLabel("Item Price: ");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 12));
        priceLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(priceLabel, gbc);

        JScrollPane priceScrollPane = new JScrollPane(priceInput);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(priceScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(this.saveButton, gbc);

        panel.setOpaque(false); // Make the panel transparent

        regVMBG.add(panel);

        frame.setIconImage(icon.getImage());
        frame.getContentPane().add(regVMBG);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public JButton getChooseButton() {
        return chooseButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JComboBox<String> getNameOptions() {
        return nameOptions;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JComboBox<String> getQuantityOptions() {
        return quantityOptions;
    }
    
    public JTextArea getCaloriesInput() {
        return caloriesInput;
    }

    public JTextArea getPriceInput() {
        return priceInput;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void displayVendingMachine() {
        // Initialize frame 
        this.frame = new JFrame("Greens & Grains");
        frame.setSize(480, 680);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    
        // Create the background panel with the image
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/TEMPLATE.png"));
        JPanel regVMBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        // add other components
        
    
        // Add the background panel to the frame
        frame.setContentPane(regVMBG);
    
        // Show the frame after all components are added
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create a RegularVendingView instance
        RegularVendingView regularVendingView = new RegularVendingView();   
        // Create a RegularVendingController instance and pass the RegularVendingView to it
        new RegularVendingController(regularVendingView);
        // Show the RegularVendingView frame
        regularVendingView.CustomRVM();
        regularVendingView.displayVendingMachine();
    }
}



