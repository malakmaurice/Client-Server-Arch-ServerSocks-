package distributed_ass;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class clientHandler extends Thread {
	private Socket client;
	private String destination;
	private static int threadcount = 0;
	private int threadid;

	// constructor
	public clientHandler(Socket s, String String) {
		// TODO Auto-generated constructor stub
		this.client = s;
		this.destination = String;
		threadid = threadcount++;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			System.out.println("Driver no " + (threadid + 1) + " connected");
			//String test=new String("Hello ,i want to Connect to server");
			//System.out.println(test.contains("Hello"));
			dos.writeUTF("Hello ,i want to Connect to server");
			dos.flush();
			String reseverMsg = dis.readUTF();
			System.out.println(reseverMsg);
			dos.writeUTF(destination);
			dos.flush();
			reseverMsg = dis.readUTF();
			System.out.println(reseverMsg);
			dos.writeUTF("thanks bye");
			dos.flush();
			reseverMsg = dis.readUTF();
			System.out.println(reseverMsg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
