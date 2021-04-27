-- 급여가 10000이상 15000이하인 사원들의 아이디, 이름, 급여를 조회
select employee_id, first_name, salary
from employees
where salary >= 10000 and salary <= 15000;

-- 소속부서 아이디가 50번이고, 급여를 3000이상 받는 사원의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary, department_id
from employees
where department_id = 50 and salary >= 3000;

-- 직종 아이디가 SH_CLERK이고, 급여를 4000이상 받는 사원의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from employees
where job_id = 'SH_CLERK' and salary >= 4000;

-- 자신의 상사가 101번이거나 102번인 사원의 아이디, 이름, 직종 아이디, 상사의 아이디를 조회하기
select employee_id, first_name, job_id, manager_id
from employees
where manager_id in (101, 102);

-- 소속부서 아이디가 30번이거나 60번이면서 급여를 5000이상 받는 사원의 아이디,
-- 이름, 급여, 소속부서아이디를 조회하기
select first_name, salary, department_id
from employees
where department_id in (30, 60)
and salary >= 5000;

-- is null, in not null을 이용해서 컬럼의 값이 null인 것과 null이 아닌것을 구분해서 조회하기
-- departments 테이블에서 등록된 부서 중에서 부서관리자가 지정되지 않은 부서의 아이디,
-- 부서명, 관리자 아이디를 조회하기
select department_name, manager_id
from departments
where manager_id is null;

-- employees테이블에 등록된 사원들 중에서 커미션을 받는 사원의 아이디, 이름, 급여, 커미션 조회하기
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null;

-- employees테이블에 등록된 사원들 중에서 커미션을 받고, 급여를 10000이상 받는 사원의 아이디,
-- 이름, 급여, 커미션을 조회하기
select first_name, salary, commission_pct
from employees
where commission_pct is not null
and salary >= 10000;

-- employees테이블에 등록된 사원들 중에서 커미션을 받고, 급여를 10000이상 받는 사원의 아이디,
-- 이름, 급여, 커미션을 조회하기(커미션에 대한 오름차순으로 정렬)
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null
order by commission_pct asc;


-- employee테이블에서 사원번호가 110번 이상 120번 이하인 사원의 사원아이디, 이름을 조회하기
select employee_id, salary
from employees
where employee_id between 110 and 120;


-- employees 테이블에서 직종 아이디에 CLERK를 포함하고 있는 사원의 아이디, 이름, 직종아이디 조회하기
select employee_id, first_name, job_id
from employees
where job_id like '%CLERK%';

-- employees 테이블에서 대문자 'S'를 이름에 포함하고 있는 모든 사원의 이름을 조회하기
select first_name
from employees
where first_name like '%S%';

-- employees 테이블에 등록된 사원들 중에서 소속부서아이디가 30,50,60,80이 아닌 사원의
-- 아이디, 이름, 부서아이디를 조회하기
select employee_id, first_name, department_id
from employees
where department_id in (30, 50, 60, 80);

-- 문자함수 연습하기
-- lower(컬럼명 혹은 표현식) - 소문자로 변환
-- upper(컬럼명 혹은 표현식) - 대문자로 변환
select lower('Hellow World'),
        upper('Hellow World')
from dual;

-- substr(컬럼명 혹은 표현식, 시작위치, 갯수) - 시작위치에서 갯수만큼 잘라서 반환
select substr('Hellow World',3,7)
from dual;

-- length(컬럼명 혹은 표현식) - 문자열의 길이 반환
select length('Hellow World'),
        lengthb('Hellow World'),
        lengthb('안녕하세요')
from dual;

-- instr(컬럼명 혹은 표현식, '문자') - 지정된 문자의 위치를 반환(인덱스는 1부터 시작)
-- instr(컬럼명 혹은 표현식, '문자', 시작위치, n번째) - 지정된 시작위치부터 문자를 검색했을 때 n번째로 등장하는 위치를 반환
select instr('Hellow World', 'W'),
        instr('Hellow World','l',2,3)
from dual;

-- lpad(컬럼명 혹은 표현식, 길이, '문자') - 지정된 길이보다 짧으면 부족한 길이만큼 지정된 문자를 왼쪽에 채운다.
-- rpad(컬럼명 혹은 표현식, 길이, '문자') - 지정된 길이보다 짧으면 부족한 길이만큼 지정된 문자를 오른쪽에 채운다.
select lpad ('Hellow World',15,'*'),
        rpad ('Hellow World',15,'*')
from dual;

-- trim(컬럼명 혹은 표현식) - 불필요한 좌우 공백을 제거한다.
select trim('     Hello World   '),
        length(trim('      Hello World   '))
from dual; 

-- replace(컬럼 혹은 표현식, '찾는문자', '대체할 문자') - 문자를 찾아서 지정된 문자로 대체한다.
select replace('AcAcBcBcCcCc', 'c','z')
from dual;

-- employees 테이블에서 이름에 'tay'가 포함되는 사원을 조회하기
select employee_id, first_name
from employees
where lower(first_name) like '%tay%';

-- employees 테이블에서 'MAN'이나 'MGR'로 직종을 가진 사원의 이름 직종아이디 조회하기
select first_name, employee_id, job_id
from employees
--where job_id like '%MAN%' or job_id like '%MGR';
where substr(job_id, 4, 3) in ('MAN', 'MGR');

-- employees 테이블에서 사용자 아이디, 이름, 원래전화번호, 전화번호 조회하기
-- (전화번호의 2번째 구분점부터 조회)
select employee_id, first_name, phone_number,
        substr( phone_number, instr(phone_number, '.', 1, 2) )
from employees;

-- employees 테이블에서 사원아이디, 이름, 이메일을 조회하기
-- (단, 이메일의 세번째부터 2글자는 **로 바꾸기)
select employee_id, first_name, 
        replace(email, substr(email,3,2),'**')
from employees;

