/*
	함수 : 전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환 
    
    - 단일행 함수 : N개의 값을 읽어서 N개의 결과값 리턴 (매 행마다 함수 실행 결과 반환)
    - 그룹 함수 : N개의 값을 읽어서 1개의 결과값 리턴 (그룹별로 함수 실행 결과 반환)
    
    >> SELECT 절에 단일행 함수와 그룹 함수는 함께 사용하지 못함!
	   왜? 결과 행의 개수가 다르기 때문에!alter
       
	>> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/

-- 단일행 함수

/*
	문자 처리 함수
    
    LENGTH : 해당 문자열값의 BYTE 길이 수 반환
    - 한글 한 글자 -> 3BYTE로 침
    - 영문자, 숫자, 특수문자 한글자 -> 1BYTE 
    CHAR_LENGTH : 해당 문자열값의 글자 수 반환
*/
SELECT length('데이터베이스'), char_length('데이터베이스'),
		length('database'), char_length('database');
        
-- 사원명(emp_name), 사원명의 글자수, 이메일(email), 이메일의 글자수 조회
SELECT emp_name, char_length(emp_name), email, length(email)
FROM employee;

/*
	INSTR(컬럼|'문자열', '찾으려는 문자열')
    - 특정 문자열에서 찾고자 하는 문자열의 위치 반환
*/
SELECT instr('AABAACAABBAA', 'B'), instr('AABAACAABBAA', 'D'); /*있는 경우 위치를, 없는 경우 0을 반환*/

-- 's'가 포함되어 있는 이메일 중 이메일, 이메일의 @ 위치 조회
SELECT email, instr(email, '@') 
FROM employee
WHERE email LIKE '%s%';

/*
	LPAD|RPAD(컬럼|'문자열', 최종적으로 반환할 문자의 길이, '덧붙이고자 하는 문자')
    - 문자열에 덧붙이고자 하는문자를 왼쪽 또는 오른쪽에 덧붙여서
      최종적으로 반환할 문자의 길이만큼 문자열 반환
*/
SELECT lpad('hello', 10, '*'), rpad('hello', 10, '+');

/*
	TRIM(컬럼|'문자열') | TRIM([LEADING|TRAILING|BOTH] 제거하고자하는 문자들 FROM 컬럼|'문자열')
    - 문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/
SELECT trim('        K H        '); -- 기본적으로 양쪽에 있는 공백 제거
SELECT trim(BOTH ' ' FROM '        K H        '); -- 위랑 같은 기능, BOTH는 양옆, ' '는 공백을 제거하겠다는 뜻

SELECT trim(LEADING 'Z' FROM 'ZZZKHZZZ'); -- KHZZZ 앞쪽의 Z만 제거하겠다는 뜻
SELECT ltrim('        K H        '); -- LTRIM : 앞쪽 공백만 제거(문자는 제거 불가)

SELECT trim(TRAILING 'Z' FROM 'ZZZKHZZZ'); -- ZZZKH 뒤쪽의 Z만 제거하겠다는 뜻
SELECT rtrim('        K H        '); -- RTRIM : 뒤쪽 공백만 제거(문자는 제거 불가)

/*
	SUBSTR|SUBSTRING(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
    - 문자열에서 특정 문자열을 추출해서 반환
*/
SELECT substr('PROGRAMMING', 5, 2); -- RA 5번째 위치에서 시작하여, 2개를 추출하겠다는 뜻
SELECT substr('PROGRAMMING', 1, 6); -- PROGRA
SELECT substr('PROGRAMMING', -8, 3); -- PROGRA // -를 쓰면 뒤에서부터 셈

-- 여자 사원들의 이름(emp_name), 주민등록번호(emp_no) 조회
SELECT emp_name, emp_no 
FROM employee
WHERE substr(emp_no, 8, 1) IN (2, 4); -- 여자 주민번호는 2,4로 시작하는 것을 이용한 방법

-- 남자 사원들의 이름, 주민등록번호 조회
SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, instr(emp_no, '-') + 1, 1) IN (1, 3); -- instr을 이용한 방법 함수 안의 함수

/*
	LOWER : 다 소문자로 변경한 문자열 반환
    UPPER : 다 대문자로 변경한 문자열 반환
*/
SELECT lower('Welcome To MySQL'), upper('Welcome to MySQL');

/*
	REPLACE(컬럼|'문자열', '바꾸고 싶은 문자열', '바꿀 문자열')
    - 특정 문자열로 변경하여 반환
*/
SELECT replace('서울특별시 강남구 역삼동', '강남구', '서초구');

/*
	CONCAT : 문자열을 하나로 합친 후 결과 반환
*/
SELECT concat('가나다라', 'ABCD', '1234'); -- 가나다라ABCD1234 -> 제한 없이 붙일 수 있음

-- 실습문제 --- 
-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회
SELECT  emp_name, email"변경 전", replace(email, 'kh.or.kr', 'gmail.com') "변경 후" 
FROM employee;
-- 2. 사원명과 주민등록번호(000000-0******)으로 조회
-- replace 
SELECT emp_name, replace(emp_no, substr(emp_no, -6, 6), '******')
FROM employee;

-- rpad
SELECT emp_name, rpad(substr(emp_no, 1, 8), char_length(emp_no), '*') -- char_length 자리에 14 들어가도 되긴 함
FROM employee;

-- concat
SELECT emp_name, concat(substr(emp_no, 1, 8), "******")
FROM employee;
-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회 (@ 앞)
-- replace
SELECT emp_name, email, replace(email, '@kh.or.kr', ' ')
FROM employee;

-- substr, instr
SELECT emp_name, email, substr(email, 1, instr(email, '@')-1) -- substr은 앞의 몇개를 자를건지가 문제가 되므로 instr을 써 골뱅이위치 기준으로 자름 
FROM employee;

-- trim
SELECT emp_name, email, trim(both '@kh.or.kr' from email)
FROM employee;

/*
	숫자 처리 함수
    
    ABS : 절대값 반환
*/
SELECT abs(5.6), abs(-10);

/*
	숫자 DIV 숫자 = 숫자 / 숫자
    숫자 MOD 숫자 = 숫자 % 숫자 = MOD(숫자, 숫자)
*/
SELECT 
	10 DIV 3, 10 / 3,
    10 MOD 3, 10 % 3, mod(10, 3);


/*
	ROUND(숫자, [위치])
    - 반올림한 결과를 반환
*/
SELECT round(123.567), round(123.567, 1), round(123.567, -1); -- 반올림이라 123.456을 기재하면 123을 출력, 뒤에 위치를 기재 시 반올림하는 자리수를 정함

/*
	CEIL : 올림 처리해서 반환
    FLOOR : 버림 처리해서 반환
*/
SELECT ceil(123.152), floor(123.952);

/*
	TRUNCATE(숫자, 위치)
    - 위치 지정하여 버림 처리해서 반환
*/
SELECT truncate(123.456, 1), truncate(123.456, -1); -- 얘는 floor와 다르게 반드시 위치를 지정해야함

/*
	날짜 처리 함수
    NOW, CURRENT_TIMESTAMP : 현재 날짜와 시간 반환
    CURDATE, CURRENT_DATE : 현재 날짜 반환
    CURTIME, CURRENT_TIME : 현재 시간 반환
*/
SELECT now(), current_timestamp(), curdate(), current_date(), curtime(), current_time();

/*
	DAYOFYEAR : 날짜가 해당 연도에서 몇 번째 날인지 반환
    DAYOFMONTH : 날짜가 해당 월에서 몇 번째 날인지 반환
    DAYOFWEEK : 날짜가 해당 주에서 몇 번째 날인지 반환 (일요일 = 1, 토요일 = 7)
*/
SELECT dayofyear(now()), dayofmonth(now()), dayofweek(now());

/*
	PERIOD_DIFF(날짜, 날짜) : 두 기간의 차이를 숫자로 반환
    DATEDIFF(날짜, 날짜) : 두 날짜 사이의 일수를 숫자로 반환
    TIMEDIFF(날짜, 날짜) : 두 시간의 차이를 날짜 형식으로 반환
    TIMESTAMPDIFF(날짜단위, 날짜, 날짜) : 두 날짜 사이의 기간을 날짜단위에 따라 변환
    
    * 날짜단위 : YEAR(연도), QUARTER(분기), MONTH(월), WEEK(주), DAY(일)
			   HOUR(시간), MINUTE(분), SECOND(초)
*/
SELECT period_diff(202406, 202411), period_diff(202412, 202406); -- 앞에서 뒤를 뺌
SELECT datediff('2024-12-31', now()), timediff('2025-01-01 00:00:00', now());

-- 직원명, 입사일, 근무 일 수, 근무 개월 수, 근무 년 수 조회
SELECT emp_name, hire_date, timestampdiff(day, hire_date, now()), -- datediff(now(), hiredate)해도되긴 함
	timestampdiff(month, hire_date, now()), timestampdiff(year, hire_date, now())
FROM employee;

/*
	ADDDATE(날짜, INTERVAL 숫자 날짜단위)
    ADDTIME(날짜, 시간정보)
    - 특정 날짜에 입력받은 정보만큼 더한 날짜를 반환
    
    SUBDATE(날짜, INTERVAL 숫자 날짜단위)
    SUBTIME(날짜, 시간정보)
    - 특정 날짜에 입력받은 정보만큼 뺀 날짜를 반환
*/
SELECT now(), adddate(now(), interval 10 year), -- 현재 날짜에서 10년만큼 더하겠다
			  subdate(now(), interval 15 day), -- 현재 날짜에서 15일만큼 빼겠다
			  addtime(now(), "01:10:00"), -- 현재 시간에서 1시간 10분만큼 더하겠다
              subtime(now(), "01:00:00"); -- 현재 시간에서 1시간만큼 빼겠다
              
-- 직원명(emp_name), 입사일(hire_date), 입사 후 6개월이 된 날짜를 조회
SELECT emp_name, hire_date, adddate(hire_date, interval 6 month)
FROM employee;

/*
	LAST_DAY : 해당 월의 마지막 날짜를 반환
*/
SELECT last_Day(now());

/*
	YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
    - 특정 날짜에 연도, 월, 일, 시간, 분, 초 정보를 각각 추출해서 반환
*/
SELECT year(now()), month(now()), day(now()),
	   hour(now()), minute(now()), second(now());
       
-- 연도별 오래된 순으로 직원명, 입사년도, 입사월, 입사일 조회
SELECT emp_name, year(hire_date) 입사년도, month(hire_date) 입사월, day(hire_date) 입사일
FROM employee
-- ORDER BY hire_date; 
ORDER BY 입사년도, 입사월, 입사일;

/*
	포맷 함수
    FORMAT(숫자, 위치) : 숫자에 3단위씩 콤마 추가해서 반환
    DATE_FORMAT(날짜, 포맷형식) : 날짜 형식을 변경해서 반환
*/
SELECT salary, format(salary, 0) -- 위치를 빼먹으면 작동하지 않음
FROM employee;

SELECT now(), date_format(now(), '%Y.%m.%d'), -- %Y : 년도, %m : 월, %d : 일
			  date_format(now(), '%Y.%m.%d %T'); -- %T : 시간 전체, %H : 시, %i : 분, %s : 초
              
-- 직원명, 입사일(2024년 06월 19일 14시 05분 30초) 조회
SELECT emp_name, date_format(hire_date, '%Y년 %m월 %d일 %H시 %i분 %s초')
FROM employee; 

/*
	null 처리 함수
    
    COALESCE|IFNULL(값, 값이 NULL일 경우 반환할 값)
*/
SELECT emp_name, coalesce(bonus, 0), ifnull(bonus, 0) -- 두 개가 같은 효과 
FROM employee;

-- 전 사원의 직원명, 보너스, 보너스 포함 연봉(급여 + 급여 * 보너스) * 12 조회
SELECT emp_name, ifnull(bonus, ''), ifnull(salary + salary * bonus, 0) * 12 연봉
FROM employee; 