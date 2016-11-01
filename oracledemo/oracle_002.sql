------------
숫자함수
------------
--3.55을 소수점 1의 자리까지 구하시오(반올림)
select round(3.55,1)
from dual;

--2535.598을 십의 자리까지 구하시오(반올림)
select round(2535.598, -1)
from dual;

--256.78을 무조건 올림한다.(올림)
select ceil(256.78)
from dual;

--289.78에서 소수이하는 무조건 버린다.(버림)
select floor(289.78)
from dual;

--2의 3승 (거듭제곱)
select power(2,3)
from dual;

--25의 제곱근
select sqrt(25)
from dual;

--나머지
select mod(10, 3)
from dual;

-----------------------------
날짜함수
-----------------------------

-- 현재 시스템에서 제공해주는 오늘의 날짜 구하는 함수
select sysdate
from dual;

--두 날짜 월의 차를 반환. 앞에 있는 값이 크면 +로 리턴하고 반대이면 -으로 리턴
select months_between('2013-01-01', '2013-09-30')
from dual;

--첫번째 인자의 달에 두번째 인자값을 더한 날짜를 반환
select add_months(sysdate, 10)
from dual;

--첫번째 인자를 기준으로 앞으로 다가올 날짜를 두번쨰에서
--지정한 요일의 날짜를 구함
select next_day(sysdate, '일요일')
from dual;

--현재 날짜를 기준으로 달의 마지막 일을 구함
select last_day(sysdate)
from dual;

숫자        >        문자          >          날짜
       to_char              to_date
          <                     <
       to_number            to_char                      

---------------------------
to_char()
1 숫자 -> 문자
2 날짜 -> 문자
---------------------------

--숫자->문자
--첫번째 인자값을 두번쨰 인자값의 형식으로 변환해주는 함수
SELECT to_char(2532,'999,999.99')
FROM dual;

SELECT to_char(2532,'009,999.00')    
FROM dual;

SELECT to_char(2532,'$999,999.99')
FROM dual;

--각 나라의 통화를 표현해 줄 떄 L 기호를 사용한다.
SELECT to_char(2532,'L999,999.99')
FROM dual;

--날짜 -> 문자
SELECT to_char(sysdate, 'yyyy-mm-dd hh:mi:ss day')
FROM dual;

SELECT to_char(sysdate, 'yyyy-mm-dd hh:mi:ss dy')
FROM dual;


--------------------------------
to_number()
문자->숫자
--------------------------------
SELECT to_number('253')
FROM dual;

--------------------------------
to_date()
문자->날짜
--------------------------------
SELECT to_date('2013-10-14','yy-mm-dd')
FROM dual;

--hire_date를 이용해서 '홍길동님은 2003년 1월 3일에 입사했습니다'로 출력하는
--query를 작성하세요.
SELECT first_name||'님은'||to_char(hire_date,'yyyy')||'년'||to_char(hire_date,'mon')||
ltrim(to_char(hire_date,'dd'),'0')||'일에 입사했습니다'
FROM employees;

--------------------------------
일반함수
nvl()
--------------------------------
--nvl(컬럼,대체값) : 첫번째 인자값이 null이면 0으로 대체해서 출력한다
--대체할 값이 숫자이면 대체값에 숫자를 지정한다.
--대체할 값이 문자이면 대체값에 문자를 지정한다.
--대체할 값이 날짜이면 대체값에 날짜를 지정한다.

--commission_pct컬럼의 값이 null인 경우 0을로 대체해서 출력한다.
SELECT first_name, commission_pct, nvl(commission_pct,0)
FROM employees;

--nuvl2(컬럼,대체1,대체2) : 컬럼의 값이 null이 아니면 대체1로, null이면 대체 2로 출력한다.
SELECT first_name, commission_pct, nvl2(commission_pct,commission_pct,-1)
FROM employees;

--------------------------------
일반함수
decode()
--------------------------------
--decode(컬럼, 조건1, 값1, 조건2, 값2, 조건3, 값3, 그밖의 값)
--department_id값이 10이면 'AA', 20이면 'BB', 30이면 'CC' 그밖의 값은 'DD'
--java의 switch~case문과 비슷

SELECT first_name, department_id,
		decode(department_id,10,'AA',20,'BB',30,'CC','DD') as code
FROM employees
WHERE department_id <=50;

--------------------------------
일반함수
case()
--------------------------------
case when 조건1 then 결과1
	 when 조건2 then 결과2
	 when 조건3 then 결과3
	 else 결과 n
end

자바의 다중 if~else제어문과 비슷

SELECT first_name, department_id,
case	when department_id=10 then 'AA'
		when department_id=20 then 'BB'
		when department_id=30 then 'CC'
		else 'DD'
		end as code
FROM employees
WHERE department_id <=50;
	 
	 
--입사일에서 월이 1~3이면 '1사분기', 4~6이면 '2사분기', 7~9이면 '3사분기', 10~12이면 '4사분기'로
--처리를 하고 사원명(first_name), 입사일(hire_date), 분기로 출력하시오.
SELECT first_name as "사원명", hire_date as "입사일",
		case
		when to_char(hire_date,'mm')>=1 and to_char(hire_date,'mm')<=3 then '1사분기'
		when to_char(hire_date,'mm')>=4 and to_char(hire_date,'mm')<=6 then '2사분기'
		when to_char(hire_date,'mm')>=7 and to_char(hire_date,'mm')<=9 then '3사분기'
		when to_char(hire_date,'mm')>=10 and to_char(hire_date,'mm')<=12 then '4사분기'
		 end as "분기"
FROM employees;

/*case
		when to_char(hire_date,'mm')<=3 then '1사분기'
		when to_char(hire_date,'mm')<=6 then '2사분기'
		when to_char(hire_date,'mm')<=9 then '3사분기'
		when to_char(hire_date,'mm')<=12 then '4사분기'
*/


--------------------------------
그룹함수
--------------------------------
--max(컬럼) : 최대값
SELECT max(salary)
FROM employees;

--min(컬럼) : 최소값
SELECT min(salary)
FROM employees;

--COunt(컬럼) : 갯수   컬럼을 넣으면 null값이 있는 레코드는 뺴고 알려줌. *는 모든것이 들어감(null값 포함)
SELECT count(salary)
FROM employees;

--sum(컬럼) : 합계
SELECT sum(salary)
FROM employees;

--avg(컬럼) : 평균
SELECT avg(salary)
FROM employees;

--그룹 함수는 단순컬럼과 함께 사용할 수 없다.(출력되는 레코드수가 다르기 때문)
SELECT first_name, count(*)
FROM employees;

--구룹함수와 단순컬럼을 사용하기 위해서는 단순컬럼을 그룹화 해야 한다. 그룹지어질 수 있는 것만 사용.(group by 사용)
SELECT department_id, count(*)
FROM employees
group by department_id
order by department_id;

--NULL이 아닌 무차별의 직원수를 출력하시오
SELECT department_id, count(*)
FROM employees
WHERE department_id is not null
GROUP BY department_id
HAVING department_id <=50   --having과 where의 차이는 having은 그룹에 대한 조건식 사용할 때 쓰임.
ORDER BY department_id;


--부서별 최소연봉, 최대 연봉을 출력하시오.
SELECT department_id, min(salary), max(salary)
FROM employees
--WHERE department_id is not null
GROUP BY department_id
ORDER BY department_id;

--직업별(job_id) 연봉합계를 출력하시오.
SELECT job_id, sum(salary)
FROM employees
GROUP BY job_id
ORDER BY job_id;

============================================
조인(join) : 한개 이상의 테이블에서 원하는 데이터를 추출해주는 쿼리문이다.
join은 oracle제품에서 사용되는 oracle용 join이 있고 모든 제품에서 공통적으로
 사용되는 표준(ansi) join이 있다.
==============================================

1 cartesian product(카티션 곱) 조인 : 테이블 행의 갯수만큼 출력해주는 조인이다.
  employees테이블의 행의 갯수가 10이고, job테이블의 행의 갯수가 5개 이면 총 50개의 결과를 출력한다.
(1) oracle용 cartesian product
  select e.department_id, e.first_name, e.job_id, j.job_title
  from employees e ,jobs j;
  
(2) ansi용 cartesian product
  select e.department_id, e.first_name, e.job_id, j.job_title
  from employees e cross join jobs j;
  
2 equi join
  
  가장 많이 사용되는 조인방법으로 조인 대상이 되는 두 테이블에서 공통적으로
  존재하는 컬럼의 값이 일치되는 행을 연결하여 결과를 생성하는 방법이다.
  (1)oracle용 equi join
   select e.first_name, e.salary, e.job_id, j.job_title
   from employees e, jobs j
   where e.job_id=j.job_id;   --두 테이블이 서로 일치하는 것만 갖구옴.
   (2)ansi용 equi join
    select e.first_name, e.salary, e.job_id, j.job_title
    from employees e join jobs j
     on  (e.job_id=j.job_id);

--employees와 departments테이블에서 사원번호(employee_id), 부서번호(department_id), 부서명(department_name)을 검색하시오.
select e.employee_id, e.department_id, d.department_name
   from employees e, departments d
   where e.department_id=d.department_id;

--employees와 jobs 테이블에서 사원번호(employee_id), 직업번호(job_id), 직업명(job_title)을 검색하시오.
SELECT e.employee_id, e.job_id, j.job_title
FROM employees e, jobs j
WHERE e.job_id=j.job_id;
--직업번호가 없어도 두개의 테이블을 보고 비교해서 공통적으로 있는 컬럼을 파악해서 사용.




--job_id가 'FI_MGR'인 사원이 속한 연봉(salary)의 최소값(min_salary),
--최대값(max_salary)을 출력하시오. 
SELECT job_id, min(salary), max(salary)
FROM employees
WHERE job_id = 'FI_MGR'
GROUP by job_id
ORDER by job_id;
  
    
--부서가 'Seattle'에 있는 부서에서 근무하는  
--직원들의 first_name, hire_date, department_name, city 
--출력하는 SELECT문장을 작성하여라(결과 18행) 
SELECT e.first_name, e.hire_date, d.department_name, l.city
FROM employees e, departments d, locations l
WHERE d.locatio_id=l.location_id 
and e.department_id=d.department_id
and l.city='Seattle'

    
--20번 부서의 이름과 그 부서에 근무하는 사원의 이름을 출력하시오.(결과2행) 
select d.department_name, e.first_name, e.last_name
from employees e, departments d
where e.department_id = d.department_id 
and d.department_id = 20;
 
    
 --1400,1500 번 위치의 도시 이름과 그곳에 있는 부서의 이름을 출력하시오.(결과2행)
select l.city, d.department_name
from departments d, locations l
where d.location_id = l.location_id 
and(l.location_id in(1400,1500));






3. non_equi join
 (=)연산자를 제외한 >=, <=, >, < 등의 연산자를 이용해서 조건을 지정하는 조인방법이다.  
 (1)oracle용 non_equi join 
 select e.first_name, e.salary, j.job_title
 from employees e, jobs j
 where e.job_id=j.job_id
  and e.salary>=j.min_salary
  and e.salary<=j.max_salary;
  
 (2)ansi용 non_equi join
 select e.first_name, e.salary, j.job_title
 from employees e  join  jobs j
  on e.job_id=j.job_id 
    and e.salary>=j.min_salary
    and e.salary<=j.max_salary;
    
 4 outer join
  한쪽 테이블에는 데이터가 있고 다른 반대쪽에는 데이터가 없는 경우에 데이터가 있는 
  테이블의 내용을 모두 가져오는 조인이다. 
 
  oracle용 outer join  
  select e.first_name, e.employee_id, d.department_id
  from employees e, departments d
  where e.department_id=d.department_id(+)
  order by e.employee_id;
  
  ansi용 outer join
  select e.first_name, e.employee_id, d.department_id
  from employees e  left outer join departments d
  on( e.department_id=d.department_id)
  order by e.employee_id;
  
--employees의 테이블의 데이터는 모두 출력을 하며 부서명이 null일때는 '<미배치>'가 출력되게 하시오.    
SELECT e.employee_id, e.first_name, nvl(d.department_name, '<미배치>')
FROM employees e ,departments d
WHERE e.department_id=d.department_id(+)
ORDER BY e.employee_id;

5 self join
  하나의 테이블을 두개의 테이블로 설정해서 사용하는 조인방법이다. 
  oracle용  self join
  select e.employee_id as"사원번호", 
  e.first_name as "사원이름", 
  e.manager_id as "관리자번호", 
  m.first_name as "관리자명"
  from employees e, employees m
  where e.manager_id=m.employee_id;  
  
 ansi용 self join
  select e.employee_id, e.first_name, e.manager_id, m.first_name
  from employees e join employees m
  on ( e.manager_id=m.employee_id); 
  
    
select employee_id, first_name, manager_id
from employees;


--사원테이블에서 manager가 null값일때에도 결과가 나오도록 사원의 매니저를
-- 출력하시오.( Lex 사원의 매니저는 Steven입니다.)  
  select e.first_name || '사원의 매니저는 ' || nvl(m.first_name,'자신') || '입니다.'
   from employees e, employees m
   where e.manager_id=m.employee_id(+);
   
--------------------------------------------
서브쿼리
외부 쿼리 (주쿼리)
 :일반 쿼리를 의미합니다.
스칼라 서브쿼리
 :SELECT 절에 쿼리가 사용되는 경우로, 함수처럼 레코드당 정확히 하나의 값만을 반환하는 서브쿼리입니다.
인라인 뷰
 :FROM 절에 사용되는 쿼리로, 원하는 데이터를 조회하여 가상의 집합을 만들어 조인을 수행하거나 가상의 집합을 다시 조회할 때 사용합니다.
서브 쿼리
 :HERE,HAVING 절에 사용되는 쿼리입니다.
//////////////
서브쿼리는 하나의 select문장의 절 안에 포함된 또 하나의 select문장이다.
서브쿼리를 포함하고 있는 쿼리문을 메인쿼리, 포함된 또 하나의 쿼리를 서브쿼리라 한다.
서브쿼리는 비교연산자의 오른쪽에 기술해야 하고 반드시 괄호 안에 넣어야한다.
서브쿼리는 메인쿼리가 실행되기 이전에 한번만 실행이 된다.
서브쿼리는 단일행 서브쿼리와 다중행 서브쿼리로 나눈다.
단일행 서브쿼리는 오직 하나의 로우(행)로 반환되는 서브쿼리의 결과는 메인쿼리로
   보내는데 메인 쿼리의 where 절에서는 단일행 비교연산자인 =, >,>=, <, <=, <>를
   사용해야 한다.
다중행 서브쿼리는 다중행연산자(in, any(some), all, exists)와 함께 사용해야한다.
   in : 메인쿼리의 비교조건('='연산자로 비교할 경우)이 서브쿼리의 결과 중에서
         하나라도 일치하면 참이다.
   any,some : 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 하나 이상이 일치하면
          참이다.
   all : 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 모든 값이 일치하면 참이다.
   exists : 메인 쿼리의 비교 조건이 서브 쿼리의 결과 중에서 만족하는 값이 하나라도
          존재하면 참이다.
//////////
서브 쿼리 사용:SELECT, FROM, WHERE, HAVING, INSERT문의 VALUES, UPDATE문의 SET, CREATE문
/////////
서브쿼리와 조인 비교
		서브쿼리						
결과 집합	외부쿼리(메인쿼리) 레벨로 결과 집합이 생성		
컬럼 사용	외부쿼리의 컬럼을 사용할 수 있지만 서브쿼리의 컬럼을 외부에서 사용할 수 없다.

                조인
결과 집합	조인되는 테이블간의 곱 레벨이 집합이 생성
컬럼 사용	조인되는 테이블의 컬럼을 모두 사용할 수 있다.
//////
**결과 집합이 하나의 테이블 레벨이고 다른 테이블을 체크의 용도로 사용한다면 조인이 아닌 서브쿼리를 사용해야 합니다.
---------------------------------------------------------------  
  
--LEX가 근무하는 부서명을 출력하시오.
SELECT department_id
FROM employees

WHERE first_name='Lex'

SELECT department_name
FROM departments
WHERE department_id=90;


SELECT department_name
FROM employees e, departments d
WHERE e.department_id=d.department_id
	AND e.first_name='Lex'
	
SELECT department_name
FROM departments
WHERE department_id = (SELECT department_id
						FROM employees
						WHERE first_name='Lex')	

						
SELECT a.first_name, e.department_id
FROM employees a, employees e
WHERE a.department_id =e.department_id
AND e.first_name='Lex';

SELECT first_name,department_id
FROM employees
WHERE department_id=(
						SELECT department_id
						FROM employees
						WHERE first_name='Lex');
						
--'Lex'와 동일한 직업(job_id)을 가진 사원의 이름(first_name),
-- 직업(job_title), 입사일(hire_date)을 출력하시오.

SELECT e.first_name,j.job_title,e.hire_date
FROM employees e, jobs j //조인
WHERE e.job_id=j.job_id AND j.job_id=(SELECT job_id 
FROM employees
WHERE first_name='Lex')  //묶어준다.
						
						
--IT에 근무하는 사원의 이름, 부서번호를 출력하시오.
--it는 디파트먼트 칼럼에서 제공 테이블 하나에서 제공, 조인 필요 없음
SELECT first_name, department_id
FROM employees
WHERE department_id=(SELECT department_id
FROM departments
WHERE department_name='IT')



--Bruce보다 연봉을  많이 받은 사원이름(first_name), 부서명을 출력하시오. --사원이르음 임플로이에 있고 부서는 디파트먼트에있음
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_ide=d.department --둘이 같아야함
AND e.salary>(SELECT salary
FROM employees
WHERE first_name='Bruce')



--Steven와 같은 부서에서 근무하는 사원의 이름, 급여, 입사일을 출력하시오.(in)
 
--다중행 서브쿼리로 짜야한다.				

SELECT first_name, salary, hire_date
FROM EMPLOYEES
WHERE department_id in(SELECT department_id
FROM employees
WHERE first_name='Steven');


--부서별로 가장 급여를 많이 받는 사원의 이름, 급여, 부서번호를 출력하시오.(in)
--먼저 부서벽로 가장 급열르 많이 받는 사원을 찾는다.
--다중열 서브쿼리

SELECT first_name, salary, department_id
FROM employees
WHERE (department_id, salary) in (
								SELECT department_id, max(salary)
								FROM employees
								GROUP BY department_id
								)
ORDER BY department_id;								
					
								
--서브쿼리에서는 order by 사용 안함


--30소속된 사원들중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를
--받는 사원의 이름, 급여, 입사일을 출력하시오.(all)
--(서브쿼리에서 max()함수를 사용하지 않는다.) 

SELECT first_name, salary, hire_date
FROM employees
WHERE salary>all(SELECT salary	
				FROM employees
				WHERE department_id=30);
				
SELECT max(salary)
FROM employees
WHERE department_id=30			
				
--부서번호가 30번인 사원들이 받는 최저급여보다  높은 급여를 받는 사원의 이름,
--급여, 입사일을 출력하시오. (min( )함수를 사용하지 않는다)	(any)	

SELECT first_name, salary, hire_date
FROM employees
WHERE salary >any(
			  	SELECT salary
				FROM employees
				WHERE department_id=30);


SELECT min(salary)
FROM employees
WHERE department_id=30
				

--20번 부서에 속한 사원이 있으면 사원들의 사원명, 입사일, 급여,
--부서번호를 출력하시오(exists)
SELECT first_name, hire_date, salary
FROM employees
WHERE exists(
				SELECT department_id
				FROM employees
				WHERE department_id=20);--0으로 바꿔서 해보기.
				
------------------------------------------------------
Top-N 서브쿼리
   상위의 값을 추출할때 사용된다.
   <, <=연산자를 사용할수 있다. 단 비교되는 값이 1일때는 =도 가능하다.
   order by절을 사용할 수 있다.
------------------------------------------------------

   
 --급여가 가장높은 상위3명을 검색하시오.
 SELECT a.first_name, a.salary
 FROM (

 SELECT first_name,salary
 FROM employees
 ORDER BY salary desc)a
 where rownum<=3;
   
   
   
 SELECT first_name, salary
 FROM employees
 ORDER BY salary desc
 


SELECT b.*
FROM(
	 SELECT a.first_name,a.salary
 FROM employees
 ORDER BY salary desc)a a)b
 
 WHERE b.rm <=3;
 
 1.단일 행 서브쿼리
 2.다중 행 서브쿼리
 3.단ㅇ리 컬럼 서브쿼리
 4.다중 컬럼 서브쿼리
 
 --부서명에 IT가 포함이된 사람이 속한 사원명, 부서번호, 부서명을 출력하시오(in)

 SELECT e.first_name,d.department_id, d.department_name
 FROM employees e, department d
 where e.department_id=d.department_id
 	and d.department_id in(select department_ie
 	from departments
 	where department_name like '%IT%');
 	  
   
 

--Toronto 사원들보다 많은 연봉을 받는 first_name, city, salary을 출력하시오
--(any연산자) 단 부서가 있는 사원의 정보만 출력한다.
--Toronto은 제외한다. 
select e.first_name, l.city, e.salary
from employees e, departments d, location l
where e.department_id =l.location_id
and d.location_id=l.location_id
and e.salary > any(select e.salary
from employees e, departments d, location l
where e.department_id=d.department_id
and d.location_id=l.location_id
and l.city='Toronto')
and l.city<>'Toronto'
and e.department_id is not null;
 
 
 
--연봉이 상위 5~10사이의 사원명, 입사일, 연봉을 출력하시오.(Top-N)
select b.*
from(select rownum as rm,a.*
from(select first_name, hire_date,salary
from employees
order by salary desc)a)b
where b.rm>=5 and b.rm<=10;


select rownum as rm,a.*
from(select first_name, hire_date,salary
from employees
order by salary desc)a
where rownum<=3
        
 











