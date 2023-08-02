import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 	This SpecialVendingController inherits the RegularVendingController class.
 */
public class SpecialVendingController extends RegularVendingController {
    private SpecialVendingMachine specialVendingModel;

    /**
     * Constructs a SpecialVendingController object
     */
    public SpecialVendingController(SpecialVendingMachine specialVendingModel, SpecialVendingView specialVendingView) {
        super(specialVendingModel, specialVendingView);
        this.specialVendingModel = specialVendingModel;
    }

    /**
     * Shows a JOptionPane that displays the list of items dispensed in a combo.
     */
    @Override
    public void customizeAction(){
        // Get the customize button
        JButton customButton = this.regularVendingView.getCustomizeButton(); 
        
        // Add an action listener
        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularVendingView.getTextField().setText("Dispensing Hail Caesar Salad..."); // Display the selected item name in the textField
                ArrayList<Item> itemCombo = specialVendingModel.dispenseItems("Lettuce", "Dressing", "Croutons", "Roasted Chicken", "Fresh Herbs"); // Ingredients of the salad
                String text = "Preparing " + itemCombo.get(0).getName() + "...\n" +
                              "Mixing " + itemCombo.get(1).getName() + "...\n" +
                              "Adding " + itemCombo.get(2).getName() + "...\n" +
                              "Combining " + itemCombo.get(3).getName() + "...\n"+
                              "Tossing " + itemCombo.get(4).getName() + "...\n";
                JOptionPane.showMessageDialog(regularVendingView.getFrame(), text, "Salad Combo",
                JOptionPane.INFORMATION_MESSAGE); 

                JOptionPane.showMessageDialog(regularVendingView.getFrame(), "Hail Caesar Dispensed Successfully", "Salad Combo",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
