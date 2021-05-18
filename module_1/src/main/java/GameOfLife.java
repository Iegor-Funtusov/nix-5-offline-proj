import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameOfLife {
    final String name = "Game of Life";
    final int location = 200;
    final int size = 50;
    final int point = 10;
    final int sizeField = size * point + 7;
    final int heightPanel = 5;
    boolean[][] life = new boolean[size][size];
    boolean[][] lifeNew = new boolean[size][size];
    volatile boolean nextGeneration = false;
    int showDelay = 20;
    Board canvasPanel;
    Random random = new Random();

    void run() {
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeField, sizeField + heightPanel);
        frame.setLocation(location, location);
        frame.setResizable(false);

        canvasPanel = new Board();
        canvasPanel.setBackground(Color.white);

        JButton fillButton = new JButton("Fill");
        fillButton.addActionListener(new ButtonFill());

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                life();
                canvasPanel.repaint();
            }
        });

        final JButton button = new JButton("Play");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextGeneration = !nextGeneration;
                button.setText(nextGeneration ? "Stop" : "Play");
            }
        });

        JPanel panel = new JPanel();
        panel.add(fillButton);
        panel.add(stepButton);
        panel.add(button);

        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);

        while (true) {
            if (nextGeneration) {
                life();
                canvasPanel.repaint();
                try {
                    Thread.sleep(showDelay);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public class ButtonFill implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    life[x][y] = random.nextBoolean();
                }
            }
            canvasPanel.repaint();
        }
    }

    int neighbors(int x, int y) {
        int number = 0;
        for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                int nX = x + dx;
                int nY = y + dy;
                nX = (nX < 0) ? size - 1 : nX;
                nY = (nY < 0) ? size - 1 : nY;
                nX = (nX > size - 1) ? 0 : nX;
                nY = (nY > size - 1) ? 0 : nY;
                number += (life[nX][nY]) ? 1 : 0;
            }
        }
        if (life[x][y]) { number--; }
        return number;
    }

    void life() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int count = neighbors(x, y);
                lifeNew[x][y] = life[x][y];
                lifeNew[x][y] = (count == 3) ? true : lifeNew[x][y];
                lifeNew[x][y] = ((count < 2) || (count > 3)) ? false : lifeNew[x][y];
            }
        }
        for (int x = 0; x < size; x++) {
            System.arraycopy(lifeNew[x], 0, life[x], 0, size);
        }
    }

    public class Board extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (life[x][y]) {
                        g.fillOval(x* point, y* point, point, point);
                    }
                }
            }
        }
    }
}
