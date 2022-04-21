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
        for(int i=0;i<win.length;i++){
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

    public static void addAllButtons() {
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
    }

    static JButton button = null;

    public static void showUI() {
        final JFrame frame = new JFrame ();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().removeAll();
        frame.repaint();

        final JPanel panel = new JPanel ( new FlowLayout( FlowLayout.LEFT, 5, 5 ) )
        {
            public Dimension getPreferredSize ()
            {
                Dimension ps = super.getPreferredSize ();
                ps.width = 0;
                return ps;
            }
        };
        panel.setBackground(Color.decode("#000000"));
        frame.add ( new JScrollPane ( panel ) );

        frame.setSize ( 445, 240 );
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.setLocationRelativeTo ( null );

        //frame2.setVisible(true);

//        try {
//            try {
//                SwingUtilities.invokeAndWait ( new Runnable ()
//                {
//                    public void run ()
//                    {
        frame.setVisible ( true );
//                    }
//                } );
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        final JDialog load = new JDialog ( frame );

        JPanel panel2 = new JPanel ( new BorderLayout() );
        panel2.setBorder ( BorderFactory.createEmptyBorder ( 15, 15, 15, 15 ) );
        load.add ( panel2 );

        final JProgressBar progressBar = new JProgressBar ( 0, 100 );
        panel2.add ( progressBar );

        load.setModal ( false );
        load.pack ();
        load.setLocationRelativeTo ( frame );

//        try {
//            SwingUtilities.invokeAndWait ( new Runnable ()
//            {
//                public void run ()
//                {
//                    load.setVisible ( true );
//                }
//            } );
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        // = new JButton (String.valueOf(src.utils.Utils.getText().get(i)));
        setButtonColor();

        for ( int i = 0; i < 9; i++ )
        {
            button = buttons.get(i);
            button.setText(Utils.inputs.get(i));
            button.setPreferredSize(new Dimension(136, 60));
            button.setBackground(Color.decode("#212121"));
            button.setOpaque(true);
            button.setForeground(Utils.getText().get(i).equals("X") ? Color.red : Color.green);
            final int finalI = i;
            setButtonColor();

            // Updating panel and progress in EDT
            JButton finalButton = button;
            panel.add(finalButton);
            finalButton.revalidate ();
            finalButton.repaint();
            progressBar.setValue ( finalI );

        }

        JLabel status = new JLabel();
        status.setText("");

        load.setVisible(false);
        progressBar.setVisible(false);
        setButtonColor();
        frame.toFront();
        frame.setAlwaysOnTop(true);
    }

    public static void setButtonColor() {
        for (int i = 0; i < 9; i++) {
            buttons.get(i).setBackground(Color.decode("#212121"));
            buttons.get(i).setContentAreaFilled( false );
        }
    }

    private static void writeToConsole(int cellValue) {

    }

    @Override
    public final void setVisible(boolean v) {
        // Make sure we grab the focus so that key events don't go astray.
        requestFocus();
        super.setVisible(v);
    }
}
