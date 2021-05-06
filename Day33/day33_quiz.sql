-- quiz
-- 사원아이디, 이름, 소속부서 아이디, 소속부서명을 조회하기
select E.employee_id, E.first_name, E.department_id, D.department_name
from employees E, departments D
where E.department_id = D.department_id
order by 1, 3;



-- 60번부서에 소속된 사원들의 사원아이디, 이름, 급여, 직종아이디, 직종제목, 직종최저급여, 직종최고급여를 조회하기
select E.employee_id, E.first_name, E.salary, J.job_id, J.job_title, J.min_salary, J.max_salary
from employees E, jobs J
where E.job_id = J.job_id
and E.department_id = 60;

-- 모든 사원들의 사원아이디, 이름, 급여, 급여등급을 조회하기
select E.employee_id, E.first_name, E.salary, SG.grade
from employees E, salary_grade SG
where E.salary >= SG.min_salary and E.salary <= SG.max_salary;


-- 60번부서에 소속된 사원들의 사원아이디, 이름, 상사의 이름을 조회하기
select E.employee_id, E.first_name, M.first_name manager_name
from employees E, employees M
where E.manager_id = M.employee_id;


-- 부서관리자가 있는 부서의 부서아이디, 부서명, 부서관리자 아이디, 부서관리자이름을 조회하기
select D.department_id, D.department_name, D.manager_id, M.first_name
from departments D, employees M
where D.manager_id = M.employee_id
and D.manager_id is not null;


-- 부서관리자가 있는 부서의 부서소재지 도시명을 중복없이 조회하기
select distinct L.city
from departments D, locations L
where D.manager_id is not null
and D.location_id = L.location_id;


-- 소속부서명이 'Sales'이고, 급여등급이 'A'나 'B'에 해당하는 사원들의 아이디, 이름, 급여, 급여등급을 조회하기
select E.employee_id, E.first_name, E.salary, SG.grade
from departments D, Employees E, salary_grade SG
where D.department_id = E.department_id
and (E.salary >= SG.min_salary and E.salary <= SG.max_salary)
and SG.grade in ('A', 'E');


-- 60번 부서에 소속된 사원들의 평균급여를 조회하기
select avg(salary)
from employees
where department_id = 60;


-- 직종아이디별 사원수를 조회하기
select job_id, count(*)
from employees
group by job_id
order by 2 desc;


-- 급여 등급별 사원수를 조회하기
select SG.grade, count(*)
from employees E, salary_grade SG
where E.salary >= SG.min_salary and E.salary <= SG.max_salary
group by SG.grade
order by 1;


-- 2007년 입사한 사원들의 월별 입사자 수를 조회하기
select to_char(hire_date, 'mm') hire_month, count(*)
from employees
where hire_date >= '2007.01.01' and hire_date <= '2007.12.31'
group by to_char(hire_date, 'mm')
order by hire_month;




with months 
as (
    select lpad(level, 2, 0) as month
    from dual 
    connect by level <= 12
), emp
as (
    select employee_id, first_name, to_char(hire_date, 'mm') month
    from employees
    where hire_date >= to_date('2007/01/01') and hire_date < to_date('2008/01/01')
)
select B.month, sum(nvl2(A.month, 1, 0))
from emp A, months B
where A.month(+) = B.month
group by B.month
order by 1
