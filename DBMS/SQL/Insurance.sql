CREATE DATABASE Insurance;
use Insurance;

create table Customer12(
	CustomerID int not null primary key,
    CustomerName varchar(255) not null,
    DOB date not null,
    ContactNo bigint not null
);
describe Customer12;

INSERT INTO Customer12 VALUES
(1, 'Ramesh', '1985-05-10', 9876543210),
(2, 'Kavya', '1990-09-15', 9123456789);

create table  PolicyType(
	PolicyType varchar(255) not null primary key,
    PremiumRate int not null,
    CoverageYears int not null
);
describe PolicyType;

insert into PolicyType values
('Health', 5, 10),
('Life', 8, 20),
('Vehicle', 6, 5);

create table Branch(
	BranchID int not null primary key,
    BranchName varchar(255) not null,
    Manager varchar(255) not null
);
describe Branch;

insert into Branch values
(1,'Bengaluru','Anil'),
(2,'Mysuru','Sneha');

create table Policy(
	PolicyID int not null primary key, 
    CustomerID int not null, 
    PolicyType varchar(255) not null, 
    PremiumAmount int not null,
    BranchID int not null,
    foreign key(CustomerID) references Customer12(CustomerID),
    foreign key(PolicyType) references PolicyType(PolicyType),
    foreign key(BranchID) references Branch(BranchID)
);
describe Policy;

insert into Policy values
(1,1,'Health', 20000, 1),
(2,1,'Vehicle',15000,1),
(3,2,'Life',50000,2);

-- Query1
select max(PremiumRate) as Highest from PolicyType ;

-- Query2
SELECT CustomerID, COUNT(*) AS NumberOfPolicies FROM Policy 
GROUP BY CustomerID HAVING COUNT(*) > 1;

SELECT c.CustomerID, c.CustomerName, COUNT(*) AS NumberOfPolicies 
FROM Customer12 c JOIN Policy p ON c.CustomerID = p.CustomerID
GROUP BY c.CustomerID, c.CustomerName HAVING COUNT(*) > 1;

-- Query3
SELECT BranchID, SUM(PremiumAmount) AS TotalAnnualPremium
FROM Policy GROUP BY BranchID;

create user 'BranchManager' identified by 'BM123';
create user 'PolicyAuditor' identified by 'PAud123';
create user 'PolicyAdmin' identified by 'PAd123';
show grants;

grant insert, update on Policy to 'BranchManager';
show grants;

grant select on Policy to 'PolicyAuditor';
show grants;

grant all privileges on Insurance to 'PolicyAdmin';
show grants;

create table Patients(
	id int not null primary key, 
    name varchar(255) not null, 
    gender varchar(255) not null, 
    age int not null, 
    height double not null, 
    weight double not null, 
    bmi double not null
);
drop table Patients; 

SELECT * FROM Policy;