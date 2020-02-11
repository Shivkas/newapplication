package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordResetJDBC {

	public void updatePassword(String userid, String confirmpassword) throws ClassNotFoundException, SQLException {

	
		// Step: 1 loading the driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step 2: opening the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseapp", "root", "root");

		// Step 3: Preparing the queries
		PreparedStatement ps = con.prepareStatement("update  userpasword set password=? where userId=?");

		// Step 4: Setting the values
		ps.setString(1, confirmpassword);

		ps.setString(2, userid);

		// Step 5: Executing the queries
		ps.executeUpdate();
		
		
		PreparedStatement ps2 = con.prepareStatement("update  registration set loginAttemps=? where pan=?");

		// Step 4: Setting the values
		ps2.setInt(1, 1);

		ps2.setString(2, userid);

		// Step 5: Executing the queries
		ps2.executeUpdate();
		
		
		

	}

}
