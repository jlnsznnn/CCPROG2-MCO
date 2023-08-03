import javax.swing.*;

import java.awt.*;

/**
 * 	This SpecialVendingView inherits the RegularVendingView class
 */
public class SpecialVendingView extends RegularVendingView {
    /**
    * 	Constructs a SpecialVendingView
    */
    public SpecialVendingView() {
        // Call the constructor of the superclass (RegularVendingView)
        super();
    }

    /**
     * Displays the background
     * 
     * @return        The background image
     */
    @Override
    public JPanel displayBackground() {
        // get the chosen background image from Images folder
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("Images/SPECIAL VM BG.png"));
        JPanel regVMBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };

        return regVMBG;
    }
}

