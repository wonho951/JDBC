package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookUpdateApp {
	public static void main(String[] args) {
		
		/*
		update author               
		set author_name = '기안84',
		    author_desc = '웹툰작가'
		where author_id = 1;
		*/
		
		
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
			query += " update book";
			query += " set title = ?,";
			query += " pubs = ?";
			query += " where author_id = ?";
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "응가");
			pstmt.setString(2, "내일모레출판사");
			pstmt.setInt(3, 8);
			
			int count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count + "건이 수정되었습니다.");
			
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
