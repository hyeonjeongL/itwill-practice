--insert
insert into GUEST values(guest_no_seq.nextval , '���ȣ1', sysdate, 'guard1@naver.com', 'http://', '���� ����1', '����ó�� ����Ͻø� �˴ϴ�1');
insert into GUEST values(guest_no_seq.nextval , '���ȣ2', sysdate, 'guard2@naver.com', 'http://', '���� ����2', '����ó�� ����Ͻø� �˴ϴ�2');
insert into GUEST values(guest_no_seq.nextval , '���ȣ3', sysdate, 'guard3@naver.com', 'http://', '���� ����3', '����ó�� ����Ͻø� �˴ϴ�3');
insert into GUEST values(guest_no_seq.nextval , '���ȣ4', sysdate, 'guard4@naver.com', 'http://', '���� ����4', '����ó�� ����Ͻø� �˴ϴ�4');
--delete
delete from guest where guest_no = 1;
--update
update guest set guest_name='name����',guest_email='email����',guest_homepage='homepage����',guest_title='title����',guest_content='content����' where guest_no = 3;
--select pk
select * from guest where guest_no = 3;

--select all
select * from guest;

commit;

DESC guest;