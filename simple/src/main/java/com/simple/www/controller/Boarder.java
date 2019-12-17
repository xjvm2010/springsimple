package com.simple.www.controller;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.simple.www.dao.*;
import com.simple.www.services.FileService;
import com.simple.www.vo.*;

@Controller
@RequestMapping("/board/")
public class Boarder {
	@Autowired
	MemberDAO mDAO;
	@Autowired
	FileService fileSrvc;
	@Autowired
	FileDAO fDAO;
	
	
	@RequestMapping("boardlist.van")
	public ModelAndView boardlist(ModelAndView mv) {
		List<BoardVO> list = mDAO.boardlist();
		mv.setViewName("board/list");
		mv.addObject("LIST",list);
		return mv;
	}
	
	@RequestMapping("writeform.van")
	public ModelAndView writeform(ModelAndView mv) {
		mv.setViewName("board/write");
		return mv;
	}
	
	@RequestMapping("boardwrite.van")
	public ModelAndView boardwrite(RedirectView rv, ModelAndView mv , BoardVO vo) {
		mDAO.boardwrite(vo);
		rv.setUrl("/www/board/boardlist.van");
		mv.setView(rv);
		return mv;
	}
	
	@RequestMapping("uploading.van")
	public void uploadingform() {}
	
	
	@RequestMapping("gallery.van")
	public ModelAndView galleryproc(ModelAndView mv, GalleryVO vo, RedirectView rv, HttpSession session) {
		fileSrvc.setDAO(fDAO);
		
		int cnt = fileSrvc.Galleryup(session, vo);
		
		mv.addObject("CNT", cnt);
		
		rv.setUrl("/www/main.van");
		
		mv.setView(rv);
		
		return mv;
	}
}

