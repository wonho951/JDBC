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
	/*
	getAuthorOne(){
		
	}
	
	
	authorInsert(){
		
	}
	
	authorUpdate(){
		
	}
	
	authorDelete(){
		
	}
	*/
	
}
