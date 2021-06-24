create table t_childs
(
    id        bigint       not null auto_increment,
    name      varchar(255) not null,
    parent_id bigint       not null,
    birthday  date,
    primary key (id),
    foreign key (parent_id) references t_users (id)
);