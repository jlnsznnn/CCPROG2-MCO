package SourceCode.Controller;
import SourceCode.View.VendingMachineView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class VendingMachineController {
    private ArrayList<String> savedItems = new ArrayList<>();
    private int savedItemCount = 0; // Initialize to 0
    private boolean isChooseButtonClicked = false; 
    private VendingMachineView vendingMachineView;

    public VendingMachineController(VendingMachineView vendingMachineView ) {
        this.vendingMachineView = vendingMachineView;

        this.vendingMachineView.setMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int choice;
                if(e.getSource() == vendingMachineView.getMenuButton1()){
                    JOptionPane.showMessageDialog(vendingMachineView.getFrame(), "Regular Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // INSERT CODE
                    vendingMachineView.CustomRVM();
                    vendingMachineView.getFrame().setVisible(false);
                } else if (e.getSource() == vendingMachineView.getMenuButton2()) {
                    JOptionPane.showMessageDialog(vendingMachineView.getFrame(), "Special Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // INSERT CODE
                } else if (e.getSource() == vendingMachineView.getMenuButton3()) {
                    choice = JOptionPane.showConfirmDialog(vendingMachineView.getFrame(), "Are you sure you want to exit?", "Terminate Program", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION){
                        vendingMachineView.getFrame().dispose();
                    }
                }
            }
        });

        JButton chooseButton = vendingMachineView.getChooseButton();

        // Add ActionListener to chooseButton
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) vendingMachineView.getNameOptions().getSelectedItem();
                if (selectedOption != null) {
                    vendingMachineView.getTextField().setText(selectedOption); // Display the selected item name in the textField
                    isChooseButtonClicked = true;
                }
            }
        });
        
        // Assuming the initialization of vendingMachineView, savedItemCount, and a List<String> to store saved items
        // For example: List<String> savedItems = new ArrayList<>();

        // Get the saveButton instance from the VendingMachineView
        JButton saveButton = vendingMachineView.getSaveButton();

        // Add ActionListener to saveButton
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String) vendingMachineView.getNameOptions().getSelectedItem();
                String quantity = (String) vendingMachineView.getQuantityOptions().getSelectedItem();
                String calories = vendingMachineView.getCaloriesInput().getText().trim();
                String price = vendingMachineView.getPriceInput().getText().trim();

                if (name.isEmpty() || quantity.isEmpty() || calories.isEmpty() || price.isEmpty()) {
                    JOptionPane.showMessageDialog(vendingMachineView.getCustomRVMFrame(), "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        //double caloriesValue = Double.parseDouble(calories);
                        
                        if (!isChooseButtonClicked) {
                            JOptionPane.showMessageDialog(vendingMachineView.getCustomRVMFrame(), "Please click 'Choose' to select an item before saving.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (savedItemCount < 12) {
                            // Add the selected item to the list of saved items
                            savedItems.add(name);

                            // Reset the flag for "Choose" button click
                            isChooseButtonClicked = false;

                            // Remove the chosen option from the nameComboBox
                            vendingMachineView.getNameOptions().removeItemAt(vendingMachineView.getNameOptions().getSelectedIndex());

                            // Set text in textField based on the most recent option after removal
                            if (vendingMachineView.getNameOptions().getItemCount() > 0) {
                                vendingMachineView.getTextField().setText((String) vendingMachineView.getNameOptions().getItemAt(0));
                            } else {
                                vendingMachineView.getTextField().setText("");
                            }

                            JOptionPane.showMessageDialog(vendingMachineView.getCustomRVMFrame(), "Saved successfully!", "Save Success", JOptionPane.INFORMATION_MESSAGE);
                            vendingMachineView.getCaloriesInput().setText(""); // Clear the text areas after saving
                            vendingMachineView.getPriceInput().setText(""); // Clear the text areas after saving
                            vendingMachineView.getTextField().setText("");
                            savedItemCount++; // Increment savedItemCount when an item is successfully saved
                        //} else {
                            //vendingMachineView.RegularVM();
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(vendingMachineView.getCustomRVMFrame(), "Please enter valid numeric values for Calories and Price.", "Error", JOptionPane.ERROR_MESSAGE);
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
    