package $;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//BorderLayout
class B extends JFrame implements ActionListener{
    JButton bN, bS, bW, bE, bC,
            bPC, bPE, bPW;
    Container cp;
    JPanel p;

    void init(){
        p = new JPanel();
        p.setLayout(new BorderLayout());
        bPC = new JButton("Panel Center");
        bPE = new JButton("Panel East");
        bPW = new JButton("Panel West");
        p.add(bPC,BorderLayout.CENTER);
        p.add(bPE,BorderLayout.EAST);
        p.add(bPW,BorderLayout.WEST);
        bPC.addActionListener(this);
        bPE.addActionListener(this);
        bPW.addActionListener(this);

        bN = new JButton("North");
        bS = new JButton("South");
        bE = new JButton("East");
        bW = new JButton("West");
        bC = new JButton("Center");
        cp = getContentPane();
        cp.add(bN,BorderLayout.NORTH);
        cp.add(bS,BorderLayout.SOUTH);
        cp.add(bW,BorderLayout.WEST);
        cp.add(bE,BorderLayout.EAST);
        //cp.add(bC,BorderLayout.CENTER);
        cp.add(p);

        setUI();
    }
    void setUI(){
        setTitle("TEST");
        setVisible(true);
        setSize(1280,720);
        setLocation(50,50);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj == bPC){
            pln("Panel Center Click");
        }else if(obj == bPE){
            pln("Panel East Click");
        }else{
            pln("Panel West Click");
        }
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        B b = new B();
        b.init();
    }
}
