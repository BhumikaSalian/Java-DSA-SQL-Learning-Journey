use Payment123;

-- INSERT INTO CreditCard VALUES(5656565656, 'Bhumi', 50000, 'Active');
-- select * from CreditCard;

update CreditCard set creditLimit = 30000 where cardNo = 144224902570;
update CreditCard set cardStatus = 'active' where cardHolder = 'Ramika';
select * from CreditCard;