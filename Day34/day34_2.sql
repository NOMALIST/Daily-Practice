------------------------------- 다중열 서브쿼리 -------------------------------------------     
-- 부서별 최고 급여를 받는 사원의 아이디, 이름, 급여, 부서아이디를 조회하기
-- 1. 부서별 최고급여를 조회하기
select department_id, max(salary)
from employees
where department_id is not null
group by department_id;

-- 2. 부서별 최고 급여를 받는 사원을 조회하기
select employee_id, first_name, department_id
from employees
where (department_id, salary) in (select department_id, max(salary)
                                    from employees
                                    where department_id is not null
                                    group by department_id);
                                  
                            
-------------------------- having절 서브쿼리 ------------------------------------------------
-- 부서별 사원수를 조회했을 때 가장 인원수가 많은 부서의 아이디와 인원수를 조회하기
-- 1. 부서별 사원수를 조회하기
select department_id, count(*)
from employees
where department_id is not null
group by department_id;

-- 2. 가장 많은 인원수 조회하기
select max(count(*))
from employees
where department_id is not null
group by department_id;

-- 3. 가장 많은 인원수를 보유하고 있는 부서
select department_id
from employees
where department_id is not null
group by department_id
having count(*) >= (select max(count(*))
                    from employees
                    where department_id is not null
                    group by department_id);

-- 4. 부서별 사원수를 조회했을 때 가장 인원수가 많은 부서의 아이디와 인원수를 조회하기
select department_id, count(*)
from employees
where department_id is not null
group by department_id
having count(*) in (select max(count(*))
                    from employees
                    where department_id is not null
                    group by department_id);


-- 단일행 서브쿼리 연습
-- Neena와 같은 해에 입사한 사원들의 아이디, 이름, 입사일 조회하기
select employee_id, first_name, hire_date
from employees
where to_char(hire_date, 'yyyy') in (select to_char(hire_date, 'yyyy')
                                     from employees
                                     where first_name = 'Neena');

-- Neena와 같은 해에 입사한 사원중에서 전체 사원의 평균급여보다 급여를 많이 받는
-- 사원의 아이디, 이름, 입사일, 급여를 조회하기
select employee_id, first_name, hire_date, salary
from employees
where salary > (select avg(salary)
                from employees)
and to_char(hire_date, 'yyyy') in (select to_char(hire_date, 'yyyy')
                                   from employees
                                   where first_name = 'Neena');
              
-- Neena의 상사가 소속되어 있는 부서와 같은 부서에서 근무하는 사원의 아이디,
-- 이름, 직종, 부서아이디를 조회하기
select first_name, job_id, department_id
from employees
where department_id in (select department_id
                     from departments
                     where manager_id in (select manager_id
                                          from employees
                                          where first_name in ('Neena')));

-- 60번 부서에 소속된 사원들의 급여를 인상시키기
-- (인상액은 전체 사원 평균급여의 10%, 소수점이하는 반올림한다.)
update employees
set 
    salary = salary + (select trunc(avg(salary)*0.1)
                       from employees)
where department_id = 60;

-- 다중행 서브쿼리 연습하기
-- 100 상사에게 보고하는 직원이 자신의 상사인 사원들의 아이디, 이름, 상사의 아이디를 조회하기
select employee_id, first_name, manager_id
from employees
where manager_id in(select employee_id
                    from employees
                    where manager_id = 100);
                     
-- 직종이 변경된 적이 있는 직원의 아이디, 이름, 소속부서아이디를 조회하기
select employee_id, first_name, department_id
from employees
where employee_id in (select employee_id
                      from job_history);
            
-- 'Seattle'l에 소속부서가 있는 사원들의 사원아이디e, 이름e, 부서아이디e를 조회하기
select employee_id, first_name, department_id
from employees
where department_id in (select department_id
                        from departments
                        where location_id in (select location_id
                                              from locations
                                              where city = 'Seattle'));

-- 'Steven'의 급여보다 많은 급여를 받는 사원들의 아이디, 이름, 급여를 조회하기
-- 크다, 작다와 같은 비교연산자를 사용할 때는 서브쿼리의 연산결과가 반드시 단일행이어야 한다.
select employee_id, first_name, salary
from employees
where salary > (select salary
                from employees
                where employee_id = 100);
