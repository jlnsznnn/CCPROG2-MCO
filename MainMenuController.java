import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainMenuController {

    public MainMenuController(MainMenuView mainMenuView){
        mainMenuView.setMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int choice;
                if(e.getSource() == mainMenuView.getMenuButton1()){
                    JOptionPane.showMessageDialog(mainMenuView.getFrame(), "Regular Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // INSERT CODE
                    RegularVendingView regularVendingView = new RegularVendingView();
                    VendingMachine regularVendingModel = new VendingMachine();
                    RegularVendingController regularVendingController = new RegularVendingController(regularVendingModel, regularVendingView);
                    ArrayList<Slot> savedItems = regularVendingController.getSlotList();
                    regularVendingView.setItems(savedItems);
                    regularVendingView.CustomRVM();
                    mainMenuView.getFrame().setVisible(false);
                } else if (e.getSource() == mainMenuView.getMenuButton2()) {
                    JOptionPane.showMessageDialog(mainMenuView.getFrame(), "Special Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // INSERT CODE
                    // Create a SpecialVendingView instance
                    SpecialVendingView specialVendingView = new SpecialVendingView();   
                    // Create a SpecialVendingController instance and pass the RegularVendingView to it
                    SpecialVendingController specialVendingController = new SpecialVendingController(new SpecialVendingMachine(), specialVendingView);
                    ArrayList<Slot> savedItems = specialVendingController.getSlotList();
                    specialVendingView.setItems(savedItems);
                    // Show the RegularVendingView frame
                    specialVendingView.CustomRVM();
                    mainMenuView.getFrame().setVisible(false);
                } else if (e.getSource() == mainMenuView.getMenuButton3()) {
                    choice = JOptionPane.showConfirmDialog(mainMenuView.getFrame(), "Are you sure you want to exit?", "Terminate Program", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION){
                        mainMenuView.getFrame().dispose();
                    }
                }
            }
        });

    }
}
