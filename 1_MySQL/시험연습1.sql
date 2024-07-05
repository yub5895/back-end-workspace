-- 실습문제 ----
-- 1. 직급코드 (job_code)가 J7이거나 J2인 사원들 중
-- 	  급여(salary)가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE job_code IN ('J7', 'J2') AND salary >= 2000000;

-- 2. 사수가 없고 부서배치도 받지 않은 사원들의 사원명(emp_name),
--    사수사번(manager_id), 부서코드(dept_code) 조회
SELECT emp_name, manager_id, dept_code
FROM employee
WHERE manager_id IS NULL AND dept_code IS NULL;

-- 3. 연봉(보너스포함X)이 4000만원 이상이고 보너스를 받지 않은 사원들의 
--    사번(emp_id), 사원명, 급여, 보너스(bonus) 조회
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE (salary * 12) >= 40000000 AND bonus IS NULL;

-- 4. 입사일이 '1995-01-01' 이상이고 부서배치를 받은 사원들의 
--    사번, 사원명, 입사일(hire_date), 부서코드 조회 (정렬은 입사일 기준)
SELECT emp_id, emp_name, hire_date, dept_code
FROM employee
WHERE hire_date > '1995-01-01' AND dept_code IS NOT NULL;

-- 5. 급여가 200만원 이상 500만원 이하이고 입사일이 '2001-01-01' 이상이고
--    보너스를 받지 않은 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, salary, hire_date, bonus
FROM employee
WHERE salary BETWEEN 2000000 AND 5000000 AND hire_date >= '2001-01-01' AND bonus IS NULL;

-- 6. 보너스 포함 연봉이 NULL이 아니고 이름에 '하'가 포함되어 있는 사원들의 
--    사번, 사원명, 급여, 보너스 포함 연봉(별칭부여) 조회 
--    보너스 포함 연봉 : (SALARY + SALARY * BONUS) * 12
--    연봉이 높은 순으로 정렬 
SELECT emp_id, emp_name, salary, (salary + salary * bonus) * 12
FROM employee
WHERE (salary + salary * bonus) * 12 IS NOT NULL AND emp_name LIKE "%하%"
ORDER BY 4 DESC;

-- 실습문제 --- 
-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회
SELECT email, replace(email, 'kh.or.kr', 'gmail.com')
FROM employee;

-- 2. 사원명과 주민등록번호(000000-0******)으로 조회
SELECT emp_name, replace(emp_no, substr(emp_no, 9, 6), '******')
FROM employee;

-- 사원명, 직급코드(job_code), 기존급여(salary), 인상된 급여 조회
-- 정렬 : 직급코드 J1부터, 인상된 급여 높은 순서대로
-- 직급코드가 J7인 사원은 급여를 10% 인상
-- 직급코드가 J6인 사원은 급여를 15% 인상
-- 직급코드가 J5인 사원은 급여를 20% 인상
-- 그 외의 직급의 사원은 급여를 5% 인상
SELECT emp_name, job_code, salary, 
		format(if(job_code = 'J7', salary * 1.1, 
        if(job_code = 'J6', salary * 1.15, 
        if(job_code = 'J5', salary * 1.2, salary*1.05))), 0) "인상된 급여"
FROM employee
ORDER BY 2, 4 DESC;

-- 직급별 총 급여의 합이 1000만원 이상인 직급만 조회
SELECT job_code, sum(salary)
FROM employee
GROUP BY job_code
HAVING sum(salary) >= 10000000;


-- 사번, 사원명, 직급코드, 직급명 조회 

CREATE TABLE 


INSERT INTO 


