# forcelate-task
Create One-to-Many relation with unit tests for API

Create tables
```sql
drop table if exists user;
drop table if exists article;

create  table user(
id int not null identity
, name varchar (255)
, age int
,primary key(id)
);
create table article(
id int not null identity
, text varchar (255)
,color varchar (255)
, user_id int
,primary key(id)
, constraint FK_ARTICLE_1 foreign key (user_id)
references user(id)
);
```


### Postman collection

Postmam folder in root project directory

### Run

* mvn clean install

* java- jar target/task-0.0.1-SNAPSHOT.jar
