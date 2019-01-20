import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
public class DbConnection {
	public static void main(String[] args) {
//		public static Connection connectDb(){
			try{
				Scanner scanner = new Scanner(System.in);
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","JUHI","juhistudylink");
				Statement statement = conn.createStatement();
				System.out.println("Connection successful!");
				int option;
				do{
					System.out.println("Press " +
							"1.registering new account " +
							"2.if already have an account " +
							"3.exit");
					System.out.println("Enter your option : ");
					option=scanner.nextInt();
					scanner.nextLine();
					switch(option){

						case 1:
							System.out.println("Enter the user-name : ");
							String rusername = scanner.nextLine();
							System.out.println("Enter the password : ");
							String rpassword = scanner.nextLine();
							statement.execute("INSERT INTO user (user_name, user_password) VALUES ('"+rusername+"','"+rpassword+"')");
							System.out.println("Record inserted successfully!");
							break;
						case 2:
							System.out.println("Enter the user-name : ");
							String username = scanner.nextLine() ;
							System.out.println("Enter your password : ");
							String password = scanner.nextLine();
							String sql = "SELECT * FROM user";
							ResultSet rs = statement.executeQuery(sql);
							while(rs.next()){

								if(rs.getString("user_name").equals(username) && rs.getString("user_password").equals(password)){
									System.out.println("Login successful!");
								}else{
									System.out.println("Account not registered");
								}
							}
							rs.close();
							break;
						case 3:break;
					}
				}while(option!=3);




			}
			catch(SQLException e){
				System.out.println("Issue in connecting to db!"+e);
			}
			catch(Exception e){
				System.out.println("Issue : "+e);
			}

//		}
	}
}