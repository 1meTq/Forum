create table t_categories
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
);


create table t_articles
(
    id      bigint not null auto_increment,
    name    varchar(255),
    content varchar(255),
    primary key (id)
);


create table t_articles_categories
(
    articles_id  bigint not null,
    categories_id bigint not null,

    foreign key (articles_id) references t_articles (id),
    foreign key (categories_id) references t_categories (id)
);

-- alter table t_articles_categories
--     add constraint articles_categories_fk foreign key (articles_id) references t_articles (id);
-- alter table t_articles_categories
--     add constraint categories_articles_fk foreign key (categories_id) references t_categories (id);
