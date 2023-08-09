package Question19;

public class GUIMain {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Tic Tac Toe");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.add(new TicTacToeGUI());
            frame.pack();
            frame.setVisible(true);
        });
    }
}