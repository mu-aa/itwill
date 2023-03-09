package xyz.itwill10.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.RestBoard;
import xyz.itwill10.mapper.RestBoardMapper;

@Repository
@RequiredArgsConstructor
public class RestBoardDAOImpl implements RestBoardDAO {
	private final SqlSession session;

	@Override
	public int insertRestBoard(RestBoard restBoard) {
		return session.getMapper(RestBoardMapper.class).insertRestBoard(restBoard);
	}

	@Override
	public int updateRestBoard(RestBoard restBoard) {
		return session.getMapper(RestBoardMapper.class).updateRestBoard(restBoard);
	}

	@Override
	public int deleteRestBoard(int num) {
		return session.getMapper(RestBoardMapper.class).deleteRestBoard(num);
	}
	
	@Override
	public int selectRestBoardCount() {
		return session.getMapper(RestBoardMapper.class).selectRestBoardCount();
	}

	@Override
	public RestBoard selectRestBoard(int num) {
		return session.getMapper(RestBoardMapper.class).selectRestBoard(num);
	}

	@Override
	public List<RestBoard> selectRestBoardList(Map<String, Object> map) {
		return session.getMapper(RestBoardMapper.class).selectRestBoardList(map);
	}
}