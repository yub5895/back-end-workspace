CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
    age INT,
    addr VARCHAR(50)
);

SELECT * FROM person;

CREATE TABLE member(
	id VARCHAR(20),
    name VARCHAR(20), 
    password VARCHAR(20)
);	

SELECT * FROM member;

DROP TABLE member;