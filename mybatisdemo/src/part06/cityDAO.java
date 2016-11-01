package part06;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class cityDAO {

	SqlSession session;
	
	public cityDAO() {
		
		String resource = "config/configuration.xml";

		try {
			Reader reader = Resources.getResourceAsReader(resource);

			SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();

			SqlSessionFactory factory = build.build(reader);

			session = factory.openSession(true);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	} //end cityDAO()
	
	public List<EmployeeDTO> printMethod(){
		return session.selectList("city.all");
	}
	
	
	
}//end class
