------------------------- 단일행 서브 쿼리 -------------------------------------------------
-- 전체사원의 평균급여보다 급여를 적게 받는 사원들의 아이디, 이름, 급여를 조회하기
--1.
select avg(salary)
from employees;
--2.
select employee_id, first_name, salary
from employees
where salary < (select avg(salary)
                from employees);

-- 100번 사원과 같은 부서에서 근무하는 사원들의 사원아이디, 이름을 조회하기
-- 1. 100번 사원이 소속되어 있는 부서아이디
select department_id
from employees
where employee_id = 100;

-- 2. 90번 부서에서 근무하고 있는 사원들의 사원아이디, 이름 조회하기
select employee_id, first_name
from employees
where department_id = 90;

-- 3. 100번 사원과 같은 부서에서 근무하는 사원들의 사원아이디, 이름을 조회하기
select employee_id, first_name
from employees
where department_id = (select department_id
                       from employees
                       where employee_id = 100);
                       
-------------------------- 다중행 서브쿼리 --------------------------------------------------                                               
-- 부서별 평균급여를 조회했을 때 평균급여가 5000달러 이하 부서에 근무중인 사원들 조회하기
-- 1. 부서별 평균급여를 조회했을 때 평균급여가 5000달러 이하인 부서
select department_id, avg(salary)
from employees
where department_id is not null
group by department_id
having avg(salary) < 5000;

-- 2. 5000달러 이하 부서에 근무중인 사원들 조회하기
select department_id, employee_id, first_name
from employees
where department_id in (10, 30, 50);


-- 3. 부서별 평균급여를 조회했을 때 평균급여가 5000달러 이하 부서에 근무중인 사원들 조회하기
select department_id, employee_id, first_name
from employees
where department_id in (select department_id
                        from employees
                        where department_id is not null
                        group by department_id
                        having avg(salary) < 5000);

                        
-- 직종최소급여가 10000달러 이상인 직종에 종사중인 사원들이 아이디, 이름, 직종아이디를 조회하기
-- 1. 직종최소급여가 10000달러 이상인 직종
select job_id
from jobs
where min_salary >= 10000;

--2. 직종최소급여가 10000달러 이상인 직종에 종사중인 사원
select employee_id, first_name
from employees
where job_id in ('AD_PRES', 'AD_VP', 'SA_MAN');

-- 3. 직종최소급여가 10000달러 이상인 직종에 종사중인 사원들이 아이디, 이름, 직종아이디를 조회하기
select employee_id, first_name, job_id
from employees
where job_id in (select job_id
                 from jobs
                 where min_salary >= 10000);
                 
-- 서브쿼리로 해결되는 문제를 조인으로 해결하기
select E.employee_id, E.first_name, J.job_id
from employees E, jobs J
where E.job_id = J.job_id
and J.min_salary >= 10000;

-- 50번 부서에 소속된 사원중에서 60번 부서에 소속된 직원의 급여보다 급여를 많이 받는 
-- 사원의 아이디, 이름, 급여를 조회하기
-- 1. 60번부서에 소속된 사원들의 급여 조회
select employee_id, first_name, salary
from employees
where department_id = 60;


-- 2. 60번 부서에 소속된 직원의 모든 급여보다 급여를 많이 받는 50번 부서의 사원 조회
select employee_id, first_name, salary
from employees
where salary > all (select salary
                    from employees
                    where department_id = 60)
and department_id = 50;

-- 2. 60번 부서에 소속된 직원의 급여 중 아무꺼나 하나보다 급여를 많이 받는 50번 부서의 사원 조회
select employee_id, first_name, salary
from employees
where salary > any (select salary
                    from employees
                    where department_id = 60)
and department_id = 50;

-- 3. 50번 부서에 소속된 사원중에서 60번 부서에 소속된 직원의 급여보다 급여를 많이 받는 
-- 사원의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from employees
where salary > any (select salary
                    from employees
                    where department_id = 60)
and department_id = 50;

-- ">all"은 "> max()"로 대체할 수 있다.
select employee_id, first_name, salary
from employees
where salary > (select max(salary)
                    from employees
                    where department_id = 60)
and department_id = 50;

