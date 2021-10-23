use demo;
select er.Event_No,er.Date_Held,count(*) as EventCount from EventRequest er join EventPlan ep on er.Event_No = ep.Event_No
		where ep.Work_date between '2018-12-01' and '2018-12-30' group by er.Event_No having EventCount > 0;
        
        
select ep.Plan_No,ep.Event_No,ep.Work_date,ep.activity from EventPlan ep 
	join EventRequest er on ep.Event_No = er.Event_No
    join Facility f on er.Fac_No = f.Fac_No
    where (Work_date between '2018-12-01' and '2018-12-30')
    and (f.Fac_Name = 'Basketball arena') ;
    
    
    
    
select er.Event_No,er.Date_Held,er.Date_Req,er.Est_Cost,er.Status_
		from EventRequest er Join EventPlan ep on er.Event_No = ep.Emp_No
        join Employee emp on ep.Emp_No = emp.Emp_No
        join Facility f on er.Fac_No = f.Fac_No
        where (emp.Emp_Name = 'Mary Manager') and 
        (er.Date_Held between '2018-10-01' and '2018-12-30')
        and (f.Fac_Name = 'Basketball arena');



select epl.Plan_No, epl.Line_No, epl.Number_Fld, epl.Time_Start, epl.Time_End
			From EventPlanLine epl join EventPlan ep on epl.Plan_No = ep.Plan_No
            join Location l on l.Loc_No = epl.Loc_No
            join Facility f on f.Fac_No = l.Fac_No
            join ResourceTbl rt on rt.Res_No = epl.Res_No
            where (f.Fac_Name='Basketball arena') and (ep.Activity = 'Operation')
            and (ep.Work_date between '2018-10-01' and '2018-12-31');
            


 