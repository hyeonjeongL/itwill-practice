insert into userinfo(userid,password,name,email) values('guard1','1111','���ȣ1','guard1@korea.com');
insert into userinfo(userid,password,name,email) values('guard2','2222','���ȣ2','guard2@korea.com');
insert into userinfo(userid,password,name,email) values('guard3','3333','���ȣ3','guard3@korea.com');

--pk update
update  userinfo 
set password='1111',name='�̸�����',email='change@naver.com' 
where userid='guard1';
--pk delete
delete userinfo where userid='guard1';

--select pk
select userid,password,name,email from userinfo where userid='guard2';

--select all
select userid,password,name,email from userinfo;

--select count by userid
select count(*) cnt from userinfo where userid='guard1'; 
select count(*) cnt from userinfo where userid='guard2'; 




commit;