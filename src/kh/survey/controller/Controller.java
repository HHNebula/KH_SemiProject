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

		String query = "SELECT RESERV_ID, " + "DATE_FORMAT(CHECK_IN, '%Y-%m-%d') AS CHECK_IN, "
				+ "DATE_FORMAT(CHECK_OUT, '%Y-%m-%d') AS CHECK_OUT " + "FROM reservations WHERE USER_ID = '"
				+ userId + "';";

		try {

			ResultSet resultSet = statement.executeQuery(query); // 투숙 내역이 있는지 확인

			while (resultSet.next()) {

				String id = resultSet.getString("RESERV_ID");
				String in = resultSet.getString("CHECK_IN");
				String out = resultSet.getString("CHECK_OUT");

				if (in.equals(checkIn) && out.equals(checkOut)) {
					if (checkOverlap(statement, id)) {
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

		String query = "SELECT * FROM user_reserv_qa WHERE RESERV_ID = '" + id + "';";

		try {

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
