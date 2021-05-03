-- 포괄조인
-- 부서아이디, 부서명, 부서관리자아이디, 부서관리자 이름 조회하기
-- 부서아이디, 부서명, 부서관리자아이디 - departments
-- 부서관리자 이름 - employees
select D.department_id, D.department_name, D.manager_id, E.first_name
from departments D, employees E
where D.manager_id = E.employee_id
order by D.department_id asc;

-- 포괄 조인을 활용하면, employees테이블과 매칭되지 않는 departments의 부서정보도 조회
select D.department_id, D.department_name, D.manager_id, E.first_name
from departments D, employees E
where D.manager_id = E.employee_id(+)
order by D.department_id asc;

-- 커미션을 받는 사원들의 사원아이디, 이름, 소속부서아이디, 소속부서명 조회하기
select E.employee_id, E.first_name, D.department_id, D.department_name
from employees E, departments D
where E.department_id = D.department_id(+)
and E.commission_pct is not null;

-- 90번 부서에서 소속된 사원들의 사원아이디, 이름, 해당 사원의 상사의 이름을 조회하기
select E.employee_id, E.first_name, M.first_name manager_name
from employees E, employees M
where E.manager_id = M.employee_id(+)
and E.department_id = 90;

-- 90번 부서에 소속된 사원들의 아이디, 이름, 직종제목 조회하기(오라클조인)
select E.employee_id, E.first_name, J.job_title
from employees E, jobs J
where E.job_id = J.job_id
and E.department_id = 90;

-- 90번 부서에 소속된 사원들의 아이디, 이름, 직종제목 조회하기(ANSI-조인)
select E.employee_id, E.first_name, J.job_title
from employees E join jobs J on E.job_id = J.job_id
where E.department_id = 90;

-- 90번 부서에 소속된 사원의 아이디, 이름, 직종아이디, 직종제목, 소속부서 아이디, 소속부서명 조회하기
-- 사원의 아이디, 이름, 직종아이디, 소속부서아이디 - employees
-- 직종아이디, 직종제목 - jobs
-- 소속부서아이디, 소속부서명 - departments (오라클조인)
select E.employee_id, E.first_name, J.job_id, J.job_title, D.department_id, D.department_name
from employees E, jobs J, departments D
where E.job_id = J.job_id
and E.department_id = D.department_id
and E.department_id = 90;


-- 90번 부서에 소속된 사원의 아이디, 이름, 직종아이디, 직종제목, 소속부서 아이디, 소속부서명 조회하기
-- 사원의 아이디, 이름, 직종아이디, 소속부서아이디 - employees
-- 직종아이디, 직종제목 - jobs
-- 소속부서아이디, 소속부서명 - departments (ANSI-조인)
select E.employee_id, E.first_name, J.job_id, J.job_title, D.department_id, D.department_name
from employees E join jobs J on E.job_id = J.job_id
                 join departments D on E.department_id = D.department_id
where E.department_id = 90;

-- 90번 부서에 소속된 사원의 아이디, 이름, 급여, 급여등급을 조회하기 (오라클조인)
select E.employee_id, E.first_name, E.salary, G.grade
from employees E, salary_grade G 
where E.salary >= G.min_salary
and E.salary <= G.max_salary
and E.department_id = 90;

-- 90번 부서에 소속된 사원의 아이디, 이름, 급여, 급여등급을 조회하기 (ANSI-조인)
select E.employee_id, E.first_name, E.salary, G.grade
from employees E join salary_grade G on E.salary >= G.min_salary
                                     and E.salary <= G.max_salary
where E.department_id = 90;
-- 부서아이디, 부서명, 부서담당자 아이디, 부서담당자 이름 조회하기
-- 부서담당자가 결정되어 있지 않은 부서도 조회한다. (오라클조인)
select D.department_id, D.department_name, E.employee_id, E.first_name
from departments D, employees E
where D.manager_id = E.employee_id(+)
order by department_id asc;

-- 부서아이디, 부서명, 부서담당자 아이디, 부서담당자 이름 조회하기
-- 부서담당자가 결정되어 있지 않은 부서도 조회한다. (ANSI-조인)
select D.department_id, D.department_name, E.employee_id, E.first_name
from departments D left outer join employees E on D.manager_id = E.employee_id;

select D.department_id, D.department_name, E.employee_id, E.first_name
from employees E right outer join departments D on D.manager_id = E.employee_id;