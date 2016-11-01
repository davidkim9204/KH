--연봉이 2500이하인 사원의 사원번호,사원명,연봉을 검색하시오.

SELECT employee_id, first_name, salary
FROM employees
WHERE salary <=2500

--사원 테이블에서 'Lex'인 사원의 사원번호, 사원명, 연봉을 검색하시오.
SELECT employee_id, first_name, salary
FROM employees
WHERE first_name='Lex'

--사원번호가 132이거나 140이거나 148인 사원의 사원번호, 연봉을 검색하시오.
SELECT employee_id, salary
FROM employees
WHERE employee_id IN(132,140,148)

SELECT first_name, hire_date, salary
FROM employees
WHERE salary>=20000

SELECT  first_name, length(first_name)
FROM employees

SELECT first_name||'님은'||to_char(hire_date,'yyyy')||'년'||to_char(hire_date,'mon')||
ltrim(to_char(hire_date,'dd'),'0')||'일에 입사했습니다' 
FROM employees;
--"Steven님은 2003년 06월 17일 입사한 사원입니다."처럼 각 사원을 출력하시오.

SELECT first_name || '님은'||to_char(hire_date,'yyyy')||'년'||to_char(hire_date,'mon')||'월
' salary|| '입니다'as name 
--오라클에서 우리가 문자 처리할때는 홀따옴표를 이용해야한다. 
FROM employees;



--모든사원에게는 상관(Manager)이 있다. 하지만 employees테이블에 유일하게 상관이
--   없는 로우가 있는데 그 사원(CEO)의 MGR컬럼값이 NULL이다. 상관이 없는 사원한
--   출력하되 MGR컬럼값 NULL 대신 CEO로 출력하시오.

SELECT manager_id, nvl(manager_id,a)  as MGR

FROM employees
WHERE 
