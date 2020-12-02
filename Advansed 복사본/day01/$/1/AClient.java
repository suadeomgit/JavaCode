import java.io.*;
import java.net.*;

public class AClient {
    Socket s;
    String ip = "192.168.0.26";
    int port = 2000;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    OutputStream os;
    DataOutputStream dos;

    AClient(){
        try{
            System.out.println("Hello World/(What the Fu**/)");
            s = new Socket(ip, port);
            pln("Server Connecting Seccess");

            readyIO();
            speak();
        }catch(UnknownHostException ne){
        }catch(IOException ie){
            pln("Can not find Server( ip : "+ip+" ) in Network");
        }
    }
    void readyIO(){
        try{
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
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
        new AClient();
    }
}
