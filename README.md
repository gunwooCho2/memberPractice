#테이블 기본 생성

#유저 테이블
create table userTable (
    userNo int auto_increment primary key,
    userID varchar(20) not null unique,
    userPassword varchar(20) not null,
    userName varchar(15) not null unique,
    registerDate date default now()
);

#음식 테이블
create table foodTable (
    foodNo int auto_increment primary key,
    foodName varchar(20) not null,
    foodExplain varchar(255),
    writer varchar(15) not null,
    foreign key (writer) references userTable (userName) on delete cascade,
    registerDate date default now()
);
