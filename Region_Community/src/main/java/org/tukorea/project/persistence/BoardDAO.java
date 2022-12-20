package org.tukorea.project.persistence;

import java.util.List;

import org.tukorea.project.domain.BoardVO;
import org.tukorea.project.domain.CommentVO;

public interface BoardDAO {
		//리스트 
		public List<BoardVO> readList(String residence, String residenceGu) throws Exception;
		// 게시글 작성
		public void boardWrite(BoardVO board) throws Exception;
		// 내 게시글 보기
		public BoardVO read(int num) throws Exception;
		// 게시글 수정
		public void update(BoardVO board) throws Exception;
		// 게시글 삭제
		public void delete(int num) throws Exception; 
		// 댓글 보기
		public List<CommentVO> comment(String residence, String residenceGu) throws Exception;
		// 댓글 추가
		public void commentInsert(CommentVO comment) throws Exception;
		//댓글 삭제
		public void commentDelete(int Comment_num) throws Exception;
		// 게시판 테이블 전체 삭제
		public void commentDeletes(int board_num) throws Exception;
}
