package org.tukorea.project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.project.domain.BoardVO;
import org.tukorea.project.domain.CommentVO;
import org.tukorea.project.persistence.BoardDAO;


@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private BoardDAO boardDAO;
	
	CommentVO comment = new CommentVO();
	
	
	private static final String namespace = "org.tukorea.project.mapper.BoardMapper";
	@Override
	public List<BoardVO> boardList(String residence, String residenceGu) throws Exception {
		// TODO Auto-generated method stub
	
		return boardDAO.readList(residence, residenceGu);
	}

	@Override
	public void boardWrite(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".boardWrite", board);	
	}

	@Override
	public BoardVO read(int num) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.read(num);
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.update(board);
	}
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		commentDeletes(num); 
		boardDAO.delete(num); 
	}

	@Override
	public List<CommentVO> comment(String residence, String residenceGu) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.comment(residence, residenceGu);
	}
	
	@Override
	public void commentInsert(CommentVO comment) throws Exception {
		// TODO Auto-generated method stub
		
		boardDAO.commentInsert(comment);
	}

	@Override
	public void commentDelete(int Comment_num) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.commentDelete(Comment_num);
		
	}

	@Override
	public void commentDeletes(int board_num) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.commentDeletes(board_num);
		
	}
}
