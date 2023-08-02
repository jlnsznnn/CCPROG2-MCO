import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class SpecialVendingView extends RegularVendingView {
    public SpecialVendingView() {
        // Call the constructor of the superclass (RegularVendingView)
        super();
    }

    @Override
    public JPanel displayBackground() {
        //frame.setSize(480, 680);
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/SPECIAL VM BG.png"));
        JPanel regVMBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };

        return regVMBG;
    }

    public static void main(String[] args) {
        // Create a SpecialVendingView instance
        SpecialVendingView specialVendingView = new SpecialVendingView();   
        SpecialVendingController specialVendingController = new SpecialVendingController(new SpecialVendingMachine(), specialVendingView);
        ArrayList<Slot> savedItems = specialVendingController.getSlotList();
        specialVendingView.setItems(savedItems);
        
        // Show the RegularVendingView frame
        specialVendingView.CustomRVM();
    }
}

