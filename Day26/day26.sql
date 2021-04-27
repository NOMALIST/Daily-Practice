2021 - 04 - 26 SELECT�� �⺻

-- dapartments ���̺��� ��� ��, ��� �÷� ��ȸ�ϱ� (select~from)
select *
from departments;

-- employess ���̺��� �����, ��� �÷� ��ȸ�ϱ�
select *
from employees;

-- jobs ���̺��� �����, ��� �÷� ��ȸ�ϱ�
select *
from jobs;

-- ���̺��� ������ �÷��� ��ȸ�ϱ� (select~from)
-- employees ���̺��� ������̵�, �̸�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, salary
from employees;

-- employees ���̺��� ������̵�, �̸�, �������̵� ��ȸ�ϱ�
select employee_id, first_name, job_id
from employees;

-- departmenets ���̺��� �μ����̵�, �μ��� ��ȸ�ϱ�
select department_id, department_name
from departments;

-- jobs ���̺��� �������̵�, �ּұ޿�, �ִ�޿� ��ȸ�ϱ�
select job_id, min_salary, max_salary
from jobs;

-- locations ���̺��� ��ġ���̵�, �ּ�, ���ø� ��ȸ�ϱ�
select location_id, street_address, city
from locations;

-- employees ���̺��� �ҼӺμ����̵�, ����� ������̵�, ����� �̸� ��ȸ�ϱ�
select department_id, manager_id, employee_id, first_name
from employees;

-- ��ȸ����� �ߺ��� ���� ���� �� �ߺ��� ���� �����ϰ� ��ȸ�ϱ� (distinct)
-- employees�� ��ϵ� ������� �����ϴ� ������ ���̵� ��ȸ�ϱ�
select distinct job_id
from employees;

-- employees�� ��ϵ� ������� �ҼӺμ� ���̵� ��ȸ�ϱ�
select department_id
from employees;

-- job_history ���̺��� ��ȸ�ؼ� ������ ����� ���� �ִ� ����� ���̵� ��ȸ�ϱ�
select employee_id
from job_history;

-- ���� �����ڸ� �̿��ؼ� �� �� �̻��� �÷����� �ٿ��� ��ȸ�ϱ�
select employee_id, first_name ||' '||last_name
from employees;

-- ��ȸ ����� ��Ī�� �ٿ��� ��ȸ�ϱ�
select employee_id, first_name ||' '||last_name as full_name
from employees;

-- ��Ģ ������ ����ϱ�
-- employees ���̺��� ������̵�, �̸�, �ֱ�, ���� ��ȸ�ϱ�
select employee_id, first_name, salary/4 as weekly_salary, salary
from employees;

-- jobs ���̺��� �������̵�, �ּұ޿�, �ִ�޿�, �ּұ޿��� �ִ�޿��� ���̸� ��ȸ�ϱ�
select job_id, min_salary, max_salary, max_salary - min_salary as gap_salary
from jobs;

-- where ���� �̿��ؼ� ��ȸ�Ǵ� ���� �����ϱ�
-- ������̵� 100�� ����� ���̵�, �̸�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, salary
from employees
where employee_id = 100;


-- �̸��� Steven�� ����� ������̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where first_name = 'Steven';

-- �޿��� 2500������ ����� ������̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where salary <= 2500;


-- �޿��� 15000�̻��� ����� ������̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where salary >= 15000;

-- ��ȸ����� �̸��� ���� ������������ �����ϱ�
select employee_id, first_name, job_id, salary
from employees
order by first_name asc;

-- �޿��� 10000�̻��� ����� �̸�, �޿��� ��ȸ�ϱ�
-- ��ȸ����� �޿��� ���� ������������ �����ϱ� (desc)
select first_name, salary
from employees
where salary >= 10000
order by salary desc;

-- �޿��� 10000�̻��� ����� �̸�, �޿��� ��ȸ�ϱ�
-- ��ȸ����� �޿��� ���� ������������ �����ϱ�
-- �޿��� ������ ��� �̸������� �������� �����ϱ� (asc)
select first_name, salary
from employees
where salary >= 10000
order by salary desc, first_name asc;
