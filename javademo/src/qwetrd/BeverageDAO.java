package qwetrd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beverageDTO.BeverageDTO;



public class BeverageDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	

	private static BeverageDAO dao=new BeverageDAO();
	private BeverageDAO() {

	}
	
	public static BeverageDAO getInstance(){
		if(dao==null)
			dao=new BeverageDAO();
		return dao;
	}
	
	
	private Connection init() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2. 
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);
	}//end init()	
	

	private void stop() {

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end stop()
	
	public ArrayList<BeverageDTO> searchmethod(String name, String price) {
		ArrayList<BeverageDTO> arr = new ArrayList<BeverageDTO>();

		String[] strarr = price.split("~");
		
		
		try {
			conn = init();

			String sql = "select * from b_beverage where beverage_type =? "
					+ " and beverage_price >= ?" + "and beverage_price <= ?"
					+ " order by beverage_price";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, Integer.parseInt(strarr[0]));
			pstmt.setInt(3, Integer.parseInt(strarr[1]));
			
			//pstmt.setString(1, "%" + serch.toLowerCase() + "%");
			//pstmt.setString(2, serch);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BeverageDTO dto = new BeverageDTO();
				dto.setBeverage_id(rs.getInt("beverage_id"));
				dto.setCafe_id(rs.getInt("cafe_id"));
				dto.setBeverage_price(rs.getInt("beverage_price"));
				dto.setBeverage_type(rs.getString("beverage_type"));
				dto.setBeverage_name(rs.getString("beverage_name"));
				dto.setBeverage_text(rs.getString("beverage_text"));
				arr.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return arr;
	}
	
	

	
	
	
}//end class
