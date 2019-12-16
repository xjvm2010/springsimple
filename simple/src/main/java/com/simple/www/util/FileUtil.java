package com.simple.www.util;
/**
 *	이 클래스는 파일 업로드에 필요한 기능을 처리하기 위해서 만든 유틸리티적 클래스이다.
 *
 * @author	박송림
 * @since	2019.12.16
 * @version v.1.0
 * @see
 * 			변경이력
 * 				2019.12.16		-	클래스 제작		- 담당자 : 박송림
 * 
 */
import java.io.*;

public class FileUtil {
	/*
	 	파일 이름이 중복되면 이전에 업로드한 파일에 덮어쓰기가 되기 때문에
	 	혹시 같은 이름의 파일이 존재하면 파일이름을 바꿔서 저장해야 한다.
	 */
	
	public static String rename(String path, String oldName) {
		/*
		 	[정책설정]
		 		파일이름이 중복되면 "_1" 을 붙여서 저장하자.
		 */
		int count = 0; //동일한 파일의 경우 붙여질 번호를 기억할 변수
		
		String tmpName = oldName; // 현재 이름을 따로 기억해 놓는다.
		
		File file = new File(path, oldName); // 경로에 현재파일명으로 파일객체 생성.
		
		while(file.exists()) { // 위에 저장한 경로에 같은 파일명이 있는지 검색.
			
			count ++; //있는경우 카운트를 증가
			int len = tmpName.lastIndexOf("."); // .이전의 인덱스 번호를 저장
			String tmp1 = tmpName.substring(0, len); //  . 이전의 파일이름을 저장
			oldName= tmp1+"_"+count + tmpName.substring(len); //파일 이름 + _ + 카운트 + 확장자명
			
			file = new File(path, oldName); 
		}
		
		return oldName;
	}
	
}
