
/* Drop Tables */

DROP TABLE Books_detail CASCADE CONSTRAINTS;
DROP TABLE favorite CASCADE CONSTRAINTS;
DROP TABLE Rental CASCADE CONSTRAINTS;
DROP TABLE Reservation CASCADE CONSTRAINTS;
DROP TABLE Book CASCADE CONSTRAINTS;
DROP TABLE Book_club CASCADE CONSTRAINTS;
DROP TABLE Request_board CASCADE CONSTRAINTS;
DROP TABLE Seat_reservation CASCADE CONSTRAINTS;
DROP TABLE User_info CASCADE CONSTRAINTS;
DROP TABLE Book_category CASCADE CONSTRAINTS;
DROP TABLE Notice CASCADE CONSTRAINTS;
DROP TABLE Seat CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE Book
(
	book_no number NOT NULL UNIQUE,
	book_title number NOT NULL,
	book_author varchar2(100),
	book_publisher varchar2(100),
	book_summary varchar2(500),
	book_publish_date date,
	book_input_date date,
	book_image varchar2(500),
	book_page number,
	book_qty number,
	book_res_count number,
	rental_status number,
	res_status number,
	category_no number NOT NULL,
	PRIMARY KEY (book_no)
);


CREATE TABLE Books_detail
(
	books_no number NOT NULL,
	isbn_no number NOT NULL,
	rental_status number NOT NULL,
	res_status number NOT NULL,
	book_no number NOT NULL UNIQUE,
	PRIMARY KEY (books_no)
);


CREATE TABLE Book_category
(
	category_no number NOT NULL,
	category_name varchar2(50),
	PRIMARY KEY (category_no)
);


CREATE TABLE Book_club
(
	club_no number NOT NULL,
	club_name varchar2(50),
	club_readcount number,
	club_count number,
	club_person varchar2(50),
	club_time varchar2(100),
	club_place varchar2(100),
	club_content varchar2(500),
	category_no number NOT NULL,
	user_no number NOT NULL,
	PRIMARY KEY (club_no)
);


CREATE TABLE favorite
(
	favorite_no number NOT NULL,
	user_no number NOT NULL,
	book_no number NOT NULL,
	PRIMARY KEY (favorite_no)
);


CREATE TABLE Notice
(
	notice_no number NOT NULL,
	notice_title varchar2(100),
	notice_date date,
	notice_content varchar2(600),
	notice_image varchar2(100),
	notice_readcount number,
	PRIMARY KEY (notice_no)
);


CREATE TABLE Rental
(
	rental_no number NOT NULL,
	rental_date date,
	return_date date,
	rental_count number,
	user_no number NOT NULL,
	book_no number NOT NULL,
	PRIMARY KEY (rental_no)
);


CREATE TABLE Request_board
(
	board_no number NOT NULL,
	board_title varchar2(50),
	board_date date,
	board_content varchar2(50),
	board_readcount number,
	board_status varchar2(100),
	board_type_no number,
	board_depth number,
	board_step number,
	board_groupno number,
	category_no number NOT NULL,
	user_no number NOT NULL,
	PRIMARY KEY (board_no)
);


CREATE TABLE Reservation
(
	res_no number NOT NULL,
	res_date date,
	user_no number NOT NULL,
	book_no number NOT NULL,
	PRIMARY KEY (res_no)
);


CREATE TABLE Seat
(
	seat_no number NOT NULL,
	seat_count number,
	PRIMARY KEY (seat_no)
);


CREATE TABLE Seat_reservation
(
	seat_res_no number NOT NULL,
	seat_date date,
	seat_status varchar2(50),
	seat_start_time varchar2(50),
	seat_end_time varchar2(50),
	seat_no number NOT NULL,
	user_no number NOT NULL,
	PRIMARY KEY (seat_res_no)
);


CREATE TABLE User_info
(
	user_no number NOT NULL,
	user_name varchar2(50),
	user_id varchar2(100) NOT NULL,
	user_password varchar2(20),
	user_email varchar2(100),
	user_birth date,
	user_gender varchar2(50),
	user_phone varchar2(30),
	user_address varchar2(50),
	user_qr varchar2(50),
	category_no number NOT NULL,
	user_rental_stop_term number,
	user_rental_status number,
	PRIMARY KEY (user_no)
);



/* Create Foreign Keys */

ALTER TABLE Books_detail
	ADD FOREIGN KEY (book_no)
	REFERENCES Book (book_no)
;


ALTER TABLE favorite
	ADD FOREIGN KEY (book_no)
	REFERENCES Book (book_no)
;


ALTER TABLE Rental
	ADD FOREIGN KEY (book_no)
	REFERENCES Book (book_no)
;


ALTER TABLE Reservation
	ADD FOREIGN KEY (book_no)
	REFERENCES Book (book_no)
;


ALTER TABLE Book
	ADD FOREIGN KEY (category_no)
	REFERENCES Book_category (category_no)
;


ALTER TABLE Book_club
	ADD FOREIGN KEY (category_no)
	REFERENCES Book_category (category_no)
;


ALTER TABLE Request_board
	ADD FOREIGN KEY (category_no)
	REFERENCES Book_category (category_no)
;


ALTER TABLE User_info
	ADD FOREIGN KEY (category_no)
	REFERENCES Book_category (category_no)
;


ALTER TABLE Seat_reservation
	ADD FOREIGN KEY (seat_no)
	REFERENCES Seat (seat_no)
;


ALTER TABLE Book_club
	ADD FOREIGN KEY (user_no)
	REFERENCES User_info (user_no)
;


ALTER TABLE favorite
	ADD FOREIGN KEY (user_no)
	REFERENCES User_info (user_no)
;


ALTER TABLE Rental
	ADD FOREIGN KEY (user_no)
	REFERENCES User_info (user_no)
;


ALTER TABLE Request_board
	ADD FOREIGN KEY (user_no)
	REFERENCES User_info (user_no)
;


ALTER TABLE Reservation
	ADD FOREIGN KEY (user_no)
	REFERENCES User_info (user_no)
;


ALTER TABLE Seat_reservation
	ADD FOREIGN KEY (user_no)
	REFERENCES User_info (user_no)
;



