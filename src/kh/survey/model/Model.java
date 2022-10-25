package kh.survey.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private String userId;
    private String loginId;
    private String loginPw;
    private String name;
    private String checkIn;
    private String checkOut;

    public Model() throws IOException {
        menu();
        br.readLine();
    }

    public void menu()  { // 현정

         // 메뉴 출력
        // A > 설문 시작
        // B > 전체 통계 조회
        // Z 종료


}

   public void verification(String loginID, String loginPW){
//    -- +string verification(String loginId, String loginPw)
//    메서드 호출해서 USER_ID 리턴
//    만일 정보가 없다면 exception 발생 // 현정
   
   
 
    
   }
    

    public void startSurvey() { // 성수

        // 설문 구현

        // 사용자한테 정보 입력 요구
        
        // 유효검 검사 > 메서드 호출
        
        // INSERT 메서드 호출

    }

    public void inquery() { // 보경

        // 조회기능 구현
        // 조회 메서드 호출

    }
    
}
