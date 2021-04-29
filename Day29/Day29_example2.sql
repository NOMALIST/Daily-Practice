--********************************************************************
-- 모든 사원들의 사원아이디, 이름, 소속부서아이디, 소속부서명을 조회하기
select E.employee_id, E.first_name, E.department_id, D.department_name
from employees E, departments D
where E.department_id = D.department_id;

-- 모든 사원들의 사원아이디, 이름, 직종아이디, 직종제목을 조회하기
select E.employee_id, E.first_name, E.job_id, J.job_title
from employees E, jobs J
where E.job_id = J.job_id;


-- 사원들 중에서 소속부서가 정해지지 않은 사람의 아이디, 이름, 급여, 직종,
-- 직종최소급여, 직종최대급여를 조회하기
select E.employee_id, E.first_name, E.salary, E.job_id, J.min_salary, J.max_salary
from employees E, jobs J
where E.department_id is null
and E.job_id = J.job_id;

-- 2007년에 입사한 사원들의 사원아이디, 이름, 소속부서 아이디, 소속부서명을 조회하기
select E.employee_id, E.first_name, E.department_id, d.department_name
from employees E, departments D
where E.hire_date >= '2007.01.01' and E.hire_date <= '2007.12.31'
and E.department_id = D.department_id;

-- 커미션을 받은 사원들의 사원아이디, 이름, 직종, 직종제목, 소속부서아이디, 소속부서명을 조회하기
select E.employee_id, E.first_name, E.job_id, J.job_title, E.department_id, D.department_name
from employees E, departments D, jobs J
where E.commission_pct is not null
and E.department_id = D.department_id
and E.job_id = J.job_id;

-- 직종최소급여가 10000달러 이상인 직종에 종사하고 있는 사원들의
-- 아이디, 이름, 직종아이디, 급여를 조회하기
select E.employee_id, E.first_name, E.job_id, E.salary
from employees E, jobs J
where E.job_id = J.job_id
and J.min_salary >= 10000;

-- 모든 사원들의 사원아이디, 이름, 소속부서아이디, 소속부서명, 해당부서의 소재지도시 및 주소를 조회하기
select E.employee_id, E.first_name, E.department_id, D.department_name, L.city, L.street_address
from employees E, departments D, locations L
where E.department_id = D.department_id
and D.location_id = L.location_id;


-- 모든 사원들의 사원아이디, 이름, 직종아이디, 직종제목, 소속부서아이디, 소속부서명, 해당부서의 소재지 도시 및 주소
select E.employee_id, E.first_name, E.job_id, J.job_title, D.department_id, D.department_name, L.city, L.street_address
from employees E, jobs J, locations L, departments D
where E.job_id = J.job_id
and E.department_id = D.department_id
and D.location_id = L.location_id;

-- 부서 소재지 국가가 미국에 위치하고 있는 부서의 부서아이디, 부서명, 도시명을 조회하기
select D.department_id, D.department_name, L.city
from departments D, locations L
where d.location_id = l.location_id
and L.country_id = 'US';

-- 'Seattle'에서 근무하고 있는 사원들의 사원아이디, 이름, 부서아이디, 부서명을 조회하기
select E.employee_id, E.first_name, D.department_id, D.department_name
from employees E, departments D, locations L
where E.department_id = D.department_id
and D.location_id = L.location_id
and L.city = 'Seattle';

-- 2006년에 job이 변경된 기록이 있는 사원들의 사원아이디, 이름, 직종아이디를 조회하기
select E.employee_id, E.first_name, J.job_title
from employees E, jobs J, job_history JH
where E.job_id = J.job_id
and E.employee_id = JH.employee_id
and JH.start_date >= '2006.01.01' and JH.start_date <= '2006.12.31';


-- 이전에 50번 부서에서 근무한 적이 있는 사원들의 사원아이디, 이름, 근무시작일, 근무종료일, 근무당시 직종아이디를 조회하기
select E.employee_id, E.first_name, JH.start_date, JH.end_date, JH.department_id
from employees E, job_history JH
where E.employee_id = JH.employee_id
and JH.department_id = 50;

-- 사원들 중에서 자신이 근무하고 있는 직종의 최소급여와 최대급여의 평균값보다 적은 급여를받는
-- 사원의 아이디, 이름, 직종아이디, 급여, 최소급여, 최대급여, 최소/최대급여 평균값을 조회하기
-- (평균값은 (최소급여+최대급여)/2로 구한다)
select E.employee_id, E.first_name, E.salary, J.min_salary, J.max_salary, trunc(J.min_salary + J.max_salary)/2 as average
from employees E, jobs J
where E.job_id = J.job_id
and (J.min_salary + J.max_salary)/2 > E.salary;


