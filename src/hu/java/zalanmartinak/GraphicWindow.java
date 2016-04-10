package hu.java.zalanmartinak;

import javax.swing.*;
import java.awt.event.*;

public class GraphicWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JLabel lable;
    private boolean textField1Visiblity=false;
    public GraphicWindow() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here

        if(textField1.getText().length()>3) {
            textField1.setVisible(false);
            lable.setText(textField1.getText());
            textField1Visiblity=true;
        }

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }
    public String getPlayerName()
    {
        System.out.println("a");
        new Thread()
        {
                private void onOK() {
                    if(textField1.getText().length()>3) {
                        textField1.setVisible(false);
                        lable.setText(textField1.getText());
                        textField1Visiblity=true;
                        System.out.println("valami");
                    }

            }
        }.start();
        System.out.println("b");
        return textField1.getText();
    }
    public static void main() {
        GraphicWindow dialog = new GraphicWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
