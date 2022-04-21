package src.ui;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JWindow {

    public static void main(String[] args) {
        welcome();
    }

	public static void welcome() {
        TicTacToeUI.dispatchWindows();
        JLabel label = new JLabel(new ImageIcon(Welcome.class.getResource("welcome.gif")));

        JFrame f = new JFrame("Tic Tac Toe");
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
