


/* Drop Tables */

DROP TABLE BOOK CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_BOOK_ID;




/* Create Sequences */

CREATE SEQUENCE SEQ_BOOK_ID INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE BOOK
(
	ID number NOT NULL,
	ITEM_ID number,
	GUBUN varchar2(50 char),
	TITLE varchar2(200 char),
	INFO varchar2(4000 char),
	WRITER varchar2(50 char),
	PUBLISHER varchar2(100 char),
	IMAGE varchar2(200 char),
	IMAGE_SRC varchar2(200 char),
	GIHO varchar2(100 char),
	PUB_YEAR varchar2(50 char),
	PAGE_CNT number,
	TOTAL_CNT number,
	STATUS number,
	EXPIRED_DT number,
	REG_DT date,
	PRIMARY KEY (ID)
);







