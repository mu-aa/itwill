package xyz.itwill10.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardMapper {
	int insertRestBoard(RestBoard restBoard);
	int updateRestBoard(RestBoard restBoard);
	int deleteRestBoard(int num);
	int selectRestBoardCount();
	RestBoard selectRestBoard(int num);
	List<RestBoard> selectRestBoardList(Map<String, Object> map);
}