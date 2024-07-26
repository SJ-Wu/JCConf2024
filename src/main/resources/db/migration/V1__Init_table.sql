create table person
(
    id     serial primary key,
    name   varchar(255)     not null,
    age    int              not null,
    gender varchar(255)     not null,
    salary double precision not null
);