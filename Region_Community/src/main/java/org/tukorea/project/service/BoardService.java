package org.tukorea.project.service;

import java.util.List;

import org.tukorea.project.domain.BoardVO;
import org.tukorea.project.domain.CommentVO;

public interface BoardService {
	public List<BoardVO> boardList(String residence, String residenceGu) throws Exception;
	public void boardWrite(BoardVO board) throws Exception;
	public BoardVO read(int num) throws Exception;
	public void updateBoard(BoardVO board) throws Exception;
	public void delete(int num) throws Exception;
	public List<CommentVO> comment (String residence, String residenceGu) throws Exception;
	public void commentInsert(CommentVO comment) throws Exception;
	public void commentDelete(int Comment_num) throws Exception;
	public void commentDeletes(int board_num) throws Exception;
}
