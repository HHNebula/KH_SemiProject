package kh.survey.controller;

import java.sql.*;

public class Controller {

	public void insertSurvey(Statement statement, String reservID, int answer1, int answer2, int answer3, int answer4,
			int answer5) {

		String query = "INSERT INTO user_reserv_qa VALUES ( '" + reservID + "', 'Q1', " + answer1 + " ), ( '" + reservID
				+ "', 'Q2', " + answer2 + " ), ( '" + reservID + "', 'Q3', " + answer3 + " ), ( '" + reservID
				+ "', 'Q4', " + answer4 + " ), ( '" + reservID + "', 'Q5', " + answer5 + " );";

		try {
			statement.executeQuery(query);
		} catch (SQLException sqlException) {
		}

	}

	// [성수] 사용자가 입력한 정보들이 유효한지, 설문 작성이 가능한 상태인지 확인
	public String checkUserId(Statement statement, String loginID, String loginPW, String checkIn, String checkOut) {

		String query = ("SELECT USER_ID FROM users WHERE LOGIN_ID = '" + loginID + "' AND LOGIN_PW = '" + loginPW
				+ "'");

		try {

			ResultSet resultSet = statement.executeQuery(query);
			String userId = resultSet.getString("USER_ID");

			// 확인된 USER_ID 로 숙박 내역이 있는지 확인
			return checkReserv(statement, userId, checkIn, checkOut);

		} catch (SQLException sqlException) {
			return "Exception";
		}

	}

	// [성수] 유저 아이디와 입력한 체크인, 아웃 날짜로 투숙 내역이 있는지 조회
	public String checkReserv(Statement statement, String userId, String checkIn, String checkOut) {

		String query = ("SELECT RESERV_ID FROM reservations WHERE USER_UD = '"+ userId +"' AND CHECK_IN = '" + checkIn + "' AND CHECK_OUT = '"
				+ checkOut + "';");

		try {

			ResultSet resultSet = statement.executeQuery(query); // 투숙 내역이 있는지 확인

			String reservId = resultSet.getString("RESERV_ID");
			if (checkOverlap(statement, reservId)) {
				return reservId;
			} else {
				return "overlap";
			}

		} catch (SQLException sqlException) {
			return "Exception";
		}

	}

	// 중복 여부 검사
	public boolean checkOverlap(Statement statement, String id) {

		String query = "SELECT * FROM user_reserv_qa WHERE RESERV_ID = '" + id + "';";

		try {

			// 있다면 중복
			ResultSet resultSet = statement.executeQuery(query);
			
			return false;

		} catch (SQLException sqlException) {
			return true;
		}

	}

	public void totalsSatistics(Statement statement) {
		String query = "";
	}

}
