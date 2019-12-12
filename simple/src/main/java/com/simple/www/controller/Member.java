package com.simple.www.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.www.dao.*;
import com.simple.www.vo.*;

@Controller
@RequestMapping("/member/")
public class Member {
	@Autowired
	MemberDAO mDAO;
	
	@RequestMapping("login.van")
	public ModelAndView loginForm(ModelAndView mv) {
		mv.setViewName("member/login");
		return mv;
	}
	
	@RequestMapping("loginProc.van")
	public ModelAndView loginProc(HttpSession session, RedirectView rv,
								ModelAndView mv, MemberVO vo) {
		// 함수에 들어가는 인자값들은 서버에서 자동으로 찾아서 처리해준다.
		
		int cnt = mDAO.loginProc(vo);
		if(cnt == 1) {
			session.setAttribute("SID", vo.getId());
			rv.setUrl("/www/main.van");
			mv.setView(rv);
		}else {
			rv.setUrl("/www/member/login.van");
			mv.setView(rv);
		}
		return mv;
	}
	
	@RequestMapping("logout.van")
	public ModelAndView logout(ModelAndView mv, HttpSession session, RedirectView rv) {
		session.setAttribute("SID", "");
		rv.setUrl("/www/main.van");
		mv.setView(rv);
		return mv;
	}
	
	@RequestMapping("join.van")
	public ModelAndView joinForm(ModelAndView mv) {
		mv.setViewName("member/join");
		return mv;
	}
	
	@RequestMapping("joinProc.van")
	public ModelAndView joinProc(ModelAndView mv, MemberVO vo, HttpSession session, RedirectView rv) {
		int cnt = mDAO.joinProc(vo);
		
		if(cnt == 1 ) {
			session.setAttribute("SID", vo.getId());
			rv.setUrl("/www/main.van");
			mv.setView(rv);
		}else {
			rv.setUrl("/www/member/join.van");
			mv.setView(rv);
		}
		return mv;
	}
	
}
