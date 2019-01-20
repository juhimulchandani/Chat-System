import java.net.*;
import java.util.*;
public class Connection {

	/********************DATA MEMBERS*******************************/
    static Vector<OperationHandler> records = new Vector();

    /*********************GETTERS***************************/
    /*
    * This is getRecord() method.
    * @param: Nothing
    * @return: Vector<OperationHandler>
    * */
    public static Vector<OperationHandler> getRecords() {
    	return records;
    }

    /****************METHODS****************/
	/*
	* This is addConnection() method.
	* @param: OperationHandler client
	* @return: Nothing.
	* */
    public static void addConnection(OperationHandler client) {
    	records.addElement(client);
    }
}
