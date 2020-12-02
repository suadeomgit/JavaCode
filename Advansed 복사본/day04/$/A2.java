import java.awt.event.*;
import javax.swing.*;

class A2 extends JFrame{
    JButton b;
    void init(){
        b = new JButton("JAVA's Button");
        add(b);
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                b.setText("Button Clicked!!( by Anonymous Inner Class )");
            }
        };
        b.addActionListener(listener);

        setUI();
    }
    void setUI(){
        setTitle("BUI Test Ver 1.0");
        setSize(300,300);
        setVisible(true);
        setLocation(600,350);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        A2 a2 = new A2();
        a2.init();
    }
}