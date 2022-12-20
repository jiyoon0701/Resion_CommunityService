package org.tukorea.project.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;


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
import org.tukorea.project.controller.MemberController;
import org.tukorea.project.domain.BoardVO;
import org.tukorea.project.domain.UserVO;
import org.tukorea.project.service.BoardService;
import org.tukorea.project.service.MemberService;
import org.tukorea.utils.UploadFileUtils;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getlogin() throws Exception{
		return "/member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO user, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");

		HttpSession session = req.getSession();
		UserVO login = memberService.login(user);
		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("residence", URLEncoder.encode(login.getResidence(),"UTF-8"));
			session.setAttribute("residenceGu", URLEncoder.encode(login.getResidenceGu(),"UTF-8"));
			session.setAttribute("id", login.getId());
		}
		return null;
	}
	 // 회원가입 
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info(" /register URL GET method called. then forward member_register.jsp.");
		
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String createMemberPost(@ModelAttribute("user") UserVO vo) throws Exception {
		memberService.register(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
	
	
}