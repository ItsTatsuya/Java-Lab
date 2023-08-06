
package com.mycompany.Question19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons;
    private boolean playerX;

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        playerX = true;

        initializeButtons();

        setVisible(true);
    }

    private void initializeButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 50));
                buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                add(buttons[row][col]);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("")) {
                if (playerX) {
                    buttons[row][col].setText("X");
                } else {
                    buttons[row][col].setText("O");
                }
                playerX = !playerX;

                if (checkWin()) {
                    String winner = playerX ? "Player X" : "Player O";
                    JOptionPane.showMessageDialog(null, winner + " wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    resetGame();
                } else if (checkDraw()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    resetGame();
                }
            }
        }

        private boolean checkWin() {
            String symbol = playerX ? "X" : "O";

            // Check rows
            for (int i = 0; i < 3; i++) {
                if (buttons[i][0].getText().equals(symbol) &&
                    buttons[i][1].getText().equals(symbol) &&
                    buttons[i][2].getText().equals(symbol)) {
                    return true;
                }
            }

            // Check columns
            for (int i = 0; i < 3; i++) {
                if (buttons[0][i].getText().equals(symbol) &&
                    buttons[1][i].getText().equals(symbol) &&
                    buttons[2][i].getText().equals(symbol)) {
                    return true;
                }
            }

            // Check diagonals
            if (buttons[0][0].getText().equals(symbol) &&
                buttons[1][1].getText().equals(symbol) &&
                buttons[2][2].getText().equals(symbol)) {
                return true;
            }

            if (buttons[0][2].getText().equals(symbol) &&
                buttons[1][1].getText().equals(symbol) &&
                buttons[2][0].getText().equals(symbol)) {
                return true;
            }

            return false;
        }

        private boolean checkDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j].getText().equals("")) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void resetGame() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                }
            }
            playerX = true;
        }
    }
}
