package $;

import java.io.*;
import java.net.*;

class UServerClient extends Thread{
    int port = 5000;
    String ip;
    String ipHeader = "192.168.0.";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void init(){
        start();
        try{
            Thread.sleep(50);
        }catch(Exception e){}

        //inputIp();

        DatagramSocket ds = null;
        DatagramPacket dp = null;
        try{
            ds = new DatagramSocket();

            while(true){
                inputIp();
                //p("messege wanna sand: ");
                String msg = br.readLine();
                if(msg != null) msg = msg.trim();
                byte[] buf = msg.getBytes();
                InetAddress ia = InetAddress.getByName(ip);
                dp = new DatagramPacket(buf,buf.length,ia,port);
                ds.send(dp);
                pln("Sending Complete");
            }
        }catch(SocketException se){
            init();
        }catch(UnknownHostException ue){
            pln("Can't find conformed Server("+ip+") on Network");
            init();
        }catch(IOException ie){
            init();
        }finally{
            ds.close();
        }
    }
    void inputIp(){
        try{
            p("IP(4th): ");
            String ipTail = br.readLine();
            if(ipTail != null) ipTail = ipTail.trim();
            if(ipTail.length() != 0){
                ip = ipHeader + ipTail;
            }else{
                inputIp();
            }
        }catch(IOException ie){
            inputIp();
        }
    }
    public void run(){
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        try{
            ds = new DatagramSocket(port);
            pln("Waiting on UDP Server Number"+port+" ...");
            byte buf[] = new byte[2048];
            dp = new DatagramPacket(buf,buf.length);

            while(true){
                ds.receive(dp);
                String msg = new String(buf);
                msg = msg.trim();
                pln("Client>> "+ msg);
                for(int i=0;i<buf.length;i++) buf[i]=0;
            }
        }catch(SocketException se){

        }catch(IOException ie){

        }finally{
            ds.close();
        }
    }
    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }
    public static void main(String args[]){
        new UServerClient().init();
    }
}