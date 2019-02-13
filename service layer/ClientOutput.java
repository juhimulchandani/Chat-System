import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientOutput extends Thread{

	/********************DATA MEMBERS*******************************/
	private Client client;
    private ObjectOutputStream output ;
    private Message messageToBeSent ;
    private Connection connection;
    private Scanner scanner;
    private String msg;

    /********************CONSTRUCTOR****************************/
    /*
    * @param: The Socket of the current client.
    * */
    ClientOutput(Client client){
		this.client=client;
        scanner = new Scanner(System.in);
        try{
            output = new ObjectOutputStream(client.getSocket().getOutputStream());
        }
        catch(Exception ioe){
            System.out.println(ioe);
        }
	}

	/*****************METHODS****************/
	/*
	* This is the run method.
	* @param: Nothing.
	* @return: Nothing.
	* */
    public void run(){
    	try{
            while(true)
            {
                System.out.println("Enter the message you want to sent:");
                msg = scanner.nextLine();
	            System.out.println(client.getClientName());
                messageToBeSent = new Message(client.getClientName(),"puja" , msg);
                output.writeObject(messageToBeSent);
                if(messageToBeSent.getMessage().equalsIgnoreCase("exit")){
                    System.out.println("Im exiting");
                    break;
                }
            }
    	}
    	catch(Exception e){
    		System.out.println("Issue from Client output: "+e);
    	}
    	finally{
			try{
				output.close();
                client.getSocket().close();
			}catch(IOException e){
				System.out.println("Issue from finally block client output : "+e);
			}
		}
    }
}
