import javax.swing.*;
import java.awt.event.*;

class A3 extends JFrame implements ActionListener{
    JButton b;
    void init(){
        b = new JButton("JAVA's Button");
        add(b);
        b.addActionListener(this);

        setUI();
    }
    void setUI(){
        setTitle("GUI Test Ver 1");
        setSize(128,72);
        setLocation(660,350);
        setVisible(true);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        b.setText("Button Clicked!!( by Its Own Class )");
    }
    public static void main(String args[]){
        A3 a3 = new A3();
        a3.init();
    }
}
