package com.javaex.ex03;

import java.util.List;

public class AuthorApp {


	//메소드 - 일반	
	public static void main(String[] args) {	//스태틱에 메인이므로 이 안에서 사용하는 메소드들은 메모리에 올라가있음.
		
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> authorList;
		
		//리스트출력
		//DB에서 데이터 가져오기
		authorList = authorDao.getAuthorList();
		//리스트를 for문으로 출력
		
		pritnList(authorList); //이걸로 메소드 만들어서 출력함.
				
		//작가 등록	iCount 사용은 생략했음
		int iCount = authorDao.authorInsert("김일성", "뽀글머리");
		
		if(iCount > 0) {	
		System.out.println("[등록되었습니다.]");
		} else {
			System.out.println("[관리자에게 문의하세요(" + iCount + ")]");
		}
		
		//리스트출력
		//DB에서 데이터 가져오기
		authorList = authorDao.getAuthorList();
		
		//리스트를 for문으로 출력
		
		pritnList(authorList);
		
		
		
		//작가 수정
		int uCount = authorDao.authorUpdate(3, "김정은", "돼지");
		
		
		
		//리스트출력
		authorList = authorDao.getAuthorList();
		
		//리스트를 for문으로 출력 --> 메소드로 정의
		//DB에서 리스트 가져오기
		pritnList(authorList);
		
		
		
		
		
		
		
		//작가 삭제
		int dCount = authorDao.authorDelete(7);
		
		
		
		//리스트출력		
		//리스트를 for문으로 출력 --> 메소드로 정의
		//DB에서 리스트 가져오기
		pritnList(authorList);
		
		
		
		/*
		//작가 한명의 정보
		??? = authorDao.getAuthorOne(3);	//3번 작가정보 출력
		*/
		
		
		
		
	}
	
	
	//리스트 출력 반복되니까 만들기
	public static void pritnList(List<AuthorVo> authorList){
		
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
		
	}
	

}
