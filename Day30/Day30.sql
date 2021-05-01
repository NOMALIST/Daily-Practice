-- 모든 사원들의 아이디,이름,급여,급여등급을 조회하기
-- 아이디, 이름, 급여 - employees
-- 급여등급 = salary_grade
-- 사원의 급여가 급여등급정보의 최소급여 이상이고, 최대급여 이하인 행과 조인
select  E.employee_id, E.salary, G.grade
from employees E, salary_grade G
where E.salary >= G.min_salary and E.salary <= max_salary
order by E.salary asc;


-- 60번 부서에 소속된 사원들의 사원아이디, 사원이름, 상사의 아이디, 상사의 이름 조회하기
-- 사원아이디, 사원이름 - employees
-- 상사의 아이디, 상사의 이름 - employees
select E.employee_id, E.first_name, E.manager_id, M.first_name
from employees E, employees M
where E.manager_id = M.employee_id
and E.department_id = 60
order by E.employee_id asc;

-- 60번 부서에 소속된 사원들의 사원아이디, 사원이름, 사원의 소속부서명,
--                          상사의 아이디, 상사의 이름, 상사의 소속부서명 조회하기
-- 사원아이디, 사원이름 - employees
-- 상사의 아이디, 상사의 이름 - employees
-- 사원의 소속부서명 - departments
-- 상사의 소속부서명 - departments
select E.employee_id, E.first_name, ED.department_name,
        M.employee_id manager_id, M.first_name manager_name, MD.department_name manager_department
from employees E, employees M, departments ED, departments MD
where E.manager_id = M.employee_id
and E.department_id = ED.department_id
and M.department_id = MD.department_id
and E.department_id = 60
order by E.employee_id asc;