
create table product(
id int(11) not null auto_increment,
product_name varchar(300),
primary key(id));

create table comment(
id int(11) not null auto_increment,
comment_description varchar(300),
review_id int(11),
primary key(id));

create table review(
 id int(11) not null auto_increment,
 product_id int(11),
 primary key(id));

ALTER TABLE review add column review_description varchar(300);

ALTER TABLE review add constraint review_product_id_fk foreign key (product_id) references product (id);

ALTER TABLE comment add constraint comment_review_id_fk foreign key (review_id) references review (id);

