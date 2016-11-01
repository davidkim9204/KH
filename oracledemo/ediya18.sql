select * from b_member;
insert into b_member(member_num, name, gender, email, birth_date, member_id, password) 
values(SEQ_b_member_member_num.nextval,'유재민', '남', 'dfw@nate.com', '12341212', 'qwerasd', '123456');


select * from B_CAFE;
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '스타벅스');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '투썸');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '할리스');
insert into b_cafe(cafe_id, cafe_name)
values(SEQ_b_cafe_cafe_id.nextval, '이디야');

delete from b_beverage

--이디야 ------------
select * from B_BEVERAGE;
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2300, '커피', '에스프레소', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2800, '커피', '카페아메리카노', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3200, '커피', '카페라떼', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '커피', '카페모카', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '커피', '카라멜마끼아또', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '티', '레몬티', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 3500, '티', '밀크티', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2500, '티', '아이스티복숭아', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 2500, '티', '아이스티레몬', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '딸기주스', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '골드키위주스', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '주스', '홍시주스', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '플레인요거트', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '딸기요거트', '왜부적합하니');
insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)
values(SEQ_b_beverage_beverage_id.nextval, 4, 4200, '기타', '녹차요거트', '왜부적합하니');
