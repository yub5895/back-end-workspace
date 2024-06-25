-- Sakila : DVD 대여 및 영화 정보와 관련된 데이터 포함

SELECT * FROM category; -- 영화 카테고리 정보 : category_id
SELECT * FROM rental; -- DVD 대여 정보 : customer_id, inventory_id
SELECT * FROM inventory; -- DVD 대여점에서 관리하는 정보 : inventory_id, film_id
SELECT * FROM film; -- 영화 정보 : film_idactor_idactor_id
SELECT * FROM actor; -- 영화 배우 정보 : actor_id

SELECT * FROM film_category; -- film과 category 연결 : film_id, category_id
SELECT * FROM film_actor; -- film과 actor 연결 : film_id, actor_id

-- DVD 대여 고객 정보 : customer_id, address_id, first_name, last_name
SELECT * FROM customer; 

SELECT * FROM address; -- 고객 주소 정보 : address_id, city_id, address, district
SELECT * FROM city; -- city_id, country_id, city
SELECT * FROM country; -- country_id, country

-- 1. customer 테이블의 first_name이 TRACY인 사람들 조회 
SELECT country, city, address, district, first_name, last_name
FROM customer
JOIN address USING (address_id)
JOIN city USING(city_id)
JOIN country USING (country_id)
WHERE first_name = "TRACY";

-- 2. 배우 JULIA MCQUEEN이 찍은 영화 제목 조회 (title 기준 정렬 10개까지)
SELECT first_name, last_name, title
FROM film_actor
JOIN film USING (film_id)
JOIN actor USING (actor_id)
WHERE first_name = "JULIA" AND last_name = "MCQUEEN"
ORDER BY title
LIMIT 10;

-- 3. 영화 NOON PAPI에 나오는 배우들의 이름 조회
SELECT first_name, last_name
FROM film_actor
JOIN film USING (film_id)
JOIN actor USING (actor_id)
WHERE title = "NOON PAPI";

-- >> 서브쿼리로도 가능하지만 추천은 안함
-- >> 사실상 조회해야 되는게 actor 테이블만 필요
SELECT first_name, last_name
FROM actor
WHERE actor_id IN (SELECT actor_id
FROM film_actor
WHERE film_id = (SELECT film_id
					FROM film 
					WHERE title = 'NOON PAPI'));

SELECT *
FROM film_actor
WHERE film_id = (SELECT film_id
					FROM film 
					WHERE title = 'NOON PAPI');
SELECT film_id -- NOON PAPI의 film_id가 몇번인지만 확인해두면 됨
FROM film 
WHERE title = 'NOON PAPI';

-- 4. 각 카테고리별 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 빌린 DVD 대여 수 조회
SELECT name category, count(*) count
FROM rental
JOIN customer USING (customer_id)
JOIN inventory USING (inventory_id)
JOIN film_category USING (film_id)
JOIN category USING (category_id)
WHERE email = "JOYCE.EDWARDS@sakilacustomer.org" -- 내가 틀린 부분, where을 걸고 group by를 걸어도 된다. 기억
GROUP BY name;

-- 서브쿼리로 변경

SELECT name category, count(*) count
FROM rental
JOIN inventory USING (inventory_id)
JOIN film_category USING (film_id)
JOIN category USING (category_id)
WHERE customer_id = (SELECT customer_id
					FROM customer 
					WHERE email = "JOYCE.EDWARDS@sakilacustomer.org")
GROUP BY name;

SELECT customer_id
FROM customer 
WHERE email = "JOYCE.EDWARDS@sakilacustomer.org";
-- 5. 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 가장 최근에 빌린 영화 제목과 영화 내용을 조회 
SELECT title, description
FROM film_category
JOIN film USING (film_id)
JOIN category USING (category_id)
JOIN inventory USING (film_id)
JOIN rental USING (inventory_id)
JOIN customer USING (customer_id)
WHERE email = "JOYCE.EDWARDS@sakilacustomer.org" AND rental_date = "2005-08-21 20:02:18";

SELECT title, description
FROM rental
JOIN inventory USING (inventory_id)
JOIN film USING (film_id)
JOIN customer USING (customer_id)
WHERE email =  "JOYCE.EDWARDS@sakilacustomer.org"
ORDER BY rental_date DESC -- 가장 최근에 대여한 것을 보기 위함
LIMIT 1;

-- 서브쿼리
SELECT title, description
FROM rental
JOIN inventory USING (inventory_id)
JOIN film USING (film_id)
JOIN customer USING (customer_id)
WHERE email =  "JOYCE.EDWARDS@sakilacustomer.org"
ORDER BY rental_date DESC
LIMIT 1;

SELECT max(rental_date)
FROM rental
JOIN customer USING (customer_id)
WHERE email =  "JOYCE.EDWARDS@sakilacustomer.org";

SELECT title, description
FROM rental
JOIN inventory USING (inventory_id)
JOIN film USING (film_id)
WHERE rental_date = (SELECT max(rental_date)
					FROM rental
					JOIN customer USING (customer_id)
					WHERE email =  "JOYCE.EDWARDS@sakilacustomer.org");