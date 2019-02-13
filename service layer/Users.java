import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Users{

	private Connection conn = DbConnection.connectDb();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql;
	Scanner scanner;


	public boolean checkUser(String user_name,String userpassword){
		sql = "SELECT * FROM user WHERE user_name = ?";
		String password;
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,user_name);
			rs=ps.executeQuery();
			if(rs.next()) {
				password=rs.getString("user_password");
				if(password.equals(userpassword)) {
					System.out.println("User found!");
					return false;
				}
				return true;
			}
			else {
				System.out.println("Not registered!");
				return true;
			}
		}
		catch(Exception e){
			System.out.println("Issue from checkUser : "+e);
			return false;
		}
	}

	public void createUser(String user_name, String user_password){
		if(checkUser(user_name,user_password)){
			sql = "INSERT INTO user(user_name, user_password) VALUES (?,?)";
			try{
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_name);
				ps.setString(2, user_password);
				ps.execute();
				System.out.println("User created successfully!");

			}
			catch(Exception e){
				System.out.println("Issue from createUser : "+e);
			}
		}else{
			System.out.println("User already exists!");
		}
	}

	public void displayUsers(){

		sql="SELECT user_name FROM user WHERE user_status = 1";
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String presentUser = rs.getString("user_name");
				System.out.println(presentUser);
			}
		}
		catch(Exception e) {
			System.out.println("Issue from displayUser : " + e);
		}
	}

	public void updateStatus(String user_name){
		sql = "UPDATE user SET user_status = 1 WHERE user_name = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,user_name);
			ps.execute();

		}catch(Exception e){
			System.out.println("Issue from updateStatus : "+e);
		}
	}
}