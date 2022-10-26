package kh.survey.model;

import java.io.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kh.survey.controller.Controller;

public class Model {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Controller controller = new Controller();

    private String userId;
    private String loginId;
    private String loginPw;
    private String checkIn;
    private String checkOut;
    private int answer1;
    private int answer2;
    private int answer3;
    private int answer4;
    private int answer5;

    public void menu() { // 현정

        try {

            String url = "jdbc:mysql://localhost:3306/hotelsurvey";
            String user = "root";
            String password = "*khacademy!";

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            System.out.println("-----------------------------------------------------------\r\n" + "Welcome :)\r\n"
                    + "L4 Hotel Satisfaction Survey Manager Run.\r\n"
                    + "-----------------------------------------------------------\n");

            Loop: while (true) {

                try {
                    System.out.print("실행할 메뉴를 입력해주세요.\n[A] 만족도 설문 시작\n[B] 전체 통계 조회\n[Z] 프로그램 종료\n입력 > ");
                    String input = br.readLine();

                    switch (input) {
                        case "A":
                            startSurvey(statement);
                            break;

                        case "B":
                            inquery();
                            break;

                        case "Z":
                            break Loop;

                        default:
                            System.out.println("\n잘못 입력하셨습니다. 다시 입력해주세요.\n");
                    }
                } catch (IOException ioException) {
                } finally {
                    System.out.print("\n-----------------------------------------------------------\r\n"
                            + "Good Bye :)\r\n" + "Exit L4 Hotel Satisfaction Survey Manager.\r\n"
                            + "-----------------------------------------------------------\n");

                }
            }

        } catch (SQLException sqlException) {
            System.out.print("\n-----------------------------------------------------------\r\n"
                    + "Cannot Find DB\r\n"
                    + "-----------------------------------------------------------\n");
        }
    }

    public void startSurvey(Statement statement) { // 성수

        try {

            System.out.println("-----------------------------------------------------------");
            System.out.println("L4 호텔 이용 만족도 설문을 시작합니다.");
            System.out.println("-----------------------------------------------------------");

            System.out.println("[ 1 ] 아이디를 입력해주세요.");
            System.out.print("입력 > ");
            loginId = br.readLine();

            System.out.println("[ 2 ] 비밀번호를 입력해주세요.");
            System.out.print("입력 > ");
            loginPw = br.readLine();

            while (true) {
                System.out.println("[ 3 ] 투숙 기간을 입력해주세요. ( ex. 2022-10-21 )");
                System.out.print("Check In > ");
                checkIn = br.readLine();
                System.out.print("Check Out > ");
                checkOut = br.readLine();

                Pattern pattern = Pattern
                        .compile("(?:(?:19|20)[\\d]{2})-[0-1][0-2]-(0[1-9]|[12][0-9]|3[01])$");
                Matcher matcher1 = pattern.matcher(checkIn);
                Matcher matcher2 = pattern.matcher(checkOut);

                if (matcher1.find() && matcher2.find()) {
                    break;
                }

                System.out.println("날짜 양식과 동일하게 입력해주세요.");

            }

            String userId = controller.checkUserId(statement, loginId, loginPw, checkIn, checkOut);

            if (userId.equals("Eception")) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("일치하는 정보가 없어 처음으로 돌아갑니다.");
                System.out.println("정보를 다시 확인해주세요.");
                System.out.println("-----------------------------------------------------------");
                return;
            }

            while(true){
            System.out.println("[ 4 ] 호텔을 찾아오시는 길은 편리하셨습니까?");
            System.out.println("[ 1 : 매우 불만 ] [ 2 : 불만 ] [ 3 : 만족 ] [ 4 : 매우 만족 ]");
            System.out.print("번호입력 > ");
            
            answer1 = parseInt(br.readLine());
                if(answer1>0 || answer1<5){
                    break;
                }
                    System.out.println("정상적인 숫자를 입력하세요");
                
            }
            
            System.out.println("[ 5 ] 호텔의 전체적인 청결도는 만족하셨습니까?");
            System.out.println("[ 1 : 매우 불만 ] [ 2 : 불만 ] [ 3 : 만족 ] [ 4 : 매우 만족 ]");
            System.out.print("번호입력 > ");

            answer2 = parseInt(br.readLine());
     
            
            System.out.println("[ 6 ] 식당의 음식 만족도는 어떠셨습니까?");
            System.out.println("[ 1 : 매우 불만 ] [ 2 : 불만 ] [ 3 : 만족 ] [ 4 : 매우 만족 ]");
            System.out.print("번호입력 > ");

            answer3 = parseInt(br.readLine());
       
     
            
            System.out.println("[ 7 ] 호텔을 찾아오시는 길은 편리하셨습니까?");
            System.out.println("[ 1 : 매우 불만 ] [ 2 : 불만 ] [ 3 : 만족 ] [ 4 : 매우 만족 ]");
            System.out.print("번호입력 > ");

            answer4 = parseInt(br.readLine());
           
         
            
            System.out.println("[ 8 ] 부대시설 이용은 편리하셨습니까?");
            System.out.println("[ 1 : 매우 불만 ] [ 2 : 불만 ] [ 3 : 만족 ] [ 4 : 매우 만족 ]");
            System.out.print("번호입력 > ");

            answer5 = parseInt(br.readLine());
     
            
        
        } catch (IOException ioException) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("입력 오류가 발생되어 처음으로 돌아갑니다.");
            System.out.println("-----------------------------------------------------------");
        }

    }

    private int parseInt(String readLine) {
        return 0;
    }

    public void inquery() { // 보경

        // 조회기능 구현
        // 조회 메서드 호출

    }

}