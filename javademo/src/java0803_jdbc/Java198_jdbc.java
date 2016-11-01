package java0803_jdbc;

import java.util.ArrayList;

import java0803_jdbc.dao.MemDAO;
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
public class Java198_jdbc {
public static void main(String[] args) {
	MemDAO dao = MemDAO.getInstance();
	dao.insertMethod(new MemDTO("이영희",30,"경기"));
	
//	HashMap<String, Object>map=new HashMap<String, Object>();
//	map.put("num", 1); 
//	map.put("name", "공작");
//	dao.updateMethod(map);
	
//	dao.deleteMethod(1); //
	
	ArrayList<MemDTO> mData=new ArrayList<MemDTO>();
	mData.add(new MemDTO("first",8,"세종"));
	mData.add(new MemDTO("first",5,"세종"));
	mData.add(new MemDTO("first",3,"세종"));		
	int cnt=dao.insertMethod(mData);
	System.out.println("삽입갯수"+cnt);
	
	
	
	
//delete이후에 이것으로 수정. 2개다 할 수 있다.	
	ArrayList<MemDTO>aList = dao.listMethod("영");
	
//	ArrayList<MemDTO>aList = dao.listMethod();
	for (int i=0; i<aList.size();i++){
		MemDTO dto=aList.get(i);
		System.out.printf("%d %s %d %s\n", dto.getNum(),dto.getName(),dto.getAge(),dto.getLoc());
	}
}
}
