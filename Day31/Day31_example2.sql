select *
from sample;


-- 행의 모든 컬럼의 값을 지정해서 추가하기
insert into sample
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
values
(101, '자바의정석', '남궁성', 35000, 29000, 1000, sysdate);

-- 행의 특정 컬럼에만 값을 지정해서 추가하기
insert into sample
(book_no, book_title, book_writer, book_price)
values
(102, '이것이 자바다', '신용권', 27000);

-- 테이블에 저장된 모든 데이터 삭제
delete from sample;

-- 테이블에 저장된 데이터 중에서 특정 행을 삭제하기
delete from sample
where book_title like '%자바%';

-- 테이블에 저장된 데이터 변경하기
-- 테이블의 모든 행에 대해서 book_price 컬럼의 값을 10000으로 변경하기
update sample
set book_price = 10000;

-- 테이블의 특정 행에 대해서 book_price 컬럼의 값을 32000으로 변경
UPDATE SAMPLE
set book_price = 32000
where book_no = 101;

-- sample-books 테이블에 새로운 책 정보 추가하기 (3개 이상, 책 번호는 겹치지 않도록 한다.)
insert into sample
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
values
--(103, '50억 부자아빠의 현실경제수업', '정선용', 16000, 14000, 100)
--(104, '달러구트 꿈 백화점', '이미예', 13800, 12420, 100)
--(105, '설민석의 한국사 대모험]', '설민석', 12000, 10800, 100)
--(106, '어떻게 말해줘야 할까', '오은영', 17500, 16000, 100)
(107, '질서 너머', '조던 피터슨', 17800, 16020, 150);

-- 책번호가 104번인 책 삭제하기
delete from sample
where book_no = 104;

-- 책번호가 103번인 책 삭제하기
delete from sample
where book_no = 103;

-- 모든 책 정보 삭제하기
delete from sample;

