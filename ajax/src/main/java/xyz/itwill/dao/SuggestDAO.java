package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.SuggestDTO;

public class SuggestDAO extends JdbcDAO {
	private static SuggestDAO _dao;
	
	private SuggestDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new SuggestDAO();
	}
	
	public static SuggestDAO getDAO() {
		return _dao;
	}
	
	//검색어를 전달받아 SUGGEST 테이블에서 해당 검색어가 포함된 제시어 관련 정보를
	//모두 검색하여 반환하는 메소드
	public List<SuggestDTO> selectSuggestList(String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<SuggestDTO> suggestList=new ArrayList<SuggestDTO>();
		
		try {
			con=getConnection();
			
			String sql="select rownum, temp.* from (select * from suggest where upper(word) "
					+ "like '%'||upper(?)||'%' order by word) temp where rownum<=10";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SuggestDTO suggest=new SuggestDTO();
				suggest.setWord(rs.getString("word"));
				suggest.setUrl(rs.getString("url"));
				suggestList.add(suggest);
			}
		} catch (SQLException e) {
			System.out.println("[ERROR]selectSuggestList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return suggestList;
	}
}
