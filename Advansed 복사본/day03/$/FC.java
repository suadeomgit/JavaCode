package $;

import java.io.*;
import java.net.*;

class FC{
    Socket s;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    FileInputStream fis;
    OutputStream os;
    BufferedInputStream bis;
    BufferedOutputStream bos;

    String fname = "/Users/gwonseonghwan/Music/iTunes/iTunes Media/Music/Showtek feat. We Are Loud & Sonny Wilson/Unknown Album/Booyah.m4a";

    FC(){
        connect();
    }
    void connect(){
        try{
            p("Server IP(default:127.0.0.1): ");
            String ip = br.readLine();
            if(ip != null) ip = ip.trim();
            if(ip.length() == 0) ip = "127.0.0.1";

            p("PORT(default:2000): ");
            String portStr = br.readLine();
            if(portStr != null) portStr = portStr.trim();
            if(portStr.length() == 0) portStr = "2000";
            int port = Integer.parseInt(portStr);
            if(port<0 || port>65535){
                pln("Range is unavailable for Fort Number");
                connect();
                return;
            }
            s = new Socket(ip,port);

            ready();
        }catch(IOException ie){}
    }
    void ready(){
        try{
            fis = new FileInputStream(fname);
            bis = new BufferedInputStream(fis,4096);
            os = s.getOutputStream();
            bos = new BufferedOutputStream(os,4096);

            send();
        }catch(FileNotFoundException fe){
        }catch(IOException ie){}
    }
    void send(){
        byte bs[] = new byte[1024];
        int i=0;
        long total = 0L;
        try{
            while((i=bis.read(bs)) != -1){
                bos.write(bs,0,i);
                pln("Sending..."+( total += i )+"bytes");
            }
            bos.flush();
            pln("File("+fname+": "+total+"bytes) Sending Successfully");
        }catch(IOException ie){
        }finally{
            closeAll();
        }
    }
    void closeAll(){
        try{
            bis.close();
            bos.close();
            fis.close();
            os.close();
            s.close();
        }catch(IOException ie){}
    }
    void p(String str){
        System.out.print(str);
    }
    void pln(String str){
        System.out.println(str);
    }
    
}
