package nix.com.Main;

import nix.com.lvl_2.lvl_2_frame;
import nix.com.lvl_1.lvl_1_frame;
import nix.com.lvl_3.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMain implements ActionListener {
    JPanel jPanel;
    JFrame jFrame;

    JButton jButtonLevel1;
    JButton jButtonLevel2;
    JButton jButtonLevel3;
    JButton jButtonExit;
    public AppMain() {

        jPanel = new JPanel();

        jFrame = new JFrame("Module 1");
        jFrame.setSize(260, 260);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(jPanel);

        jPanel.setLayout(null);
        jPanel.setBackground(new Color(17, 82, 142));

        JLabel jLabel1 = new JLabel("Please choose the level");
        jLabel1.setBounds(50, 20, 250, 25);
        jLabel1.setForeground(new Color(255,255,255));
        jPanel.add(jLabel1);

        jButtonLevel1 = new JButton("Level 1");
        jButtonLevel1.setBounds(20, 60, 205, 25);
        jButtonLevel1.setForeground(new Color(255,255,255));
        jButtonLevel1.setBackground(new Color(17, 82, 142));
        jButtonLevel1.addActionListener(this);
        jButtonLevel1.setFocusable(false);
        jPanel.add(jButtonLevel1);

        jButtonLevel2 = new JButton("Level 2");
        jButtonLevel2.setBounds(20, 100, 205, 25);
        jButtonLevel2.setForeground(new Color(255,255,255));
        jButtonLevel2.setBackground(new Color(17, 82, 142));
        jButtonLevel2.addActionListener(this);
        jButtonLevel2.setFocusable(false);
        jPanel.add(jButtonLevel2);

        jButtonLevel3 = new JButton("Level 3");
        jButtonLevel3.setBounds(20, 140, 205, 25);
        jButtonLevel3.setForeground(new Color(255,255,255));
        jButtonLevel3.setBackground(new Color(17, 82, 142));
        jButtonLevel3.setFocusable(false);
        jButtonLevel3.addActionListener(this);
        jPanel.add(jButtonLevel3);

        jButtonExit = new JButton("Exit");
        jButtonExit.setBounds(20, 180, 205, 25);
        jButtonExit.setForeground(new Color(255,255,255));
        jButtonExit.setBackground(new Color(17, 82, 142));
        jButtonExit.setFocusable(false);
        jButtonExit.addActionListener(this);
        jPanel.add(jButtonExit);

        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonLevel1){

            jFrame.dispose();

            new lvl_1_frame();
        }

        if (e.getSource() == jButtonLevel2){

            jFrame.dispose();

            new lvl_2_frame();
        }

        if (e.getSource() == jButtonLevel3){

            jFrame.dispose();

            new GameOfLife().go();

        }

        if (e.getSource() == jButtonExit){
            jFrame.dispose();
        }
    }

    public static void main(String[] args) {
        new AppMain();
    }
}
