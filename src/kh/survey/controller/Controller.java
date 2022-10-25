package kh.survey.controller;

import java.sql.*;

public class Controller {

	static private String url = "jdbc:mysql://localhost:3306/hotelsurvey";
	static private String user = "root";
	static private String password = "*khacademy!";

	public boolean checkReserv(String userId, String checkIn, String checkOut) {

		boolean isOk = false;

		try {
			Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
			Statement statement = connection.createStatement();
			String query = "SELECT RESERV_ID, " + "DATE_FORMAT(CHECK_IN, '%Y-%m-%d') AS CHECK_IN, "
					+ "DATE_FORMAT(CHECK_OUT, '%Y-%m-%d') AS CHECK_OUT " + "FROM reservations WHERE USER_ID = '"
					+ userId + "';";
			ResultSet resultSet = statement.executeQuery(query); // 쿼리 실행 및 결과 리턴

			while (resultSet.next()) {

				String id = resultSet.getString("RESERV_ID"); // 예약번호 저장
				String in = resultSet.getString("CHECK_IN"); // 체크인 저장
				String out = resultSet.getString("CHECK_OUT"); // 체크아웃 저장

				if (in.equals(checkIn) && out.equals(checkOut)) { // 입력값과 저장값이 같은게 있다면
					isOk = checkOverlap(id, statement); // 중복인지 검사함
					break;
				}

			}

			return isOk;

		} catch (

		SQLException e) {
			return false;
		}

	}

	public boolean checkOverlap(String id, Statement statement) {

		String query = "SELECT * FROM user_reserv_qa WHERE RESERV_ID = '" + id + "';";

		try {
			ResultSet resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}

	}

	public static void main(String[] args) {
		String userId = "U1";
		String checkIn = "2022-10-22";
		String checkOut = "2022-10-23";

		Controller c = new Controller();
		System.out.println(c.checkReserv(userId, checkIn, checkOut));
	}

}
