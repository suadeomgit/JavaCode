import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class A extends JFrame implements ActionListener{
    Container cp;
    JButton bOpen;
    JButton bSave;
    JButton bClear;
    JTextPane tp;
    JScrollPane sp;
    JPanel p;

    A(){
        tp = new JTextPane();
        sp = new JScrollPane(tp);
        p = new JPanel();
        bOpen = new JButton("Open");
        bSave = new JButton("Save");
        bClear = new JButton("Clear");

        init();
    }

    void init(){
        cp = getContentPane();

        p.setLayout(new GridLayout(1,2));
        p.add(bOpen);
        p.add(bSave);
        cp.add(p,BorderLayout.NORTH);
        cp.add(sp);
        cp.add(bClear, BorderLayout.SOUTH);

        setUI();
    }
    void setUI(){
        setTitle("JFileChooser Test");
        setSize(300,400);
        setVisible(true);
        setLocation(400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj==bOpen){

        }else if(obj==bSave){

        }else{
            tp.setText("");
            tp.requestFocus();
        }
    }
    public static void main(String args[]){
        new A();
    }
}