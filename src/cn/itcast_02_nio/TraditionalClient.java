package cn.itcast_02_nio;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TraditionalClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		long start = System.currentTimeMillis();
		//creat socket connettion
		Socket socket = new Socket("localhost", 2000);
		System.out.println("Connected with server " + socket.getInetAddress() + ":" + socket.getPort());
		//read the file
		FileInputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\file.java");
		//output the file
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		byte[] b = new byte[4096];
		 long read = 0, total = 0;
		 while((read = inputStream.read(b)) >=0){
			 total = total + read;
			 outputStream.write(b);
		 }
		 
		 outputStream.close();
		 socket.close();
		 inputStream.close();
	}	
}
