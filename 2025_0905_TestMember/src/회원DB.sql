/*
 
 --일련번호 관리객체 
 create sequence seq_member_mem_idx
 
 
 *not null* -> 빈공간을 허용하지 않음을 나타냄. 
 
 --테이블
 create table member2
 (
 
 	mem_idx 	int,				   	--회원번호
 	mem_name 	varchar2(100) not null,	--회원명
 	mem_id		varchar2(100) not null,	--아이디	
 	mem_pwd		varchar2(100) not null,	--비밀번호
 	mem_email	varchar2(100) not null,	--이메일
 	mem_zipcode	varchar2(10)  not null,	--우편번호
 	mem_addr	varchar2(200) not null, --주소
 	mem_ip		varchar2(100) not null, --아이피
 	mem_regdate date,					--가입일자
 	mem_grade 	varchar2(100)			--등급
 	
 
 )
 --기본키
 alter table member
 	add constraint pk_member_mem_idx primary key(mem_idx);
 	
 --unique제약
 alter table member
 	add constraint unique_member_mem_id unique(mem_id);
 
 --체크제약
 alter table member
 	add constraint ck_member_mem_grade check(mem_grade in('일반','관리자'));	
 		
 				
 -- sample data
 insert into member2 values ( seq_member_mem_idx.nextVal,
 							'일길동',
 							'one',
 							'1234',
 							'one@githrd.com',
 							'12345',
 							'서울시 관악구 남붑순환로 111',
 							'192.412.456.789',
 							sysdate,
 							'일반'
 							);
 							
 insert into member2 values(seq_member_mem_idx.nextVal,
 							'김관리',
 							'admin',
 							'1234',
 							'admin@githrd.com',
 							'12345',
 							'서울시 관악구 남붑순환로 111',
 							'192.412.456.789',
 							sysdate,
 							'관리자'
 							);
 							
 							
 --DAO에 사용할 SQL
 insert into member values( seq_member_mem_idx.nextVal,?,?,?,?,?,?,?,sysdate,'일반');
 					
 select * from member2
 
 select * from member2 where mem_idx=2
 select * from member2 where mem_id='one'
 
 
 
 
 
 
 */