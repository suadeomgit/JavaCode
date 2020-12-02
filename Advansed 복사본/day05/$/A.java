import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;
import java.io.File;

class A extends JFrame implements ActionListener {
    Container cp;
    JButton bOpen;
    JButton bSave;
    JButton bClear;
    JTextPane tp;
    JScrollPane sp;
    JPanel p;
    String fPath = "/Users/";
    final static int FC_OPEN = 0;
    final static int FC_SAVE = 1;

    
    A() {
        tp = new JTextPane();
        sp = new JScrollPane(tp);
        p = new JPanel();
        bOpen = new JButton("Open");
        bSave = new JButton("Save");
        bClear = new JButton("Clear");
        bOpen.addActionListener(this);
        bSave.addActionListener(this);
        bClear.addActionListener(this);
        
        init();
    }
    
    void init() {
        cp = getContentPane();
        
        p.setLayout(new GridLayout(1, 2));
        p.add(bOpen);
        p.add(bSave);
        cp.add(p, BorderLayout.SOUTH);
        cp.add(sp);
        cp.add(bClear, BorderLayout.NORTH);
        
        setUI();
    }
    
    void setUI() {
        setTitle("JFileChooser Test");
        // pack();
        setSize(500,700);
        setVisible(true);
        // setLocation(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void showFC(int mode) {
        JFileChooser jfc = new JFileChooser(fPath);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Open File(txt/java)", "txt", "java");
        jfc.addChoosableFileFilter(filter);
        
        int option = -1;
        if (mode == FC_OPEN) {
            option = jfc.showOpenDialog(this);
        } else {
            option = jfc.showSaveDialog(this);
        }
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            if (mode == FC_OPEN) {
                readF(f);
            }else{
                writeF(f);
            }
        }
    }
    
    void readF(File f){
        BufferedReader br;
        try{
            String line = "";
            StringBuffer sb = new StringBuffer();
            FileReader fr = new FileReader(f);
            br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                sb.append(line + "\n");
            }
            String result = sb.toString();
            tp.setText(result);
        }catch(IOException ie){
            
        }finally{
            
        }
    }
    void writeF(File f){
    }
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        if(obj==bOpen){
            showFC(FC_OPEN);
        }else if(obj==bSave){
            showFC(FC_SAVE);
        }else{
            tp.setText("");
            tp.requestFocus();
        }
    }
    public static void main(String args[]){
        new A();
    }
}