import java.io.*;
import java.net.*;

class AClient  {
	Socket s;
	String ip = "192.168.0.136";
	int port = 2000;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Keyboard
	OutputStream os; //Node 
	DataOutputStream dos; //Filter 

	AClient(){
		try{
			s = new Socket(ip, port);
			pln("������ ���� ����");

			readyIO();
			speak();
		}catch(UnknownHostException ne){
		}catch(IOException ie){
			pln("����("+ip+")�� ��Ʈ��ũ���� ã�� �� ����");
		}
	}
	void readyIO(){
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
		}catch(IOException ie){
		}
	}
	void speak(){ //Keyboard -> Socket 
		try{
			String line = null;
			while((line=br.readLine()) != null){
				dos.writeUTF(line);
				dos.flush();
			}
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new AClient();
	}
}
