package part01;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/*
 * Template 클래스
 * 1. 개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고 있다.
 * 2. JDBC뿐만 아니라 myBatis, JMS와 같은 다양한 기술에 대해 템플릿을 제공한다.
 * 3. 예로 JDBC인 경우 JdbcTemplate클래스를 제공하고 있는데, JdbcTemplate클래스를 사용함으로써
 * 	  예외처리 및 커넥션 관리를 위한 중복된 코드를 줄이거나 없앨 수 있다. (알아서 예외 처리 해줌)
 * 
 * 								Java JDBC API일 때	Spring JDBC일 때 
 * 		select 					executeQuery()		query()
 * 		insert, update, delete  executeUpdate()		update()		-> 받을 때는 무조건 Object[] 로 받아야함.
 */
public class MemDaoImp implements MemDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public MemDaoImp(){
		
	}
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//query(a,b) a=쿼리문 b=쿼리문을 받아(select에서 발생한 결과) 처리해줄 객체 => while(rs.next()){} 이거 결과 부분
	//이부분 잘 모르겠음 설명좀
	@Override
	public List<MemDTO> list() {
		String sql = "select * from mem order by num desc";
		List<MemDTO> list= jdbcTemplate.query(sql, new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto= new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			};
		});
		return list;
	}

	@Override
	public void insertMethod(MemDTO dto) {
		String sql = "insert into mem values(mem_num_seq.nextval,?,?,?)";
		Object[] args = new Object[] {dto.getName(), dto.getAge(), dto.getLoc()} ;
		jdbcTemplate.update(sql, args);	
		
	}

	@Override
	public void updateMethod(MemDTO dto) {
		String sql = "update mem set name=? where num=?";
		Object[] args = new Object[] {dto.getName(), dto.getNum()};
		jdbcTemplate.update(sql, args);
		
	}

	@Override
	public void deleteMethod(int num) {
		String sql ="delete from mem where num=?";
		Object[] args= new Object[] {num};
		jdbcTemplate.update(sql, args);
		
	}

	@Override
	public MemDTO one(int num) {
		String sql = "select * from mem where num =?";
		Object[] args= new Object[] {num};
		/*MemDTO dt=*/
		//queryForObject는 리스트가 아니고 하나만 구하는거.
		return jdbcTemplate.queryForObject(sql, args, new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemDTO dto=new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			};
		} );
		
		//return dt;
	}

	
	@Override
	public int countMethod() {
		String sql = "select count(*) from mem";		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {
			
			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				//return rs.getInt("count(*)");
				//(그냥 인덱스 값을 줘도 됨);
				return rs.getInt(1);
			}
		});	
	}

}//end class
