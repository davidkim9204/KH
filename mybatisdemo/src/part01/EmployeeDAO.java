package part01;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import part01.dto.EmployeeDTO;

public class EmployeeDAO {
	SqlSession session;
		public EmployeeDAO(){
			//1. 트랜잭션이 설정되어 있는 파일의 경로를 정의한다.
			String resource="config/configuration.xml";
			
			try {
				//2. 설정파일을 로딩하기 위해서 입력스트립과 연결한다.
				Reader reader=Resources.getResourceAsReader(resource);
				
				//3. 설정파일을 저장하기 위한 팩토리를 생성해줄 수 있는 빌더를 생성한다.
				SqlSessionFactoryBuilder build=new SqlSessionFactoryBuilder();
				
				//4. 설정파일의 정보를 읽어와 관래해주는 팩토리를 생성한다.
				SqlSessionFactory factory=build.build(reader);
				
				//5. 쿼리문에 접근할 수 있도록 sqlSession객체를 리턴한다. ()안에 true아니면 false를 넣어줘야함.
				//openSession()의 기본값은 false. true일 때와 false일 때의 차이는 커밋. 자동커밋을 설정하고 싶으면 true로 설정.
				session=factory.openSession(true);
				
				//6. 입력스트림 연결을 종료한다.
				reader.close();				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//end EmployeeDAO 
		
		public List<EmployeeDTO> allMethod(){
					//selectList의 리턴타입은 List	//(namespace.id)
			return session.selectList("emp.all");
		}
		
		public int countMethod(){
			return session.selectOne("emp.cnt");
		}
		
		public List<EmployeeDTO> searchMethod(String name){
			return session.selectList("emp.search",name);
		}

		public List<EmployeeDTO> searchMethod(HashMap<String,Object> map) {
			return session.selectList("emp.part", map);
		}
		
}//end class





