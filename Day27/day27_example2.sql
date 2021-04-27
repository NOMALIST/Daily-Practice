-- ��� �μ������� ��ȸ�ϱ�
select *
from departments;

-- ��� �μ������������� ��ȸ�ϱ�
select *
from locations;

-- ��� ���������� ��ȸ�ϱ�
select *
from jobs;

-- �������� ���̺��� �������̵�, �ּұ޿�, �ִ�޿��� ��ȸ�ϱ�
select job_id, min_salary, max_salary
from jobs;

-- �μ����� ���̺��� �μ����̵�, �μ����� ��ȸ�ϱ�
select department_id, department_name
from departments;

-- ������� ���̺��� ������̵�, �̸�, �ش����� ������, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, hire_date, job_id, salary
from employees;

-- ������� ���̺��� ������̵� 100���� ����� �̸�, ��ȭ��ȣ, �̸���, �Ի���, �޿��� ��ȸ�ϱ�
select first_name, phone_number, email, hire_date, salary
from employees
where employee_id = 100;

-- ������� ���̺��� 100�� ����� ���� �ΰ� �ִ� ������� �̸�, �Ի���, �������̵� ��ȸ�ϱ�
select first_name, hire_date, job_id
from employees
where manager_id = 100;

-- �������̺��� ���� �ּұ޿��� 10000 �̻��� ������ ���̵�, ����, �ּұ޿�, �ִ�޿��� ��ȸ�ϱ�
select job_id, job_title, min_salary, max_salary
from jobs
where min_salary >= 10000;

-- ������̺��� Ŀ�̼��� �޴� ��� �߿��� �޿��� 5000���� �޴� ����� ���̵�, �̸�, ����, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where salary >= 5000;

-- ������̺��� ������ 'MAN'�̳� 'MGR'�� ������ ����߿��� �޿��� 10000���� �޴� ����� ���̵�, 
-- �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select first_name, job_id, salary
from employees
where (job_id like '%MAN' or job_id like '%MGR')
and salary >= 10000;


-- ����������̺��� Ŀ�̼��� �޴� ����߿��� 147�� ����� ��縦 �ΰ� �����鼭, �޿��� 10000�̻� �޴�
-- ����� ���̵�, ����̸�, �޿�, Ŀ�̼��� ��ȸ�ϱ�
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null
and manager_id = 147
and salary >= 10000;


-- ����������̺��� 101���� 102���� ���� ������ ������� ���̵�, �̸�, �����̵� ��ȸ�ϱ�
select employee_id, first_name, manager_id
from employees
where manager_id in (101, 102);

-- ����������̺��� �ҼӺμ��� �������� ���� ����� ���̵�, �̸�, �������̵� ��ȸ�ϱ�
select employee_id, first_name, job_id
from employees
where department_id is null;

-- ����������̺��� 60�� �μ��� �Ҽӵ� ������� ���̵�, �̸�, ����, ������ ��ȸ�ϱ�
-- (salary�� �����̴�. ������ ��Ī�� �ο��Ѵ�.)
select employee_id, first_name, salary, salary*12 as yearly_salary
from employees
where department_id = 60
order by salary desc;

