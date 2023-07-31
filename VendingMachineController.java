import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class VendingMachineController {
    private VendingMachineView vendingMachineView;

    public VendingMachineController(VendingMachineView vendingMachineView ) {
        this.vendingMachineView = vendingMachineView;

        this.vendingMachineView.setMenuButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int choice;
                if(e.getSource() == vendingMachineView.getMenuButton1()){
                    JOptionPane.showMessageDialog( vendingMachineView.getFrame(), "Regular Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // INSERT CODE
                    vendingMachineView.CustomRVM();
                    vendingMachineView.getFrame().dispose();
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
    }
}