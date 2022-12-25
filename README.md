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
video varchar(30),
primary key (id)
);

create table person(
id bigint not null auto_increment,
nickname varchar(30),
pwd varchar(30),
email varchar(50),
teacher boolean,
primary key(id)
);


INSERT person(nickname, pwd, email, teacher) 
VALUES ('qwerty','123', '1@mail.com', true);
select * from person

#если нужно будет удалить какую-то таблицу
#drop table videos;
```
 
Ссылки :
1. URL : `http://localhost:8080`


