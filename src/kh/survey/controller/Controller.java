package kh.survey.controller;

import java.sql.*;

public class Controller {

	public void insertSurvey(Statement statement, String reservId, int answer1, int answer2, int answer3, int answer4,
			int answer5) {

		String query = ("INSERT INTO user_reserv_qa ( RESERV_ID, QUESTION_ID, ANSWER_ID ) " + "VALUES ( '" + reservId + "', 'Q1', 'AS" + answer1 + "' ),"
				+ "( '" + reservId + "', 'Q2', 'AS" + answer2 + "' ),"
				+ "( '" + reservId + "', 'Q3', 'AS" + answer3 + "' ), " + "( '" + reservId + "', 'Q4', 'AS" + answer4 + "' )," + "( '" + reservId
				+ "', 'Q5', 'AS" + answer5 + "' )");

		try {
			statement.execute(query);
		} catch (SQLException sqlException) {
		}

	}

	// [성수] 사용자가 입력한 정보들이 유효한지, 설문 작성이 가능한 상태인지 확인
	public String checkUserId(Statement statement, String loginID, String loginPW) {

		String query = ("SELECT USER_ID FROM users WHERE LOGIN_ID = '" + loginID + "' AND LOGIN_PW = '" + loginPW
				+ "'");
		try {
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			return resultSet.getString("USER_ID");
		} catch (SQLException sqlException) {
			return "Exception";
		}

	}

	// [성수] 유저 아이디와 입력한 체크인, 아웃 날짜로 투숙 내역이 있는지 조회
	public String checkReserv(Statement statement, String userId, String checkIn, String checkOut) {

		String query = ("SELECT RESERV_ID FROM reservations WHERE USER_ID = '" + userId + "' AND CHECK_IN = '" + checkIn
				+ "' AND CHECK_OUT = '" + checkOut + "'");
		try {
			ResultSet resultSet = statement.executeQuery(query); // 투숙 내역이 있는지 확인
			resultSet.next();
			return resultSet.getString("RESERV_ID");
		} catch (SQLException sqlException) {
			return "Exception";
		}

	}

	// 중복 여부 검사
	public boolean checkOverlap(Statement statement, String id) {

		String query = "SELECT * FROM user_reserv_qa WHERE RESERV_ID = '" + id + "'";

		try {

			// 있다면 중복
			ResultSet resultSet = statement.executeQuery(query);
			return !resultSet.next();

		} catch (SQLException sqlException) {
			return true;
		}

	}

	public void totalsSatistics(Statement statement) { // 보경

		// 총 갯수 구하는 쿼리
		String query = "SELECT questions.QUESTION AS '질문들', COUNT(CASE WHEN ANSWER_ID = 'AS1' THEN 1 END ) AS '매우 불만', "
				+ " COUNT(CASE WHEN ANSWER_ID = 'AS2' THEN 1 END ) AS '불만', "
				+ " COUNT(CASE WHEN ANSWER_ID = 'AS3' THEN 1 END ) AS '만족', "
				+ " COUNT(CASE WHEN ANSWER_ID = 'AS4' THEN 1 END ) AS '매우 만족' "
				+ " FROM user_reserv_qa INNER JOIN questions ON user_reserv_qa.QUESTION_ID = questions.QUESTION_ID GROUP BY user_reserv_qa.QUESTION_ID";

		ResultSet resultset;

		// 통계 보여주는 부분
		// while문으로 데이터가 없을때까지 추출
		try {
			resultset = statement.executeQuery(query);

			System.out.println("구분\t\t매우 불만\t불만\t만족\t매우 만족\t");
			while (resultset.next()) {
				String question = resultset.getString("질문들");
				int as1 = resultset.getInt("매우 불만");
				int as2 = resultset.getInt("불만");
				int as3 = resultset.getInt("만족");
				int as4 = resultset.getInt("매우 만족");
				System.out.printf("%s : %9d %9d %9d %9d \n", question, as1, as2, as3, as4);

			}

		} catch (SQLException exception) {
			exception.printStackTrace();
		}

	}

}
