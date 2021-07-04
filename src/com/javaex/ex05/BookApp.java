package com.javaex.ex05;

import java.util.List;
import java.util.Scanner;


public class BookApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//(1)
		//DB에서 작가테이블, 책테이블 완성 되어있어야함.
		AuthorDao authorDao = new AuthorDao();		
		List<AuthorVo> authorList;
		
		BookDao bookDao = new BookDao();
		List<BookVo> bookList;
		//작가테이블, 책테이블 시퀀스 있어야함.
		
		
		
		while (true) {
			
			System.out.println("**************");
			System.out.println("책/작가 조회");
			System.out.println("**************");
			System.out.println("1.작가 등록 2. 작가 수정 3.작가 삭제 4.작가 조회");
			System.out.println("5.책 등록 6. 책 수정 7.책 삭제 8. 책 조회");
			System.out.println("9.책/작가 조회 10.책/작가 검색 11.종료");
			System.out.println("번호 입력 :");
			int num = sc.nextInt();
			switch(num) {
			case  1:	//작가등록
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
				
				break;
				
				
			case  2: //작가 수정
				
				AuthorVo uAuthrVo = new AuthorVo(6, "원호", "30살");
				int uCount = authorDao.authorUpdate(uAuthrVo);
			
				break;
			
			case 3: //작가 삭제
				int dCount = authorDao.authorDelete(6);
				
				break;
				
			case 4: //작가 조회
				//DB에서 리스트 가져오기
				authorList = authorDao.getAuthorList();
				//리스트를 for문으로 출력 --> 메소드로 정의
				pritnList(authorList);
				break;
				
			case 5: //책 등록
				
				BookVo bookvo1 = new BookVo("우리들의 일그러진 영웅", "다림", "1998/02/22", 1);
				BookVo bookvo2 = new BookVo("삼국지", "믿음", "2002/03/01", 1);
				BookVo bookvo3 = new BookVo("토지", "마로니에북스", "2012/08/15", 2);
				BookVo bookvo4 = new BookVo("유시민의 글쓰기 특강", "생각의 길", "2015/04/01", 3);
				BookVo bookvo5 = new BookVo("패션왕", "중앙북스(books)", "2012/02/22", 4);
				BookVo bookvo6 = new BookVo("순정만화", "재미주의", "2011/08/03", 5);
				BookVo bookvo7 = new BookVo("오직두사람", "문학동네", "2017/05/04", 6);
				BookVo bookvo8 = new BookVo("26년", "재미주의", "2012/02/04", 5);
				
						
				bookDao.bookInsert(bookvo1);
				bookDao.bookInsert(bookvo2);
				bookDao.bookInsert(bookvo3);
				bookDao.bookInsert(bookvo4);
				bookDao.bookInsert(bookvo5);
				bookDao.bookInsert(bookvo6);
				bookDao.bookInsert(bookvo7);
				bookDao.bookInsert(bookvo8);
				
				break;
				
			case 6: //책 수정
				
				
			}
		}
		
		//여기부터 시작
		
		/*
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
		
		
		
		//작가 리스트 출력
		//DB에서 리스트 가져오기
		authorList = authorDao.getAuthorList();
		//리스트를 for문으로 출력 --> 메소드로 정의
		pritnList(authorList);
		
		
		
		//bookDao.bookInsert(); 책 데이터 추가(8개)
		
		
		
		BookVo bookvo1 = new BookVo("우리들의 일그러진 영웅", "다림", "1998/02/22", 1);
		BookVo bookvo2 = new BookVo("삼국지", "믿음", "2002/03/01", 1);
		BookVo bookvo3 = new BookVo("토지", "마로니에북스", "2012/08/15", 2);
		BookVo bookvo4 = new BookVo("유시민의 글쓰기 특강", "생각의 길", "2015/04/01", 3);
		BookVo bookvo5 = new BookVo("패션왕", "중앙북스(books)", "2012/02/22", 4);
		BookVo bookvo6 = new BookVo("순정만화", "재미주의", "2011/08/03", 5);
		BookVo bookvo7 = new BookVo("오직두사람", "문학동네", "2017/05/04", 6);
		BookVo bookvo8 = new BookVo("26년", "재미주의", "2012/02/04", 5);
		
				
		bookDao.bookInsert(bookvo1);
		bookDao.bookInsert(bookvo2);
		bookDao.bookInsert(bookvo3);
		bookDao.bookInsert(bookvo4);
		bookDao.bookInsert(bookvo5);
		bookDao.bookInsert(bookvo6);
		bookDao.bookInsert(bookvo7);
		bookDao.bookInsert(bookvo8);
		*/
				
		
		//책 수정, 삭제 각자 알아서 테스트
		
		
		
		
		/*
		//책 리스트 출력

		//DB에서 리스트 가져오기
		bookList = bookDao.getBookList();
		//bookDao.getBookList(); --> 8개
		bpritnList(bookList);
		
		///////////////////////////////////////////////
		
		
		
		
		//(2)
		//스캐너 통해서 사용자에게 키워드 입력받음.
		//"검색어를 입력해주세요"
		//"검색어 : 문"
		
		//bookDao.getBookList(keyword); --> 4개
		//책 정보 출력되도록
		//검색된 책 정보 출력
		*/
		
		
		
		
		
		
		
		
		
	}
	
	//작가 리스트 출력
	public static void pritnList(List<AuthorVo> authorList){		
		for(int i = 0; i < authorList.size(); i++) {
			AuthorVo authorVo = authorList.get(i);
			System.out.println(authorVo.getAuthorId() + "\t" + authorVo.getAuthorName() + "\t" + authorVo.getAuthorDesc());			
		}
	
	}
	
	//책 리스트 출력
	public static void bpritnList(List<BookVo> bookList){		
		for(int i = 0; i < bookList.size(); i++) {
			BookVo bookVo = bookList.get(i);
			System.out.println(bookVo.getBookId() + "\t" + bookVo.getTitle() + "\t" + bookVo.getPubs() + "\t" + bookVo.getPubDate() + "\t" + bookVo.getAuthorId());			
		}
	
	}
	
	
	
	
	
	
	
	
	
}

