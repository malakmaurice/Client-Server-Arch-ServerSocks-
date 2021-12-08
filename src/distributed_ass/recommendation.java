package distributed_ass;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class recommendation {

	public static void main(String[] args) throws IOException {

		try {
			// 1.open server socket
			ServerSocket sv = new ServerSocket(1234);
			Socket client =new Socket("localhost",5000);
			System.out.println("Recommendation Server Running...");
			while (true) {
				// 2.accept connection
				Socket s = sv.accept();
				System.out.println("Client Accepted...");
				// 3. open thread for this client (s)
				Thread t = new recommendationHandler(s,client);
				t.run();

			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
