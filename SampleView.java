import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class SampleView extends JFrame{
    private JFrame frame;

    public SampleView() {
        this.frame = new JFrame("Sample MCO GUI");
        this.frame.setSize(400, 550);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sample lang
        this.frame.setLayout(new FlowLayout()); 

        JLabel background = new JLabel(new ImageIcon("C:/Users/Jaja/Downloads/Untitled design (13).png"));
        this.frame.add(background);
        background.setLayout(new FlowLayout());

        Font titleFont = new Font("Times New Roman", Font.BOLD, 40);
        JLabel titleLabel = new JLabel("Greens & Grains", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        background.add(titleLabel); 

        this.frame.setVisible(true);
    }
}
