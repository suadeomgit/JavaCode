import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

class Q extends JFrame{
    Container cp;
    JPanel Tp, Bp;
    JButton Cb, Pb, Scb, Mb, Stb;
    JLabel Tl;
    ImageIcon Ti, Sti;
    // Image Scni;
    
    Q(){
        init();
    }
    void init(){
        cp = getContentPane();

        setPnl();
        setImg();
        setBtn();
        setLbl();
        setUI();
    }
    void setUI(){
        setTitle("Quiz Time!");
        setVisible(true);
        setSize(700,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void setPnl(){
        Tp = new JPanel();
        Bp = new JPanel();
        Tp.setLayout(new BorderLayout());
        Bp.setLayout(new BorderLayout());
        cp.add(Tp,BorderLayout.NORTH);
        cp.add(Bp,BorderLayout.SOUTH);
    }
    void setBtn(){
        Cb = new JButton("Correct");
        Pb = new JButton("Pass");
        Scb = new JButton("SCORE");
        Mb = new JButton("Mute(Y/N)");
        Stb = new JButton(Sti);
        
        Tp.add(Scb,BorderLayout.WEST);
        Tp.add(Mb,BorderLayout.EAST);
        
        Bp.add(Cb,BorderLayout.WEST);
        Bp.add(Pb,BorderLayout.EAST);
        Bp.add(Stb,BorderLayout.CENTER);
        // cp.add(Stb);
        //Stb.setLayout(null);
        // Stb.setBounds(350,200,30,30);
    }
    void loadImg(){
        // try{
        //     File Tf = new File("imgs/Timer.gif");
        //     BufferedImage Tbi = ImageIO.read(Tf);
        //     Ti = new ImageIcon(Tbi);
        // }catch(IOException ie){
        //     System.out.println("No such File");
        // }
        // Scni = new ImageIcon("imgs/screen.png").getImage();
        Ti = new ImageIcon(getClass().getResource("imgs/Timer.gif"));
        Sti = new ImageIcon(getClass().getResource("imgs/play_button.png"));
    }
    void setLbl(){
        Tl = new JLabel(Ti);
        // Tp.add(Tl);
        Tp.add(Tl,BorderLayout.CENTER);
    }
    void setImg(){
        loadImg();
        //Tl.setIcon(Ti);
    }
    public static void main(String args[]){
        new Q();
    }
}