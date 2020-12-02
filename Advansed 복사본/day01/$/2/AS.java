import java.io.*;
import java.net.*;

class AS extends Thread{
    ServerSocket ss;
    Socket s;
    int port = 2000; //0 ~ 65535 // Well-Known Port : 0 ~ 1023
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InputStream is; //Node
    OutputStream os;
    DataInputStream dis;// Filter
    DataOutputStream dos;
    PrintStream ps = System.out;

    AS(){
        try{
            ss = new ServerSocket(port);
            pln("Server is ready on port Number:("+port+")");

            s = ss.accept();
            pln("Client("+s.getInetAddress().getHostAddress()+") Conecting Success");
            
            
            readyIO();
            start();
            listen();
            
        }catch(IOException ie){
            pln("ie: " + ie);
        }
    }
    void readyIO(){
        try{
            is = s.getInputStream();
            os = s.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
        }catch(IOException ie){}
    }

    public void run(){
        speak();
    }
    void listen(){
        try{
            String line = null;
            while((line=dis.readUTF()) != null){
                ps.println("Client>> " + line);
            }
        }catch(IOException ie){}
    }
    void speak(){
        try{
            String line = null;
            while((line=br.readLine()) != null){
                dos.writeUTF(line);
                dos.flush();
            }
        }catch(IOException ie){}
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        new AS();
    }
}

//socket..
//ss (Server Socket)
