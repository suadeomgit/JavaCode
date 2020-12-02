import java.io.*;
import java.net.*;

public class AC extends Thread{
    Socket s;
    String ip = "192.168.0.26";
    int port = 2000;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    PrintStream ps = System.out;

    AC(){
        try{
            s = new Socket(ip, port);
            pln("Server Connecting Seccess");
            readyIO();
            start();
            speak();
            
        }catch(UnknownHostException ne){
        }catch(IOException ie){
            pln("Can not find Server( ip : "+ip+" ) in Network");
        }
    }
    public void run(){
        listen();
    }
    void readyIO(){
        try{
            os = s.getOutputStream();
            is = s.getInputStream();
            dos = new DataOutputStream(os);
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
    void speak(){ //Keyboard -> Socket
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
    public static void main(String arg[]){
        new AC();
    }
}
