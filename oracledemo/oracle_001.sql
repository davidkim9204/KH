select*from jobs;





데이터베이스 정의
 : 데이터베이스는 원래 같은 데이터가 서로 다른 목적을 가진 여러 응용시스템에
   중복되어 사용될 수 있는 개념에 기초를 두고 있다. 데이터베이스는 어느 한
  조직의 여러 응용 시스템이 공용될 수 있도록 통합, 저장딘 운영 데이터의 집합이다.
 (1) 통합된 데이터(Integrated Data)  : 데이터베이스는 똑같은 데이터가 원칙적으로
     중복되어 저장되지 않는다는 것을 말하며, 데이터의 중복은 관리상 복잡한 부작용을
     초래한다.
 (2) 저장된 데이터(Stored Data) : 컴퓨터가 접근할 수 있는 기억장치에 저장된 
     데이터를 말한다. 주로 하드디스크에 저장되어 관리된다.
 (3) 운영데이터(Operational Data) : 존재 목적이 명확하며 유용성을 지니고 있는
     데이터를 말한다. 즉, 단순히 데이터를 모아둔 개념이 아닌 병원 관리를 위한
     데이터 구축과 같은 목적이 분명한 데이터야만 한다.
 (4) 공용 데이터(Shared Data) : 여러 사용자가 서로 다른 목적으로 사용하는
     공유 가능한 데이터이다.

데이터베이스의 특징
 (1) 실시간 접근성(Real-time Accessibility) : 다수의 사용자의 요구에 대해서
     처리 시간이 몇 초를 넘기지 말아야 한다는 의미이다.
 (2) 지속적인 변화(Continuos Evolution) : 데이터베이스에 저장된 데이터는
     최신 정보가 정확하게 저장되어 처리되어야 한다.
 (3) 동시 공유(Concurrent Sharing) : 동일한 데이터를 동시에 서로 다른 목적으로
     사용할 수 있어야 한다.
 (4) 내용에 대한 참조 : 데이터베이스 내에 있는 데이터 레코드들은 주소나 위치에
     의해 참조되는 것이 아니라 가지고 있는 값에 따라 참조해야 한다.

데이터베이스관리시스템
 : 기업이 지속적으로 유지 관리해야 하는 데이터의 집합을 데이터베이스(Database)라
   하며, 이러한 방대한 양의 데이터를 편리하게 저장하고 효율적으로 관리하고
   검색할 수 있는 환경을 제공해주는 시스템 소프트웨어를 데이터베이스 관리시스템
   (Database Management System)이라고 하며 일반적으로 약어로 DBMS라 부른다.
 
관계형 데이터베이스 시스템(Relational DataBase Management System)
 : 일련의 정형화된 데이터 항목의 집합체로, 데이터베이스를 만들거나 이용하기가
   쉬우며 무엇보다도 확장이 용이하다는 장점이 있다. 또한 처음 데이터베이스를
   만든 후 관련되는 응용 프로그램들을 변경하지 않고도 새로운 데이터 항목을
   데이터베이스에 추가할 수 있다는 장점이 있다.
   대표적인 RDMS로는 오라클,인포믹스, MySQL, Access, MS-SQL등이 있다.
   RDMS는 정보를 저장하기 위한 구조를 위해 테이블을 이용한다.
   테이블은 2차원 형태의 표처럼 볼수 있수 있도록 로우(ROW:행)와 
   컬럼(COLUMN:열)으로구성된다.

데이터베이스 관리시스템의 구성요소 : 저장장치(데이터사전,데이터베이스)와 
  이를 사용하기 위한 데이터베이스 관리시스템(자료정의, 질의처리, 저장관리, 
  트랜잭션관리),사용자(데이터베이스관리자, 응용프로그래머, 최종사용자)등으로 구성된다.
 
데이터베이스 시스템 사용자
 (1) 데이터베이스 관리자(DBA) : 데이터베이스 설계와 정의, 관리 및 운영등
     데이터베이스 시스템을 관리하고 제어하는 사용자이다.
 (2) 응용프로그래머(Application Programmer) : 응용 프로그래머는 데이터베이스를
     실제적으로 설계하며 최종 사용자들의 요구에 맞는 인터페이스와 응용프로그램을
     개발한다.
 (3) 최종사용자(End User) : 데이터베이스를 실질적으로 사용하는 사용자이다.
 
 
 
 --테이블에서 컬럼에 해당하는 데이터를 검색하라.
 SELECT column1, column2, column3
 FROM table;
 -- 키워드를 쓸때는 대문자를 사용, 칼럼테이블명은 소문자. 가독성을 위하여.
  
 SELECT job_title, min_salary, max_salary
 FROM jobs;
 
 --실행할때 블록처리해서 alt x
 
 --한라인 주석
 /*여러라인 주석*/
 
 --컬럼명, 테이블명에 별칭을 지정할 수 있다.
 --별칭(alias)명으로 한글이나 영문공백을 사용할 때는""(따옴표)을 지정한다.
 
 SELECT salary*10 as "b o n u s" --그냥 해도 된다. but 한글을 쓰면 ""필요. 공백이 껴있어도 필요.
 FROM employees;
 
 
--컬럼명들을 하나의 문장처럼 출력할 때 결합연산자(||)를 사용한다.
SELECT last_name || '님의 연봉은'|| salary|| '입니다'as name 
--오라클에서 우리가 문자 처리할때는 홀따옴표를 이용해야한다. 
FROM employees;

--distinct은 중복제거를 한 후 출력해 주는 명령어이다.
SELECT distinct first_name --중복을 제거 해준다 distinct
FROM employees
WHERE first_name='David';

--해석할때는 from where select 순으로 해석한다. from에서 where 조건에 맞는 select해라


SELECT  distinct first_name, salary  --중복제거는 그 칼럼에서의 값들이 다 같아야한다.
FROM employees
WHERE first_name='David';

--SELECT 입력순서

SELECT 컬럼명, 컬럼명
FROM 테이블명
WHERE 컬럼명='값'
GROUP BY 컬럼명
HAVING 컬럼명='값'
ORDER BY 컬럼명;

--SELECT 해석순서
FROM 테이블명
WHERE 컬럼명='값'
GROUP BY 컬럼명
HAVING 컬럼명='값'
SELECT 컬럼명, 컬럼명
ORDER BY 컬럼명;


--employees 테이블에서 salary이 300미만일때의 first_name, salary을 출력하라.
SELECT first_name, salary --select from 필수
FROM employees
WHERE salary <3000;

--employees테이블에서 first_name컬럼의 값이 'David'일때의
--first_name, salary을 출력하시오.

SELECT first_name, salary
FROM employees
WHERE first_name='David'; --=는 같다라는 의미.

--employees테이블에서 first_name컬럼의 값이 'David'가 아닐때의
--first_name, salary을 출력하시오.

SELECT first_name, salary
FROM employees
WHERE first_name <> 'David'; --!=도 동일

--employees 테이블에서 salary이 3000,9000,17000dlfEo
--first_name, hire_date,salary를 출력하라.

SELECT first_name, hire_date, salary
FROM employees
WHERE salary=3000 OR salary=9000 OR salary=17000;


SELECT first_name, hire_date, salary
FROM employees
WHERE salary IN(3000,9000,17000); --같은 결과를 얻을 수 있다.

--employees 테이블에서 salar가 3000부터 5000까지 일때의
--first_name, hire_date,salary를 출력하라.

SELECT first_name, hire_date, salary
FROM employees
WHERE salary>=3000 AND salary <=5000;

--이상 이하에만 적용.
SELECT first_name, hire_date, salary
FROM employees
WHERE salary BETWEEN 3000 AND 5000;

--employees테이블에서 job_id가 'IT_PROG'가 아닐때
--first_name, email,job_id를 출력하라.

SELECT first_name, email, job_id
FROM employees
WHERE job_id <> 'IT_PROG';

SELECT first_name, email, job_id
FROM employees
WHERE job_id <> 'IT_PROG';

SELECT first_name, hire_date, salary
FROM employees
WHERE not(job_id = 'IT_PROG');

--employees테이블에서 salary가 3000부터 5000까지 아닐때
--first_nmae, hire_date,salary를 출력하라.

SELECT first_name, hire_date, salary
FROM employees
WHERE NOT(salary >=3000 AND salary<=5000);



SELECT first_name, hire_date, salary
FROM employees
WHERE salary not BETWEEN 3000 AND 5000;


SELECT first_name, hire_date, salary
FROM employees
WHERE NOT(salary BETWEEN 3000 AND 5000);


--employees테이블에서 commission_pct가 null일때
--first_name, salary, commission_pct를 출력하라.

SELECT first_name, salary, commission_pct
FROM employees
WHERE commission_pct is null;
 
--emplyees테이블에서 commission_pct이 null이 아닐때
--first_name, salary, commission_pct를 출력하라.
 
SELECT first_name, salary, commission_pct
FROM employees
WHERE commission_pct is not null;
 
--employees테이블에서 first_name에 'der'이 포함이된
--first_nmae,salary, email을 출력하라.
 
SELECT first_name, salary, email
FROM employees
WHERE first_name like '%der%'; --der%로시작한 %der로 끝나는 앞뒤 문자길이 상관없이.
 
--employees테이블에서 first_name의 값 중 A로 시작하고 두번째 문자는 임의 문자이며
--exander로 끝나는 first_name, salary, email을 출력하라.

SELECT first_name, salary, email
FROM employees
WHERE first_name like 'Ale_ander'; --_%같은 것을 와일드 카드라고 한다. _는 여기서 문자하나를 의미한다.

--employees테이블에서 job_id를 오름차순으로
--first_name, email, job_id를 출력하시오.

SELECT first_name, email, job_id
FROM employees
ORDER BY job_id asc; --기본값이 asc이므로 생략가능하다. 하지만 내림차순인경우 dsc

--employees테이블에서 부서를 오름차순하고 사원명을 내림차순으로
--department_id,first_name,salary를 출력하시오.

SELECT department_id, first_name, salary
FROM employees
ORDER BY department_id asc, first_name desc;
 
--employees 테이블에서 가장 최근 입사순으로
--사원의 first_name, salary,hire_date를 출력하시오.

SELECT first_name, salary, hire_date
FROM employees
ORDER BY hire_date desc;

--emplyees테이블에서 직업이 'FI_ACCOUNT'인 사원들의 연봉이 높은순으로 (salary
--first_name, job_id, salary를 출력하시오.

SELECT first_name, job_id, salary
FROM employees
WHERE job_id='FI_ACCOUNT'
ORDER BY salary desc;


--////////////////////////////////////
--문제--
--/////////////////////////////////////

--급여가 17000이하인 사원의 사원번호, 사원명(first_name), 급여를 출력하시오.

SELECT job_id, first_name, salary
FROM employees
WHERE salary<=17000;

--연봉이 5000이상이고 직업이 'IT_PROG'이 사원의 사원명(first_name), 연봉, 
--직업을 출력하시오.

SELECT first_name, salary, job_id
FROM employees
WHERE salary>=5000 AND job_id='IT_PROG';


--부서번호가 10, 40, 50 인 사원의 사원명(first_name), 부서, 이메일을 출력하시오.
SELECT first_name, department_id, email
FROM employees
WHERE department_id IN(10,40,50);

--사원명(first_name)이 even이 포함된 사원명,연봉,입사일을 출력하시오.

SELECT first_name, salary, hire_date
FROM employees
WHERE first_name LIKE '%even%'; 



--사원명(first_name)이 teve앞뒤에 문자가 하나씩 있는 사원명,연봉,입사일을 출력하시오.

SELECT first_name, salary, hire_date
FROM employees
WHERE first_name LIKE '_teve_'; 



--연봉이 17000이하이고 커미션이 널이 아닐때의 사원명(first_name), 연봉, 
-- 커미션을 출력하시오.

SELECT first_name, salary, commission_pct
FROM employees
WHERE salary<=17000 AND commission_pct is not null;


--솔루션
--////////////////////////////////////
--문제--
--/////////////////////////////////////

--급여가 17000이하인 사원의 사원번호, 사원명(first_name), 급여를 출력하시오.
select employee_id, first_name, salary
from employees
where salary<=17000;

--연봉이 5000이상이고 직업이 'IT_PROG'이 사원의 사원명(first_name), 연봉, 
--직업을 출력하시오.
select first_name, salary, job_id
from employees
where salary>=5000 and job_id='IT_PROG';

--부서번호가 10, 40, 50 인 사원의 사원명(first_name), 부서, 이메일을 출력하시오.
select first_name, department_id, email
from employees
where department_id in(10,40,50);

--사원명(first_name)이 even이 포함된 사원명,연봉,입사일을 출력하시오.
select first_name, salary, hire_date
from employees
where first_name like '%even%';

--사원명(first_name)이 teve앞뒤에 문자가 하나씩 있는 사원명,연봉,입사일을 출력하시오.
select first_name, salary, hire_date
from employees
where first_name like '_teve_';

--연봉이 17000이하이고 커미션이 널이 아닐때의 사원명(first_name), 연봉, 
-- 커미션을 출력하시오.
select first_name, salary, commission_pct 
from employees
where salary <=17000 and commission_pct is not null;

--솔루션

================================
집합연산자(set operator)
 - 둘 이상의 query결과를 하나의 결과로 조합한다.
 -select의 인자 갯수가 같아야 한다. 첫번째 select가 2개이면 두번째 select도 2개여야 한다.
 - 타입이 일치해야 한다.  예를 들어 character이면 character이여야 한다.
집합연산자 종류
union(합집합)- 중복행이 제거된 두 query
union all(합집합)-중복행이 포함된 두 query행
intersect(교집합)-두 query에 공통적인 행
minus(차집합)-첫번째 query에 있는 행 중 두번째 query에 없는 행표시

집합연산자 사용이유
-서로 다른 테이블에서 유사한 형태의 결과를 반환하기 위해서
-서로 같은 테이블에서 서로 다른 질의를 수행하여 결과를 합치기 위해서
===============================================

--union(합집합) --집합연산자를 쓰려면 안의 데이터타입이 같아야 한다.
SELECT department_id, first_name, last_name
FROM employees
WHERE department_id=20
union all
SELECT department_id, first_name, last_name
FROM employees
WHERE department_id=20;

CREATE TABLE emp01
AS
SELECT department_id, first_name, last_name
FROM employees
WHERE department_id IN (20,40,60);

SELECT*FROM emp01;

CREATE TABLE emp02
AS
SELECT department_id, first_name, last_name
FROM employees
WHERE department_id IN (20,50,80);

SELECT*FROM emp02;



SELECT department_id, first_name, last_name
FROM emp01
WHERE department_id=20
union all
SELECT department_id, first_name, last_name
FROM emp02
WHERE department_id=20;


SELECT department_id, first_name, last_name
FROM emp01
union 
SELECT department_id, first_name, last_name
FROM emp02


--intersect(교집합)

SELECT department_id, first_name, last_name
FROM emp01
intersect
SELECT department_id, first_name, last_name
FROM emp02

--minus(차집합)

SELECT department_id, first_name, last_name
FROM emp01
minus
SELECT department_id, first_name, last_name
FROM emp02

========================================
SQL(structured query language)함수
1. 단일행함수 : 행 하나당 하나의 결과를 출력한다
              (문자함수, 숫자함수, 날짜함수, 변환함수, 일반함수)
2. 복수행함수 : 행 여러개당 하나의 결과를 출력한다
               (합계, 평균, 최대, 최소, 갯수) 
========================================
--select문에서는 반드시 테이블명을 명시해야한다. 
--하지만 select절에 식이나 특정함수를 이용해서 결과값을
--가져올때 사용 할 수 있는 dual이라는 테이블을 제공하고있다.

SELECT 3+2
FROM dual;

SELECT sysdate
FROM dual;

--문자함수
SELECT initcap('Korea hello')
FROM dual;

--모든 문자를 대문자로 변경해주는 함수이다.
SELECT upper('korea')
FROM dual;

SELECT upper(first_name), upper(last_name)
FROM employees;

--모든 문자를 소문자로 변경해주는 함수이다.
SELECT lower('KOREA')
FROM dual;

SELECT first_name, lower(first_name)
FROM employees;

--employees테이블에서 first_name에서 대소문자 구분없이'ja'가 포함이 된
--first_name, salary를 출력하라.
SELECT first_name,salary
FROM employees
WHERE first_name like '%ja%' --이렇게 하면 대소문자를 구분한다.

SELECT first_name,salary
FROM employees
WHERE lower(first_name) like '%ja%'

--문자의 길이를 리턴해주는 함수이다.
SELECT length('korea')
FROM dual;

SELECT length('한국')
FROM dual;

--문자의 길이를 바이트로 구해서 리턴해주는 함수이다.
SELECT lengthb('korea')
FROM dual;

SELECT lengthb('한국')
FROM dual;

CREATE TABLE user1(
data varchar2(5)
);

INSERT INTO user1(data)
values('korea');

INSERT INTO user1(data)
values('한국');

select*from user1;


--문자열 결합을 해주는 함수이다.

SELECT 'oracle' || 'java'
FROM dual

SELECT contact('oracle','java')
FROM dual;

--특정범위의 문자를 추출해주는 함수이다. --자바는 미만이지만 오라클에서는 갯수이다.
--substr('문자',시작위치,갯수)
SELECT substr('oracle test',2,4) 
FROM dual;

SELECT SUBSTR('오라클 테스트',4,4 )
FROM dual;


SELECT SUBSTRb('oracle test',2,4 )
FROM dual;

SELECT SUBSTRb('오라클 테스트',4,4 )
FROM dual; --3바이트에 한글에 저장이된다.

--특정 문자의 인덱스를 추출해주는 함수이다.
SELECT instr('korea','or')
FROM dual;

SELECT instr('한국자바','자')
FROM dual;

--특정문자의 바이트인덱스를 추출해주는 함수이다.
SELECT instrb('korea','or')
FROM dual;

SELECT instrb('한국자바','자')
FROM dual;

--주어진 문자열에서 왼쪽으로 특정문자를 채우는 함수이다.
SELECT lpad('korea',8,'*')
FROM dual;

--주어진 문자열에서 오른쪽으로 특정문자를 채우는 함수이다.
SELECT rpad('korea',8,'*')
FROM dual;

--주어진 문자열에서 왼쪽으로 특정문자를 삭제하는 함수이다.
SELECT ltrim('***korea','*')
FROM dual;

--주어진 문자열에서 오른쪽으로 특정문자를 삭제하는 함수이다.
SELECT rtrim('korea***','*')
FROM dual;

--주어진 문자열에서 특정문자를 다른 문자로 변경해주는 함수이다.
SELECT replace('oracle test','test','sample')
FROM dual;

--주어진 문자열에서 조건에 맞는 문자가 포함되어 있을때 출력해주는 함수이다.
SELECT 'korea'
FROM dual
where 'korea' like '%a%' or 'korea' like '%b%' or 'korea'like '%c%' ;

SELECT 'korea'
FROM dual
where regexp_like ('korea','[abc]');

SELECT first_name, salary
FROM employees
where regexp_like (first_name,'[Dd]');

SELECT first_name, salary
FROM employees
where first_name like 'D%';

SELECT first_name, salary
FROM employees
where regexp_like (first_name,'[^D]'); -- ^[D] ^D [D] --[] or이다. 

SELECT first_name, salary
FROM employees
where regexp_like (first_name,'d$'); --하나밖에 없을땐 안써도된다.

SELECT '123 korea'
FROM dual
where regexp_like ('1234 korea', '[0-9]');

--employees테이블에서 first_name의 컬럼에 'le'또는 'A'가 포함된
--데이터를 출력하시오.

SELECT first_name
FROM employees
WHERE regexp_like(first_name, 'le|A');
