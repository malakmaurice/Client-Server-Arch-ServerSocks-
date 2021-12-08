package distributed_ass;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException {

		try {

			Socket s = new Socket("localhost", 1234);
			Thread driver1 = new clientHandler(s, "street 1");
			Thread driver2 = new clientHandler(s, "street 2");
			//Thread driver3 = new clientHandler(s, "street 3");
			driver1.run();
			driver2.run();
			//driver3.run();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
