package org.tukorea.project.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.project.domain.BoardVO;
import org.tukorea.project.domain.CommentVO;

@Service
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.project.mapper.BoardMapper";
	
	public List<BoardVO> readList(String residence) throws Exception { // 거주지를 매개변수로 받아 리스트를 출력하는 함수
		// TODO Auto-generated method stub
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		
		boardlist = sqlSession.selectList(namespace+".board_List", residence);
	
		return boardlist;
	}
	@Override
	public void boardWrite(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.insert(namespace+".boardWrite", board);
	}
	@Override
	public BoardVO read(int num) throws Exception {
		// TODO Auto-generated method stub
		BoardVO boardread = sqlSession.selectOne(namespace+".read", num);
		
		return boardread;
	}
	@Override
	public void update(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".update", board);
		
	}
	@Override
	public void delete(int num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".delete", num);
	}
	
	@Override
	public List<CommentVO> comment(String residence) throws Exception {
		// TODO Auto-generated method stub
		List<CommentVO> commentlist = new ArrayList<CommentVO>();
		
		commentlist = sqlSession.selectList(namespace+".comment", residence);
	
		return commentlist;
	}
	@Override
	public void commentInsert(CommentVO comment) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".commentinsert", comment);
		
	}
	@Override
	public void commentDelete(int Comment_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".commentdelete", Comment_num);
	}
	@Override
	public void commentDeletes(int board_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".commentdeletes", board_num);
	}
}
