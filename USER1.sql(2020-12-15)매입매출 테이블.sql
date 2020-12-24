-- user1 

CREATE TABLE tbl_iolist(
io_seq	NUMBER	NOT NULL	PRIMARY KEY	,
io_date	VARCHAR2(10)	NOT NULL,		
io_time	VARCHAR2(10)	NOT NULL,		
io_dcode	VARCHAR2(5)	NOT NULL,		
io_inout	CHAR(1)	NOT NULL,		
io_pcode	VARCHAR2(13)	NOT NULL,		
io_vat	CHAR(1)	NOT NULL,		
io_qty	NUMBER	NOT NULL,		
io_price	NUMBER	NOT NULL,		
io_amt	NUMBER,			
io_tax	NUMBER,			
io_total	NUMBER			
);

INSERT INTO tbl_iolist(io_seq, io_date,io_time,io_dcode,io_inout,io_pcode,io_vat,io_qty,io_price,io_amt,io_tax,io_total) 
VALUES ('1','2020-12-24','12:55','D001','2','P001','1','1','1','1','1','5');



DROP TABLE tbl_iolist;

CREATE SEQUENCE seq_iolist
START WITH 1 INCREMENT BY 1;

drop sequence seq_iolist;

commit;

SELECT * FROM tbl_dept;


CREATE TABLE tbl_dept(
d_code	VARCHAR2(5)	NOT NULL PRIMARY KEY,	
d_name	nVARCHAR2(20)	NOT NULL,		
d_sid	VARCHAR2(13)	NOT NULL,		
d_ceo	nVARCHAR2(20)	NOT NULL,		
d_tel	VARCHAR2(20)	NOT NULL,		
d_addr	nVARCHAR2(125),			
d_product	nVARCHAR2(125)			
		
);


DROP TABLE tbl_dept;

CREATE SEQUENCE seq_dept
START WITH 1 INCREMENT BY 1;

commit;


CREATE TABLE tbl_product(
p_code	VARCHAR2(13)	NOT NULL PRIMARY KEY,	
p_name	nVARCHAR2(50)	NOT NULL,		
p_item	nVARCHAR2(20),			
p_menuf	nVARCHAR2(50),			
p_dcode	VARCHAR2(5)	,		
p_vat	CHAR(1)	NOT NULL,		
p_iprice	NUMBER	NOT NULL,		
p_oprice	NUMBER	NOT NULL		
);


DROP TABLE tbl_product;

CREATE SEQUENCE seq_product
START WITH 1 INCREMENT BY 1;

commit;


SELECT IO.io_seq,IO.io_date,P.p_name,D.d_name,D.d_ceo,IO.io_qty,P.p_iprice,IO.io_amt,io.io_price,IO.io_total
FROM tbl_iolist IO
LEFT JOIN tbl_dept D
ON IO.io_date = D.d_name
LEFT JOIN tbl_product P
ON D.d_name = P.p_name
WHERE P.p_name IS NULL;


SELECT IO.io_date,P.p_name,D.d_name,D.d_ceo,IO.io_qty,P.p_oprice,IO.io_amt,io.io_price,IO.io_inout,IO.io_total
FROM tbl_iolist IO
LEFT JOIN tbl_dept D
ON IO.io_date = D.d_name
LEFT JOIN tbl_product P
ON D.d_name = P.p_name;

SELECT * FROM tbl_iolist;


CREATE TABLE tbl_login (
username	VARCHAR2(30)		PRIMARY KEY,
PASSWORD	nVARCHAR2(255)	NOT NULL	,
M_NAME	nVARCHAR2(30)		,
M_TEL	VARCHAR2(30)		,
M_EMAIL	VARCHAR2(30)		,
Enabled	CHAR(1)	DEFAULT '0'	,
AccountNonExpired	CHAR(1)		,
AccountNonLocked	CHAR(1)		,
CredentialsNonExpired	CHAR(1)		
);

SELECT * FROM  tbl_login;

SELECT * FROM tbl_iolist;
SELECT * FROM tbl_dept;
SELECT * FROM tbl_product;


