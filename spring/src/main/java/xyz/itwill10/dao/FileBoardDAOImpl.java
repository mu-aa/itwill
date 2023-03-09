package xyz.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.mapper.FileBoardMapper;

@RequiredArgsConstructor
@Repository
public class FileBoardDAOImpl implements FileBoardDAO {
	private final SqlSession session;

	@Override
	public int insertFileBoard(FileBoard fileBoard) {
		return session.getMapper(FileBoardMapper.class).insertFileBoard(fileBoard);
	}

	@Override
	public int deleteFileBoard(int num) {
		return session.getMapper(FileBoardMapper.class).deleteFileBoard(num);
	}

	@Override
	public FileBoard selectFileBoard(int num) {
		return session.getMapper(FileBoardMapper.class).selectFileBoard(num);
	}

	@Override
	public List<FileBoard> selectFileBoardList() {
		return session.getMapper(FileBoardMapper.class).selectFileBoardList();
	}
}