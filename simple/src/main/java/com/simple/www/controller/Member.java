package com.simple.www.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("showname.van")
	public ModelAndView showName(ModelAndView mv, MemberVO vo, HttpServletRequest req) {
		String name = mDAO.showName(vo);
		
		System.out.println(name);
		
		req.setAttribute("NAME", name);
		mv.setViewName("member/showName");
		return mv;
	}
	@RequestMapping("showid.van")
	public ModelAndView showId(ModelAndView mv) {
		 List<MemberVO> list = mDAO.showId();
		
		mv.addObject("LIST",list);
		mv.setViewName("member/showId");
		return mv;
	}
	
	@RequestMapping("idCheck.van")
	@ResponseBody
	public MemberVO	idCheck(String id) {
		MemberVO vo = mDAO.idCheck(id);
		
		System.out.println("컨트롤러에서 출력 : "+vo.getCnt());
		/*
			우리가 현재 필요한 데이터는 json 형식의 데이터다.
			데이터의 숫자가 적을 경우는 해당 json 형식의 데이터를 만들어 주는것이 문제 없지만
			여러개 라면 문제가 될 수 있다.
			코드의 길이가 늘어날 수 있고
			확인하는 작업이 불편해진다.
			
			만약 vo의 모든 변수에 대한 데이터를 json 형식으로 변환시켜야한다면 
			모든 변수의 키값을 만들고 데이터를 입력해 줘야 하겠다.
			
			다행이도 스프링에서는 json 문서를 쉽게 만들 수 있는 방법을 제공하고 있다.
			방법 ]
				실행함수의 반환값을 VO 타입으로 정하고
				함수에 
					@ResponseBody
				라는 어노테이션을 붙여주면 된다.
				VO 에 선언된 변수 이름을 키값으로 하고
				입력된 데이터를 벨류로 해서 
				json 문서를 알아서 만들어 준다.
		 */
		return vo;
	}
	@RequestMapping("membInfo.van")
	@ResponseBody // ajax처리 
	public MemberVO membInfo(String id) { //회원정보를 보여줄 함수 
		MemberVO vo = mDAO.membInfo(id);
		return vo;
	}
	
	@RequestMapping("infoEdit.van") 
	public @ResponseBody MemberVO editInfo(MemberVO vo) { //회원정보를 수정하는 함수
			//ajax처리와 같으나 방식만 좀 다르게 함.
		System.out.println(vo.getMno());
		vo.setCnt(mDAO.editInfo(vo));
		
		return vo;
	}
	
}
