package java0804_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java0804_jdbc.dto.EmpDTO;

public class EmpDAO {
	
	private static EmpDAO dao = new EmpDAO();

	

	public static EmpDAO getInstance() {
		return dao;
	}

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private EmpDAO() {
		// TODO Auto-generated constructor stub
	}

	private Connection init() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);

	}// end init()

	private void stop() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// end stop()

	public ArrayList<EmpDTO> searchMethod(String word) {

		ArrayList<EmpDTO> aList = new ArrayList<EmpDTO>();

		try {
			conn = init();
			String sql = "SELECT employee_id, first_name, salary, hire_date FROM employees WHERE upper(first_name) LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + word.toUpperCase() + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setHire_date(rs.getDate("hire_date"));

				aList.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;
	}// end searchMethod()

}// end class
