package nix.com.lvl_3;

import nix.com.Main.AppMain;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GameOfLife implements ActionListener {

    final int NUM_CELLS = 50;

    Random random = new Random();

    boolean[][] lifeGen = new boolean[NUM_CELLS][NUM_CELLS];
    boolean[][] stepGen = new boolean[NUM_CELLS][NUM_CELLS];

    Canvas canvas;

    JButton jButtonBack;
    JButton jButtonFill;
    JButton jButtonNext;

    JFrame jFrame;

    public void go() {
        jFrame = new JFrame("Game of Life");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(510, 565);
        jFrame.setLocation(200, 200);
        jFrame.setResizable(false);

        JPanel jPanel = new JPanel();

        canvas = new Canvas();
        canvas.setBackground(Color.white);

        jButtonFill = new JButton("Fill");
        jButtonFill.setForeground(new Color(255,255,255));
        jButtonFill.setBackground(new Color(17, 82, 142));
        jButtonFill.setFocusable(false);
        jButtonFill.addActionListener(this);
        jPanel.add(jButtonFill);

        jButtonNext = new JButton("Step");
        jButtonNext.setForeground(new Color(255,255,255));
        jButtonNext.setBackground(new Color(17, 82, 142));
        jButtonNext.setFocusable(false);
        jButtonNext.addActionListener(this);
        jPanel.add(jButtonNext);

        jButtonBack = new JButton("Back");
        jButtonBack.setForeground(new Color(255,255,255));
        jButtonBack.setBackground(new Color(17, 82, 142));
        jButtonBack.setFocusable(false);
        jButtonBack.addActionListener(this);
        jPanel.add(jButtonBack);

        jFrame.getContentPane().add(BorderLayout.NORTH, jPanel);
        jFrame.getContentPane().add(BorderLayout.CENTER, canvas);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonBack) {
            new AppMain();
            jFrame.dispose();
        }

        if (e.getSource() == jButtonNext) {
                processOfLife();
                canvas.repaint();
        }

        if (e.getSource() == jButtonFill) {
            for (int i = 0; i < NUM_CELLS; i++) {
                for (int j = 0; j < NUM_CELLS; j++) {
                    lifeGen[i][j] = random.nextBoolean();
                }
            }
            canvas.repaint();
        }
    }

    public int countNeighbors(int i, int j) {
        int count = 0;
        for (int di = -1; di < 2; di++) {
            for (int dj = -1; dj < 2; dj++) {

                int ni = i + di;
                int nj = j + dj;

                if (ni < 0) {
                    ni = NUM_CELLS - 1;
                }
                if (nj < 0) {
                    nj = NUM_CELLS - 1;
                }
                if (ni > NUM_CELLS - 1) {
                    ni = 0;
                }
                if (nj > NUM_CELLS - 1) {
                    nj = 0;
                }
                if (lifeGen[ni][nj]) {
                    count += 1;
                } else {
                    count += 0;
                }
            }
        }
        if (lifeGen[i][j]) {
            count--;
        }
        return count;
    }

    private void processOfLife() {
        for (int i = 0; i < NUM_CELLS; i++) {
            for (int j = 0; j < NUM_CELLS; j++) {
                int count = countNeighbors(i, j);
                boolean tmp = lifeGen[i][j];
                stepGen[i][j] = tmp;

                stepGen[i][j] = (count >= 2) && (count <= 3) && stepGen[i][j];

                stepGen[i][j] = count == 3 || stepGen[i][j];
            }
        }

        for (int i = 0; i < NUM_CELLS; i++) {
            for (int j = 0; j < NUM_CELLS; j++) {
                boolean tmpLife = stepGen[i][j];
                lifeGen[i][j] = tmpLife;
            }
        }
    }

    public class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < NUM_CELLS; i++) {
                for (int j = 0; j < NUM_CELLS; j++) {
                    if (lifeGen[i][j]) {
                        int size = 10;
                        g.fillOval(i*size, j*size, 10, 10);
                    }
                }
            }
        }
    }
}