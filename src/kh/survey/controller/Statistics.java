package kh.survey.controller;

import java.sql.*;

public class Statistics {
    Public void statistics(Statement statement) {

        
// 갯수 구하는 쿼리
//SELECT *
// FROM (SELECT QUESTION_ID, COUNT(ANSWER_ID) AS 매우불만
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS1'AND QUESTION_ID = 'Q1') AS 매우불만
// INNER JOIN (SELECT COUNT(ANSWER_ID) AS 불만
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS2' AND QUESTION_ID = 'Q1' ) AS 불만
// INNER JOIN (SELECT COUNT(ANSWER_ID) AS 만족
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS3' AND QUESTION_ID = 'Q1' ) AS 만족
// INNER JOIN (SELECT COUNT(ANSWER_ID) AS 매우만족
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS4' AND QUESTION_ID = 'Q1' ) AS 매우만족

// 갯수 구하는 쿼리
        String query = "SELECT COUNT(ANSWER_ID) AS CNT "+
        " FROM user_reserv_qa "+
        "WHERE QUESTION_ID = ?"+
        "GROUP BY ANSWER_ID;";

        ResultSet resultset;

        try(
           resultset = statement.executeQuery(query);
            
           System.out.println("|     구분     | 접근 편리성 | 직원 친절도 | 호텔 청결도 | 음식 만족도 | 시설 만족도 |"
           );



        )catch(SQLException exception){
            exception.printStackTrace();
        }

    }


    
}
