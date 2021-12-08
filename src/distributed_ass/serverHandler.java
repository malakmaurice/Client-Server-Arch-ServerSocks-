package distributed_ass;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class serverHandler extends Thread {
	private Socket client;

	public serverHandler(Socket s) {
		// TODO Auto-generated constructor stub
		this.client = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			while(true) {
				String clientMsg=dis.readUTF();
				//System.out.println(clientMsg);
				if(clientMsg!=null&&clientMsg.contains("open")) {
					System.out.println("Server opend!");
					dos.writeUTF("Server opend!");
					dos.flush();
				}else if(clientMsg!=null&&clientMsg.contains("close")) {
					System.out.println("Server closed!");
					dos.writeUTF("Server closed!");
					dos.flush();
				}else if(clientMsg!=null&&clientMsg.contains("street 1")) {
					System.out.println("iformation about street 1 sent!");
					dos.writeUTF("iformation about street 1 sent!");
					dos.flush();
				}else if(clientMsg!=null&&clientMsg.contains("street 2")) {
					System.out.println("iformation about street 2 sent!");
					dos.writeUTF("iformation about street 2 sent!");
					dos.flush();
				}else if(clientMsg!=null&&clientMsg.contains("street 3")) {
					System.out.println("iformation about street 3 sent!");
					dos.writeUTF("iformation about street 3 sent!");
					dos.flush();
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		super.run();
	}
}
