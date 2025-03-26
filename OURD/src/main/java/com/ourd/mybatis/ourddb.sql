create database ourdDB;
use ourdDB;

drop table if exists user;

create table user(
  num int auto_increment primary key,
  name varchar(30) not null,
  nickname varchar(30) not null,
  birth varchar(30) not null,
  id varchar(30) unique key not null,
  pw varchar(30) not null,
  email varchar(30) not null,
  tel varchar(30) not null
);
select* from user;

drop table if exists belong;

create table belong(
  num int auto_increment primary key,
  club int not null,
  keeper int not null,
  member int not null
);
select* from belong;

drop table if exists club;

create table club(
  num int auto_increment primary key,
  name varchar(30) not null,
  keeper int not null
);
select* from club;

drop table if exists message;

create table message(
  num int auto_increment primary key,
  club int not null,
  send int not null,
  take int not null,
  state int not null
);
select* from message;

drop table if exists diary;

create table diary(
  num int auto_increment primary key,
  writer int not null,
  club int not null,
  title varchar(30) not null,
  content varchar(255) not null,
  feel varchar(30),
  weather varchar(30) not null,
  img VARCHAR(50),
  date varchar(30) not null
);
select* from diary;

drop table if exists comment;

create table comment(
  num int auto_increment primary key,
  diary int not null,
  date varchar(30) not null,
  content varchar(50) not null,
  writer int not null
);
select* from comment;