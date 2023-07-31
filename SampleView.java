import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleView {
    private ImageIcon icon;
    private JFrame frame;
    private JPanel mainBG;
    private JButton menuBtn1, menuBtn2, menuBtn3;
    private JLabel titleSpace;

    // Constructor
    public SampleView() {
        this.icon = new ImageIcon(getClass().getResource("/Images/VM ICON.png"));
        this.frame = new JFrame("Greens & Grains");

        // Create a background image label using the provided URL
        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/VM BG.png"));
        this.mainBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };

        this.frame.setSize(480, 780);
        this.frame.setIconImage(icon.getImage());

        this.titleSpace = new JLabel();
        this.titleSpace.setPreferredSize(new Dimension(0, 105));

        this.menuBtn1 = new JButton("Regular Vending Machine");
        this.menuBtn2 = new JButton("Special Vending Machine");
        this.menuBtn3 = new JButton("Exit");

        menuBtn1.addActionListener(new MenuButtonListener());
        menuBtn2.addActionListener(new MenuButtonListener());
        menuBtn3.addActionListener(new MenuButtonListener());

        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        
    }

    // Main Menu GUI
    public void MainMenu() {
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
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // ActionListener
    private class MenuButtonListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e){
            int choice;
            if(e.getSource() == menuBtn1){
                JOptionPane.showMessageDialog(frame, "Regular Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                // INSERT CODE
                CustomRVM();
                frame.dispose();
            } else if (e.getSource() == menuBtn2) {
                JOptionPane.showMessageDialog(frame, "Special Vending Machine is created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                // INSERT CODE
            } else if (e.getSource() == menuBtn3) {
                choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Terminate Program", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION){
                    frame.dispose();
                }
            }
        }
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
    
        Border whiteLine = BorderFactory.createLineBorder(Color.white);
        regVMBG.setBorder(whiteLine); // Add a white border around the panel
        regularVM.add(regVMBG);
    
        JPanel labelPanel = new JPanel(new GridBagLayout());
    
        regVMBG.add(labelPanel);

        regularVM.setIconImage(icon.getImage());
        regularVM.setLocationRelativeTo(null);
        regularVM.setResizable(false);
        regularVM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        regularVM.setVisible(true);
    }

    // Regular Vending Machine GUI
    public void RegularVM(){
        JFrame regularVM = new JFrame("Regular Vending Machine");
        regularVM.setSize(480, 780);

        final ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Images/TEMPLATE.png"));
        JPanel regVMBG = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, null);
            }
        };
        
        regularVM.add(regVMBG);
        regularVM.setIconImage(icon.getImage());
        regularVM.setLocationRelativeTo(null);
        regularVM.setResizable(false);
        regularVM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        regularVM.setVisible(true);
    }

    // For testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SampleView().MainMenu();
            }
        });
    }
}

