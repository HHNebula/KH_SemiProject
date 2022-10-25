package kh.survey.controller;

import java.sql.*;

public class Statistics {

    public void statistics(Statement statement) {

//최종목적

// |     구분     | 매우 불만 |   불만   |   만족   |   매우만족   |
// | 접근 편리성 |     n     |     n    |     n    |      n      |
// | 직원 친절도 |     n     |     n    |     n    |      n      |
// | 호텔 청결도 |     n     |     n    |     n    |      n      |
// | 음식 만족도 |     n     |     n    |     n    |      n      |
// | 시설 만족도 |     n     |     n    |     n    |      n      | 



// 갯수 구하는 쿼리
        String query = "SELECT questions.QUESTION AS 질문들, COUNT(CASE WHEN ANSWER_ID = 'AS1' THEN 1 END ) AS '매우 불만',"+
        "COUNT(CASE WHEN ANSWER_ID = 'AS2' THEN 1 END ) AS '불만' ," +
        "COUNT(CASE WHEN ANSWER_ID = 'AS3' THEN 1 END ) AS '만족'," +
        "COUNT(CASE WHEN ANSWER_ID = 'AS4' THEN 1 END ) AS '매우 만족'"+
        "FROM user_reserv_qa"+
        "INNER JOIN questions ON user_reserv_qa.QUESTION_ID = questions.QUESTION_ID"+
        "GROUP BY user_reserv_qa.QUESTION_ID";

        ResultSet resultset;


        // 통계 보여주는 부분
        // while문으로 데이터가 없을때까지 추출
        try {
           resultset = statement.executeQuery(query);
            
           System.out.println("|     구분     | 매우 불만 |  불만  |  만족  | 매우 만족 |");
           while(resultset.next()){
            String Question = resultset.getString("질문들");
            int AS1 = resultset.getInt("매우 불만");
            int AS2 = resultset.getInt("불만");
            int AS3 = resultset.getInt("만족");
            int AS4 = resultset.getInt("매우 만족");
            System.out.printf("%s : %3d %3d %3d %3d \n" ,Question, AS1, AS2, AS3, AS4 );

           
        }


        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

}
