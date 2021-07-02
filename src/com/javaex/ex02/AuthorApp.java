package com.javaex.ex02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		
		
		//리스트출력
		List<AuthorVo> authorList = authorDao.getAuthorList();
		//리스트를 for문으로 출력
		for(int i = 0; i < authorList.size(); i++) {
			int authorId = authorList.get(i).getAuthorId();
			String authorName = authorList.get(i).getAuthorName();
			String authorDesc = authorList.get(i).getAuthorDesc();
			
			System.out.println(authorId + "\t" + authorName + "\t\t" + authorDesc);
		}
		
		
		
		
		
		
		/*
		//작가 등록
		authorDa.authorInsert("김일성", "뽀글머리");
		
		
		
		//리스트출력
		List<> authorList = authorDao.getAuthorList();
		//리스트를 for문으로 출력
		
		
		//작가 수정
		authorDao.authorUpdate(3, "김정은", "돼지");
		
		
		
		//리스트출력
		List<> authorList = authorDao.getAuthorList();
		//리스트를 for문으로 출력
		
		
		//작가 삭제
		authorDao.authorDelete(3);
		
		
		
		//리스트출력
		List<> authorList = authorDao.getAuthorList();
		//리스트를 for문으로 출력
		
		
		//작가 한명의 정보
		??? = authorDao.getAuthorOne(3);	//3번 작가정보 출력
		*/
		
		
		
		
	}

}
