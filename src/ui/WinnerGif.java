package src.ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class WinnerGif extends JWindow{

    public static void winner() {
        TicTacToeUI.dispatchWindows();
        JLabel label = new JLabel(new ImageIcon(WinnerGif.class.getResource("won.gif")));

        JFrame f = new JFrame("You Won");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.toFront();
        f.setAlwaysOnTop(true);
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setVisible(false);
    }

}
