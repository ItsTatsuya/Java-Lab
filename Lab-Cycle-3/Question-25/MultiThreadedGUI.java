package testapp;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MultiThreadedGUI extends javax.swing.JFrame {

    public MultiThreadedGUI() {
        initComponents();
        setTitle("Odd/Even Generator");
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = Color.decode("#a513d1");
                Color color2 = Color.decode("#0f99a8");
                Color color3 = Color.decode("#2bf08a");
                float[] fractions = { 0.0f, 0.7f, 1.0f };
                Color[] colors = { color1, color2, color3 };
                MultipleGradientPaint gradient = new LinearGradientPaint(
                        new Point2D.Float(0, 0),
                        new Point2D.Float(getWidth(), getHeight()),
                        fractions, colors);
                g2d.setPaint(gradient);
                g2d.fill(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));

            }
        };
        jLabel1 = new javax.swing.JLabel();
        field_number = new javax.swing.JTextField();
        btn_generate = new javax.swing.JButton();
        btn_display = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_area_even = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        field_area_odd = new javax.swing.JTextArea();
        generated = false;
        icon = new ImageIcon("numbers.png");
        number = 0;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Font labelFont = new Font("Consolas", Font.BOLD, 15);
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        jLabel1.setText("Number");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(labelFont);

        btn_generate.setText("Generate");
        btn_generate.setBackground(Color.decode("#28fa83"));
        btn_generate.setForeground(Color.decode("#252525"));
        btn_generate.setFont(buttonFont);

        btn_display.setText("Display");
        btn_display.setBackground(Color.decode("#0286fa"));
        btn_display.setForeground(Color.decode("#a8adb5"));
        btn_display.setFont(buttonFont);

        jLabel2.setText("Even");
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setFont(labelFont);

        field_area_even.setColumns(20);
        field_area_even.setRows(5);
        jScrollPane1.setViewportView(field_area_even);

        jLabel3.setText("Odd");
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setFont(labelFont);

        field_area_odd.setColumns(20);
        field_area_odd.setRows(5);
        jScrollPane2.setViewportView(field_area_odd);

        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });

        btn_display.setEnabled(false);
        btn_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_displayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_display, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(field_number, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(jScrollPane2))))
                                .addContainerGap(18, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(field_number, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_generate)
                                        .addComponent(btn_display))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {
        String numberString = field_number.getText();
        if (numberString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int newNumber = Integer.parseInt(numberString);
            if (number == newNumber) {
                JOptionPane.showMessageDialog(this, "Please provide a new number to regenerate!", "Change number",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            number = newNumber;
            if (number < 1 || number > 1000) {
                JOptionPane.showMessageDialog(this, "Please enter a number between 1 and 1000!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            OddThread oddThread = new OddThread(number, "ODD.txt");
            EvenThread evenThread = new EvenThread(number, "EVEN.txt");
            oddThread.start();
            evenThread.start();
            if (!generated) {
                btn_display.setEnabled(true);
                btn_display.setForeground(Color.decode("#252525"));
                btn_generate.setText("Regenerate");
                btn_generate.setBackground(Color.decode("#fa7c28"));
            } else if (generated) {
                field_area_odd.setText("");
                field_area_even.setText("");
            }
            generated = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btn_displayActionPerformed(java.awt.event.ActionEvent evt) {
        if (!generated) {
            JOptionPane.showMessageDialog(this, "Please generate the numbers first!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String oddText = readFileContents("ODD.txt");
            String evenText = readFileContents("EVEN.txt");

            field_area_odd.setText(oddText);
            field_area_even.setText(evenText);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading the files!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String readFileContents(String filename) throws IOException {
        Path filePath = Paths.get(filename);
        List<String> lines = Files.readAllLines(filePath);
        return String.join("\n", lines);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MultiThreadedGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiThreadedGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiThreadedGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiThreadedGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiThreadedGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btn_display;
    private javax.swing.JButton btn_generate;
    private javax.swing.JTextArea field_area_even;
    private javax.swing.JTextArea field_area_odd;
    private javax.swing.JTextField field_number;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private boolean generated;
    private int number;
    private ImageIcon icon;

}
