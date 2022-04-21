package src.ui;

import javax.swing.*;

public class LostGif extends JWindow {

    public static void lost() {
        TicTacToeUI.dispatchWindows();
        JLabel label = new JLabel(new ImageIcon(LostGif.class.getResource("lost.gif")));

        JFrame f = new JFrame("You Lost");
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
