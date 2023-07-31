import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;

public class VendingMachineView {
    private ImageIcon icon;
    private JFrame frame;
    private JPanel mainBG;
    private JButton menuBtn1, menuBtn2, menuBtn3;
    private JLabel titleSpace;
    private VendingMachineController controller; 

    public VendingMachineView() {
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        this.frame = new JFrame("Greens & Grains");

        // Create a background image label 
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/VM BG.png"));
        this.mainBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };

        this.frame.setSize(480, 780); // Set the size of the frame
        this.frame.setIconImage(icon.getImage());

        this.titleSpace = new JLabel();
        this.titleSpace.setPreferredSize(new Dimension(0, 105));

        this.menuBtn1 = new JButton("Regular Vending Machine");
        this.menuBtn2 = new JButton("Special Vending Machine");
        this.menuBtn3 = new JButton("Exit");

        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        initializeGUI();

        controller = new VendingMachineController(this);
    }

    private void initializeGUI() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weighty = 0.0;
        mainBG.add(titleSpace, gbc);

        // Reset gridwidth and weighty for buttons
        gbc.gridwidth = 1;
        gbc.weighty = 0.0;

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        mainBG.add(menuBtn1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainBG.add(menuBtn2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainBG.add(menuBtn3, gbc);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(mainBG);
    }

    // Method to set the menu button listener
    public void setMenuButtonListener(ActionListener menuButtonListener) {
        menuBtn1.addActionListener(menuButtonListener);
        menuBtn2.addActionListener(menuButtonListener);
        menuBtn3.addActionListener(menuButtonListener);
    }


    public JFrame getFrame() {
        return frame;
    }

    public JButton getMenuButton1() {
        return menuBtn1;
    }

    public JButton getMenuButton2() {
        return menuBtn2;
    }

    public JButton getMenuButton3() {
        return menuBtn3;
    }
    

    // Regular Vending Machine GUI
    public void CustomRVM() {
        JFrame regularVM = new JFrame("Customize Your Regular Vending Machine");
        regularVM.setSize(480, 780);
    
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/ASK USER RVM.png"));
        JPanel regVMBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };
    
        JPanel labelPanel = new JPanel(new GridBagLayout());
    
        regVMBG.add(labelPanel);

        regularVM.setIconImage(icon.getImage());
        regularVM.setLocationRelativeTo(null);
        regularVM.setResizable(false);
        regularVM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        regularVM.setVisible(true);
    }

    // Regular Vending Machine GUI
    public void RegularVM() {
        JFrame regularVM = new JFrame("Regular Vending Machine");
        regularVM.setSize(480, 780);
        // INSERT CODE
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VendingMachineView view = new VendingMachineView();
                
                // The controller is used for setting up the view and handling button actions.
                view.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.getFrame().setVisible(true);
            }
        });
    }
}