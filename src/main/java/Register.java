

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBCUtility.JDBCConnect;


@WebServlet("/regist")
public class Register extends HttpServlet {
	
    public Register() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside doPost");
		JDBCConnect jdbc = new JDBCConnect();
		
		String vname = request.getParameter("vname");
		String vcmpny = request.getParameter("vcmpny");
		String vcost = request.getParameter("vcost");
		
		
		jdbc.setVname(vname);
		jdbc.setVcompany(vcmpny);
		jdbc.setVcost(vcost);
		
		try {
			jdbc.getParam();
		} catch (SQLException e) {
			
			System.out.println("Failed to connect to DB");
		}
		
		   if(jdbc.isStatus()) {
			   response.sendRedirect("/VaccineRegistration/UnSuccessful.jsp");
		   }
		   else {
			   response.sendRedirect("/VaccineRegistration/success.jsp");
		   }
		
	}

}
