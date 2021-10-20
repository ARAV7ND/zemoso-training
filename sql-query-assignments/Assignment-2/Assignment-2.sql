use sakila;
-- 1. Find out the number of documentaries with deleted scenes.
select count(*) from film where special_features like '%Deleted%' and film_id in
	(select film_id from film_category where category_id in 
		(select category_id from category where name = 'Documentary')
    );


-- 2. Find out the number of sci-fi movies rented by the store managed by Jon Stephens.
select count(*) from staff where (first_name='Jon' and last_name='Stephens') 
		and staff_id in 
        (select staff_id from rental where inventory_id in 
			(select inventory_id from inventory where film_id in
				(select film_id from film where film_id in 
					(select film_id from film_category where category_id in 
						(select category_id from category where name = "Sci-Fi")
                    )
                )
            )
        );


-- 3.Find out the total sales from Animation movies.
	select sum(amount) as Total_sales from payment where rental_id in
			(select rental_id from rental where inventory_id in
				(select inventory_id from inventory where film_id in
					(select film_id from film where film_id in 
						(select film_id from film_category where category_id in
							(select category_id from category where name = 'Animation')
                        )
                    )
                )
            );


-- 4. Find out the top 3 rented category of movies by “PATRICIA JOHNSON”.
select name from category where category_id in
	(select category_id from film_category where film_id in 
		(select film_id from film where film_id in 
			(select film_id from inventory where inventory_id in
				(select inventory_id from rental where customer_id in
					(select customer_id from customer where first_name = 'PATRICIA' and last_name = 'JOHNSON')
				)
			)
		)
    )limit 0,3;
    

-- 5. Find out the number of R rated movies rented by “SUSAN WILSON”.   
select count(*) as "Total" from film where (rating = 'R') and film_id in 
			(select film_id from inventory where inventory_id in
				(select inventory_id from rental where customer_id in
					(select customer_id from customer where first_name = 'SUSAN' and last_name = 'WILSON')
				)
			);
    


