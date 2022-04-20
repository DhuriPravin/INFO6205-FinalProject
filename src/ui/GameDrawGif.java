package src.ui;

import javax.swing.*;

public class GameDrawGif extends JWindow {

    public static void draw() {
        TicTacToeUI.dispatchWindows();
        JLabel label = new JLabel(new ImageIcon(GameDrawGif.class.getResource("200.gif")));

        JFrame f = new JFrame("Game Draw");
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
