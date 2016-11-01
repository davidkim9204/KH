package java0803_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import java0803_jdbc.dto.MemDTO;

/*
 * 1.ClassNotFoundException 
 *  해결)JRE System Library에서 ojdbc14.jar파일 확인
 *  
 * 2.java.sql.SQLException: IO 예외 상황: The Network Adapter ... 
 *   Listener refused....
 *   제어판->관리도구->서비스->OracleServiceXE 하고 OracleXETNSListener을 시작한다. 
 * 
 * 3. java.sql.SQLException: ORA-XXXX
 *   쿼리문을 확인
 *   
 */

/*
 * java.sql.PreparedStatement
 * 1 반복되는 쿼리문의 수행에 사용한다.
 * 2 미리 정의된 SQL문을 수행하기 때문에 Statement에 비해 속도가 빠르다.
 * 3 위치표시자(placeholder)(?)를 사용하여 쿼리문을 간략하게 작성한다.
 */

public class MemDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*
	 * 싱글톤 패턴
	 * : 하나의 객체만을 생성해서 사용할 수 있도록 설계한 구조이다.
	 * 1 생성자의 접근제어자는 private
	 * 2 객체자신을 생성을 한다.
	 * 3 생성된 객체를 넘겨줄 수 있는 메소드를 정의한다.
	 */

	private static MemDAO dao = new MemDAO();

	private MemDAO() {

	}

	public static MemDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {

		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.OracleDriver");

		// 2. 서버연결
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

	public ArrayList<MemDTO> listMethod() {
		ArrayList<MemDTO> aList = new ArrayList<MemDTO>();

		try {
			conn = init();
			// 3. 쿼리문을 실행하기 위해 Statment 타입의 객체를 리턴
			stmt = conn.createStatement();
			// 4. 쿼리문을 실행한다.
			String sql = "SELECT * FROM mem ORDER BY num";
			rs = stmt.executeQuery(sql);

			// 5. rs의 값을 dto 객체를 새로 만들어 다음 레코드값이 없을때까지 반복시켜
			// 값을 셋팅한다
			while (rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));

				// 6. ArrayList에 dto객체의 값을 추가시킴.
				aList.add(dto);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;
	}// end listMethod()

	public ArrayList<MemDTO> listMethod(String a) {
		ArrayList<MemDTO> aList = new ArrayList<MemDTO>();

		try {
			conn = init();
			String sql = "SELECT * FROM mem WHERE name LIKE ? ORDER BY num";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+a+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));

				aList.add(dto);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;
	}// end listMethod()

	public void insertMethod(MemDTO dto) {
		try {
			conn = init();
			// stmt = conn.createStatement();
			// String sql = "INSERT INTO mem(num, name, age, loc)
			// VALUES(mem_num_seq.NEXTVAL,'"+dto.getName()+"',"+
			// dto.getAge()+",'"+dto.getLoc()+"')";
			// stmt.executeUpdate(sql);

			String sql = "INSERT INTO mem(num, name, age, loc) VALUES(mem_num_seq.NEXTVAL,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getLoc());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

	}// end insertMethod()

	public int insertMethod(ArrayList<MemDTO> mdata) {

		int cnt[] = null;

		try {
			conn = init();

			String sql = "INSERT INTO mem(num, name, age, loc) VALUES(mem_num_seq.NEXTVAL,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < mdata.size(); i++) {
				MemDTO dto = mdata.get(i);
				pstmt.setString(1, dto.getName());
				pstmt.setInt(2, dto.getAge());
				pstmt.setString(3, dto.getLoc());
				pstmt.addBatch(); // 한개가아닌 여러개일때는 update가 아닌 batch사용
			}
			cnt = pstmt.executeBatch();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return cnt.length;
	}// end insertMethod()

	public void updateMethod(HashMap<String, Object> map) {
		try {
			conn = init();
			String sql = "UPDATE mem SET name=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) map.get("name"));
			pstmt.setInt(2, (Integer) map.get("num"));
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

	} // end updateMethod()

	public void deleteMethod(int num) {
		try {
			conn = init();
			String sql = "DELETE FROM mem WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
	}

}// end class
