drop table deltager;
CREATE TABLE deltager ( 
fornavn           CHARACTER VARYING (12),   
etternavn         CHARACTER VARYING (16),  
mobilnr			  CHARACTER (8), 
passord			  CHARACTER VARYING,
kjonn			  CHARACTER (1),
PRIMARY KEY (mobilnr));  
--FOREIGN KEY (klasse_kode) REFERENCES klasse (kode));


insert into deltager VALUES
	('Simen', 'Etternavn', '12345678', 'Passord', 'm'),
	('Alf', 'Etternavn', '10000001', 'Pass', 'm'),
	('Bern', 'Etternavn', '10000002', 'Pass', 'm'),
	('Catrine','Etternavn', '10000003', 'Pass', 'k'),
	('Dent', 'Etternavn', '10000004', 'Pass', 'k'),
	('Eva', 'Etternavn', '10000005', 'Pass', 'k');
select * from deltager;