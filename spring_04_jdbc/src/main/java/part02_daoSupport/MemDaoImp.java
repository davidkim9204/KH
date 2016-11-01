package part02_daoSupport;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;



//JdbcDaoSupport : getJdbcTemplate()클래스를 상속 받아 구현해서 part01/jdbc에서 2번 단계를 생략
public class MemDaoImp extends JdbcDaoSupport implements MemDao{
	
	public MemDaoImp(){
		
	}
	
	//query(a,b) a=쿼리문 b=쿼리문을 받아(select에서 발생한 결과) 처리해줄 객체
	//이부분 잘 모르겠음 설명좀
	@Override
	public List<MemDTO> list() {
		String sql = "select * from mem order by num desc";
		List<MemDTO> list=getJdbcTemplate().query(sql, new RowMapper<MemDTO>() {
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
		getJdbcTemplate().update(sql, args);	
		
	}

	@Override
	public void updateMethod(MemDTO dto) {
		String sql = "update mem set name=? where num=?";
		Object[] args = new Object[] {dto.getName(), dto.getNum()};
		getJdbcTemplate().update(sql, args);
		
	}

	@Override
	public void deleteMethod(int num) {
		String sql ="delete from mem where num=?";
		Object[] args= new Object[] {num};
		getJdbcTemplate().update(sql, args);
		
	}

	@Override
	public MemDTO one(int num) {
		String sql = "select * from mem where num =?";
		Object[] args= new Object[] {num};
		/*MemDTO dt=*/
		return getJdbcTemplate().queryForObject(sql, args, new RowMapper<MemDTO>() {
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
		return getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				//return rs.getInt("count(*)");
				//(그냥 인덱스 값을 줘도 됨);
				return rs.getInt(1);
			}
		});	
	}

}//end class
