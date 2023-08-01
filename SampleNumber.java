import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SampleNumber {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Small Number Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 680); // Set the frame size to 480x680 pixels

        int rows = 4;
        int columns = 3;
        int hGap = 5;
        int vGap = 5;
        int buttonWidth = 50;
        int buttonHeight = 20;
        int largeButtonWidth = 100;
        int largeButtonHeight = 40;

        // Predefined string array containing image filenames
        String[] imageFilenames = {
            "1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png","10.png","11.png","12.png",
        };

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Panel 1: Images at the top (smaller size)
        JPanel imagePanel = new JPanel(new GridLayout(3, columns, hGap, vGap));
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

        // Panel 2 Left: Buttons column
        JPanel buttonsColumnPanel = new JPanel(new GridLayout(rows, columns, hGap, vGap));
        for (int i = 1; i <= (rows * columns); i++) {
            JButton button = new JButton(String.format("%02d", i)); // Format the number as two digits
            button.setFont(new Font("Arial", Font.PLAIN, 12)); // Adjust the font size
            button.setPreferredSize(new Dimension(buttonWidth, buttonHeight)); // Set the size of the button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle button click events here if needed
                    System.out.println("Button clicked!");
                }
            });
            buttonsColumnPanel.add(button);
        }
        buttonsPanel.add(buttonsColumnPanel, BorderLayout.WEST);

// Panel 2 Right: Combo boxes column
JPanel comboBoxesColumnPanel = new JPanel(new GridBagLayout());

// Create and add coins ComboBox
JLabel coinsLabel = new JLabel("Insert Coins:");
JComboBox<Integer> coinsComboBox = createComboBox(new Integer[]{1, 5, 10});
coinsComboBox.setPreferredSize(new Dimension(50, 20)); // Make the combo box narrower
JTextArea coinsQuantityTextArea = new JTextArea("Quantity", 1, 1);
coinsQuantityTextArea.setPreferredSize(new Dimension(60, 20));

// Create and add bills ComboBox
JLabel billsLabel = new JLabel("Insert Bills:");
JComboBox<Integer> billsComboBox = createComboBox(new Integer[]{20, 50, 100, 200, 500, 1000});
billsComboBox.setPreferredSize(new Dimension(50, 20)); // Make the combo box narrower
JTextArea billsQuantityTextArea = new JTextArea("Quantity", 1, 1);
billsQuantityTextArea.setPreferredSize(new Dimension(60, 20));

// Add components to the panel with GridBagLayout
GridBagConstraints gbc = new GridBagConstraints();
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.gridx = 0;
gbc.gridy = 0;
gbc.insets = new Insets(0, 0, 5, 5); // Add some spacing between components
comboBoxesColumnPanel.add(coinsLabel, gbc);

gbc.gridx = 1;
gbc.insets = new Insets(0, 0, 5, 0);
comboBoxesColumnPanel.add(coinsComboBox, gbc);

gbc.gridx = 2;
gbc.insets = new Insets(0, 0, 5, 5);
comboBoxesColumnPanel.add(coinsQuantityTextArea, gbc);

gbc.gridx = 0;
gbc.gridy = 1;
gbc.insets = new Insets(0, 0, 5, 5);
comboBoxesColumnPanel.add(billsLabel, gbc);

gbc.gridx = 1;
gbc.insets = new Insets(0, 0, 5, 0);
comboBoxesColumnPanel.add(billsComboBox, gbc);

gbc.gridx = 2;
gbc.insets = new Insets(0, 0, 5, 5);
comboBoxesColumnPanel.add(billsQuantityTextArea, gbc);

// Create and add "Current Chosen Item" label and text box
JLabel currentChosenItemLabel = new JLabel("Current Chosen Item:");
JTextArea currentChosenItemTextArea = new JTextArea();
currentChosenItemTextArea.setLineWrap(true);
currentChosenItemTextArea.setWrapStyleWord(true);
currentChosenItemTextArea.setPreferredSize(new Dimension(150, 80));

// Create and add the Dispense button
JButton dispenseButton = new JButton("Dispense");
dispenseButton.setFont(new Font("Arial", Font.PLAIN, 12));
dispenseButton.setPreferredSize(new Dimension(100, 30));
dispenseButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle dispense button click event here
        System.out.println("Dispense button clicked!");
        String selectedItem = currentChosenItemTextArea.getText();
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
comboBoxesColumnPanel.add(new JScrollPane(currentChosenItemTextArea), gbc);

gbc.gridy = 4;
gbc.weighty = 0.0; // Reset weighty to 0 for the button
gbc.fill = GridBagConstraints.NONE;
gbc.anchor = GridBagConstraints.CENTER;
gbc.insets = new Insets(5, 0, 0, 0);
comboBoxesColumnPanel.add(dispenseButton, gbc);

buttonsPanel.add(comboBoxesColumnPanel, BorderLayout.CENTER);

        // Create and add maintenance button (larger size)
        JButton maintenanceButton = new JButton("Maintenance");
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
        JButton customizeButton = new JButton("Customize");
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

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private static JComboBox<Integer> createComboBox(Integer[] options) {
        JComboBox<Integer> comboBox = new JComboBox<>(options);
        comboBox.setPreferredSize(new Dimension(60, 20));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedValue = (int) comboBox.getSelectedItem();
                System.out.println("Selected value: " + selectedValue);
            }
        });
        return comboBox;
    }

    private static Image loadImageFromFile(String filename) {
        try {
            ClassLoader classLoader = SampleNumber.class.getClassLoader();
            // Replace "images/" with the directory where your images are located relative to the classpath
            String imagePath = "images/" + filename;
            return ImageIO.read(classLoader.getResource(imagePath));
        } catch (IOException | NullPointerException ex) {
            System.err.println("Error loading image: " + filename);
        }
        return null;
    }
}
