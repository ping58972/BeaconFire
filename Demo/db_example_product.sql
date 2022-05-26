drop table product;

create table product
(
    id          int auto_increment
        primary key,
    name        varchar(250) not null,
    price       bigint       not null,
    quantity    int          not null,
    description text         not null,
    photo       varchar(250) not null,
    featured    tinyint(1)   not null,
    categoryid  int          not null,
    constraint product_category_id_fk
        foreign key (categoryid) references category (id)
);

INSERT INTO product (id, name, price, quantity, description, photo, featured, categoryid) VALUES (1, 'iPhone 13', 999, 100, 'iPhone 13 128G', 'photo_iphone13', 1, 1);
INSERT INTO product (id, name, price, quantity, description, photo, featured, categoryid) VALUES (2, 'iPhone 13 Pro', 1099, 200, 'iPhone 13 Pro 256G', 'photo_iphone13Pro', 1, 1);
INSERT INTO product (id, name, price, quantity, description, photo, featured, categoryid) VALUES (3, 'iPad', 399, 150, 'iPad', 'photo_ipad', 0, 2);
INSERT INTO product (id, name, price, quantity, description, photo, featured, categoryid) VALUES (4, 'Apple watch 6 Nike', 299, 100, 'Apple watch 6 Nike edition', 'photo_apple_watch', 1, 3);