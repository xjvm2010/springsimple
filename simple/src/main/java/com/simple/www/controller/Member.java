package com.simple.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simple.www.dao.*;
import com.simple.www.vo.*;

@Controller
@RequestMapping("/member/")
public class Member {
	@Autowired
	MemberDAO mDAO;
	
	@RequestMapping("login.van")
	public ModelAndView loginForm(ModelAndView mv) {
		mDAO.testStr();
		mv.setViewName("member/login");
		
		return mv;
	}
	
	@RequestMapping("loginProc.van")
	public ModelAndView loginProc(ModelAndView mv, MemberVO vo) {
		System.out.println("### controller vo.id : " + vo.getId());
		return mv;
	}
	
	@RequestMapping("join.van")
	public ModelAndView joinForm(ModelAndView mv) {
		mv.setViewName("member/join");
		
		return mv;
	}
}
