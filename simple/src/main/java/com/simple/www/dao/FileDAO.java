package com.simple.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.www.vo.BoardVO;
import com.simple.www.vo.FileVO;
import com.simple.www.vo.GalleryVO;

public class FileDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//파일 정보 입력 전담 처리 함수
	public int insertPhoto(FileVO fVO) {
		return sqlSession.insert("mSQL.addPic", fVO);
	}
	
	public int insertgalley(GalleryVO gVO) {
		return sqlSession.insert("mSQL.addgallery",gVO);
	}
	
	public List<GalleryVO> gallerylist(){
		List<GalleryVO> list = sqlSession.selectList("mSQL.gallerylist");
		return list;
	}
}
