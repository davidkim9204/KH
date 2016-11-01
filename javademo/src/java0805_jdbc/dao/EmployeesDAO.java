package java0805_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java0803_jdbc.dto.MemDTO;
import java0804_jdbc.dto.DepartmentsDTO;
import java0804_jdbc.dto.EmployeesDTO;
import java0804_jdbc.dto.LocationsDTO;

public class EmployeesDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 싱글톤 패턴을 활용해서?
	private static EmployeesDAO dao = new EmployeesDAO();

	private EmployeesDAO() {

	}

	public static EmployeesDAO getInstance() {
		return dao;
	}

	private Connection init() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";

		return DriverManager.getConnection(url, username, password);

	}

	private void stop() {

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public ArrayList<EmployeesDTO> listMethod() {
		ArrayList<EmployeesDTO> aList = new ArrayList<EmployeesDTO>();

		try {
			// 여기서 호출에서 사용
			conn = init();

			stmt = conn.createStatement();

			String sql = "select*from mem order by num";

			rs = stmt.executeQuery(sql); // 데이터 베이스 칼럼 레코드ㅡ를리턴하는 것. 칼럼별로 인덱스
											// 번호가1234순이다. 0이아님.

			while (rs.next()) {
				MemDTO dto = new MemDTO(); // 이 문장을 와일문 밖에서 선언하면. 마지막이 다 채워버린다.
				// 안일때는 저장되는 레코드의 주소가 다르지만 dto문이 밖이면 같은 주소에 계속 넣는다.
				// 바로 멤머변수 호출 불가.
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name")); // 레코드 가져오려면 칼럼명 넣으면된다.
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				aList.add(dto);
				// while안 이만큼이 한싸이클이다.
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;

	}