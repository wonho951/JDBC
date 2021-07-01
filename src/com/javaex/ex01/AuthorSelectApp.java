package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorSelectApp {

	public static void main(String[] args) {
		//작가리스트 가져오기
		
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
			
			/*
			select  author_id,
	        		author_name,
	        		author_desc        
	        from author;
			*/
			
			String query = "";
			query += " select  author_id, ";	//sql에 쓴것처럼 써줌. 알아보기 쉽게.ㅇㅋ?
			query += "         author_name, ";
			query += "         author_desc ";
			query += " from author ";
			
			pstmt = conn.prepareStatement(query);	//->실질적으로 쿼리문으로 만들어줌.
					
			rs = pstmt.executeQuery();	//	rs에 작가정보가 지금 저장되어있음.
		
		    // 4.결과처리
			//여기서 자바 정보 꺼내옴
			while (rs.next()) {	//row 하나씩 처리해야하기때문에 while문 사용. next는 row를 한줄씩 읽고 다음줄로 넘어간다는 뜻.
				int authorId = rs.getInt("author_id");	//만약 sql에서 별명을 썻다면 컬럼명이 아니라 별명을 써줘야함.
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				System.out.println(authorId + ", " + authorName + ", " + authorDesc);
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

		
		
	}

}
