package kh.survey.controller;

import java.sql.*;

public class Controller {

	public void insertSurvey() {

	}

	public String checkUserId(Statement statement, String loginID, String loginPW, String checkIn, String checkOut) {

		String query = ("SELECT USER_ID FROM users WHERE LOGIN_ID = '" + loginID + "' AND LOGIN_PW = '" + loginPW
				+ "'");

		try {
			ResultSet resultSet = statement.executeQuery(query);

			String userId = resultSet.getString("USER_ID");
			
			return checkReserv(statement, userId, checkIn, checkOut);

		} catch (SQLException sqlException) {

			return "Exception";
			
		}

	}

	public String checkReserv(Statement statement, String userId, String checkIn, String checkOut) {

		// 성수 //
		// 쿼리 > USER_ID 로 RESERV_ID 조회
		// 일치하는 정보가 있다면 checkOverlap 호출
		// 없다면 false 반환

		// checkOverlap 결과를 받아 리턴

		String query = "SELECT RESERV_ID, " + "DATE_FORMAT(CHECK_IN, '%Y-%m-%d') AS CHECK_IN, "
				+ "DATE_FORMAT(CHECK_OUT, '%Y-%m-%d') AS CHECK_OUT " + "FROM reservations WHERE USER_ID = '"
				+ userId + "';";

		try {

			ResultSet resultSet = statement.executeQuery(query); // 투숙 내역이 있는지 확인

			while (resultSet.next()) {

				String id = resultSet.getString("RESERV_ID"); // 예약번호 저장
				String in = resultSet.getString("CHECK_IN"); // 체크인 저장
				String out = resultSet.getString("CHECK_OUT"); // 체크아웃 저장

				if (in.equals(checkIn) && out.equals(checkOut)) { // 입력값과 저장값이 같은게 있다면
					if (checkOverlap(statement, id)) { // 중복인지 검사함
						return id;
					}
				}

			}

			return "Exception";

		} catch (SQLException sqlException) {

			return "Exception";

		}

	}

	public boolean checkOverlap(Statement statement, String id) {

		// 성수 //
		// 쿼리 USER_ID 로 RESERV_ID 조회
		// 작성된 내역이 없다 true 반환
		// 작성된 내역이 있다면 false 반환

		String query = "SELECT * FROM user_reserv_qa WHERE RESERV_ID = '" + id + "';";
		try {
			ResultSet resultSet = statement.executeQuery(query);
			return false;
		} catch (SQLException sqlException) {

			// SQLException 이 발생했다는 것은 설문이 조회되지 않는다는 것
			return true;

		}

	}

}
