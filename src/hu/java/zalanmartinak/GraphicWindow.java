package hu.java.zalanmartinak;

import javax.swing.*;
import java.awt.event.*;

public class GraphicWindow extends JDialog {
    private JPanel contentPane;
    private JButton button1;
    private JLabel playersLable;
    private JPanel ownCards;
    private JLabel topCard;
    private JPanel abc;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JLabel lable;

    public GraphicWindow() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void onOK() {
// add your code here

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void setTable(String s)
    {
        playersLable.setText(s);
    }
    public void setTopCard(String s)
    {
        topCard.setText(s);

    }
    public void seta()
    {
        abc.setSize(100,100);
    }
    public JButton getDrawButton()
    {
        return button1;
    }


    public JPanel getOwnCards()
    {
        return ownCards;
    }
    public static void main() {
        GraphicWindow dialog = new GraphicWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}