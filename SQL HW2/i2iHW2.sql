select * from hr.employees;

SELECT employee_id, first_name, last_name, 
    MONTHS_BETWEEN 
    (TO_DATE('22-JUN-2015'),
    TO_DATE(hr.employees.hire_date) ) "Number of Months"
FROM hr.employees;

SELECT DISTINCT job_id as Job,
DECODE(job_id,  'AD_PRES','A',
                     'ST_MAN','B',
                     'IT_PROG','C',
                    'SA_REP','D',
                    'ST_CLERK','E',
                    '0') Grade
FROM hr.employees
ORDER BY Grade DESC;

SELECT DISTINCT
  job_id AS Job,
  CASE job_id
    WHEN 'AD_PRES' THEN 'A'
    WHEN 'ST_MAN' THEN 'B'
    WHEN 'IT_PROG' THEN 'C'
    WHEN 'SA_REP' THEN 'D'
    WHEN 'ST_CLERK' THEN 'E'
    ELSE '0'
  END AS Grade
FROM hr.employees
ORDER BY Grade DESC;

select p.employee_id, p.last_name
from   hr.employees p
where  p.last_name LIKE '%i%' and p.department_id is not null;


CREATE TABLE my_emp_table(
    id Number(1),
    last_name VARCHAR2(20),
    first_name VARCHAR2(20),
    salary number(10)
);

select * from my_emp_table;


INSERT ALL
   INTO my_emp_table(ID,last_name,first_name,salary) VALUES (1,'Black', 'John', 1100)
   INTO my_emp_table(ID,last_name,first_name,salary) VALUES (2,'White', 'Kent', 1300)
   INTO my_emp_table(ID,last_name,first_name,salary) VALUES (3,'Orange', 'David', 1700)
   INTO my_emp_table(ID,last_name,first_name,salary) VALUES (4,'Pink', 'Alissa', 1900)
SELECT 1 FROM DUAL;

UPDATE my_emp_table
SET salary = salary*1.1;

DELETE FROM my_emp_table 
WHERE first_name = 'David'; 

TRUNCATE TABLE my_emp_table;
