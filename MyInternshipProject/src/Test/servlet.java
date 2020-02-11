package Test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName=request.getParameter("firstname");
		String middlename=request.getParameter("middlename");	
		String lastname=request.getParameter("lastname");
		String mobile=request.getParameter("mobile");
		String dob=request.getParameter("dob");
		String currentaddress=request.getParameter("currentaddress");
		String permanentaddress=request.getParameter("permanentaddress");
		String panid=request.getParameter("panid");
		String aadhaar=request.getParameter("aadhaar");
		String mobilenumber=request.getParameter("mobilenumber");
		String emailId=request.getParameter("emailId");		
		
		System.out.println(firstName);
		
		jdbc j= new jdbc();
		try {
			j.insert(firstName,middlename,lastname,mobile,dob,currentaddress,permanentaddress,panid,aadhaar,mobilenumber,emailId);
			response.sendRedirect("index.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
