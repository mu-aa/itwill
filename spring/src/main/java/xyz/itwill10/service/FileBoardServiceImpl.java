package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.FileBoardDAO;
import xyz.itwill10.dto.FileBoard;

@RequiredArgsConstructor
@Service
public class FileBoardServiceImpl implements FileBoardService {
	private final FileBoardDAO fileBoardDAO;

	@Override
	public void addFileBoard(FileBoard fileBoard) {
		fileBoardDAO.insertFileBoard(fileBoard);
	}

	@Override
	public void removeFileBoard(int num) {
		fileBoardDAO.deleteFileBoard(num);
	}

	@Override
	public FileBoard getFileBoard(int num) {
		return fileBoardDAO.selectFileBoard(num);
	}

	@Override
	public List<FileBoard> getFileBoardList() {
		return fileBoardDAO.selectFileBoardList();
	}
}