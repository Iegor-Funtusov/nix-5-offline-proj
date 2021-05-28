package level3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {

    JFrame frame;
    JPanel panel;
    Box[][] boxes;
    JButton[] buttons;
    JSlider slider;
    Timer timer;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
        initPanel();
        initButtons();
        initSlider();
    }

    void initPanel() {
        panel = new JPanel(new GridLayout(3, 1));
        panel.setBounds(Config.SIZE * Config.WIDTH, 0, Config.SIDE_PANEL_WIDTH, Config.SIZE * Config.HEIGHT);
        frame.add(panel);
    }

    void initButtons() {
        buttons = new JButton[2];
        buttons[0] = new JButton("Start");
        buttons[0].addActionListener(new ActionListener() {
            boolean flop = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                flop = !flop;
                if (flop) {
                    timer.start();
                    buttons[0].setText("Stop");
                } else {
                    timer.stop();
                    buttons[0].setText("Start");
                }
            }
        });
        panel.add(buttons[0]);
        buttons[1] = new JButton("Clear");
        buttons[1].addActionListener(e -> {
            for (int x = 0; x < Config.WIDTH; x++)
                for (int y = 0; y < Config.HEIGHT; y++) {
                    boxes[x][y].cell.status = Status.NONE;
                    boxes[x][y].setColor();
                }
        });
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning())
                    buttons[0].doClick();
            }
        });
        panel.add(buttons[1]);
    }

    void initSlider() {
        slider = new JSlider(0, 1000, 500);
        slider.setOrientation(JSlider.VERTICAL);
        slider.setInverted(true);
        slider.setMajorTickSpacing(100);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = ((JSlider)e.getSource()).getValue();
                timer.setDelay(value);
            }
        });
        panel.add(slider);
    }

    void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * Config.WIDTH + Config.SIDE_PANEL_WIDTH, Config.SIZE * Config.HEIGHT + 23);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Game of Life");
    }

    void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }

        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++)
                for (int sx = -1; sx <= +1 ; sx++)
                    for (int sy = -1; sy <= +1 ; sy++)
                        if(!(sx == 0 && sy == 0))
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);
    }

    private void initTimer() {
        TimerListener tl = new TimerListener();
        timer = new Timer(500, tl);
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {
                    if (flop)
                        boxes[x][y].step1();
                    else
                        boxes[x][y].step2();
                }
            }
        }
    }

}
