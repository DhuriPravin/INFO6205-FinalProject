package src.ui;

import src.game.Participant;
import src.game.TicTacToeGame;
import src.game.ValuesOfCell;
import src.human.HumanInput;
import src.menace.MenaceTrainStrategy;
import src.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class TicTacToeUI extends JWindow {

    public static void dispatchWindows() {
        java.awt.Window win[] = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].dispose();
        }
    }

    private static ArrayList<JButton> buttons = new ArrayList<JButton>();
    private static JButton button1 = new JButton("");
    private static JButton button2 = new JButton("");
    private static JButton button3 = new JButton("");
    private static JButton button4 = new JButton("");
    private static JButton button5 = new JButton("");
    private static JButton button6 = new JButton("");
    private static JButton button7 = new JButton("");
    private static JButton button8 = new JButton("");
    private static JButton button9 = new JButton("");

}