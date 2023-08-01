package SourceCode.View;

import javax.swing.*;

//import SourceCode.Controller.VendingMachineController;
import java.awt.*;
import java.awt.event.ActionListener;

public class VendingMachineView {
    private ImageIcon icon;
    private JFrame frame;
    private JFrame customVM;
    private JPanel mainBG;
    private JButton menuBtn1, menuBtn2, menuBtn3;
    private JLabel titleSpace;
    private GridBagConstraints gbc;
    private JButton chooseButton, saveButton;
    private JComboBox<String>  nameOptions;
    private JTextField textField;
    private JComboBox<String> quantityOptions; 
    private JTextArea caloriesInput, priceInput;
    //private VendingMachineController controller; 

    public VendingMachineView() {
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        this.frame = new JFrame("Greens & Grains");

        // Create a background image label 
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/VM BGM.png"));
        this.mainBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };

        this.frame.setSize(480, 680); // Set the size of the frame
        this.frame.setIconImage(icon.getImage());

        this.titleSpace = new JLabel();
        this.titleSpace.setPreferredSize(new Dimension(0, 105));

        this.gbc = new GridBagConstraints();

        this.menuBtn1 = new JButton("Regular Vending Machine");
        this.menuBtn2 = new JButton("Special Vending Machine");
        this.menuBtn3 = new JButton("Exit");

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

        this.customVM = new JFrame("Customize Your Regular Vending Machine");

        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        initializeGUI();

        //controller = new VendingMachineController(this);
    }

    private void initializeGUI() {
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weighty = 0.0;
        mainBG.add(titleSpace, gbc);

        // Reset gridwidth and weighty for buttons
        gbc.gridwidth = 1;
        gbc.weighty = 0.0;

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        mainBG.add(menuBtn1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainBG.add(menuBtn2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainBG.add(menuBtn3, gbc);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(mainBG);
    }

    // Method to set the menu button listener
    public void setMenuButtonListener(ActionListener menuButtonListener) {
        menuBtn1.addActionListener(menuButtonListener);
        menuBtn2.addActionListener(menuButtonListener);
        menuBtn3.addActionListener(menuButtonListener);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getMenuButton1() {
        return menuBtn1;
    }

    public JButton getMenuButton2() {
        return menuBtn2;
    }

    public JButton getMenuButton3() {
        return menuBtn3;
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

    public JFrame getCustomRVMFrame() {
        return customVM;
    }

    // Regular Vending Machine GUI
    public void CustomRVM() {
        customVM.setSize(480, 680);
    
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

        customVM.setIconImage(icon.getImage());
        customVM.getContentPane().add(regVMBG);
        customVM.setLocationRelativeTo(null);
        customVM.setResizable(false);
        customVM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        customVM.setVisible(true);
    }


    // Regular Vending Machine GUI
    public void regularVM() {
        //JFrame ragular = new JFrame("Regular Vending Machine");
        //regular.setSize(480, 780);
        // INSERT CODE
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VendingMachineView view = new VendingMachineView();
                
                // The controller is used for setting up the view and handling button actions.
                view.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.getFrame().setVisible(true);
            }
        });
    }
}