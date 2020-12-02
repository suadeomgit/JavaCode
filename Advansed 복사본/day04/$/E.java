import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

class E extends JFrame implements ActionListener{
    Container cp;
    JButton b;
    ImageIcon i;
    ImageIcon ii;

    void init(){
        cp = getContentPane();
        loadImg();
        b = new JButton(ii);
        b.addActionListener(this);
        cp.add(b);

        setUI();
    }
    void loadImg(){
        try{
            File f = new File("imgs/Orange.png");
            BufferedImage bi = ImageIO.read(f);
            i = new ImageIcon(bi);

            //i = new ImageIcon(ImageIO.read(new File(".png")));
            ii = new ImageIcon(ImageIO.read(new File("imgs/Gray.png")));
        }catch(IOException ie){}
    }
    void setUI(){
        setTitle("Image Test");
        pack();
        setVisible(true);
        setLocation(200,100);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        int answer = JOptionPane.showConfirmDialog(null,"Sleepy?","Ask",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            ii);
        if(answer == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Oh...you feel hard");
        }else{
            JOptionPane.showMessageDialog(null,"Great work!!!");
        }
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        E e = new E();
        e.init();
    }
}
