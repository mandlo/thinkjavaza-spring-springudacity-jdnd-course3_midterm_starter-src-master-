create table product(
product_id int(11) not null auto_increment,
product_name varchar(300),
primary key(product_id));

create table comment(
comment_id int(11) not null auto_increment,
comment_description varchar(300),
primary key(comment_id));

create table review(
 review_id int(11) auto_increment,
 product_id int(11),
 comment_id int(11),
 primary key(review_id));

ALTER TABLE review add column review_description varchar(300);

ALTER TABLE review add constraint review_product_id_fk
foreign key (product_id) references product (id);

ALTER TABLE comment add constraint comment_review_id_fk foreign key (review_id) references review (id);


