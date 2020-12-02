import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame{
    class A1Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //System.out.println("pereivere");
            b.setText("Button Clicked!!( by NamedInnerClass )");

            //JButton bb = (JButton)e.getSource();
            //bb.setText("Button Clicked!!( by NamedInnerClass2 )");
        }
    }

    JButton b;
    void init(){
        b = new JButton("JAVA's Button");
        add(b);
        ActionListener listener = new A1Handler();
        b.addActionListener(listener);

        setUI();
    }
    void setUI(){
        setTitle("GUI Test Ver 1.0");
        setSize(300,200);
        setVisible(true);
        setLocation(600,350);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        A1 a1 = new A1();
        a1.init();
    }
}