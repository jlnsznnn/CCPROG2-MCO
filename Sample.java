/* 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Sample extends JFrame {
    private JTextField textField;
    private List<String> options;
    private JButton chooseButton;
    private JButton saveButton;
    private JComboBox<String> nameComboBox;
    private JComboBox<String> quantityComboBox;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JTextArea caloriesTextArea;
    private JTextArea priceTextArea;
    private int savedItemCount = 0;

    public Sample() {
        super("Combined Input");
        options = new ArrayList<>();

        // Create a JPanel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Label for Item Name
        nameLabel = new JLabel("Item Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(nameLabel, constraints);

        // Create the JTextField
        textField = new JTextField(30);
        textField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, constraints);

        // Create a JComboBox with initial options for Item Name
        String[] initialNameOptions = {"Lettuce", "Tomato", "Cucumber", "Onion", "Roasted Chicken", "Boiled Egg", "Spinach", "Grapes", "Croutons", "Fresh Herbs", "Dressing", "Crushed Penuts"};
        nameComboBox = new JComboBox<>(initialNameOptions);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nameComboBox, constraints);

        // Create a button to remove the selected option from the JComboBox and update the JTextField
        chooseButton = new JButton("Choose");
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) nameComboBox.getSelectedItem();
                if (selectedOption != null) {
                    options.clear();
                    options.add(selectedOption); // Store only the most recent option
                    updateTextField();
                }
            }
        });
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        panel.add(chooseButton, constraints);

        // Label for Item Quantity
        quantityLabel = new JLabel("Item Quantity:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(quantityLabel, constraints);

        // Create a JComboBox with options for Item Quantity
        String[] quantityOptions = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        quantityComboBox = new JComboBox<>(quantityOptions);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(quantityComboBox, constraints);

        // Create a JTextArea for Item Calories
        JLabel caloriesLabel = new JLabel("Item Calories:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(caloriesLabel, constraints);

        caloriesTextArea = new JTextArea(2, 10);
        JScrollPane caloriesScrollPane = new JScrollPane(caloriesTextArea);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(caloriesScrollPane, constraints);

        // Create a JTextArea for Item Price
        JLabel priceLabel = new JLabel("Item Price:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(priceLabel, constraints);

        priceTextArea = new JTextArea(2, 10);
        JScrollPane priceScrollPane = new JScrollPane(priceTextArea);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(priceScrollPane, constraints);

        // Create a "Save" button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String) nameComboBox.getSelectedItem();
                String quantity = (String) quantityComboBox.getSelectedItem();
                String calories = caloriesTextArea.getText().trim();
                String price = priceTextArea.getText().trim();

                if (name.isEmpty() || quantity.isEmpty() || calories.isEmpty() || price.isEmpty()) {
                    JOptionPane.showMessageDialog(Sample.this, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        double caloriesValue = Double.parseDouble(calories);
                        double priceValue = Double.parseDouble(price);

                        if (savedItemCount < 12) {
                            // Remove the chosen options from the nameComboBox and the options list
                            nameComboBox.removeItem(name);
                            options.clear();
                            updateTextField();
                            JOptionPane.showMessageDialog(Sample.this, "Saved successfully!", "Save Success", JOptionPane.INFORMATION_MESSAGE);
                            caloriesTextArea.setText(""); // Clear the text areas after saving
                            priceTextArea.setText(""); // Clear the text areas after saving
                            savedItemCount++;
                        } else {
                            JOptionPane.showMessageDialog(Sample.this, "You have reached the maximum limit of 12 items.", "Limit Reached", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Sample.this, "Please enter valid numeric values for Calories and Price.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(saveButton, constraints);

        // Add the JPanel to the JFrame
        getContentPane().add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sample();
            }
        });
    }
}
*/