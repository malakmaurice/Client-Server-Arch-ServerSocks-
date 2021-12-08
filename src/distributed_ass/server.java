package distributed_ass;

import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket sv=new ServerSocket(5000);
			System.out.println("main server Running");
			while(true) {
				Socket s= sv.accept();
				System.out.println("Recommendation client acceptrd");
				Thread t=new serverHandler(s);
				t.run();
			}
			
		} catch (Exception e) {
			
			// TODO: handle exception
		}

	}

}
