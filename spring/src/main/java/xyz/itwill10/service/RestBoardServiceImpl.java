package xyz.itwill10.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.RestBoardDAO;
import xyz.itwill10.dto.RestBoard;

@RequiredArgsConstructor
@Service
public class RestBoardServiceImpl implements RestBoardService {
	private final RestBoardDAO restBoardDAO;

	@Transactional
	@Override
	public void addRestBoard(RestBoard restBoard) {
		restBoardDAO.insertRestBoard(restBoard);
	}

	@Transactional
	@Override
	public void modifyRestBoard(RestBoard restBoard) {
		/*
		if(restBoardDAO.selectRestBoard(restBoard.getNum())==null) {
			throw new Exception("해당 게시글을 찾을 수 없습니다.");
		} */
		restBoardDAO.updateRestBoard(restBoard);
	}

	@Transactional
	@Override
	public void removeRestBoard(int num) {
		restBoardDAO.deleteRestBoard(num);
	}
	
	@Override
	public int getRestBoardCount() {
		return restBoardDAO.selectRestBoardCount();
	}

	@Override
	public RestBoard getRestBoard(int num) {
		return restBoardDAO.selectRestBoard(num);
	}

	@Override
	public List<RestBoard> getRestBoardList(Map<String, Object> map) {
		return restBoardDAO.selectRestBoardList(map);
	}
}