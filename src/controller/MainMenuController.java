package src.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import src.model.Slot;
import src.model.VendingMachine;
import src.model.SpecialVendingMachine;
import src.view.MainMenuView;
import src.view.RegularVendingView;
import src.view.SpecialVendingView;
/**
 * 	This MainMenuController class is linked to the model and view of the main menu
 */
public class MainMenuController {
    /**
     * Constructs a MainMenuController object
     * 
     * @param mainMenuView      instance of the MainMenuView class
     */
    public MainMenuController(MainMenuView mainMenuView){
        mainMenuView.setMenuButtonListener(new ActionListener() {
             /**
             * Adds an action for every action performed by the user
             * 
             * @param e      instance of an Action Event
             */
            @Override
            public void actionPerformed(ActionEvent e){
                int choice;
                if(e.getSource() == mainMenuView.getMenuButton1()){
                    JOptionPane.showMessageDialog(mainMenuView.getFrame(), "Regular Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    RegularVendingView regularVendingView = new RegularVendingView();
                    VendingMachine regularVendingModel = new VendingMachine();
                    RegularVendingController regularVendingController = new RegularVendingController(regularVendingModel, regularVendingView);
                    ArrayList<Slot> savedItems = regularVendingController.getSlotList();
                    regularVendingView.setItems(savedItems);
                    regularVendingView.CustomRVM();
                    mainMenuView.getFrame().setVisible(false);
                } else if (e.getSource() == mainMenuView.getMenuButton2()) {
                    JOptionPane.showMessageDialog(mainMenuView.getFrame(), "Special Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    SpecialVendingView specialVendingView = new SpecialVendingView();   
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
