import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SampleMaintenance {
    private JFrame frame;
    private JPanel panel;
    private JLabel restockLbl;
    private JTextField displayText;
    private JButton button;
    private JPanel buttons;

    public SampleMaintenance() {
        // set up frame
        this.frame = new JFrame("Maintenance");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(480, 680);

        // create background image
        this.panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // load and draw the background image
                ImageIcon bgImageIcon = new ImageIcon("Images/MAINTENANCE BG.png");
                Image bgImage = bgImageIcon.getImage();
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // set the layout manager for the panel to fill the entire frame
        this.panel.setLayout(new BorderLayout());
        this.frame.add(panel);

        // Create the button panel on the left
        buttons = new JPanel();
        buttons.setOpaque(false); // Make the button panel transparent
        buttons.setLayout(new GridLayout(8, 1, 10, 10));

        // Add buttons to the button panel
        String[] buttonNames = {
            "Restock Item", "Set Price", "Collect Money", "Replenish Money",
            "Starting Inventory", "Ending Inventory", "Transactions", "Exit"
        };
        for (String name : buttonNames) {
            this.button = new JButton(name);
            this.button.addActionListener(this);
            buttons.add(button);
        }

        this.panel.add(buttons, BorderLayout.WEST);
        this.frame.add(buttons);
        this.frame.setVisible(true);
    }

    public void setConvertBtnListener() {
        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        this.displayText = new JTextField();
        this.displayText.setEditable(false);
        this.button = new JButton("Restock Item");

        /* 
        restockBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/

        this.frame.add(panel1);
    }

    public static void main(String[] args) {
        SampleMaintenance sm = new SampleMaintenance();
    }
}

 