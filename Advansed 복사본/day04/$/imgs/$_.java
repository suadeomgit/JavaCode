package imgs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class $_ extends JFrame implements ActionListener{
    Container cp;
    JButton b;
    JButton bs;
    JButton b0;
    ImageIcon bk;
    ImageIcon og;
    ImageIcon gy;
    ImageIcon zr;

    void init(){
        cp = getContentPane();
        loadImg();
        b = new JButton(bk);
        bs = new JButton(gy);
        b0 = new JButton(zr);
        cp.add(b);
        cp.add(bs);
        cp.add(b0);

        setUI();
    }
    void loadImg(){
        // File bif = new File("Black.png");
        // File oif = new File("Orange.png");
        // File gif = new File("Gray.png");
        // File zif = new File("Zero.png");
        try{
            // BufferedImage bi = ImageIO.read(bif);
            // BufferedImage bii = ImageIO.read(oif);
            // BufferedImage biii = ImageIO.read(gif);
            // BufferedImage biiii = ImageIO.read(zif);
            // bk = new ImageIcon(bi);
            // og = new ImageIcon(bii);
            // gy = new ImageIcon(biii);
            // zr = new ImageIcon(biiii);
            bk = new ImageIcon(ImageIO.read(new File("Black.png")));
            og = new ImageIcon(ImageIO.read(new File("Orange.png")));
            gy = new ImageIcon(ImageIO.read(new File("Gray.png")));
            zr = new ImageIcon(ImageIO.read(new File("Zero.png")));
        }catch(IOException ie){}
    }
    void setUI(){
        setTitle("Calculator Copy...hehe");
        pack();
        setVisible(true);
        setLocation(600,300);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){

    }
    public static void main(String args[]){
        $_ $ = new $_();
        $.init();
    }
}
