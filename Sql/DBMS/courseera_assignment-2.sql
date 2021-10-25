use demo;

CREATE TABLE Customer(
  Cust_No VARCHAR(8) NOT NULL, 
  Cust_Name VARCHAR(20) NOT NULL, 
  Address VARCHAR(30) NOT NULL, 
  Internal CHAR(1) NOT NULL, 
  Contact VARCHAR(20) NOT NULL, 
  Phone VARCHAR(10) NOT NULL, 
  City VARCHAR(30) NOT NULL,
  State VARCHAR(6) NOT NULL, 
  Zip VARCHAR(10) NOT NULL,
  CONSTRAINT PK_CUSTOMER PRIMARY KEY (Cust_No) 
) ;

create table Employee(
	Emp_No varchar(8) not null,
    Emp_Name varchar(20) not null,
    Department varchar(15) not null,
    Email varchar(20) not null,
    Phone varchar(11) not null,
    constraint PK_Employee primary key(Emp_No)
); 


create table Facility(
	Fac_No varchar(8) not null,
    Fac_Name varchar(30) not null,
    constraint PK_facility primary key(Fac_No)
);


create table Location(
	Loc_No varchar(8) not null,
	Fac_No varchar(8) not null,
	Loc_Name varchar(30) not null,
    constraint PK_Location primary key(Loc_No),
    constraint FK_Facility foreign key (Fac_No) references Facility(Fac_No)
);

create table ResourceTbl(
		Res_No varchar(8) not null,
        Res_Name varchar(20) not null,
        Rate decimal(8,2) not null,
        constraint PK_rescourceTbl primary key(Res_No)
);




create table EventRequest(
	Event_No varchar(8) not null,
    Date_Held date not null,
    Date_Req date not null,
    Cust_No varchar(8) not null,
    Fac_No varchar(8) not null,
    Date_Auth date,
    Status_ varchar(28) not null check (Status_ in ('Pending','Denied','Approved')), 
    Est_Cost decimal(8,2) not null,
    Est_Audience integer not null check (Est_Audience > 0), 
    Bud_No varchar(8) not null,
    constraint PK_EventRequest primary key (Event_No),
    constraint facility_FK foreign key(Fac_No) references Facility(Fac_No),
    constraint FK_Customer foreign key(Cust_No) references Customer(Cust_No)
);



create table EventPlan(
	Plan_No varchar(8) not null,
    Event_No varchar(8) not null,
    Work_date date not null,
    Notes varchar(30),
    Activity varchar(10) not null,
    Emp_No varchar(8) not null,
    constraint PK_EventPlan primary key(Plan_No),
    constraint FK_EventRequest foreign key(Event_No) references EventRequest(Event_No),
    constraint FK_Employee foreign key (Emp_No) references Employee(Emp_No)
);

create table EventPlanLine(
	Plan_No varchar(8) not null,
    Line_No varchar(8) not null,
    Loc_No varchar(8) not null,
    Res_No varchar(8) not null,
    Time_Start timestamp not null,
    Time_End timestamp not null,
    Number_Fld int not null,
    constraint PK_EventPlanLine primary key(Plan_No,Line_No),
    constraint FK_EventPlan foreign key(Plan_No) references EventPlan(Plan_No),
    constraint FK_Location foreign key(Loc_No) references Location(Loc_No),
    constraint FK_ResourceTbl foreign key(Res_No) references ResourceTbl(Res_No) 
);


desc Customer;
desc Facility;
show tables;