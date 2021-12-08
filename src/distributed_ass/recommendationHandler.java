package distributed_ass;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class recommendationHandler extends Thread {
	private Socket client;
	private Socket server;

	public recommendationHandler(Socket s, Socket server) {

		// TODO Auto-generated constructor stub
		this.client = s;
		this.server = server;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			DataInputStream disServer = new DataInputStream(server.getInputStream());
			DataOutputStream dosServer = new DataOutputStream(server.getOutputStream());
			while (true) {
				String clientMsg = dis.readUTF();
				String serverMsg=null;
				
				//System.out.println(clientMsg);
				if (clientMsg!=null&&clientMsg.contains("Hello")) {
					dos.writeUTF("Hello where do you want to go");
					dos.flush();
					
				}else if (clientMsg!=null&&clientMsg.contains("bye")) {
					dosServer.writeUTF("close");
					dosServer.flush();
					serverMsg=disServer.readUTF();
					dos.writeUTF("bye bye");
					dos.flush();
				}
				else
				{
					dosServer.writeUTF(clientMsg);
					dosServer.flush();
					serverMsg=disServer.readUTF();
				}
				
				
				if(serverMsg!=null && serverMsg.contains("street 1")) {
					dos.writeUTF("for stree 1 go to this path");
					dos.flush();
					//System.out.println("1");
				}else if(serverMsg!=null && serverMsg.contains("street 2")) {
					dos.writeUTF("for stree 2 go to this path");
					dos.flush();
					//System.out.println(serverMsg);
				}
				//clientMsg = dis.readUTF();
				//System.out.println(clientMsg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
