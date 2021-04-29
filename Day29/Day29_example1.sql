
-- 테이블 조회하기
-- 사원아이디, 사원명, 소속부서아이디, 소속부서명
-- employees 테이블 -> 사원아이디, 사원명, 소속부서아이디
-- departments 테이블 -> 소속부서명 
select E.employee_id, E.first_name, E.department_id, D.department_name
from employees E, departments D
where E.department_id = D.department_id;



-- 테이블 조인하기
-- 사원아이디, 이름, 직종아이디, 급여, 직종제목, 직종 최소 급여, 직종 최대 급여 조회하기
-- employees 테이블 -> 사원아이디, 이름, 직종아이디, 급여
-- jobs 테이블 -> 직종아이디, 직종제목, 직종 최저급여, 직종 최고급여
select E.employee_id, E.first_name, E.job_id, E.salary, J.job_title,
        J.min_salary, J.max_salary
from employees E, jobs J
where E.job_id = J.job_id;


-- 테이블 조인하기
-- 부서아이디, 부서명, 소재지 아이디, 소재지 주소, 소재지 도시명 조회하기
-- departments -> 부서아이디, 부서명, 소재지아이디
-- locations -> 소재지 주소, 소재지 도시명
select D.department_id, D.department_name, D.location_id, L.street_address, l.city
from departments D,locations L
where D.location_id = L.location_id;

-- 테이블 조인하기
-- 부서관리자가 지정되어 있는 부서의 부서아이디, 부서명, 부서관리자 아이디, 부서관리자 이름 조회하기
-- departments -> 부서아이디, 부서명, 부서관리자아이디
-- employees -> 부서관리자이름(사원이름)
-- departments의 manager_id는 부서관리자로 지정된 사원의 사원아이디다.
-- departments의 manager_id와 동일한 사원아이디를 가진 사원정보가 조인되어야한다.
select D.department_id, D.department_name, D.manager_id, e.first_name
from departments D, employees E
where D.manager_id = E.employee_id
and D.manager_id is not null;

-- 3개 이상의 테이블 조인하기
-- 사원아이디, 사원이름, 직종아이디, 급여, 직종최저급여, 직종최고급여, 소속부서 아이디, 부서명
-- employees -> 사원아이디, 사원이름, 직종아이디, 급여, 소속부서아이디
-- jobs -> 직종최저급여, 직종최고급여
-- departments -> 부서명
select E.employee_id, E.first_name, E.job_id, E.salary, J.min_salary, J.max_salary, D.department_id, D.department_name
from employees E, jobs J, departments D
where E.job_id = J.job_id
and E.department_id = D.department_id;



-- 100번 사원의 이름, 전화번호, 이메일, 
-- 소속부서아이디, 소속부서명, 소속부서 도시명, 소속부서 소재지주소 조회하기
select D.department_id, D.department_name, L.city, L.street_address
from employees E, departments D, locations L
where E.department_id = D.department_id
and D.location_id = l.location_id
and E.employee_id = 100;



-- 50번 부서에 소속된 사원들의 사원아이디, 이름, 직종아이디, 직종제목 조회하기
-- 사원아이디, 이름, 직종아이디 --> employees
-- 직종제목 --> jobs
select E.employee_id, E.first_name, J.job_id, J.job_title
from employees E, jobs J
where E.job_id = E.job_id
and E.department_id = 50;


-- 급여를 15000이상 받은 사원들의 이름, 직종아이디, 급여, 부서명을 조회하기
-- 급여를 15000이상, 급여, 이름, 직종아이디 -> employees
-- 부서명 --> departments
select E.first_name, E.job_id, E.salary, D.department_name
from employees E, departments D
where E.department_id = D.department_id
and E.salary >= 15000;



-- 100 직원이 관리하는 사원들의 이름, 직종아이디, 직종제목, 부서아이디, 부서명 조회하기
-- 100번 직원, 이름, 직종아이디, 부서아이디 --> employees
-- 직종제목 --> jobs
-- 부서명 --> departments
select E.first_name, J.job_id, J.job_title, D.department_id, D.department_name
from employees E, jobs J, departments D
where E.job_id = J.job_id
and E.department_id = D.department_id
and E.manager_id = 100;
