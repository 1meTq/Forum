create table t_cities
(
    id   bigint       not null auto_increment,
    name varchar(255) not null unique,
    primary key (id)
);

alter table t_users
    add column city_id bigint not null;
