package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc {

	public void insert(String firstName, String middlename, String lastname, String mobile, String dob,
			String currentaddress, String permanentaddress,String panid, String aadhaar, String mobilenumber, String emailId) throws ClassNotFoundException, SQLException {
		
		//Step: 1 loding the driver
		Class.forName("com.mysql.jdbc.Driver"); 
		
		//Step 2: opening the connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseapp","root","root");
		
		
		
		//Step 3: Preparing the queries
		PreparedStatement ps = con.prepareStatement("insert into Registration "
				+ "(firstName,middlename,lastname,mobile,dob,currentaddress,permanentaddress ,Pan,aadhaar,mobilenumber,emailId,loginAttemps ) values (?,?,?,?,?,?,?,?,?,?,?,?)");
		
		//Step 4: Setting the values 
		ps.setString(1, firstName);
		ps.setString(2, middlename);
		ps.setString(3, lastname);
		ps.setString(4, mobile);
		ps.setString(5, dob);
		ps.setString(6, currentaddress);
		ps.setString(7, permanentaddress);
		ps.setString(8, panid);
		ps.setString(9, aadhaar);
		ps.setString(10, mobilenumber);
		ps.setString(11, emailId);
		ps.setInt(12, 0);

		
		//Step 5: Executing the queries
		int regId=	ps.executeUpdate();
		System.out.println(regId);
		
		String userId=panid;
		int password=new passwordgenerator().generate();
		new  MailSender ().SendMailComplete(emailId, userId,password);
		
		PreparedStatement ps2 = con.prepareStatement("insert into userpasword (userId,password,regId ) values (?,?,?)");
		ps2.setString(1, userId);
		ps2.setInt(2, password);
		ps2.setInt(3, regId);
		ps2.executeUpdate();
		
		
		
	}

}
