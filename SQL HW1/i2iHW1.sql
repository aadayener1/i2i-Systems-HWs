SELECT * FROM HR.employees;


SELECT hr.employees.employee_id FROM HR.employees;


SELECT HR.employees.employee_id, HR.employees.first_name ,HR.departments.department_name
FROM HR.employees
INNER JOIN HR.departments ON HR.employees.manager_id = HR.departments.manager_id;



SELECT e.employee_id AS employee_id,
       
       m.employee_id AS manager_id
       
FROM hr.employees e
JOIN hr.employees m ON e.manager_id = m.employee_id;

SELECT SUBSTR(phone_number, 1, 3) AS Operator,
       COUNT(*) AS Total
FROM hr.employees
GROUP BY SUBSTR(phone_number, 1, 3)
ORDER BY SUBSTR(phone_number, 1, 3);

SELECT *
FROM (
  SELECT SUBSTR(phone_number, 1, 3) AS first_three_digits
  FROM hr.employees
)
PIVOT
(
  COUNT(*)
  FOR first_three_digits IN ('011' AS "011", '515' AS "515", '590' AS "590",
  '603' AS "603",'650' AS "650")
);
    
CREATE TABLE hr.emp (
  employee_id NUMBER(10),
  first_name VARCHAR2(20),
  last_name VARCHAR2(25),
  email VARCHAR2(25),
  phone_number VARCHAR2(38),
  hire_date date,
  job_id VARCHAR2(10),
  salary number(8,2),
  commision_pct number(2,2),
  manager_id number(6),
  department_id number(4)
);   
    
INSERT INTO hr.emp (employee_id,first_name,last_name,
  email,phone_number,hire_date,job_id,salary,commision_pct,manager_id,department_id)
SELECT employee_id,first_name,last_name,
  email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id
FROM hr.employees
WHERE hr.employees.employee_id > 200;

Select * from hr.emp;

UPDATE hr.emp
SET phone_number = '505.999.777', salary = 10000
WHERE employee_id = 200;

DELETE FROM hr.emp
WHERE employee_id = 200;

drop table hr.emp;

UPDATE hr.emp
SET Customer_name = first_name || last_name;

CREATE TABLE hr.emp (
  employee_id NUMBER(10),
  Customer_name VARCHAR2(40)
); 

INSERT INTO hr.emp (employee_id,Customer_name)
SELECT employee_id,first_name || ' ' || last_name AS Customer_name
FROM hr.employees
WHERE hr.employees.employee_id > 200;

UPDATE hr.emp
SET Customer_name = UPPER(Customer_name);

SELECT         
  INITCAP(SUBSTR(Customer_name, 1, 2)) 
  || RPAD('*', INSTR(Customer_name, ' ', 1, 1) - 3, '*') 
  || ' ' 
  || INITCAP(SUBSTR(Customer_name, INSTR(Customer_name, ' ', 1, 1) + 1, 2))
  || RPAD('*', LENGTH(Customer_name) - INSTR(Customer_name, ' ', 1, 1) - 2, '*') AS Customer_name
FROM hr.emp;










