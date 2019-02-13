import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerOutput extends Thread {

	/********************DATA MEMBERS*******************************/
    private Socket socket;
    ObjectOutputStream output;

	/********************CONSTRUCTOR****************************/
	/*
	 * @param: The Socket of the current client.
	 * */
	ServerOutput(Socket socket){
		try{
            this.socket=socket;
            output = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(Exception ioe)
        {
            System.out.println("issue from server output : "+ioe);
        }
	}
}
