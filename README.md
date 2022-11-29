Передзапуском нужно:
1. В файле application.yml поменять переменные для подключения к локальной базе: <br>
   a). spring.datasource.url <br>
   б). spring.datasource.user <br>
   в). spring.datasource.password <br>
2. Выполнить запрос в БД:
``` sql
CREATE TABLE videos(
id binary(16),
name varchar(30),
about varchar(100),
category varchar(30),
teacher varchar(30),
primary key (id)
);
```
 
Ссылки :
1. URL : `http://localhost:8081`


