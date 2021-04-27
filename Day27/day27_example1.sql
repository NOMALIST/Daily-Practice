-- �޿��� 10000�̻� 15000������ ������� ���̵�, �̸�, �޿��� ��ȸ
select employee_id, first_name, salary
from employees
where salary >= 10000 and salary <= 15000;

-- �ҼӺμ� ���̵� 50���̰�, �޿��� 3000�̻� �޴� ����� ���̵�, �̸�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, salary, department_id
from employees
where department_id = 50 and salary >= 3000;

-- ���� ���̵� SH_CLERK�̰�, �޿��� 4000�̻� �޴� ����� ���̵�, �̸�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, salary
from employees
where job_id = 'SH_CLERK' and salary >= 4000;

-- �ڽ��� ��簡 101���̰ų� 102���� ����� ���̵�, �̸�, ���� ���̵�, ����� ���̵� ��ȸ�ϱ�
select employee_id, first_name, job_id, manager_id
from employees
where manager_id in (101, 102);

-- �ҼӺμ� ���̵� 30���̰ų� 60���̸鼭 �޿��� 5000�̻� �޴� ����� ���̵�,
-- �̸�, �޿�, �ҼӺμ����̵� ��ȸ�ϱ�
select first_name, salary, department_id
from employees
where department_id in (30, 60)
and salary >= 5000;

-- is null, in not null�� �̿��ؼ� �÷��� ���� null�� �Ͱ� null�� �ƴѰ��� �����ؼ� ��ȸ�ϱ�
-- departments ���̺��� ��ϵ� �μ� �߿��� �μ������ڰ� �������� ���� �μ��� ���̵�,
-- �μ���, ������ ���̵� ��ȸ�ϱ�
select department_name, manager_id
from departments
where manager_id is null;

-- employees���̺� ��ϵ� ����� �߿��� Ŀ�̼��� �޴� ����� ���̵�, �̸�, �޿�, Ŀ�̼� ��ȸ�ϱ�
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null;

-- employees���̺� ��ϵ� ����� �߿��� Ŀ�̼��� �ް�, �޿��� 10000�̻� �޴� ����� ���̵�,
-- �̸�, �޿�, Ŀ�̼��� ��ȸ�ϱ�
select first_name, salary, commission_pct
from employees
where commission_pct is not null
and salary >= 10000;

-- employees���̺� ��ϵ� ����� �߿��� Ŀ�̼��� �ް�, �޿��� 10000�̻� �޴� ����� ���̵�,
-- �̸�, �޿�, Ŀ�̼��� ��ȸ�ϱ�(Ŀ�̼ǿ� ���� ������������ ����)
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null
order by commission_pct asc;


-- employee���̺��� �����ȣ�� 110�� �̻� 120�� ������ ����� ������̵�, �̸��� ��ȸ�ϱ�
select employee_id, salary
from employees
where employee_id between 110 and 120;


-- employees ���̺��� ���� ���̵� CLERK�� �����ϰ� �ִ� ����� ���̵�, �̸�, �������̵� ��ȸ�ϱ�
select employee_id, first_name, job_id
from employees
where job_id like '%CLERK%';

-- employees ���̺��� �빮�� 'S'�� �̸��� �����ϰ� �ִ� ��� ����� �̸��� ��ȸ�ϱ�
select first_name
from employees
where first_name like '%S%';

-- employees ���̺� ��ϵ� ����� �߿��� �ҼӺμ����̵� 30,50,60,80�� �ƴ� �����
-- ���̵�, �̸�, �μ����̵� ��ȸ�ϱ�
select employee_id, first_name, department_id
from employees
where department_id in (30, 50, 60, 80);

-- �����Լ� �����ϱ�
-- lower(�÷��� Ȥ�� ǥ����) - �ҹ��ڷ� ��ȯ
-- upper(�÷��� Ȥ�� ǥ����) - �빮�ڷ� ��ȯ
select lower('Hellow World'),
        upper('Hellow World')
from dual;

-- substr(�÷��� Ȥ�� ǥ����, ������ġ, ����) - ������ġ���� ������ŭ �߶� ��ȯ
select substr('Hellow World',3,7)
from dual;

-- length(�÷��� Ȥ�� ǥ����) - ���ڿ��� ���� ��ȯ
select length('Hellow World'),
        lengthb('Hellow World'),
        lengthb('�ȳ��ϼ���')
from dual;

-- instr(�÷��� Ȥ�� ǥ����, '����') - ������ ������ ��ġ�� ��ȯ(�ε����� 1���� ����)
-- instr(�÷��� Ȥ�� ǥ����, '����', ������ġ, n��°) - ������ ������ġ���� ���ڸ� �˻����� �� n��°�� �����ϴ� ��ġ�� ��ȯ
select instr('Hellow World', 'W'),
        instr('Hellow World','l',2,3)
from dual;

-- lpad(�÷��� Ȥ�� ǥ����, ����, '����') - ������ ���̺��� ª���� ������ ���̸�ŭ ������ ���ڸ� ���ʿ� ä���.
-- rpad(�÷��� Ȥ�� ǥ����, ����, '����') - ������ ���̺��� ª���� ������ ���̸�ŭ ������ ���ڸ� �����ʿ� ä���.
select lpad ('Hellow World',15,'*'),
        rpad ('Hellow World',15,'*')
from dual;

-- trim(�÷��� Ȥ�� ǥ����) - ���ʿ��� �¿� ������ �����Ѵ�.
select trim('     Hello World   '),
        length(trim('      Hello World   '))
from dual; 

-- replace(�÷� Ȥ�� ǥ����, 'ã�¹���', '��ü�� ����') - ���ڸ� ã�Ƽ� ������ ���ڷ� ��ü�Ѵ�.
select replace('AcAcBcBcCcCc', 'c','z')
from dual;

-- employees ���̺��� �̸��� 'tay'�� ���ԵǴ� ����� ��ȸ�ϱ�
select employee_id, first_name
from employees
where lower(first_name) like '%tay%';

-- employees ���̺��� 'MAN'�̳� 'MGR'�� ������ ���� ����� �̸� �������̵� ��ȸ�ϱ�
select first_name, employee_id, job_id
from employees
--where job_id like '%MAN%' or job_id like '%MGR';
where substr(job_id, 4, 3) in ('MAN', 'MGR');

-- employees ���̺��� ����� ���̵�, �̸�, ������ȭ��ȣ, ��ȭ��ȣ ��ȸ�ϱ�
-- (��ȭ��ȣ�� 2��° ���������� ��ȸ)
select employee_id, first_name, phone_number,
        substr( phone_number, instr(phone_number, '.', 1, 2) )
from employees;

-- employees ���̺��� ������̵�, �̸�, �̸����� ��ȸ�ϱ�
-- (��, �̸����� ����°���� 2���ڴ� **�� �ٲٱ�)
select employee_id, first_name, 
        replace(email, substr(email,3,2),'**')
from employees;

