select * from mem order by num desc
delete from mem;
commit

alter table mem add constraint mem_num_con primary key(num);

insert into mem values(40,'aaa',20,'korea')
insert into mem values(40,'bbb',20,'korea')

