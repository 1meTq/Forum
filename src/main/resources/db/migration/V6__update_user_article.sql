create table t_users_favourite_articles
(

    users_id    bigint not null,
    favourite_articles_id bigint not null,

    foreign key (users_id) references t_users (id),
    foreign key (favourite_articles_id) references t_articles (id)
);