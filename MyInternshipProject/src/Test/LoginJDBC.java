package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJDBC {

	public int check(String userid, String password) throws SQLException, ClassNotFoundException {
		int result = 0;
		// Step: 1 loading the driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step 2: opening the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseapp", "root", "root");

		
			// Step 3: Preparing the queries
			PreparedStatement ps = con
					.prepareStatement("select count(*) from userpasword where userId=? and password=?");

			// Step 4: Setting the values
			ps.setString(1, userid);
			ps.setString(2, password);

			// Step 5: Executing the queries
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
				System.out.println(result);
			}
		return result;

	}

	public int checkLoginAttempts(String userid, String password) throws SQLException, ClassNotFoundException {
		// Step: 1 loading the driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step 2: opening the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseapp", "root", "root");

		int loginAttempts = 0;
		PreparedStatement ps2 = con.prepareStatement("select loginAttemps from registration where panid=?");
		ps2.setString(1, userid);
		ResultSet rs2 = ps2.executeQuery();
		while (rs2.next()) {
			loginAttempts = rs2.getInt(1);
			System.out.println(loginAttempts);
		}
		return loginAttempts;
	}
}
