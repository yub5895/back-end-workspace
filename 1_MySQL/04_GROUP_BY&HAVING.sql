/*
	GROUP BY
    - 그룹 기준을 제시할 수 있는 구문
    - 여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용
*/
-- 각 부서별 조회 
SELECT dept_code,
	   count(*) "사원 수",
	   format(sum(salary), 0) "총 급여",
       format(avg(salary), 0) "평균 급여",
       min(salary) "최저 급여",
       max(salary) "최고 급여"
FROM employee
GROUP BY dept_code;

-- 직급 코드(job_code)별 사원 수 조회
SELECT job_code, count(*) "사원 수"
FROM employee
GROUP BY job_code;

-- 성별(남자/여자) 별 사원 수 조회
SELECT if(substr(emp_no, 8, 1) = 1, '남자', '여자')성별, count(*)
FROM employee
GROUP BY 성별;

/*
	HAVING
	- 그룹에 대한 조건을 제시할 때 사용하는 구문
    
    5 SELECT 		* | 조회하고자 하는 컬럼명 as 별칭 | 함수
    1 FROM		조회하고자 하는 테이블명
    2 WHERE		조건식 (연산자들 가지고 기술) 
    3 GROUP BY	그룹 기준에 해당항하는 컬럼명 | 함수
    4 HAVING		조건식 (그룹 함수를 가지고 기술)
    6 ORDER BY	컬럼명 | 컬럼순번 | 별칭 [ASC | DESC];
*/
-- 부서별 평균 급여가 300만원 이상인 부서의 평균 급여 조회
SELECT dept_code, avg(salary) 평균
FROM employee
GROUP BY dept_code
HAVING avg(salary) >= 3000000;