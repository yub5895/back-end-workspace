/*
	인덱스(INDEX)
    - SQL 명령문의 처리 속도를 향상시키기 위해 행들의 위치 정보를 가지고 있다.
    
    * 데이터 검색 방식
    Table Full Scan : 테이블 데이터를 처음부터 끝까지 검색하여 원하는 데이터를 찾는 방식
    Index Scan : 인덱스를 통해 데이터를 찾는 방식
    
    기본키 (PRIMARY KEY)는 테이블의 각 행을 고유하게 식별한다.
    실제 테이블 데이터가 모두 인덱스 구조로 저장된다.
*/
-- 테이블에서 인덱스 조회
SHOW INDEX FROM employee;

-- 특정 스키마에 있는 인덱스를 한꺼번에 조회
SELECT *
FROM INFORMATION_SCHEMA.STATISTICS
WHERE TABLE_SCHEMA = 'kh';

/*
	INDEX 생성
    
    CREATE INDEX 인덱스명
    ON 테이블명(컬럼, 컬럼, ...);
*/
SELECT *
FROM sakila.payment
WHERE amount = 0.99;

CREATE INDEX idx_amount
ON sakila.payment(amount); -- 비고유 인덱스 생성

CREATE INDEX idx_amount_id
ON sakila.payment(amount, payment_id); -- 결합 인덱스 생성

SELECT * FROM sakila.payment;
SHOW INDEX FROM sakila.payment;

/*
	INDEX 삭제
    
    DROP INDEX 인덱스명
    ON 테이블명;
*/
DROP INDEX idx_amount ON sakila.payment; 
DROP INDEX idx_amount_id ON sakila.payment;

/*
	프로시저(PROCEDURE)
    - SQL문을 저장하여 필요할 때마다 다시 입력할 필요 없이
	  간단하게 호출해서 사용 가능하게 코드 블록
     
	DELIMITER // 
    
    CREATE PROCEDURE 프로시저명(매개변수)
    BEGIN
		저장할 SQL문
	END //
    
    DELIMITER ; 
*/
CREATE TABLE emp_copy
SELECT * FROM employee;

-- emp_copy 테이블의 모든 데이터를 삭제하는 프로시저 생성
DELIMITER //

CREATE PROCEDURE del_all_emp()
BEGIN
	DELETE FROM emp_copy;
END //

DELIMITER ; 

-- 만들어진 프로시저 확인
SHOW PROCEDURE status;

-- del_all_emp 프로시저 호출
CALL del_all_emp();

-- 프로시저 삭제
DROP PROCEDURE del_all_emp;

-- 매개변수가 있는 프로시저 
DELIMITER //

CREATE PROCEDURE del_all_emp(IN id INT)
BEGIN
	DELETE FROM emp_copy 
    WHERE emp_id = id;
END //

DELIMITER ;

-- 프로시저 실행 
CALL del_all_emp(200);
CALL del_all_emp(205);
INSERT INTO emp_copy SELECT * FROM employee;
SELECT * FROM emp_copy;

/*
	함수 (FUNCTION)
	- 프로시저와 거의 유사한 용도로 값을 반환하는 재사용 가능한 코드 블록
    - 특정 계산이나 로직을 함수로 묶어 사용한다
    
    DELIMITER // 
    
    CREATE FUNCTION 함수명 (매개변수)
    RETURNS 자료형
    DETERMINISTIC
    BEGIN
		DECLARE 반환값 자료형
        결과에 해당하는 SQL문 등 계산식 (result로 처리)
        RETURN 반환값
    END // 
    
    DELIMITER ;
*/
-- 사번을 입력받아 해당 사원의 연봉을 계산하고 리턴하는 함수 생성
DELIMITER //

CREATE FUNCTION salary_calc(id INT)
RETURNS INT
DETERMINISTIC 
BEGIN
	DECLARE result INT;
    
    SELECT salary * 12 AS result 
    INTO result
	FROM employee 
	WHERE emp_id = id;

    RETURN result;
END //
DELIMITER ;

-- 함수 호출 
SELECT salary_calc(200);

-- 방금 만든 salary_calc 함수를 이용해서 연봉이 4000만원 이상인
-- 사원의 사번, 사원명, 급여, 연봉 조회 (정렬 연봉 높은 순)
SELECT emp_id, emp_name, salary, salary_calc(emp_id) 연봉
FROM employee
WHERE salary_calc(emp_id) >= 40000000
ORDER BY 연봉 DESC;

-- 함수 삭제 -> DELETE와 DROP의 차이를 이해해야함 DROP은 객체삭제
DROP FUNCTION IF EXISTS salary_calc;

/*
	트리거(TRIGGER)
    - 특정 이벤트가 발생할 때 자동으로 실행될 내용을 정의하여 저장
    
    ex)
    - 회원탈퇴 시 기존 회원테이블에 데이터 DELETE 후
	  곧바로 탈퇴된 회원들만 따로 보관하는 테이블에 자동으로 INSERT 처리
	- 신고횟수가 일정 수를 넘었을 때 해당 회원을 블랙리스트로 처리
    - 입출고에 대한 데이터가 기록(INSERT) 될 때마다
      해당 상품에 대한 재고수량을 매번 수정(UPDATE) 해야 되는 경우
	
	  DELIMITER //
      
      CREATE TRIGGER 트리거명
      BEFORE|AFTER INSERT|UPDATE|DELLETE ON 테이블명
      FOR EACH ROW
      BEGIN 
				이벤트 발생시 실행할 SQL 구문
      END //
      
      DELIMITER ;
*/
SHOW TRIGGERS;

CREATE TABLE log(
	log_code INT AUTO_INCREMENT PRIMARY KEY,
    event_type VARCHAR(50),
    event_desc TEXT,
    event_timestamp TIMESTAMP DEFAULT now()
);

-- employee 테이블에 새로운 행이 INSERT 될 때마다 '신입사원이 입사했습니다'라는
-- 메시지를 log 테이블에 자동으로 INSERT 되는 트리거 생성
DELIMITER //
CREATE TRIGGER trg_01
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
	INSERT INTO log(event_type, event_desc)
    VALUES('INSERT', '신입사원이 입사했습니다');
END //
DELIMITER ;


INSERT INTO employee(emp_id, emp_name, emp_no)
VALUES(800, '서동문', '000000-1111111');

SELECT * FROM employee;
SELECT * FROM log;

-- employee 테이블에서 UPDATE 수행 후 '업데이트 실행' 메세지를 log에 담는
-- trg_02 트리거 생성

-- OLD : 수정, 삭제 전 데이터에 접근 가능
-- NEW : 추가, 수정 후 데이터에 접근 가능
DELIMITER //
CREATE TRIGGER trg_02
AFTER UPDATE ON employee
FOR EACH ROW 
BEGIN 
	INSERT INTO log(event_type, event_desc)
    VALUES('UPDATE', concat('변경 전 : ', OLD.dept_code, '변경 후 : ', NEW.dept_code));
END //
DELIMITER ;

-- 트리거 삭제
DROP TRIGGER IF EXISTS trg_02;
-- employee 테이블에서 부서 코드가 D6인 직원들의 부서 코드를 D3으로 변경
UPDATE employee
SET dept_code = 'D6'
WHERE dept_code = 'D3';

SELECT * FROM log;

-- 상품 입/출고
-- 1. 상품에 대한 데이터 보관할 테이블 생성(product)
/*
	컬럼 : pcode / INT / 기본키 / AUTO_INCREMENT
		  pname / VARCHAR(30) / NOT NULL
          brand / VARCHAR(30) / NOT NULL
          price / INT
          stock / INT / 기본값 0
*/
CREATE TABLE product(
	pcode INT PRIMARY KEY AUTO_INCREMENT,
    pname VARCHAR(30) NOT NULL,
    brand VARCHAR(30) NOT NULL,
    price INT,
    stock INT DEFAULT 0
);
-- 데이터 3개 추가
INSERT INTO product(pname, brand, price, stock) 
	VALUES ('갤럭시S24', '삼성', 1910000, 0);
INSERT INTO product(pname, brand, price, stock) 
	VALUES ('갤럭시Z 플립4', '삼성', 1780000, 10);
INSERT INTO product(pname, brand, price, stock) 
	VALUES ('아이폰15', '애플', 1250000, 20);

SELECT * FROM product;

-- 2. 상품 입/출고 상세 이력 테이블 생성 (prodetail)
/*
	컬럼 : dcode / INT / 기본키 / AUTO_INCREMENT
		  pcode / INT / 외래키
          pdate / DATE / 기본값 현재날짜
          amount / INT / NOT NULL
          status / CHAR(2) 입고, 출고 둘 중 하나
*/
CREATE TABLE prodetail (
	dcode INT PRIMARY KEY AUTO_INCREMENT,
    pcode INT, 
	pdate DATE DEFAULT (current_date),
    amount INT NOT NULL,
    status CHAR(2) CHECK(status IN ('입고', '출고')),
    FOREIGN KEY (pcode) REFERENCES product(pcode)
);

-- 1번 상품이 오늘날짜로 10개 입고 (prodetail)
INSERT INTO prodetail(pcode, amount, status) VALUES(1, 10, '입고');
-- 1번 상품의 재고수량 10 증가 (product)

SELECT * FROM product;
SELECT * FROM prodetail 