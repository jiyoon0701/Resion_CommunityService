package org.tukorea.project.controller;

import java.io.File;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.project.domain.BoardVO;
import org.tukorea.project.domain.CommentVO;
import org.tukorea.project.service.BoardService;
import org.tukorea.utils.UploadFileUtils;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Resource(name ="uploadPath")
	private String uploadPath;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board_write", method = RequestMethod.GET)
	public String boardWriteGet( @RequestParam("residence") String residence, @RequestParam("residenceGu") String residenceGu, Model model,  HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		model.addAttribute("id",session.getAttribute("id"));
		model.addAttribute("residence",residence);
		model.addAttribute("residenceGu",residenceGu);
		return "/board/board_write";
	}
	
	@RequestMapping(value = "/board_write", method = RequestMethod.POST)
	public String boardWritePost(BoardVO board,  Model model, RedirectAttributes redirect) throws Exception {
		MultipartFile imagefile = board.getImagefile();
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String fileName = null;
		
		if(!imagefile.isEmpty()) {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, imagefile.getOriginalFilename(), imagefile.getBytes()); 
		 board.setImage(fileName);
		} 
		else {
			 board.setImage(null);
		}
		
		boardService.boardWrite(board);
		 
		redirect.addAttribute("residence",board.getResidence() );
		redirect.addAttribute("residenceGu",board.getResidenceGu() );
		Thread.sleep(3000);
		
		return "redirect:/board/board";
		
	}

	@RequestMapping(value = "/commentdelete", method = RequestMethod.GET)
	public String commentDeleteGet(@ModelAttribute("comment") CommentVO comment , RedirectAttributes rttr) throws Exception {
		boardService.commentDelete(comment.getComment_num());
		rttr.addAttribute("residence",comment.getResidence());
		rttr.addAttribute("residenceGu",comment.getResidenceGu());
		return "redirect:/board/board";
	}  
	
	
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String boardGet(@RequestParam("residence") String residence, @RequestParam("residenceGu") String residenceGu,Model model, HttpServletRequest request) throws Exception {

		System.out.println("rere"+residence);
		List<BoardVO> board = boardService.boardList(residence, residenceGu);
		List<CommentVO> comment = boardService.comment(residence, residenceGu);
		HttpSession session = request.getSession();
		model.addAttribute("comment", comment);
		model.addAttribute("board",board);
		model.addAttribute("id", session.getAttribute("id"));   
		model.addAttribute("residence",residence);
		model.addAttribute("residenceGu",residenceGu);
		return "/board/board";
	}    
	
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public String commentPost(@ModelAttribute("comment") CommentVO comment, RedirectAttributes rttr) throws Exception {
		boardService.commentInsert(comment);
		rttr.addAttribute("residence",comment.getResidence());
		rttr.addAttribute("residenceGu",comment.getResidenceGu());
		return "redirect:/board/board";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteGet(@RequestParam("num") int num, Model model, RedirectAttributes rttr) throws Exception {
		BoardVO board = boardService.read(num);
		boardService.delete(board.getNum());

		rttr.addAttribute("residence",board.getResidence());
		rttr.addAttribute("residenceGu",board.getResidenceGu());
		return "redirect:/board/board";
	}


	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyBoardGet(@RequestParam("num") int num, Model model) throws Exception {
		BoardVO board = boardService.read(num);
		model.addAttribute("board", board );
		return "/board/board_modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyBoardPost(@ModelAttribute("board") BoardVO board, RedirectAttributes rttr) throws Exception {
		boardService.updateBoard(board);
		rttr.addAttribute("residence",board.getResidence());
		rttr.addAttribute("residenceGu",board.getResidenceGu());
		return "redirect:/board/board";
	}

}
