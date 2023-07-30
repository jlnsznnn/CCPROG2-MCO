import javax.swing.*;
import java.awt.*;

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

        this.titleSpace = new JLabel();
        this.titleSpace.setPreferredSize(new Dimension(0, 95));

        this.menuBtn1 = new JButton("Regular Vending Machine");
        this.menuBtn2 = new JButton("Special Vending Machine");
        this.menuBtn3 = new JButton("Exit");

        frame.setSize(470, 750);

        // Set the icon image
        frame.setIconImage(icon.getImage());

        // Display the frame on the center of the screen
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
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
