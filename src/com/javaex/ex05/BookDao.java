package com.javaex.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex04.AuthorVo;

public class BookDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	// 생성자

	// 메소드g/s

	// 메소드 - 일반

	
	// DB연결
	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	
	// 자원 정리
	private void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	
	
	// 책리스트 가져오기
	
	public List<BookVo> getBookList() {
		// DB값을 가져와서 ArrayList로 전달

		// 리스트 생성 -> 미리 만들어둠
		List<BookVo> bookList = new ArrayList<BookVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select  book_id, ";
			query += "         title,";
			query += "         pubs, ";
			query += "         to_char(pub_date, 'yyyy-mm-dd') as pub_date, ";
			query += "         author_id ";
			query += " from book ";
			query += " order by book_id asc ";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// 4.결과처리

			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int authorId = rs.getInt("author_id");

				BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorId);

				bookList.add(bookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return bookList;

	}

	// getAuthorOne(){

//		}

	// 책 등록하기
	public int bookInsert(BookVo bookVo) {

		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " insert into book ";
			query += " values(seq_book_id.nextval, ?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubs());
			pstmt.setString(3, bookVo.getPubDate());
			pstmt.setInt(4, bookVo.getAuthorId());
			
			count = pstmt.executeUpdate();
			
			// 4.결과처리
			System.out.println(count + "건이 등록되었습니다."); // 등록할땐 개발자가 보는 용도로만.

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return count; // 성공갯수 리턴
	}

	// 책 수정하기
	public int bookUpdate(BookVo bookVo) {

		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " update book ";
			query += " set    title = ?, ";
			query += "        pubs = ?, ";
			query += "        to_char(pub_date, 'yyyy-mm-dd') as pub_date = ?, ";
			query += "        author_id = ? ";
			query += " where book_id = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getPubs());
			pstmt.setString(3, bookVo.getPubDate());
			pstmt.setInt(4, bookVo.getAuthorId());
			pstmt.setInt(5, bookVo.getBookId());

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		// 5. 자원정리
		this.close();

		return count;
	}

	// 작가 삭제하기
	public int bookDelete(int bookId) {
		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 자원정리
		this.close();

		return count;
	}

}
