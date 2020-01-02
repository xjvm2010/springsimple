package com.simple.www.services;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.simple.www.dao.*;
import com.simple.www.util.FileUtil;
import com.simple.www.vo.FileVO;
import com.simple.www.vo.GalleryVO;
import com.simple.www.vo.MemberVO;

public class FileService {
	MemberDAO mDAO;
	FileDAO fDAO;

	public void setDAO(MemberDAO mDAO) {
		this.mDAO = mDAO;
	};

	public void setDAO(FileDAO fDAO) {
		this.fDAO = fDAO;
	};

	
	// 단일 파일 업로드를 처리할 함수
	public String singleUpProc(HttpSession session, MemberVO mVO) {

		// 이 함수는 파일을 업로드 하기 위해서 컨트롤러에서 업로드할 파일의 정보를 받아와야 한다.
		// 그 정보는 MultipartFile 이라는 타입으로 전송이 될 것이고
		// 거기서 꺼내서 사용해야 한다.

		// 저장이름을 기억할 변수
		String saveName = "";
		long len = 0;
		String spath = session.getServletContext().getRealPath("resources/upload");
		/* spath 경로 출력 부분 */
		System.out.println("spath : " + spath);
		System.out.println("");

		String rePath = spath.substring(0, spath.indexOf("\\.metadata"));
		rePath = rePath + "\\springsimple\\simple\\src\\main\\webapp\\resources\\upload";
		/* repath 경로출력 부분 */
		System.out.println("repath : " + rePath);
		System.out.println("");

		/* 클라이언트가 업로드한 원본이름을 알아낸다. */
		String oriName = mVO.getsFile().getOriginalFilename();

		if (oriName == null || oriName.length() == 0) {
			return "";
		}

		// 이 라인이 실행된다는 의미는 업로드할 파일이 존재한다는 이야기 이다.
		// 혹시 업로드할 파일하고 중복되는 이름의 파일이 이미 존재하는지 검사해서
		// 있는 경우는 다른이름으로 저장을 해야 한다.

		String tmp = FileUtil.rename(spath, oriName);

		// 저장할 이름이 생겼으므로 준비된 변수에 기억해 놓는다.
		saveName = tmp;

		// 이제 업로드된 파일을 우리의 정상적인 경로에 저장한다.
		// 이 이름은 이후 데이터베이스에 등록할 대 사용해야 한다.
		// 따라서 이름을 기억해 놓을 필요가 생겼다.

		try {
			File file = new File(spath, saveName);
			mVO.getsFile().transferTo(file);
			System.out.println("### dao 파일 업로드 성공 !!! ###");

			len = mVO.getsFile().getSize();

			file = new File(rePath, saveName);
			mVO.getsFile().transferTo(file);
			System.out.println("### 파일 업로드 성공2 !!! ###");

		} catch (Exception e) {
			e.printStackTrace();
		}
		FileVO fVO = new FileVO();
		
		fVO.setMno(mVO.getMno());
		fVO.setOriName(oriName);
		fVO.setSaveName(saveName);
		fVO.setDir(fVO.getDir());
		fVO.setLen(len);

		fDAO.insertPhoto(fVO);

		return saveName;
	}

	public int Galleryup(HttpSession session, GalleryVO gVO) {

		String saveName = "";
		int cnt = 0;
		long len = 0;
		String spath = session.getServletContext().getRealPath("resources/upload");

		/* spath 경로 출력 부분 */
		System.out.println(" g- spath : " + spath);
		System.out.println("");

		String rePath = spath.substring(0, spath.indexOf("\\.metadata"));
		rePath = rePath + "\\springsimple\\simple\\src\\main\\webapp\\resources\\upload";
		/* repath 경로출력 부분 */
		System.out.println("g- repath : " + rePath);
		System.out.println("");

		/* 클라이언트가 업로드한 원본이름을 알아낸다. */
		String oriName = gVO.getsFile().getOriginalFilename();

		if (oriName == null || oriName.length() == 0) {
			return cnt;
		}

		// 이 라인이 실행된다는 의미는 업로드할 파일이 존재한다는 이야기 이다.
		// 혹시 업로드할 파일하고 중복되는 이름의 파일이 이미 존재하는지 검사해서
		// 있는 경우는 다른이름으로 저장을 해야 한다.

		String tmp = FileUtil.rename(spath, oriName);

		// 저장할 이름이 생겼으므로 준비된 변수에 기억해 놓는다.
		saveName = tmp;

		// 이제 업로드된 파일을 우리의 정상적인 경로에 저장한다.
		// 이 이름은 이후 데이터베이스에 등록할 대 사용해야 한다.
		// 따라서 이름을 기억해 놓을 필요가 생겼다.

		try {
			File file = new File(spath, saveName);
			gVO.getsFile().transferTo(file);

			len = gVO.getsFile().getSize();

			file = new File(rePath, saveName);
			gVO.getsFile().transferTo(file);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 업로드 실패 !!");
		}

		gVO.setOriName(oriName);
		gVO.setSaveName(saveName);
		gVO.setLen(len);
		gVO.setDir(gVO.getDir());;
		cnt = fDAO.insertgalley(gVO);
		return cnt;
	}

	// 다중 파일 업로드 처리 함수
	public String[] uploadProc(HttpSession session, MemberVO mVO) {

		// 이 함수는 다중 파일 업로드를 처리할 함수
		// 그런데 단일파일을 처리할 함수를 이미 만들어 놓았다.
		// 따라서 위에서 만든 함수를 호출해서 반복처리만 해주면 될 것이다.

		String[] saveName = new String[mVO.getFile().length];

		for (int i = 0; i < mVO.getFile().length; i++) {
			saveName[i] = singleUpProc(session, mVO);
		}

		return saveName;
	}

}