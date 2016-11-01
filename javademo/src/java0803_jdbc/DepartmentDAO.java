package java0803_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO(data access Object) : 데이터 접근 객체
public class DepartmentDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	//java.sql패키치에 있다.
	
	public DepartmentDAO(){
		
	}
	
	//여러개 담아
	public ArrayList<DepartmentDTO>listMethod(){
		ArrayList<DepartmentDTO>aList=new ArrayList<DepartmentDTO>();
		//db연동후엔 반드시 연동을 끊어주어야한다.
		//안끊어주면 문제발생! 다운이 될 수 있다.
		//접근할 수 있는 클라이언트 갯수가 정해져있다.
		//db가 종료를 인지하지 못한다.
		//close해서 닫아주어야 한다. 반드시 final에서 실행해야한다. 항상 실행되니까.
		
		
		
		try {
			//1.드리이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 서버연결
			String url="jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String username="hr";
			String password="a1234";
			conn=DriverManager.getConnection(url, username, password);
			
			//3. 쿼리문을 실행하기 위해 Statement타입의 객체를 리턴
			//실제 쿼리문을 할 수 있는게 state이다.
			stmt=conn.createStatement();
			
			
			//4. 쿼리문을 실행한다.
			//문자열로 쿼리문 작성
			String sql="select*from departments order by department_id";
			//select 결과값 리턴
			rs=stmt.executeQuery(sql); //데이터 베이스 칼럼 레코드ㅡ를리턴하는 것. 칼럼별로 인덱스 번호가1234순이다. 0이아님.
			
			//커서가 맨오른쪽 상단에서 존재하다 next로 이동한다.
			//굳이 하나씩 arraylist에 넘겨서 처리하는 이유는?
			//dto를 arraylist에 추가하여 arraylist를 리턴한다.
			//???null값이 리턴되므로? close??
			
			while(rs.next()){
				DepartmentDTO dto = new DepartmentDTO(); //이 문장을 와일문 밖에서 선언하면. 마지막이 다 채워버린다. 
				//안일때는 저장되는 레코드의 주소가 다르지만 dto문이 밖이면 같은 주소에 계속 넣는다.
				//바로 멤머변수 호출 불가.
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setDepartment_name(rs.getString("department_name")); //레코드 가져오려면 칼럼명 넣으면된다.
				dto.setManager_id(rs.getInt("manager_id"));
				dto.setLocation_id(rs.getInt("location_id"));
				 aList.add(dto);
				 //while안 이만큼이 한싸이클이다.
				
				
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			//역순으로 닫는다.
			//rs가 null인 경우에 close를 호출할 수 없다.
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return aList;
		
	}
	
}
//오류를 찾을때 내가 만든 것부터 찾아서 확인한다.