import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	/********************DATA MEMBERS*******************************/
//	public static int count=0;
	private String name;
	private Socket socket;

	Client(String name){
		this.name=name;
		try{
			this.socket = new Socket("localhost",8768);
		}
		catch(IOException e){
    		System.out.println("Issue from catch client main IO: "+e);
    	}catch(Exception e){
    		System.out.println("Issue from catch client main general: "+e);
    	}


	}

	public String getClientName(){
		return this.name;
	}

	public Socket getSocket(){
		return this.socket;
	}

	/*
	* This is made for UNIT TESTING.
	* */
//    public static void main(String args[]){
//    	try{
//				Socket socket = new Socket("localhost",8768);
//                System.out.println("Input chalu kar raha hu");
//                ClientInput ci = new ClientInput(socket);
//                ci.start();
//                System.out.println("output chalu kar raha hu");
//    			ClientOutput co = new ClientOutput(socket);
//    			co.start();
//    	}
//    	catch(IOException e){
//    		System.out.println("Issue from catch client main IO: "+e);
//    	}catch(Exception e){
//    		System.out.println("Issue from catch client main general: "+e);
//    	}
//    }
}

/*
* Client class{
*   name, socket
*   Client input(client)
*   client output(client)
*       op = new
*       username
* }
* */
