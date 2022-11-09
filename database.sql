CREATE TABLE company(
Id int(11) NOT NULL AUTO_INCREMENT,
CNPJ varchar(60) DEFAULT NULL,
Name varchar(60) DEFAULT NULL,
PRIMARY KEY (Id)
);

CREATE TABLE department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  companyId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (CompanyId) REFERENCES company (id)
);

CREATE TABLE seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO company (Name, CNPJ) VALUES ("Tech Inc.","140014041");

INSERT INTO department (Name, CompanyId) VALUES 
  ('Computers',1),
  ('Electronics',1),
  ('Fashion',1),
  ('Books',1);

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Alex Pink','bob@gmail.com','1997-03-04 00:00:00',3000,2);
