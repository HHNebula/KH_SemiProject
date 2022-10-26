INSERT INTO users ( USER_ID, LOGIN_ID, LOGIN_PW, NAME )
VALUES ( 'U1', 'soft', 'password!!', '홍길동' ),
('U2', 'jully', 'pp111pq', '김줄리'),
('U3', 'bona', 'ppapaaa1', '이보나'),
('U4', 'james', 'pp20184q', '박제임스'),
('U5', 'Manager', '((manager))', '매니저'),
('U6', 'Admin', '**Admin1022', '어드민');

INSERT INTO reservations ( RESERV_ID, CHECK_IN, CHECK_OUT, USER_ID )
VALUES ( 'R1', '2022-10-22', '2022-10-23', 'U1' ),
( 'R2', '2022-10-22', '2022-10-23', 'U2' ),
( 'R3', '2022-10-22', '2022-10-23', 'U3' ),
( 'R4', '2022-10-22', '2022-10-23', 'U4' ),
( 'R5', '2022-10-22', '2022-10-23', 'U5' );


INSERT INTO questions ( QUESTION_ID, QUESTION )
VALUES ( 'Q1', '접근 편리성' ),
( 'Q2', '직원 친절도' ),
( 'Q3', '호텔 청결도' ),
( 'Q4', '음식 만족도' ),
( 'Q5', '시설 편의성' );

INSERT INTO answers ( ANSWER_ID, ANSWER )
VALUES ( 'AS1', 1 ),
( 'AS2', 2 ),
( 'AS3', 3 ),
( 'AS4', 4 );