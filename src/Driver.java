package src;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.controller.MainMenuController;
import src.view.MainMenuView;
// DRIVER CLASS 
public class Driver {
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
