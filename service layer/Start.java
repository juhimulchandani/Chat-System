import java.util.Scanner;
import java.io.IOException;

class Start{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Users user = new Users();
		String username;
		String password;
		Client clientObj;

		int option ;
		System.out.println("Welcome !!! " +
				"\n 1. Log In" +
				"\n 2. Sign Up" +
				"\n 3. Exit!");
		option = scanner.nextInt();
		scanner.nextLine();
		switch(option){
			case 1: System.out.println("Enter username : ");
				username = scanner.nextLine();
				System.out.println("Enter password : ");
				password = scanner.nextLine();

				if(!user.checkUser(username,password)){
					System.out.println("Login successful");
					try{
						clientObj = new Client(username);
						Start.connectToTCP(clientObj);
						user.updateStatus(username);
						System.out.println("To whom do u want to message?");
						user.displayUsers();
						String reciever = scanner.nextLine();
					}catch(Exception e){
						System.out.println("issue while client login "+e);
					}


				}else{
					System.out.println("Please create an account ");
				}
				break;

			case 2:	System.out.println("Enter username : ");
				username = scanner.nextLine();
				System.out.println("Enter password : ");
				password = scanner.nextLine();
				user.createUser(username,password);
				try{
					clientObj = new Client(username);
					Start.connectToTCP(clientObj);
					user.updateStatus(username);
					System.out.println("To whom do u want to message?");
					user.displayUsers();
					String reciever = scanner.nextLine();
				}
				catch(Exception e){
					System.out.println("issue while client registeration "+e);
				}

				break;

			case 3: break;


		}
	}

	public static void connectToTCP(Client clientObj){
		try{

			System.out.println("Input chalu kar raha hu");
			ClientInput ci = new ClientInput(clientObj);
			ci.start();
			System.out.println("output chalu kar raha hu");
			ClientOutput co = new ClientOutput(clientObj);
			co.start();
		}catch(Exception e){
			System.out.println("Issue from catch client main general: "+e);
		}
	}
}