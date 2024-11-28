#테이블 기본 생성

create table userTable (
    userNo int auto_increment primary key,
    userID varchar(20) not null unique,
    userPassword varchar(20) not null,
    userName varchar(15) not null unique,
    registerDate date default now()
);
