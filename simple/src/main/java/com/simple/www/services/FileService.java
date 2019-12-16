package com.simple.www.services;

import java.io.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.simple.www.dao.*;
import com.simple.www.util.FileUtil;

public class FileService {
	
	MemberDAO mDAO;
	FileDAO fDAO;
	
	public void setDAO(MemberDAO mDAO) {
		this.mDAO = mDAO;
	};
	
	public void setDAO(FileDAO fDAO) {
		this.fDAO = fDAO;
	};
	
	// 파일 업로드를 처리할 함수
	public String singleUpProc(MultipartFile upfile , HttpSession session) {
		// 이 함수는 파일을 업로드 하기 위해서 컨트롤러에서 업로드할 파일의 정보를 받아와야 한다.
		// 그 정보는 MultipartFile 이라는 타입으로 전송이 될 것이고
		// 거기서 꺼내서 사용해야 한다.
		
		// 저장이름을 기억할 변수
		String saveName = "";
		
		String spath = session.getServletContext().getRealPath("resources/upload");
//		String path = this.getClass().getResource("/").getPath()  ;
//		int idx = path.indexOf("/WEB-INF");
//		path= path.substring(0, idx) + "/resources/upload";
//		
//		System.out.println("srvc path : " + path);
		System.out.println("srvc path : " + spath);
		
		// 먼저 클라이언트가 업로드한 
		
		String rePath = spath.substring(0, spath.indexOf("\\.metadata"));
		
		System.out.println("#######"+rePath);
		rePath = rePath + "\\git\\springsimple\\simple\\src\\main\\webapp\\resources\\upload";
		
		String oriName = upfile.getOriginalFilename();
		if(oriName == null || oriName.length() == 0 ) {
			return "";
		}
		// 아래 라인이 실행된다는 의미는 업로드할 파일이 존재 한다는 얘기다.
		String tmp = FileUtil.rename(spath, oriName);
		saveName = tmp ;
		
		FileInputStream fin = null; // 기본 스트림
		BufferedInputStream bin = null; //보조 스트림
		PrintStream ps = null; 
		
		
		try {
			File file = new File(spath, saveName);
			upfile.transferTo(file);
			
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saveName;
	}
	
	//다중 파일 업로드 처리 함수
	public String[] uploadProc(HttpSession session, MultipartFile[] upfile) {
		String[] saveName = new String[upfile.length];
		
		for(int i = 0 ; i <upfile.length; i ++) {
			saveName[i] = singleUpProc(upfile[i], session);
			
		}
		return saveName;
	}
}