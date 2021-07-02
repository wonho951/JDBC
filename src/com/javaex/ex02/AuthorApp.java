package com.javaex.ex02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> authorList;
		
		//리스트출력
		//DB에서 데이터 가져오기
		authorList = authorDao.getAuthorList();
		//리스트를 for문으로 출력
		for(int i = 0; i < authorList.size(); i++) {
			
			/*
			 * authorList.get(i) 의 반복이기 때문에 다른 표현법
			int authorId = authorList.get(i).getAuthorId();
			String authorName = authorList.get(i).getAuthorName();
			String authorDesc = authorList.get(i).getAuthorDesc();
			
			System.out.println(authorId + "\t" + authorName + "\t\t" + authorDesc);
			*/
			
			
			// authorList.get(i)의 반복이기 때문에 authorVo에 authorList.get(i)를 담아줌
			/*
			AuthorVo authorVo = authorList.get(i);
			
			int authorId = authorVo.getAuthorId();
			String authorName = authorVo.getAuthorName();
			String authorDesc = authorVo.getAuthorDesc();
			
			System.out.println(authorId + "\t" + authorName + "\t\t" + authorDesc);
			*/
			
			//authorId같은 변수를 필요없게 하는 방법
			
			AuthorVo authorVo = authorList.get(i);
			System.out.println(authorVo.getAuthorId() + "\t" + authorVo.getAuthorName() + "\t" + authorVo.getAuthorDesc());
			
			
			
		}
		
		
		
		
		
		
		//작가 등록
		int count = authorDao.authorInsert("김일성", "뽀글머리");
		
		if(count > 0) {	
		System.out.println("[등록되었습니다.]");
		} else {
			System.out.println("[관리자에게 문의하세요(" + count + ")]");
		}
		
		//리스트출력
		//DB에서 데이터 가져오기
		authorList = authorDao.getAuthorList();
		
		//리스트를 for문으로 출력
		for(int i = 0; i < authorList.size(); i++) {
						
			AuthorVo authorVo = authorList.get(i);
			System.out.println(authorVo.getAuthorId() + "\t" + authorVo.getAuthorName() + "\t" + authorVo.getAuthorDesc());
						
		}
		
		
		/*
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
