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

public class MemDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 싱글톤 패턴을 활용해서?
	private static MemDAO dao = new MemDAO();

	private MemDAO() {

	}

	public static MemDAO getInstance() {
		return dao;
	}

	private Connection init() throws SQLException, ClassNotFoundException { // 예외처리
																			// 넘긴다.

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

	public ArrayList<MemDTO> listMethod() {
		ArrayList<MemDTO> aList = new ArrayList<MemDTO>();

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

	}// end listMethod()

	
	public void insertMethod(MemDTO dto) {
		try {
			conn = init();
			String sql = "insert into mem(num,name,age,loc) values(mem_num_seq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getLoc());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			stop();
			
		}
		
		
	}

//		// stmt=conn.createStatement();
//		// //ㅑㅜㄴㄷㄳ ㅑㅜ새 ㅡ드 ㅍ미ㅕㄷㄴ(mem_num_seq.nextval,
//		// String sql="insert into mem(num,name,age,loc)
//		// values(mem_num_seq.nextval,'"+dto.getName()+"',"+dto.getAge()+",'"+dto.getLoc()+"')";
//		// stmt.executeUpdate(sql);
//		// 이부분 시퀀스로 이어져서 oracle파트 숙지 요망
//	
//
//	}// end insertMethod()

	//overloading
	public int insertMethod(ArrayList<MemDTO> mdata) {
		int cnt[]=null;
		try {
			conn = init();
			String sql = "insert into mem(num,name,age,loc) values(mem_num_seq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<mdata.size();i++){
				MemDTO dto= mdata.get(i);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getLoc());
			pstmt.addBatch();
			}
			cnt=pstmt.executeBatch();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			stop();
			
		}
		
	return cnt.length;

	}//end insertMethod()
	

	public void updateMethod(HashMap<String,Object>map){
		try {
			conn=init();
			String sql="update mem set name=? where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, (String)map.get("name"));
			pstmt.setInt(2,(Integer)map.get("num"));
			pstmt.executeUpdate();
	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
			stop();
		}
		
		
	}//end updateMethod()	
	
	
//	public void deleteMethod(int num){
//		try {
//			conn=init();
//			String sql="delete from mem where num=?";
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, (String)map.get("name"));
//			pstmt.setInt(2,(Integer)map.get("num"));
//			pstmt.executeUpdate();
//	
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{ 
//			stop();
//		}
//	
//	}// end upedateMethod()

}

// 수정 제대로 안됨 확인 요망.
//overloading안되어있음.

//prepare가 더 간결하다. 