package nix.com.lvl_1;

import nix.com.Main.AppMain;
import nix.com.lvl_1.area.CalcAreaTriangle;
import nix.com.lvl_1.chess.ChessBoard;
import nix.com.lvl_1.chess.Knight;
import nix.com.lvl_1.chess.Piece;
import nix.com.lvl_1.chess.PieceCoordinate;
import nix.com.lvl_1.unique.NumUniqueSym;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class lvl_1_frame implements ActionListener {
    JPanel jPanel;
    JFrame jFrame;

    JButton jButtonUniqueExecute;
    JButton jButtonBack;
    JButton jButtonChessClear;
    JButton jButtonChessExecute;
    JButton jButtonTriangleClear;
    JButton jButtonTriangleExecute;
    JButton jButtonUniqueClear;

    JTextField jTextFieldUniqueIn;
    JTextField jTextFieldUniqueOut;
    JTextField jTextFieldAreaOut;
    JTextField jTextFieldAreaInY3;
    JTextField jTextFieldAreaInX2;
    JTextField jTextFieldAreaInY2;
    JTextField jTextFieldAreaInY1;
    JTextField jTextFieldAreaInX3;
    JTextField jTextFieldAreaInX1;
    JTextField jTextFieldChessIn;

    JTextArea jTextAreaChessOut;
    ChessBoard chessBoard = new ChessBoard();

    public lvl_1_frame() {
        jPanel = new JPanel();

        jFrame = new JFrame("Level 1");
        jFrame.setSize(800, 450);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(jPanel);

        jPanel.setLayout(null);
        jPanel.setBackground(new Color(17, 82, 142));

        JLabel jLabel1 = new JLabel("Please enter array of nums, like 1 2 4 5");
        jLabel1.setBounds(20, 20, 250, 25);
        jLabel1.setForeground(new Color(255,255,255));
        jPanel.add(jLabel1);

        JLabel jLabel2 = new JLabel("Unique nums");
        jLabel2.setBounds(20, 5, 250, 25);
        jLabel2.setForeground(new Color(255,255,255));
        jPanel.add(jLabel2);

        jTextFieldUniqueIn = new JTextField("1 4 5 1 1 3");
        jTextFieldUniqueIn.setBounds(20, 60, 205, 25);
        jTextFieldUniqueIn.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = jTextFieldUniqueIn.getText();
                int l = value.length();
                jTextFieldUniqueIn.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == ' ');
            }
        });
        jPanel.add(jTextFieldUniqueIn);

        jTextFieldUniqueOut = new JTextField();
        jTextFieldUniqueOut.setBounds(20, 100, 205, 25);
        jTextFieldUniqueOut.setEditable(false);
        jPanel.add(jTextFieldUniqueOut);

        jButtonUniqueExecute = new JButton("Find unique symbols");
        jButtonUniqueExecute.setBounds(20, 140, 205, 25);
        jButtonUniqueExecute.setForeground(new Color(255,255,255));
        jButtonUniqueExecute.setBackground(new Color(17, 82, 142));
        jButtonUniqueExecute.setFocusable(false);
        jButtonUniqueExecute.addActionListener(this);
        jPanel.add(jButtonUniqueExecute);

        jButtonUniqueClear = new JButton("Clear text fields");
        jButtonUniqueClear.setBounds(20, 180, 205, 25);
        jButtonUniqueClear.setForeground(new Color(255,255,255));
        jButtonUniqueClear.setBackground(new Color(17, 82, 142));
        jButtonUniqueClear.setFocusable(false);
        jButtonUniqueClear.addActionListener(this);
        jPanel.add(jButtonUniqueClear);

        jButtonBack = new JButton("Back");
        jButtonBack.setBounds(20, 340, 205, 25);
        jButtonBack.setForeground(new Color(255,255,255));
        jButtonBack.setBackground(new Color(17, 82, 142));
        jButtonBack.setFocusable(false);
        jButtonBack.addActionListener(this);
        jPanel.add(jButtonBack);
// ---------------------------------------------------------

        JLabel jLabel4 = new JLabel("Please enter coords, like B7, A5");
        jLabel4.setBounds(245, 20, 250, 25);
        jLabel4.setForeground(new Color(255,255,255));
        jPanel.add(jLabel4);

        JLabel jLabel3 = new JLabel("Knight move");
        jLabel3.setBounds(245, 5, 250, 25);
        jLabel3.setForeground(new Color(255,255,255));
        jPanel.add(jLabel3);

        jTextFieldChessIn = new JTextField("");
        jTextFieldChessIn.setBounds(245, 60, 205, 25);
        jTextFieldChessIn.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                jTextFieldChessIn.setEditable(jTextFieldChessIn.getText().length() <= 1);
            }
        });
        jPanel.add(jTextFieldChessIn);

        jTextAreaChessOut = new JTextArea();
        jTextAreaChessOut.setBounds(245, 100, 205, 180);
        jTextAreaChessOut.setEditable(false);
        jTextAreaChessOut.setText(chessBoard.drawBoard().toString());
        jPanel.add(jTextAreaChessOut);

        jButtonChessExecute = new JButton("Place knight");
        jButtonChessExecute.setBounds(245, 300, 205, 25);
        jButtonChessExecute.setForeground(new Color(255,255,255));
        jButtonChessExecute.setBackground(new Color(17, 82, 142));
        jButtonChessExecute.setFocusable(false);
        jButtonChessExecute.addActionListener(this);
        jPanel.add(jButtonChessExecute);

        jButtonChessClear = new JButton("Clear text field");
        jButtonChessClear.setBounds(245, 340, 205, 25);
        jButtonChessClear.setForeground(new Color(255,255,255));
        jButtonChessClear.setBackground(new Color(17, 82, 142));
        jButtonChessClear.setFocusable(false);
        jButtonChessClear.addActionListener(this);
        jPanel.add(jButtonChessClear);
// ---------------------------------------------------------

        JLabel jLabel5 = new JLabel("Please enter coords of points");
        jLabel5.setBounds(500, 20, 250, 25);
        jLabel5.setForeground(new Color(255,255,255));
        jPanel.add(jLabel5);

        JLabel jLabel6 = new JLabel("Calc area triangle");
        jLabel6.setBounds(500, 5, 250, 25);
        jLabel6.setForeground(new Color(255,255,255));
        jPanel.add(jLabel6);

        jTextFieldAreaInX1 = new JTextField("");
        jTextFieldAreaInX1.setBounds(500, 60, 50, 25);
        jTextFieldAreaInX1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                jTextFieldAreaInX1.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        jPanel.add(jTextFieldAreaInX1);

        jTextFieldAreaInX2 = new JTextField("");
        jTextFieldAreaInX2.setBounds(500, 90, 50, 25);
        jTextFieldAreaInX2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                jTextFieldAreaInX2.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        jPanel.add(jTextFieldAreaInX2);

        jTextFieldAreaInX3 = new JTextField("");
        jTextFieldAreaInX3.setBounds(500, 120, 50, 25);
        jTextFieldAreaInX3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                jTextFieldAreaInX3.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        jPanel.add(jTextFieldAreaInX3);

        jTextFieldAreaInY1 = new JTextField("");
        jTextFieldAreaInY1.setBounds(600, 60, 50, 25);
        jTextFieldAreaInY1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                jTextFieldAreaInY1.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        jPanel.add(jTextFieldAreaInY1);

        jTextFieldAreaInY2 = new JTextField("");
        jTextFieldAreaInY2.setBounds(600, 90, 50, 25);
        jTextFieldAreaInY2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                jTextFieldAreaInY2.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        jPanel.add(jTextFieldAreaInY2);

        jTextFieldAreaInY3 = new JTextField("");
        jTextFieldAreaInY3.setBounds(600, 120, 50, 25);
        jTextFieldAreaInY3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                jTextFieldAreaInY3.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });
        jPanel.add(jTextFieldAreaInY3);

        jTextFieldAreaOut = new JTextField();
        jTextFieldAreaOut.setBounds(500, 150, 205, 25);
        jTextFieldAreaOut.setEditable(false);
        jPanel.add(jTextFieldAreaOut);

        jButtonTriangleExecute = new JButton("Calc area");
        jButtonTriangleExecute.setBounds(500, 300, 205, 25);
        jButtonTriangleExecute.setForeground(new Color(255,255,255));
        jButtonTriangleExecute.setBackground(new Color(17, 82, 142));
        jButtonTriangleExecute.setFocusable(false);
        jButtonTriangleExecute.addActionListener(this);
        jPanel.add(jButtonTriangleExecute);

        jButtonTriangleClear = new JButton("Clear text fields");
        jButtonTriangleClear.setBounds(500, 340, 205, 25);
        jButtonTriangleClear.setForeground(new Color(255,255,255));
        jButtonTriangleClear.setBackground(new Color(17, 82, 142));
        jButtonTriangleClear.setFocusable(false);
        jButtonTriangleClear.addActionListener(this);
        jPanel.add(jButtonTriangleClear);

        jFrame.setVisible(true);
    }

    Piece pieceKnight = new Knight();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonTriangleExecute) {
            if (jTextFieldAreaInX1.getText().isBlank()
                    || jTextFieldAreaInX2.getText().isBlank()
                    || jTextFieldAreaInY1.getText().isBlank()
                    || jTextFieldAreaInY2.getText().isBlank()
                    || jTextFieldAreaInX3.getText().isBlank()
                    || jTextFieldAreaInY3.getText().isBlank()) {
                Error("Input all fields");
                return;
            }
            Point a = new Point(Integer.parseInt(jTextFieldAreaInX1.getText()), Integer.parseInt(jTextFieldAreaInY1.getText()));
            Point b = new Point(Integer.parseInt(jTextFieldAreaInX2.getText()), Integer.parseInt(jTextFieldAreaInY2.getText()));
            Point c = new Point(Integer.parseInt(jTextFieldAreaInX3.getText()), Integer.parseInt(jTextFieldAreaInY3.getText()));

            CalcAreaTriangle calcAreaTriangle = new CalcAreaTriangle(a, b, c);
            String area = String.valueOf(calcAreaTriangle.getArea());
            jTextFieldAreaOut.setText(area);
        }

        if (e.getSource() == jButtonTriangleClear) {
            jTextFieldAreaOut.setText("");
            jTextFieldAreaInX1.setText("");
            jTextFieldAreaInX2.setText("");
            jTextFieldAreaInX3.setText("");
            jTextFieldAreaInY1.setText("");
            jTextFieldAreaInY2.setText("");
            jTextFieldAreaInY3.setText("");
        }

        if (e.getSource() == jButtonUniqueExecute) {
            String[] str = jTextFieldUniqueIn.getText().replaceAll("[\\s]{2,}", " ").split(" ");
            int[] array = new int[str.length];

            if (!str[0].equals("")) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt(str[i]);
                }
                NumUniqueSym numUniqueSym = new NumUniqueSym();

                jTextFieldUniqueOut.setText(String.valueOf(numUniqueSym.getUniqueSymbols(array)));
            } else {
                Error("Wrong input");
            }
        }

        if (e.getSource() == jButtonChessExecute) {
            String coords = jTextFieldChessIn.getText();

            if (coords.length() < 1) {
                Error("Wrong input");
                return;
            }

            if (jButtonChessExecute.getText().equals("Move knight")) {
                PieceCoordinate pieceCoordinate;
                try {
                    pieceCoordinate = new PieceCoordinate(coords);
                    if (pieceKnight.isCanMove(pieceCoordinate)) {
                        chessBoard.updateBoard(coords);
                        jTextAreaChessOut.setText(chessBoard.drawBoard().toString());
                    }else {
                        Error("Enter coords");
                    }
                } catch (Exception exception) {
                    Error("Wrong input");
                }
            } else {

            try {
                pieceKnight.pieceCoordinate = new PieceCoordinate(coords);
                    chessBoard.updateBoard(coords);
                    jTextAreaChessOut.setText(chessBoard.drawBoard().toString());
            } catch (Exception exception) {
                Error("Wrong input");
            }
            jButtonChessExecute.setText("Move knight");
            }
        }

        if (e.getSource() == jButtonUniqueClear) {
            jTextFieldUniqueOut.setText("");
            jTextFieldUniqueIn.setText("");
        }

        if (e.getSource() == jButtonChessClear) {
            jTextFieldChessIn.setText("");
        }

        if (e.getSource() == jButtonBack) {
            new AppMain();
            jFrame.dispose();
        }
    }
    public void Error (String errorName) {
        JOptionPane.showMessageDialog(jFrame,
                errorName,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
