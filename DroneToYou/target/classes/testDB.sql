create table dronetou_member (
	dm_id varchar2(15 char) primary key,
	dm_pw varchar2(15 char) not null,
	dm_name varchar2(10 char) not null,
	dm_phone varchar2(13 char) not null,
	dm_birthday date not null,
	dm_email varchar2(30 char) not null,
	dm_photo varchar2(100 char) not null
);

select * from DRONETOU_MEMBER;

insert into DRONETOU_MEMBER 
values('test1', 'test1', '이호준', '010-4104-9936', '20020425', '1134hu@naver.com');

delete from dronetou_member
where dm_id='test1';

drop table dronetou_member cascade constraint purge;