import java.awt.event.*;
import javax.swing.*;

public class CalculatorMain extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bmod,bdec,beq,bclr;
    static double a=0,b=0,result=0;
    static int operator=0;
    CalculatorMain()
    {
        t1=new JTextField();
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        b0=new JButton("0");
        badd=new JButton("+");
        bsub=new JButton("-");
        bmul=new JButton("*");
        bdiv=new JButton("/");
        bmod=new JButton("%");
        bdec=new JButton(".");
        beq=new JButton("=");
        bclr=new JButton("Clear");
        t1.setBounds(30,40,280,30);
        b7.setBounds(40,100,50,40);
        b8.setBounds(110,100,50,40);
        b9.setBounds(180,100,50,40);
        bdiv.setBounds(250,100,50,40);
        b4.setBounds(40,170,50,40);
        b5.setBounds(110,170,50,40);
        b6.setBounds(180,170,50,40);
        bmul.setBounds(250,170,50,40);
        b1.setBounds(40,240,50,40);
        b2.setBounds(110,240,50,40);
        b3.setBounds(180,240,50,40);
        bsub.setBounds(250,240,50,40);
        bdec.setBounds(40,310,50,40);
        b0.setBounds(110,310,50,40);
        beq.setBounds(180,310,50,40);
        badd.setBounds(250,310,50,40);
        bmod.setBounds(40,380,50,40);
        bclr.setBounds(110,380,120,40);
        add(t1);
        add(b7);
        add(b8);
        add(b9);
        add(bdiv);
        add(b4);
        add(b5);
        add(b6);
        add(bmul);
        add(b1);
        add(b2);
        add(b3);
        add(bsub);
        add(bdec);
        add(b0);
        add(beq);
        add(badd);
        add(bmod);
        add(bclr);
        setLayout(null);
        setVisible(true);
        setSize(350,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        badd.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        bsub.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bmul.addActionListener(this);
        bdec.addActionListener(this);
        b0.addActionListener(this);
        beq.addActionListener(this);
        bdiv.addActionListener(this);
        bmod.addActionListener(this);
        bclr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
            t1.setText(t1.getText().concat("1"));
        if(e.getSource()==b2)
            t1.setText(t1.getText().concat("2"));
        if(e.getSource()==b3)
            t1.setText(t1.getText().concat("3"));
        if(e.getSource()==b4)
            t1.setText(t1.getText().concat("4"));
        if(e.getSource()==b5)
            t1.setText(t1.getText().concat("5"));
        if(e.getSource()==b6)
            t1.setText(t1.getText().concat("6"));
        if(e.getSource()==b7)
            t1.setText(t1.getText().concat("7"));
        if(e.getSource()==b8)
            t1.setText(t1.getText().concat("8"));
        if(e.getSource()==b9)
            t1.setText(t1.getText().concat("9"));
        if(e.getSource()==b0)
            t1.setText(t1.getText().concat("0"));
        if(e.getSource()==bdec)
            t1.setText(t1.getText().concat("."));
        if(e.getSource()==badd)
        {
            a=Double.parseDouble(t1.getText());
            operator=1;
            t1.setText("");
        }
        if(e.getSource()==bsub)
        {
            a=Double.parseDouble(t1.getText());
            operator=2;
            t1.setText("");
        }
        if(e.getSource()==bmul)
        {
            a=Double.parseDouble(t1.getText());
            operator=3;
            t1.setText("");
        }
        if(e.getSource()==bdiv)
        {
            a=Double.parseDouble(t1.getText());
            operator=4;
            t1.setText("");
        }
        if(e.getSource()==bmod)
        {
            a=Double.parseDouble(t1.getText());
            operator=5;
            t1.setText("");
        }
        if(e.getSource()==beq)
        {
            b=Double.parseDouble(t1.getText());
            switch(operator)
            {
                case 1: result=a+b;
                    break;
                case 2: result=a-b;
                    break;
                case 3: result=a*b;
                    break;
                case 4: result=a/b;
                    break;
                case 5: result=a%b;
                    break;
                default: result=0;
            }
            t1.setText(""+result);
        }
        if(e.getSource()==bclr)
            t1.setText("");

    }
    public static void main(String[] args)
    {
        new CalculatorMain();
    }
}



