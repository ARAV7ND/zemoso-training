-- show databases;
use sakila;
-- show tables;

-- 1. Find out the PG-13 rated comedy movies. DO NOT use the film_list table.
-- select title from film where rating = 'PG-13' and film_id in 
-- 						(select film_id from film_category where category_id in 
-- 						(select category_id from category where name = 'Comedy')
--                             );


-- select title from film f join film_category fc on f.film_id = fc.film_id 
-- 				join category c on fc.category_id = c.category_id 
--                 where f.rating = 'PG-13' and c.name = 'Comedy'; 


-- 2. Find out the top 3 rented horror movies.
-- select * from film where film_id in 
-- 				(select film_id from film_category where category_id in 
-- 						(select category_id from category where name = 'Horror')
--                   )order by rental_rate desc limit 0,3;
--

-- select * from film f join film_category fc on f.film_id = fc.film_id 
-- 				join category c on fc.category_id = c.category_id 
--                 where f.rating = 'PG-13' and c.name = 'Horror' order by rental_rate desc limit 0,3; 



-- 3.Find out the list of customers from India who have rented sports movies.
-- select * from customer where customer_id in 
-- 	(select customer_id from rental where customer_id in
-- 		(select customer_id from customer where address_id in 
-- 			(select address_id from address where city_id in
-- 				(select city_id from city where country_id in
-- 					(select country_id from country where country = 'India')
--                 )
--             )
--         )
--         and 
--         inventory_id in
--         (select inventory_id from inventory where film_id in
-- 				(select film_id from film where film_id in 
-- 					(select film_id from film_category where category_id in
-- 						(select category_id from category c where c.name = 'Sports')
--                     )
--                 )
--             )
-- 	);

-- select * from customer c join rental r
-- 		on c.customer_id = r.customer_id join address ad
--         on c.address_id = ad.address_id join city ct
--         on ad.city_id = ct.city_id join country cnt
--         on ct.country_id = cnt.country_id join inventory i
--         on r.inventory_id = i.inventory_id join film f 
--         on f.film_id = i.film_id join film_category fc
--         on fc.film_id = f.film_id join category cg 
--         on fc.category_id = cg.category_id
--         where cnt.country = 'India' and cg.name = 'Sports';
-- 		

-- 4. Find out the list of customers from Canada who have rented “NICK WAHLBERG” movies. 
-- select * from customer where customer_id in 	
-- 	(select customer_id from rental where customer_id in
-- 		(select customer_id from customer where address_id in 
-- 			(select address_id from address where city_id in
-- 				(select city_id from city where country_id in
-- 					(select country_id from country where country = 'Canada')
--                 )
--             )
--         )and inventory_id in
-- 			(select inventory_id from inventory where film_id in
-- 					(select film_id from film where film_id in 
-- 						(select film_id from film_actor where actor_id in
-- 							(select actor_id from actor where first_name = 'NICK' and last_name = 'WAHLBERG')
-- 						)
-- 					)
-- 			)
-- 	);  

-- select * from customer c join rental r
-- 		on c.customer_id = r.customer_id join address ad
--         on c.address_id = ad.address_id join city ct
--         on ad.city_id = ct.city_id join country cnt
--         on ct.country_id = cnt.country_id join inventory i
--         on r.inventory_id = i.inventory_id join film f 
--         on f.film_id = i.film_id join film_actor fa
--         on fa.film_id = f.film_id join actor a 
--         on fa.actor_id = a.actor_id
--         where cnt.country = 'Canada' and (a.first_name = 'NICK' and a.last_name = 'WAHLBERG');




-- 5. Find out the number of movies in which “SEAN WILLIAMS” acted.
select count(*) as Total from film where film_id in 
	(select film_id from film_actor where actor_id in (
		(select actor_id from actor where first_name = 'SEAN' and last_name= 'WILLIAMS')
    ));
