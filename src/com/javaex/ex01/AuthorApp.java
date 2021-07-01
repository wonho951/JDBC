package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorApp {

	public static void main(String[] args) {

		// insert into author values(seq_author_id.nextval, '김영하', '알쓸신잡');

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	//select문일때 결과값 받아올때 사용.

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			/********중요!!!!!!!!!!!!****************/
			//쿼리문은 spl에서 꼭 실험 해보고 이클립스로 가져와야됨 꼭임 꼭 필수!!
			String query = "";	//쿼리문을 문자열로 만들기 --> ? 주의!!
			query += "insert into author";
			query += "values(seq_author_id.nextval, ?, ?)"; //->값을 아직 안줘야 해서 ?로 표시
			
			//바인딩
			pstmt = conn.prepareStatement(query); //통신하기위한 진짜준비 (변환) --> 진짜 쿼리문으로 만들기
			pstmt.setString(1, "김영하");	// 첫번째 물음표에 넣을건지 두번쨰에 넣을건지 알려줘야함. ?(물음표)중 첫번째에 들어감. -->순서중요
			pstmt.setString(2, "알뜰신잡");	//그래서 앞에 번호써줌. ?(물음표)중 두번째에 들어감.	--> 순서 잘못 넣으면 다른 컬럼에 들어감.
											//	물음표가 하나여도 1 써주는게 좋음.
			/*
			 insert into author values(seq_author_id.nextval, '김영하', '알쓸신잡');
			 위 과정을 거쳐야 sql에서 한 쿼리문이 준비된거임.
			 */
			
			//실행
			int count = pstmt.executeUpdate();	// --> 이게 실행되면 쿼리문을 진짜 실행시킴 --> 리턴값으로 성공여부 판단
												//자동으로 commit됨. 실행되는지 안되는지 카운터로 셈.
			
			
			// 4.결과처리
			System.out.println(count + "건이 저장되었습니다.");	//->결과출력.
			
			
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
