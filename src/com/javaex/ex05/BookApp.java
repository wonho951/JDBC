package com.javaex.ex05;

import java.util.List;

import com.javaex.ex04.AuthorDao;
import com.javaex.ex04.AuthorVo;

public class BookApp {

	public static void main(String[] args) {
		
		
		
		//(1)
		//DB에서 작가테이블, 책테이블 완성 되어있어야함.
		//작가테이블, 책테이블 시퀀스 있어야함.
		
		
		//여기부터 시작
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> authorList;
		
		
		//authorDao.authorInsert(); 이용 작가 데이터 추가(6명)
		AuthorVo authorvo1 = new AuthorVo("이문열", "경북 영양");
		
		AuthorVo authorvo2 = new AuthorVo("박경리", "경상남도 통영");
		AuthorVo authorvo3 = new AuthorVo("유시민", "17대 국회의원");
		AuthorVo authorvo4 = new AuthorVo("기안84", "기안동에서 산 84년생");
		AuthorVo authorvo5 = new AuthorVo("강풀", "온라인 만화가 1세대");
		AuthorVo authorvo6 = new AuthorVo("김영하", "알쓸신잡");
		
		authorDao.authorInsert(authorvo1);
		authorDao.authorInsert(authorvo2);
		authorDao.authorInsert(authorvo3);
		authorDao.authorInsert(authorvo4);
		authorDao.authorInsert(authorvo5);
		authorDao.authorInsert(authorvo6);
		
		

		
		//bookDao.bookInsert(); 책 데이터 추가(8개)
		
				//책 수정, 삭제 각자 알아서 테스트
		
		//책 리스트 출력
		//bookDao.getBookList(); --> 8개
		///////////////////////////////////////////////
		
		
		
		
		//(2)
		//스캐너 통해서 사용자에게 키워드 입력받음.
		//"검색어를 입력해주세요"
		//"검색어 : 문"
		
		//bookDao.getBookList(keyword); --> 4개
		//책 정보 출력되도록
		//검색된 책 정보 출력
		
		
		
		
		
		
		
		
		
		
	}

}
