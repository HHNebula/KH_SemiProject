-- 권한들 테이블 값 입력
INSERT INTO auths (AUTH_ID, AUTH_NAME)
VALUE ('A1','GUEST')
;
INSERT INTO auths (AUTH_ID, AUTH_NAME)
VALUE ('A2','ADMIN')
;
-- 권한들 테이블 값 확인
SELECT * 
FROM auths
;

-- 사용자들 테이블 값 입력
INSERT INTO users(USER_ID, LOGIN_ID, LOGIN_PW, NAME, AUTH_ID)
VALUE ('U1', 'soft', 'password!!', '홍길동', 'A1')
;
INSERT INTO users(USER_ID, LOGIN_ID, LOGIN_PW, NAME, AUTH_ID)
VALUE ('U2','jully', 'pp111pq', '김줄리', 'A1')
;
INSERT INTO users(USER_ID, LOGIN_ID, LOGIN_PW, NAME, AUTH_ID)
VALUE ('U3','bona', 'ppapaaa1', '이보나', 'A1')
;
INSERT INTO users(USER_ID, LOGIN_ID, LOGIN_PW, NAME, AUTH_ID)
VALUE ('U4','james', 'pp20184q', '박제임스', 'A1')
;
INSERT INTO users(USER_ID, LOGIN_ID, LOGIN_PW, NAME, AUTH_ID)
VALUE ('U5','Manager', '((manager))', '매니저', 'A2')
;
INSERT INTO users(USER_ID, LOGIN_ID, LOGIN_PW, NAME, AUTH_ID)
VALUE ('U6','Admin', '**Admin1022', '어드민', 'A2')
;

-- 로그인 확인 아이디 비번 찾아오기(?)
SELECT LOGIN_ID
FROM users
WHERE LOGIN_ID = 'soft' 
;
SELECT LOGIN_PW
FROM users
WHERE LOGIN_PW = 'password!!'
;

-- 사용자들 테이블 값 확인
SELECT * 
FROM users
;

-- 투숙내역 테이블 값 입력
INSERT INTO reservations(RESERVATION_ID, CHECK_IN, CHECK_OUT, USER_ID)
VALUE ('R1', '2022-10-22', '2022-10-23', 'U2')
;
INSERT INTO reservations(RESERVATION_ID, CHECK_IN, CHECK_OUT, USER_ID)
VALUE ('R2', '2022-04-28', '2022-04-30', 'U3')
;
INSERT INTO reservations(RESERVATION_ID, CHECK_IN, CHECK_OUT, USER_ID)
VALUE ('R3', '2022-08-30', '2022-09-02', 'U4')
;

-- 투숙내역 테이블 값 확인
SELECT * 
FROM reservations
;

-- 체크인 날짜 확인
SELECT CHECK_IN
FROM reservations
WHERE CHECK_IN = '2022-10-22'
;

-- 질문 테이블 값 입력
INSERT INTO questions(QUESTION_ID, QUESTION)
VALUE ('Q1', '호텔을 찾아오시는 길은 편리하셨습니까?')
;
INSERT INTO questions(QUESTION_ID, QUESTION)
VALUE ('Q2', '호텔의 직원들은 얼마나 친절하였습니까?')
;
INSERT INTO questions(QUESTION_ID, QUESTION)
VALUE ('Q3', '호텔의 전체적인 청결도는 만족하셨습니까?')
;
INSERT INTO questions(QUESTION_ID, QUESTION)
VALUE ('Q4', '식당의 음식 만족도는 어떠셨습니까?')
;
INSERT INTO questions(QUESTION_ID, QUESTION)
VALUE ('Q5', '부대시설 이용은 편리하셨습니까?')
;


-- 질문들 테이블 값 확인
SELECT * 
FROM questions
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U2', 'Q1','AS1')
;


-- 설문응답 값 입력
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS1', 2)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS2', 3)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS3', 3)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS4', 4)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS5', 1)
;

INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS6', 1)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS7', 3)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS8', 4)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS9', 2)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS10', 1)
;

INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS11', 1)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS12', 2)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS13', 4)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS14', 3)
;
INSERT INTO answers(ANSWER_ID, ANSWER)
VALUE ('AS15', 3)
;

-- 설문응답 값 확인
SELECT * 
FROM answers
;



-- 설문 값 입력

-- U2
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U2', 'Q1','AS1')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U2', 'Q2','AS2')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U2', 'Q3','AS3')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U2', 'Q4','AS4')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U2', 'Q5','AS5')
;

-- U3
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U3', 'Q1','AS6')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U3', 'Q2','AS7')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U3', 'Q3','AS8')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U3', 'Q4','AS9')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U3', 'Q5','AS10')
;

-- U4

INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U4', 'Q1','AS11')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U4', 'Q2','AS12')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U4', 'Q3','AS13')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U4', 'Q4','AS14')
;
INSERT INTO surveys(USER_ID, QUESTION_ID, ANSWER_ID)
VALUE ('U4', 'Q5','AS15')
;

-- 설문 값 확인
SELECT * 
FROM surveys
;


-- 질문과 답 값 넣기
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q1', 'AS1')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q2', 'AS2')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q3', 'AS3')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q4', 'AS4')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q5', 'AS5')
;

INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q1', 'AS6')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q2', 'AS7')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q3', 'AS8')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q4', 'AS9')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q5', 'AS10')
;

INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q1', 'AS11')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q2', 'AS12')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q3', 'AS13')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q4', 'AS14')
;
INSERT INTO que_ans(QUESTION_ID,ANSWER_ID)
VALUE ('Q5', 'AS15')
;

-- 질문과 답 값 확인
SELECT * 
FROM que_ans
;