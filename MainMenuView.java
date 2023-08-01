

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView {
    private ImageIcon icon;
    private JFrame frame;
    private JPanel mainBG;
    private JButton menuBtn1, menuBtn2, menuBtn3;
    private JLabel titleSpace;
    private GridBagConstraints gbc;

    public MainMenuView(){
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        this.frame = new JFrame("Greens & Grains");

        // Create a background image label 
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/VM BGM.png"));
        this.mainBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };

        this.frame.setSize(480, 680); // Set the size of the frame
        this.frame.setIconImage(icon.getImage());

        // Filler for space only
        this.titleSpace = new JLabel();
        this.titleSpace.setPreferredSize(new Dimension(0, 105));

        this.gbc = new GridBagConstraints();

        this.menuBtn1 = new JButton("Regular Vending Machine");
        this.menuBtn2 = new JButton("Special Vending Machine");
        this.menuBtn3 = new JButton("Exit");
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        initializeGUI();
    }

    private void initializeGUI() {
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

    // Getters
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainMenuView view = new MainMenuView();
                new MainMenuController(view); // Remove the variable declaration if not needed
                view.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.getFrame().setVisible(true);
            }
        });
    }    
}
