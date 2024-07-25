package JDBCUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnect {

	static Connection connect = null;
	PreparedStatement pstmnt=null;
	
	private String vname;
	private String vcompany;
	private String vcost;
	private boolean status;
	
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public void setVcompany(String vcompany) {
		this.vcompany = vcompany;
	}

	public void setVcost(String vcost) {
		this.vcost = vcost;
	}

	public String getVname() {
		return vname;
	}

	public String getVcompany() {
		return vcompany;
	}

	public String getVcost() {
		return vcost;
	}

	public void getParam() throws SQLException {
		
		System.out.println("inside GETPAram");
		String query = "INSERT INTO vaccine_info(id,vaccine_name,vaccine_company,vaccine_cost) VALUES(?,?,?,?)";
		connect = JDBCUtility.getDBConnection();
		if(connect!= null) {
			try {
				pstmnt= connect.prepareStatement(query);
			} catch (SQLException e) {
				System.out.println("Query added to stmnt failed");
			}
		}else {
			System.out.println("Connect variable is null");
		}
		
		if(pstmnt != null) {
			pstmnt.setInt(1, 12);
			pstmnt.setString(2, getVname());
			pstmnt.setString(3, getVcompany());
			pstmnt.setString(4, getVcost());
			
			status = pstmnt.execute();
			System.out.println("STATUS of execute " +status +" "+getVname() );
			if(status) {
				System.out.println("FAILED");
			}
			else {
				System.out.println("Updated Successfully");
			}
		}
		
		
	}
	
	
}
