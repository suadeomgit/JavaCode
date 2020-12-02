package $;

import java.io.*;
import java.net.*;

class FServer{
    String fname = "Booyah.m4a";
    int port = 2000;
    ServerSocket ss;
    Socket s;
    InputStream is;
    BufferedInputStream bis;
    FileOutputStream fos;
    BufferedOutputStream bos;

    FServer(){
        try{
            ss = new ServerSocket(port);
            pln("File Server is waiting on port number "+port);
            s = ss.accept();

            is = s.getInputStream();
            bis = new BufferedInputStream(is, 4096);

            fos = new FileOutputStream(fname);
            bos = new BufferedOutputStream(fos, 4096);

            receive();
        }catch(IOException ie){}
    }
    void receive(){
        byte bs[] = new byte[1024];
        int i=0;
        long total = 0L;
        try{
            while((i=bis.read(bs)) != -1){
                bos.write(bs, 0, 1);
                pln("File in Reception...Speed about"+(total+=i)+"bytes");
            }
            bos.flush();
            pln("File("+fname+": "+total+") Received Successfully");
        }catch(IOException ie){
        }finally{
            closeAll();
        }
    }
    void closeAll(){
        try{
            bis.close();
            bos.close();
            is.close();
            fos.close();
            s.close();
            ss.close();
        }catch(IOException ie){}
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String args[]){
        new FServer();
    }
}