import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientInput extends Thread{

	/********************DATA MEMBERS*******************************/
//	private Socket socket ;
	private Client client;
    private Message messageObject;

	/********************CONSTRUCTOR****************************/
	/*
	* @param: The Socket of the current client.
	* */
	ClientInput(Client client){
//		this.socket = socket;
		this.client=client;
	}

	/*****************METHODS****************/
	/*
	 * This is the run method.
	 * @param: Nothing.
	 * @return: Nothing.
	 * */
    public void run(){
    	try{
            System.out.println("Inside input ka run");
    		ObjectInputStream input = new ObjectInputStream(client.getSocket().getInputStream());
            System.out.println("Stream banay");
    		do{
                System.out.println("While me aaya");
    			messageObject = (Message)input.readObject();
    			if(messageObject.getMessage().equals("exit")){
    				break;
    			}
                System.out.println("I got this from "+messageObject.getSender()+":"+messageObject.getMessage());
    		}while(!messageObject.getMessage().equalsIgnoreCase("exit"));
    	}
    	catch(IOException e){
    		System.out.println("Issue from client input IO : "+e);
    	}
    	catch(Exception e){
    		System.out.println("Issue from input general: "+e);
    	}
    	finally{
			try{
				client.getSocket().close();
			}catch(IOException e){
				System.out.println("Issue from input finally ka catch: "+e);
			}
    	}

    }
}
