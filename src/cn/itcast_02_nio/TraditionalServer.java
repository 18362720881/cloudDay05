package cn.itcast_02_nio;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("resource")
public class TraditionalServer {
	public static void main(String args[]) throws IOException {
		//�����˿�
		ServerSocket server_socket = new ServerSocket(2000);
		System.out.println("�ȴ����˿�Ϊ��" + server_socket.getLocalPort());
		
		while (true) {
			//����������Ϣ
			Socket socket = server_socket.accept();
			//��ӡ������Ϣ
			System.out.println("�����ӣ�  " + socket.getInetAddress() + ":" +socket.getPort());
			//��socket�л�ȡ��
			DataInputStream input = new DataInputStream(socket.getInputStream());
			//��������
			byte[] byteArray = new byte[4096];
			while(true) {
				int nread = input.read(byteArray, 0, 4096);
				System.out.println(new String(byteArray, "UTF-8"));
				if (-1 == nread) {
					break;
				}
			}
			socket.close();
			System.out.println("Connection closed by client");
			
		}
	}

}
