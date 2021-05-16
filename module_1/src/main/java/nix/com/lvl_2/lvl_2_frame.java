package nix.com.lvl_2;

import nix.com.Main.AppMain;
import nix.com.lvl_2.string_bracket.RegExBracket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lvl_2_frame implements ActionListener {
    JPanel jPanel;
    JFrame jFrame;

    JButton jButtonBracketExecute;
    JButton jButtonBack;
    JButton jButtonBracketClear;

    JTextField jTextFieldBracketIn;
    JTextField jTextFieldBracketOut;

    public lvl_2_frame() {
        jPanel = new JPanel();

        jFrame = new JFrame("Level 1");
        jFrame.setSize(300, 300);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(jPanel);

        jPanel.setLayout(null);
        jPanel.setBackground(new Color(17, 82, 142));

        JLabel jLabel1 = new JLabel("Please enter string");
        jLabel1.setBounds(20, 20, 250, 25);
        jLabel1.setForeground(new Color(255,255,255));
        jPanel.add(jLabel1);

        JLabel jLabel2 = new JLabel("String Brackets");
        jLabel2.setBounds(20, 5, 250, 25);
        jLabel2.setForeground(new Color(255,255,255));
        jPanel.add(jLabel2);

        jTextFieldBracketIn = new JTextField();
        jTextFieldBracketIn.setBounds(20, 60, 205, 25);
        jPanel.add(jTextFieldBracketIn);

        jTextFieldBracketOut = new JTextField();
        jTextFieldBracketOut.setBounds(20, 100, 205, 25);
        jTextFieldBracketOut.setEditable(false);
        jPanel.add(jTextFieldBracketOut);

        jButtonBracketExecute = new JButton("Check string");
        jButtonBracketExecute.setBounds(20, 140, 205, 25);
        jButtonBracketExecute.setForeground(new Color(255,255,255));
        jButtonBracketExecute.setBackground(new Color(17, 82, 142));
        jButtonBracketExecute.setFocusable(false);
        jButtonBracketExecute.addActionListener(this);
        jPanel.add(jButtonBracketExecute);

        jButtonBracketClear = new JButton("Clear field");
        jButtonBracketClear.setBounds(20, 180, 205, 25);
        jButtonBracketClear.setForeground(new Color(255,255,255));
        jButtonBracketClear.setBackground(new Color(17, 82, 142));
        jButtonBracketClear.setFocusable(false);
        jButtonBracketClear.addActionListener(this);
        jPanel.add(jButtonBracketClear);

        jButtonBack = new JButton("Back");
        jButtonBack.setBounds(20, 220, 205, 25);
        jButtonBack.setForeground(new Color(255,255,255));
        jButtonBack.setBackground(new Color(17, 82, 142));
        jButtonBack.setFocusable(false);
        jButtonBack.addActionListener(this);
        jPanel.add(jButtonBack);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == jButtonBracketExecute) {
           RegExBracket regExBracket = new RegExBracket();
           jTextFieldBracketOut.setText(regExBracket.check(jTextFieldBracketIn.getText()) + "");
       }

       if (e.getSource() == jButtonBracketClear) {
           jTextFieldBracketOut.setText("");
           jTextFieldBracketIn.setText("");
       }

        if (e.getSource() == jButtonBack) {
            new AppMain();
            jFrame.dispose();
        }
    }
    public void Error () {
        JOptionPane.showMessageDialog(jFrame,
                "Wrong input",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
