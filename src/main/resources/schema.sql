create table member
(
    id varchar not null
        constraint member_pk
            primary key auto_increment,
    name varchar not null
);