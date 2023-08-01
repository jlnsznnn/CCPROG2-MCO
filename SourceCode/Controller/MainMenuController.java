package SourceCode.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import SourceCode.View.MainMenuView;

public class MainMenuController {

    public MainMenuController(MainMenuView mainMenuView){
        mainMenuView.setMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int choice;
                if(e.getSource() == mainMenuView.getMenuButton1()){
                    JOptionPane.showMessageDialog(mainMenuView.getFrame(), "Regular Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // INSERT CODE
                    //mainMenuView.CustomRVM();
                    mainMenuView.getFrame().setVisible(false);
                } else if (e.getSource() == mainMenuView.getMenuButton2()) {
                    JOptionPane.showMessageDialog(mainMenuView.getFrame(), "Special Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // INSERT CODE
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
