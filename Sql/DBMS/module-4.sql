use demo;

-- 	1.List the city, state, and zip codes in the customer table.  Your result should not have duplicates. (Hint: The DISTINCT keyword eliminates duplicates.)
	select distinct City,State,Zip from Customer;



-- 	2.List the name, department, phone number, and email address of employees with a phone number beginning with “3-”.
	select Emp_Name,Department,Phone,Email from Employee where Phone like '3%';


-- 	3.List all columns of the resource table with a rate between $10 and $20. Sort the result by rate.
	select * from ResourceTbl where Rate between 10 and 20 order by Rate;



-- 	4.List the event requests with a status of “Approved” or “Denied” and an authorized date in July 2018. Include the event number, authorization date, and status in the output. 
	select Event_No,Date_Auth,Status_ from EventRequest where Status_ In ('Approved','Denied') and Date_Auth between'2018-06-01' and '2018-06-30';


--   5.List the location number and name of locations that are part of the “Basketball arena”.  Your WHERE clause should not have a condition involving the facility number compared to a constant (“F101”). Instead, you should use a condition on the FacName column for the value of “Basketball arena”.
    select l.Loc_No,l.Loc_Name from Location l join Facility f on f.Fac_No = l.Fac_No where f.Fac_Name = 'Basketball arena';



--   6.For each event plan, list the plan number, count of the event plan lines, and sum of the number of resources assigned.  For example, plan number “P100” has 4 lines and 7 resources assigned.  You only need to consider event plans that have at least one line.
	select ep.Plan_No, count(el.Plan_No),sum(el.Number_Fld) from EventPlan ep join EventPlanLine el on ep.Plan_No = el.Plan_No group by ep.Plan_No;
