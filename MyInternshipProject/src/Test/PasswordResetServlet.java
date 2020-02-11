package Test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PasswordResetServlet
 */
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordResetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid= request.getParameter("userid");
		String oldpassword= request.getParameter("oldpassword");
		String newpassword= request.getParameter("newpassword");
		String confirmpassword= request.getParameter("confirmpassword");
		
		
		
		if(newpassword.equals(confirmpassword)) {
		 
			try {
				int check=new LoginJDBC().check(userid, oldpassword);
				
				if(check >0) {
					PasswordResetJDBC j= new PasswordResetJDBC();
					j.updatePassword(userid,confirmpassword);
					response.sendRedirect("index.jsp");
				}
				
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		else {
			response.sendRedirect("PasswordReset.jsp");
		}
		
		
		
		
		
		
	}

}
