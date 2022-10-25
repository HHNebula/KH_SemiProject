package kh.survey.controller;

import java.sql.*;

public class Statistics {
    public void statistics(Statement statement) {

        
// 갯수 구하는 쿼리
// SELECT *
// FROM (SELECT COUNT(ANSWER_ID) AS AS1
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS1'AND QUESTION_ID = 'Q1') AS AS1
// INNER JOIN (SELECT COUNT(ANSWER_ID) AS AS2
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS2' AND QUESTION_ID = 'Q1' ) AS AS2
// INNER JOIN (SELECT COUNT(ANSWER_ID) AS AS3
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS3' AND QUESTION_ID = 'Q1' ) AS AS3
// INNER JOIN (SELECT COUNT(ANSWER_ID) AS AS4
// FROM user_reserv_qa
// WHERE ANSWER_ID = 'AS4' AND QUESTION_ID = 'Q1' ) AS AS4
// ;

// 갯수 구하는 쿼리
        String query = "SELECT COUNT(ANSWER_ID) AS CNT "+
        " FROM user_reserv_qa "+
        "WHERE QUESTION_ID = ?"+
        "GROUP BY ANSWER_ID;";

        ResultSet resultset;


        // 통계 보여주는 부분
        try (
           resultset = statement.executeQuery(query);
            
           System.out.println("|     구분     | 매우불만 | 불만 | 만족 | 매우만족 |");
           while(resultset.next()){
           System.out.print(" 접근 편리성 " );
           System.out.print(" 직원 친절도 " );
           System.out.print(" 호텔 청결도 " );
           System.out.print(" 음식 만족도 " );
           System.out.print(" 시설 만족도 " );
           
        }


        ) catch (SQLException exception) {
            exception.printStackTrace();
        }

    }


    
}
