package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

	//필드
	
	//생성자
	
	//메소드g/s
	
	//메소드 - 일반
	
	//작가리스트 가져오기
	public List<AuthorVo> getAuthorList(){
		//DB값을 가져와서 ArrayList로 전달
		
		//리스트 생성	-> 미리 만들어둠
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query +=" select  author_id, ";
			query +="         author_name,";
			query +="         author_desc ";
			query +=" from author ";
			query +=" order by author_id asc ";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
		    // 4.결과처리

			while(rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				AuthorVo authorVo= new AuthorVo(authorId, authorName, authorDesc);
				
				authorList.add(authorVo);
				
			}
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
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

		return authorList;
		
	}
	
	//getAuthorOne(){
		
//	}
	
	
	//작가 등록하기
	public int authorInsert(String authorName, String authorDesc){
		
		int count = -1;
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "";
		    query +=" insert into author ";
		    query +=" values(seq_author_id.nextval, ?, ?) ";
		    
		    pstmt = conn.prepareStatement(query);
		    pstmt.setString(1, authorName);
		    pstmt.setString(2, authorDesc);
		    
		    
		    count = pstmt.executeUpdate();
		    // 4.결과처리
		    System.out.println(count + "건이 등록되었습니다.");	//등록할땐 개발자가 보는 용도로만.
		    
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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

		return count;	//성공갯수 리턴
	}
	
	
	//작가 수정하기
	public int authorUpdate(int author, String authorName, String aturhogDesc){
		
		int count = -1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query +=" update author ";
			query +=" set    author_name = ?, ";
			query +="        author_desc = ? ";
			query +=" where author_id = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			pstmt.setString(2, aturhogDesc);
			pstmt.setInt(3, author);
			
			
			count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count + "건이 수정되었습니다.");
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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
		return count;
	}
	
	
	//작가 삭제하기
	public int  authorDelete(int authorId){
		int count = -1;
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "";
		    query += " delete from author ";
		    query += " where author_id = ? ";
		    
		    
		    pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, authorId);
			
			count = pstmt.executeUpdate();	//실행문 자꾸 헷갈리네.
		    // 4.결과처리

			System.out.println(count + "건이 삭제되었습니다.");
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
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

		return count;
	}
	
	
}
