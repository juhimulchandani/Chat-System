import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	/*
	 * This is made for UNIT TESTING.
	 * */
    public static void main(String args[]){

        int i=1;
        try(ServerSocket serverSocket = new ServerSocket(8768)){
    		while(true){
    			Socket clientSocket = serverSocket.accept();
    			ServerInput si = new ServerInput(clientSocket);
                ServerOutput so = new ServerOutput(clientSocket);
                OperationHandler operationObj = new OperationHandler(so, si, clientSocket, "Client"+ i);
                i++;
                Connection.addConnection(operationObj);
                operationObj.start();
    		}
    	}catch(IOException e){
    		System.out.println("Issue : "+e);
    	}
    }
}

