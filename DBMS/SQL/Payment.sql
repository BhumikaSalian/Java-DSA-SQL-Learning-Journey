CREATE DATABASE Payment123;
USE Payment123;

CREATE TABLE CreditCard(
    cardNo BIGINT NOT NULL PRIMARY KEY,
    cardHolder VARCHAR(255) NOT NULL,
    creditLimit INT NOT NULL,
    cardStatus VARCHAR(255) DEFAULT 'active'
);
DESCRIBE CreditCard;

CREATE TABLE Merchant(
    merchantId INT NOT NULL PRIMARY KEY,
    merchantName VARCHAR(255) NOT NULL,
    merchantAccount BIGINT NOT NULL
);
DESCRIBE Merchant;

CREATE TABLE TransactionDetails(
    tId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tDate DATE NOT NULL,
    tAmount DOUBLE NOT NULL,
    tBy BIGINT NOT NULL,
    tTo INT NOT NULL,
    FOREIGN KEY (tBy) REFERENCES CreditCard(cardNo),
    FOREIGN KEY (tTo) REFERENCES Merchant(merchantId)
);
DESCRIBE TransactionDetails;

INSERT INTO CreditCard VALUES
(144224902570, 'Bhumika Salian', 5000, 'active'),
(648289272392, 'Rakshith', 10000, 'active'),
(347348346489, 'Ramika', 500, 'inactive');

INSERT INTO Merchant VALUES
(17, 'Ziggy', 9876543210),
(19, 'Chotu', 1098765432),
(27, 'Goofy', 3210987654);

INSERT INTO TransactionDetails VALUES 
(NOW(), 250.00, 144224902570, 19),
(NOW(), 500.45, 648289272392, 27),
(NOW(), 900.87, 144224902570, 17),
(NOW(), 80.87, 347348346489, 17),
(NOW(), 70.45, 648289272392, 17);

SELECT * FROM CreditCard;
SELECT * FROM Merchant;
SELECT * FROM TransactionDetails;

Select * from TransactionDetails where tBy = 144224902570;
Select * from CreditCard where cardNo = 648289272392;

-- Query1 Inner Join
select * from TransactionDetails inner join Merchant
on Merchant.merchantId=TransactionDetails.tTo where tBy=144224902570;

-- Query2 Inner Join
select tAmount,tDate,Merchant.merchantName from TransactionDetails
inner join Merchant on Merchant.merchantId=TransactionDetails.tTo where tBy=144224902570;

-- Query3 Inner Join
select tAmount, CreditCard.cardHolder, tDate from TransactionDetails
inner join CreditCard on tBy = CreditCard.cardNo;

-- DML: Deleting Records
delete from TransactionDetails where tBy = 347348346489;
delete from TransactionDetails where tBy = 648289272392;

-- Query4 Left Join
select cardHolder, TransactionDetails.tDate, tAmount from CreditCard
left join TransactionDetails on cardNo = TransactionDetails.tBy;

-- Query5 Right Join
delete from TransactionDetails where tTo = 19;
select merchantName, tAmount from TransactionDetails
right join Merchant on tTo = Merchant.merchantId;

-- Query6 Full Join
select database();
select cardHolder, TransactionDetails.tId, Merchant.merchantName, TransactionDetails.tAmount
from CreditCard left join TransactionDetails on cardNo = TransactionDetails.tBy
left join Merchant on TransactionDetails.tTo = Merchant.merchantId
union
select cardHolder, TransactionDetails.tId, Merchant.merchantName, TransactionDetails.tAmount
from CreditCard right join TransactionDetails on cardNo = TransactionDetails.tBy
right join Merchant on TransactionDetails.tTo = Merchant.merchantId;

-- Query7 Aggregate Functions: Sum
select CreditCard.cardHolder, sum(tAmount) as Spent from TransactionDetails
join CreditCard on tBy = CreditCard.cardNo group by CreditCard.cardHolder;

-- Query8 Aggregate Functions: Avg
select Merchant.merchantName, avg(tAmount) as AverageIncome from TransactionDetails
join Merchant on tTo = Merchant.merchantId group by Merchant.merchantName;

-- Query9 Aggregate Functions: Max
select CreditCard.cardHolder, max(tAmount) as MaxSpent from TransactionDetails
join CreditCard on tBy = CreditCard.cardNo group by CreditCard.cardHolder;

-- Query10 Aggregate Functions: Count
select merchantName, count(tId) as Bills from Merchant
left join TransactionDetails on merchantId = TransactionDetails.tTo
group by merchantName;

-- DCL: Grant and Revoke

-- Create users
create user 'Head' identified by 'Manage123';
create user 'Holder' identified by 'Custom123';
create user 'Executive' identified by 'Exec123';

show Grants;

grant update, select on CreditCard to 'Executive';
show grants;

revoke update on CreditCard from Executive;
show grants;

grant create on Payment123 to 'Head';
show grants;

flush privileges;
grant create, select on Payment123 to 'Head';