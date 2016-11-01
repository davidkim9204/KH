package guestdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import guestdemo.dto.BoardDTO;
import guestdemo.dto.PageDTO;

public class BoardDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDAO() {
	}

	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getInstance() {
		return dao;
	}

	private Connection start() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}// end start()

	private void end() throws SQLException {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}// end end()

	public int rowTotalCount(HashMap<String,String> map) {
		int cnt = -1;
		try {
			conn = start();
			String sql = "select count(*) from board";
			if(map.get("searchKey") != null){
				if(map.get("searchKey").equals("subject") || map.get("searchKey").equals("writer")){
					sql += " where " + map.get("searchKey") + " like '%" + map.get("searchWord") + "%'";
				}
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				// cnt=rs.getInt("count(*)")
				cnt = rs.getInt(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				end();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnt;
	}// end rowTotalCount()

	public List<BoardDTO> listMethod(PageDTO pdto) {
		List<BoardDTO> aList = new ArrayList<BoardDTO>();

		try {
			conn = start();
			String sql = "select b.*";
			sql += " from(select rownum as rm, a.*";
			sql += " from(select * from board";
			if (pdto.getSearchKey() != null) {
				if (pdto.getSearchKey().equals("subject") || pdto.getSearchKey().equals("writer")) {
					sql += " where " + pdto.getSearchKey() + " like '%" + pdto.getSearchWord() + "%'";
				}
			}
			sql += " order by ref desc , re_step asc)a)b";
			sql += " where b.rm >=? and b.rm <=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getStartRow());
			pstmt.setInt(2, pdto.getEndRow());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setUpload(rs.getString("upload"));
				aList.add(dto);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				end();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return aList;
	}

	public BoardDTO viewMethod(int num) {
		BoardDTO dto = null;
		try {
			conn = start();
			String sql = "select * from board where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setSubject(rs.getString("subject"));
				dto.setEmail(rs.getString("email"));
				dto.setContent(rs.getString("content"));
				dto.setUpload(rs.getString("upload"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				end();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}// end viewMethod()

	public void readCountMethod(int num) {
		try {
			conn = start();
			String sql = "update board set readcount=readcount+1 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				end();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end readCountMethod()

	public void insertMethod(BoardDTO dto) {
		try {
			conn = start();

			// (오늘한 내용) 제목글이면 000000000000000000000
			if (dto.getRe_level() == 0) {
				String sql = "insert into board(num,reg_date,writer,email,subject,content,upload,ref,re_step,re_level)";
				sql += " values(board_seq.nextval,sysdate,?,?,?,?,?,board_seq.nextval,0,0)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getEmail());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getUpload());

			} else { //답변글이면
				String sql = "insert into board(num,reg_date,writer,email,subject,content,upload,ref,re_step,re_level) values(board_seq.nextval,sysdate,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getEmail());
				pstmt.setString(3, dto.getSubject());
				pstmt.setString(4, dto.getContent());
				pstmt.setString(5, dto.getUpload());
				pstmt.setInt(6, dto.getRef());
				pstmt.setInt(7, dto.getRe_step());
				pstmt.setInt(8, dto.getRe_level());
			}
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				end();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// end insertMethod()

	// 오늘한내용00000000000000
	public void reStepMethod(HashMap<String, Integer> map) {

		try {
			conn = start();
			String sql = "update board set re_step=re_step+1 where ref=? and re_step>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, map.get("ref"));
			pstmt.setInt(2, map.get("re_step"));
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				end();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end reStepMethod()

}// end class
