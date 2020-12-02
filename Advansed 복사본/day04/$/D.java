import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//FlowLayout & CardLayout
class D extends JFrame implements ActionListener{
    String labels[] = {"B1","B2","B3","B4","B5","B6"};
    JButton bs[];
    Container cp;
    D(){
        bs = new JButton[labels.length];
    }
    void init(){
        //setLayout(new FlowLayout());
        setLayout(new CardLayout());
        cp = getContentPane();
        for(int i=0;i<bs.length;i++){
            bs[i] = new JButton(labels[i]);
            bs[i].addActionListener(this);
            cp.add(bs[i]);
        }

        setUI();
    }
    void setUI(){
        setTitle("GUI Test Ver 1.0");
        setSize(720,480);
        setVisible(true);
        setLocation(500,400);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        cp.remove((JButton)obj);

        revalidate();
        repaint();
    }
    public static void main(String args[]){
        D d = new D();
        d.init();
    }
}
