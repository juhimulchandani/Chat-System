import java.io.*;
import java.net.Socket;
public class ServerInput extends Thread{

	/********************DATA MEMBERS*******************************/
    private Socket clientSocket;
    ObjectInputStream input;

	/********************CONSTRUCTOR****************************/
	/*
	 * @param: The Socket of the current client.
	 * */
	ServerInput(Socket socket){
		this.clientSocket=socket;
        try{
            input = new ObjectInputStream(clientSocket.getInputStream());
        }catch(Exception e){
            System.out.println("Exception in creating the stream:"+e);
        }
	}
}
