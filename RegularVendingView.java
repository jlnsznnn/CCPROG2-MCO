import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

public class RegularVendingView {
    // Custom RVM attributes
    private ImageIcon icon;
    protected JFrame frame;
    private JComboBox<String> nameOptions;
    private JTextField textField;
    private JComboBox<String> quantityOptions;
    private JTextArea caloriesInput, priceInput;
    private JButton chooseButton, saveButton;
    private GridBagConstraints gbc;
    // Regular Vending Machine attributes
    private ArrayList<JButton> buttonList;
    //private JButton button;
    private JButton payButton;
    private JTextArea chosenItemTextArea;
    private JButton dispenseButton;
    private JButton lastClickedSlot;
    private JButton customizeButton;
    private JButton maintenanceButton;
    private String[] buttonLabels; // added
    private int buttonIndex;
    private int lastClickedSlotIndex;
    protected ArrayList<Slot> itemList;

    public RegularVendingView(){
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        this.frame = new JFrame("Customize Your Vending Machine");

        this.frame.setSize(480, 680); // Set the size of the frame
        this.frame.setIconImage(icon.getImage());

        this.gbc = new GridBagConstraints();

        String[] availableItems = {"Lettuce", "Tomato", "Cucumber", "Onion", "Roasted Chicken", 
                                   "Boiled Egg", "Spinach", "Grapes", "Croutons", "Fresh Herbs", 
                                   "Dressing", "Crushed Peanuts"};

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

        this.payButton = new JButton("Pay");
        
        this.chosenItemTextArea = new JTextArea();

        this.buttonList = new ArrayList<>();
        this.customizeButton = new JButton("Customize");
        this.maintenanceButton = new JButton("Maintenance");
        
        this.dispenseButton = new JButton("Dispense");
        this.buttonLabels = new String[]{
            "01", "02", "03", "04", "05", "06",
            "07", "08", "09", "10", "11", "12"
        };
    }

    public JPanel displayBackground() {
        //frame.setSize(480, 680);
    
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/ASK USER RVM.png"));
        JPanel regVMBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };

        return regVMBG;
    }

    // Regular Vending Machine GUI
    public void CustomRVM() {
        frame.setSize(480, 680);
        JPanel regVMBG = displayBackground();

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

        int rows = 4;
        int columns = 3;
        int hGap = 5;
        int vGap = 5;
        int buttonWidth = 50;
        int buttonHeight = 20;
        int largeButtonWidth = 100;
        int largeButtonHeight = 40;

        // TODO Set image pathbased on the array from user input
        
        String[] imageFilenames = {
            "1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png","10.png","11.png","12.png",
        };

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding
        
        // Panel 1: Images at the top (smaller size)
        JPanel imagePanel = new JPanel(new GridLayout(3, columns, hGap, vGap));
        imagePanel.setOpaque(false);
        for (int i = 0; i < imageFilenames.length; i++) {
            String imageFilename = imageFilenames[i];
            Image image = loadImageFromFile(imageFilename); // Load image based on filename
            if (image != null) {
                JLabel imageLabel = new JLabel(new ImageIcon(image));
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                imagePanel.add(imageLabel);
            } else {
                System.err.println("Error loading image: " + imageFilename);
            }
        }
        mainPanel.add(imagePanel, BorderLayout.NORTH);

        // Panel 2: Buttons and ComboBoxes at the bottom
        JPanel buttonsPanel = new JPanel(new BorderLayout());
        buttonsPanel.setOpaque(false);

        // Panel 2 Left: Buttons column
        JPanel buttonsColumnPanel = new JPanel(new GridLayout(rows, columns, hGap, vGap));
        buttonsColumnPanel.setOpaque(false);
        //TODO ButtonController buttonController = new ButtonController(currentChosenItemTextArea); // Pass the currentChosenItemTextArea
        for (int i = 0; i < (rows * columns); i++) {
            int finalButtonIndex = i; // Create a final variable for the button index
            JButton button = new JButton(buttonLabels[i]); // Use the buttonLabels array
            button.setActionCommand(Integer.toString(i)); 
            buttonList.add(button);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        
            // Add ActionListener to each button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //chosenItemTextArea.setText(Integer.toString(finalButtonIndex + 1));
                    chosenItemTextArea.setText(""); // Clears the text area
                    // Perform  custom action based on the clicked button here
                    displayItem(finalButtonIndex);
                    setLastClickedSlotIndex(finalButtonIndex);
                }
            });
            
            // Clear the text area when the button is clicked
            buttonsColumnPanel.add(button);
            buttonList.add(button);
        }        
        buttonsPanel.add(buttonsColumnPanel, BorderLayout.WEST);

        // Panel 2 Right: Text AreachosenItemTextArea
        chosenItemTextArea.setEditable(false);
        mainPanel.add(new JScrollPane(chosenItemTextArea), BorderLayout.CENTER);
        
        // Combo boxes column
        JPanel comboBoxesColumnPanel = new JPanel(new GridBagLayout());
        comboBoxesColumnPanel.setOpaque(false);

        // Create and add "Pay" button
        payButton.setFont(new Font("Arial", Font.PLAIN, 12));
        payButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        comboBoxesColumnPanel.add(payButton, gbc);
       
        // Create and add "Current Chosen Item" label and text box
        JLabel currentChosenItemLabel = new JLabel("Current Chosen Item:");
        currentChosenItemLabel.setForeground(Color.WHITE); 
        currentChosenItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chosenItemTextArea.setLineWrap(true);
        chosenItemTextArea.setWrapStyleWord(true);
        chosenItemTextArea.setPreferredSize(new Dimension(150, 80));

        // Create and add the Dispense button
        dispenseButton.setFont(new Font("Arial", Font.PLAIN, 12));
        dispenseButton.setPreferredSize(new Dimension(100, 30));
        dispenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle dispense button click event here
                System.out.println("Dispense button clicked!");
                String selectedItem = chosenItemTextArea.getText();
                // You can implement the dispensing logic here based on the selected item
                System.out.println("Dispensing: " + selectedItem);
            }
        });

        // Add components to the panel with GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3; // Span three columns for the text box and label
        gbc.insets = new Insets(0, 0, 5, 0);
        comboBoxesColumnPanel.add(currentChosenItemLabel, gbc);

        gbc.gridy = 3;
        gbc.weighty = 1.0; // Allow the text area to expand vertically
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 5, 0);
        comboBoxesColumnPanel.add(new JScrollPane(chosenItemTextArea), gbc);

        gbc.gridy = 4;
        gbc.weighty = 0.0; // Reset weighty to 0 for the button
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 0, 0);
        comboBoxesColumnPanel.add(dispenseButton, gbc);

        buttonsPanel.add(comboBoxesColumnPanel, BorderLayout.CENTER);

        // Create and add maintenance button (larger size)
        maintenanceButton.setFont(new Font("Arial", Font.PLAIN, 12));
        maintenanceButton.setPreferredSize(new Dimension(largeButtonWidth, largeButtonHeight));
        maintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle maintenance button click event here
                System.out.println("Maintenance button clicked!");
            }
        });
        buttonsPanel.add(maintenanceButton, BorderLayout.SOUTH);

        // Create and add customize button (larger size)
        customizeButton.setFont(new Font("Arial", Font.PLAIN, 12));
        customizeButton.setPreferredSize(new Dimension(largeButtonWidth, largeButtonHeight));
        customizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle customize button click event here
                System.out.println("Customize button clicked!");
            }
        });
        buttonsPanel.add(customizeButton, BorderLayout.NORTH);

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.setOpaque(false);

        regVMBG.add(mainPanel, gbc);
        regVMBG.setOpaque(false);

        // Add the background panel to the frame
        frame.setContentPane(regVMBG);

        frame.getContentPane().add(mainPanel);

        // Show the frame after all components are added
        frame.setVisible(true);
    }

    private void displayItem(int index) {
        chosenItemTextArea.append("Item: " + getItems().get(index).getSpecificItem().getName() + "\n"); 
        chosenItemTextArea.append("Price: " + getItems().get(index).getSpecificItem().getPrice() + "\n"); 
        chosenItemTextArea.append("Calories: " + getItems().get(index).getSpecificItem().getCalories() + "\n"); 
        chosenItemTextArea.append("Quantity: " + getItems().get(index).getItemList().size() + "\n"); 
    }

        private static Image loadImageFromFile(String filename) {
            try {
                ClassLoader classLoader = RegularVendingView.class.getClassLoader();
                // Replace "images/" with the directory where your images are located relative to the classpath
                String imagePath = "images/" + filename;
                return ImageIO.read(classLoader.getResource(imagePath));
            } catch (IOException | NullPointerException ex) {
                System.err.println("Error loading image: " + filename);
            }
            return null;
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

    public JButton getDispenseButton(){
        return dispenseButton;
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    public JTextArea getTextArea() {
        return chosenItemTextArea;
    }

    public JButton getLastClickedSlot() {
        return this.lastClickedSlot;
    }

    public void setLastClickedSlot(JButton slot) {
        this.lastClickedSlot = slot;
    }

    public JTextArea getChosenItemTextArea() {
        return chosenItemTextArea;
    }

    public JButton getCustomizeButton() {
        return customizeButton;
    }

    public JButton getMaintenanceButton() {
        return maintenanceButton;
    }

    public int getButtonIndex() {
        return buttonIndex;
    }

    public String[] getButtonLabels() {
        return buttonLabels;
    }

    public int getLastClickedSlotIndex() {
        return this.lastClickedSlotIndex;
    }

    public ArrayList<Slot> getItems() {
        return this.itemList;
    }

    public JButton getPayButton(){
        return this.payButton;
    }

    public void setLastClickedSlotIndex(int index) {
        this.lastClickedSlotIndex = index;
    }

    public void setItems(ArrayList<Slot> items) {
        this.itemList = items;
    }

    public static void main(String[] args) {
        // Create a RegularVendingView instance
        RegularVendingView regularVendingView = new RegularVendingView();   
        // Create a RegularVendingController instance and pass the RegularVendingView to it
        RegularVendingController regularVendingController = new RegularVendingController(new VendingMachine(), regularVendingView);
        ArrayList<Slot> savedItems = regularVendingController.getSlotList();
        regularVendingView.setItems(savedItems);
        // Show the RegularVendingView frame
        regularVendingView.CustomRVM();
        regularVendingView.displayVendingMachine();
    }

}





