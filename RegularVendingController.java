import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class RegularVendingController {
    private ArrayList<String> savedItems = new ArrayList<>();
    private int savedItemCount = 0; // Initialize to 0
    private boolean isChooseButtonClicked = false; 
    protected VendingMachine regularVendingModel; // add
    protected RegularVendingView regularVendingView; // add
    private int index;

    public RegularVendingController(VendingMachine regularVendingModel, RegularVendingView regularVendingView) {
        this.regularVendingModel = regularVendingModel;
        this.regularVendingView = regularVendingView;
        this.index = 0;

        chooseButtonAction();
        dispenseItemAction();
        customizeAction();
    }

    // Choose item
    public void chooseButtonAction() {
        JButton chooseButton = this.regularVendingView.getChooseButton();

        // Add ActionListener to chooseButton
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) regularVendingView.getNameOptions().getSelectedItem();
                if (selectedOption != null) {
                    regularVendingView.getTextField().setText(selectedOption); // Display the selected item name in the textField
                    isChooseButtonClicked = true;
                }
            }
        });

        // Get the saveButton instance from the regularVendingView
        JButton saveButton = regularVendingView.getSaveButton();

        // Add ActionListener to saveButton
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String) regularVendingView.getNameOptions().getSelectedItem();
                String quantity = (String) regularVendingView.getQuantityOptions().getSelectedItem();
                String calories = regularVendingView.getCaloriesInput().getText().trim();
                String price = regularVendingView.getPriceInput().getText().trim();

                if (name.isEmpty() || quantity.isEmpty() || calories.isEmpty() || price.isEmpty()) {
                    JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int quantityValue = Integer.parseInt(quantity);
                        double caloriesValue = Double.parseDouble(calories);
                        double priceValue = Double.parseDouble(price);

                        if (!isChooseButtonClicked) {
                            JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Please click 'Choose' to select an item before saving.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (savedItemCount < 12) {
                            // Add the selected item to the list of saved items
                            savedItems.add(name);

                            // add 
                            regularVendingModel.addSlot(new Slot((index+1), new Item(name, caloriesValue, priceValue, quantityValue)));
                            index++; // increment index for next slot

                            // for debugging
                            System.out.println("Slot number # " + index);
                            System.out.println("Item name: " + name);
                            System.out.println("Calories: " + calories);

                            // Reset the flag for "Choose" button click
                            isChooseButtonClicked = false;

                            // Remove the chosen option from the nameComboBox
                            regularVendingView.getNameOptions().removeItemAt(regularVendingView.getNameOptions().getSelectedIndex());

                            // Set text in textField based on the most recent option after removal
                            if (regularVendingView.getNameOptions().getItemCount() > 0) {
                                regularVendingView.getTextField().setText((String) regularVendingView.getNameOptions().getItemAt(0));
                            } else {
                                regularVendingView.getTextField().setText("");
                            }

                            JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Saved successfully!", "Save Success", JOptionPane.INFORMATION_MESSAGE);
                            regularVendingView.getCaloriesInput().setText(""); // Clear the text areas after saving
                            regularVendingView.getPriceInput().setText(""); // Clear the text areas after saving
                            regularVendingView.getTextField().setText("");
                            savedItemCount++; // Increment savedItemCount when an item is successfully saved

                            if (savedItemCount == 12){ // TODO 
                            regularVendingView.getFrame().setVisible(false);
                            regularVendingView.displayVendingMachine();
                        }
                    }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Please enter valid numeric values for Calories and Price.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }); 
    }

    public void payAction() {
        JButton payButton = this.regularVendingView.getPayButton();
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPaymentOptionsFrame();
            }
        });
    }
    
    private void showPaymentOptionsFrame() {
        // Create a new frame for the payment options
        JFrame paymentFrame = new JFrame("Payment Options");
        paymentFrame.setSize(300, 200);
        paymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        paymentFrame.setLocationRelativeTo(null);
    
        // Create the choice buttons for coins and bills
        JButton coinsButton = new JButton("Coins");
        JButton billsButton = new JButton("Bills");
    
        // Add ActionListener to the coinsButton
        coinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCoinsSpinner(paymentFrame); // Pass the paymentFrame to dispose it later
            }
        });
    
        // Add ActionListener to the billsButton
        billsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBillsSpinner(paymentFrame); // Pass the paymentFrame to dispose it later
            }
        });
    
        // Add the buttons to a panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.add(coinsButton);
        buttonPanel.add(billsButton);
    
        // Add the panel to the frame
        paymentFrame.add(buttonPanel, BorderLayout.CENTER);
    
        // Show the frame
        paymentFrame.setVisible(true);
    }
    
    private void displayCoinsSpinner(JFrame paymentFrame) {
        // Close the paymentFrame before displaying the coins spinner
        paymentFrame.dispose();
    
        // Create a new frame for the coins spinner
        JFrame coinsFrame = new JFrame("Coins Payment");
        coinsFrame.setSize(200, 150);
        coinsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        coinsFrame.setLocationRelativeTo(null);
    
        // Create the spinner for coins
        SpinnerModel coinsSpinnerModel = new SpinnerNumberModel(1, 1, 1000, 1); // Start, Minimum, Maximum, Step
        JSpinner coinsSpinner = new JSpinner(coinsSpinnerModel);
        coinsSpinner.setPreferredSize(new Dimension(100, 30));
    
        // Add the spinner to the frame
        coinsFrame.add(coinsSpinner, BorderLayout.CENTER);
    
        // Show the frame
        coinsFrame.setVisible(true);
    }
    
    private void displayBillsSpinner(JFrame paymentFrame) {
        // Close the paymentFrame before displaying the bills spinner
        paymentFrame.dispose();
    
        // Create a new frame for the bills spinner
        JFrame billsFrame = new JFrame("Bills Payment");
        billsFrame.setSize(200, 150);
        billsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        billsFrame.setLocationRelativeTo(null);
    
        // Create the spinner for bills
        SpinnerModel billsSpinnerModel = new SpinnerNumberModel(1, 1, 1000, 1); // Start, Minimum, Maximum, Step
        JSpinner billsSpinner = new JSpinner(billsSpinnerModel);
        billsSpinner.setPreferredSize(new Dimension(100, 30));
    
        // Add the spinner to the frame
        billsFrame.add(billsSpinner, BorderLayout.CENTER);
    
        // Show the frame
        billsFrame.setVisible(true);
    }
    

    public void dispenseItemAction() {
    JButton dispenseButton = this.regularVendingView.getDispenseButton();
    int slotNumber = this.regularVendingView.getLastClickedSlotIndex();
    // Add actionListener to dispenseButton
    dispenseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Add code to check denominations, get qty of coins and bills
            // before dispensing make sure there is enough change
            // + make sure the amount supplied by the user is enough
            // display item dispensed (image)
            // Optionally, you can display a thank you message after the user closes the image dialog.
            JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Thank you for purchasing!", "Thank You", JOptionPane.INFORMATION_MESSAGE);
        }
    });
}

    public void customizeAction(){
        JButton customButton = this.regularVendingView.getCustomizeButton();
        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(regularVendingView.getFrame(),"Customization feature is not available for Regular Vending Machines","Notice",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    
    // Getter for savedItemCount (if needed)
    public int getSavedItemCount() {
        return savedItemCount;
    }
    
    public ArrayList<String> getSavedItems() {
        return savedItems;
    }

    public ArrayList<Slot> getSlotList() {
        return this.regularVendingModel.getSlotList();
    }
}
    