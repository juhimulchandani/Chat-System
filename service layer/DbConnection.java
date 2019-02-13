import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
public class DbConnection {

		public static Connection connectDb(){
			try{

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","JUHI","juhistudylink");
				return conn;

			}
			catch(SQLException e){
				System.out.println("Issue in connecting to db!"+e);
				return null;
			}
			catch(Exception e){
				System.out.println("Issue : "+e);
				return null;
			}
	}
}