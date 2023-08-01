package SourceCode.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import SourceCode.View.RegularVendingView;

public class RegularVendingController {
    private ArrayList<String> savedItems = new ArrayList<>();
    private int savedItemCount = 0; // Initialize to 0
    private boolean isChooseButtonClicked = false; 

    public RegularVendingController(RegularVendingView regularVendingView) {

        JButton chooseButton = regularVendingView.getChooseButton();

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
        
        // Assuming the initialization of regularVendingView, savedItemCount, and a List<String> to store saved items
        // For example: List<String> savedItems = new ArrayList<>();

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
                        //double caloriesValue = Double.parseDouble(calories);
                        //double priceValue = Double.parseDouble(price);

                        if (!isChooseButtonClicked) {
                            JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Please click 'Choose' to select an item before saving.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (savedItemCount < 12) {
                            // Add the selected item to the list of saved items
                            savedItems.add(name);

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
                        //} else {
                            //vendingMachineView.RegularVM();
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Please enter valid numeric values for Calories and Price.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
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
    
}
    