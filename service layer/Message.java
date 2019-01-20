import java.io.Serializable;

public class Message implements Serializable{
	/********************DATA MEMBERS************************/
    private String sender;
    private String receiver;
    private String message;

	/*************************CONSTRUCTORS*******************/
	/*
	* @param: It accepts the name of Sender Client in String sender
	* @param: It accepts the name of Receiver Client in String receiver
	* @param: It accepts the message which is to be sent in String message
	* */
    Message(String sender, String receiver, String message){
    	this.sender=sender;
    	this.receiver=receiver;
        this.message=message;
    }

	/***************************GETTERS**********************/
    public String getSender(){
    	return this.sender;
    }

    public String getMessage(){
    	return this.message;
    }

    public String getReceiver(){
        return this.receiver;
    }
}
