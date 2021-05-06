-- 다중행 함수
-- employees 테이블에 저장된 모든 사원들의 수를 조회하기
select count(*) count
from employees;


-- 60번 부서에 소속된 사원들의 수를 조회하기
select count(*) count
from employees
where department_id = 60;

-- 커미션을 받는 사원들의 수를 조회하기
select count(commission_pct)
from employees;

-- 60번 부서에 소속된 사원들이 받는 급여의 총합, 최저급여, 최고급여, 평균급여를 조회하기
select sum(salary) 급여총합, min(salary) 최저급여, max(salary) 최고급여, avg(salary) 평균급여
from employees
where department_id = 60;

-- group by를 사용해서 테이블의 행들을 그룹화하기
-- 같은 부서에 소속된 사원들끼리 그룹화한 다음, 그룹함수를 적용해보기
select department_id, count(*)
from employees
group by department_id;

-- 부서별로 사원들을 그룹화한 다음, 부서별 급여총합, 급여평균을 조회하기
select department_id, sum(salary), round(avg(salary))
from employees
group by department_id;

-- 부서별로 사원들을 그룹화한 다음, 부서별 급여총합, 급여평균을 조회하기
-- 부서이름, 부서별 급여총합, 부서별 급여평균을 조회함
select D.department_name, sum(salary), round(avg(salary))
from employees E, departments D
where E.department_id = D.department_id
group by D.department_name;

-- 부서별로 사원들을 그룹화하고, 같은 부서에 소속된 사원들을 직종으로 다시 그룹화한 다음
-- 해당 그룹에 속하는 사원들의 숫자를 조회하기
select department_id, job_id, count(*)
from employees
group by department_id, job_id
order by department_id, job_id;


-- 급여별로 사원들을 그룹화했을 때, 각 급여별 사원수를 조회하기
select trunc(salary, -3) salary_step, count(*)
from employees
group by trunc(salary, -3)
order by salary_step;


-- 급여별 사원수를 조회하기
select (trunc(salary/5000)+1)*5000 || ' 미만' salary_step, count(*)
from employees
group by trunc(salary/5000)
order by trunc(salary/5000) asc;

-- 부서별 사원수를 조회하기(having)
select department_id, count(*)
from employees
group by department_id
having count(*) >= 5 and count(*) <= 10
order by 1;


-- 2007년에 입사한 사원들의 수를 직종아이디를 기준으로 집계했을 때,
-- 3명 이상 채용된 직종의 아이디와 사원수를 조회하기
select J.job_id, count(*)
from employees E, jobs J
where E.job_id = J.job_id
and E.hire_date >= '2007.01.01' and E.hire_date <= '2007.12.31'
group by J.job_id
having count(*) >= 3;


-- 부서별 사원수를 집계했을 때 사원수가 10명 이상인 부서의 아이디, 사원수를 조회하기
select department_id, count(*)
from employees
group by department_id
having count(*) >= 10;


-- with절을 사용해서 쿼리의 실행속도를 개선 및 쿼리의 가독성을 높이기
with dept_count 
as (
    select department_id dept_id, count(*) cnt
    from employees
    group by department_id
)
select D.department_name, DC.dept_id, DC.cnt
from dept_count DC, departments D
where DC.dept_id = D.department_id
order by 2;

-- 테이블에 저장된 각 행들의 ROWID 조회하기
select rowid
from employees;


-- 1부터 시작하는 시퀀스 생성하기
create sequence practice
start with 101
nocache;

create sequence practice2
increment by 10
start with 10
nocache;

select practice.nextval
from dual;

select practice2.nextval
from dual;

-- 상품테이블에 상품정보 저장하기
insert into sample_products
(product_no, product_name, product_maker, product_category, product_price, product_discount_price)
values
(product_seq.nextval, 'iphone12 plus', 'apple' ,'스마트폰' ,1400000 ,1200000);

-- 새로운 일련번호 조회하기
select practice.nextval from dual;

-- 현재 시퀀스의 일련번호 조회하기
select practice2.currval from dual;