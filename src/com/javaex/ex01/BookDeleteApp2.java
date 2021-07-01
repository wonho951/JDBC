package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDeleteApp2 {

	public static void main(String[] args) {
		
		//delete from book     
		//where author_id = 1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");	//오라클 드라이버를 메모리에 올림
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";	//localhost자리는 원래는 IP임.
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " delete from book";
			query += " where book_id = ?";
			
			pstmt = conn.prepareStatement(query);	//prepareStatement --> 외워두는게 좋음.
			pstmt.setInt(1, 20);
			
			int count = pstmt.executeUpdate();	//-->위에 짠 쿼리문을 실질적으로 실행시킴.

			// 4.결과처리			
			if(count > 0) {	//결과처리는 어떻게 사용하느냐가 관건.
			System.out.println(count + "건이 삭제되었습니다.");	//->결과출력.
			} else {
				System.out.println("삭제에 실패했습니다.");
			}
			
			
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


	}

}
