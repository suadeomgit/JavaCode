import javax.swing.*;
import java.awt.event.*;
//import java.awt.*;
class A4 extends JFrame{
    JButton b;
    void init(){
        b = new JButton("A4's Button");
        add(b);
        b.addActionListener(new A4Handler(this));


        setUI();
    }
    void setUI(){
        setTitle("GUI Test Ver 1.0");
        setSize(300,72);
        setVisible(true);
        setLocation(580,400);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // public void actionPerformed(ActionEvent e){
    //     b.setText("Button Clicked!!( by Its Own Class )");
    // }
    public static void main(String args[]){
        A4 a4 = new A4();
        a4.init();
    }
}
