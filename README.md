Перед запуском нужно:
1. В файле application.yml поменять переменные для подключения к локальной базе: <br>
   a). spring.datasource.url <br>
   б). spring.datasource.user <br>
   в). spring.datasource.password <br>
2. Выполнить запрос в БД:
``` sql
set names utf8;
create database web;
use web;
set global time_zone = '+7:00';

CREATE TABLE videos(
id bigint NOT NULL AUTO_INCREMENT,
name varchar(30),
about varchar(100),
category varchar(30),
primary key (id)
);
```
 
Ссылки :
1. URL : `http://localhost:8080`


