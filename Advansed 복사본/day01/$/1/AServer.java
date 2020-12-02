import java.io.*;
import java.net.*;

class AServer{
    ServerSocket ss;
    Socket s;
    int port = 2000; //0 ~ 65535 // Well-Known Port : 0 ~ 1023
    InputStream is; //Node
    DataInputStream dis;// Filter
    PrintStream ps = System.out;

    AServer(){
        try{
            ss = new ServerSocket(port);
            pln("Server is ready on port Number:("+port+")");

            s = ss.accept();
            pln("Client("+s.getInetAddress().getHostAddress()+") Conecting Success");

            readyIO();
            listen();
        }catch(IOException ie){
            pln("ie: " + ie);
        }
    }
    void readyIO(){
        try{
            is = s.getInputStream();
            dis = new DataInputStream(is);
        }catch(IOException ie){}
    }
    void listen(){
        try{
            String line = null;
            while((line=dis.readUTF()) != null){
                ps.println("Client>> " + line);
            }
        }catch(IOException ie){}
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        new AServer();
    }
}

//socket..
//ss (Server Socket)