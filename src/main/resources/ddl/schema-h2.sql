CREATE TABLE Employee
(
    id integer NOT NULL,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    email varchar(255),
    phoneNumber varchar(255),
    hireDate timestamp,
    salary integer,
    commissionPct integer,
    primary key(id)
);
