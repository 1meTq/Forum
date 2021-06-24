create table t_roles
(
    id   bigint not null auto_increment,
    role varchar(255),
    primary key (id)
);

create table t_users
(
    id       bigint              not null auto_increment,
    email    varchar(255) unique not null,
    name     varchar(255)        not null,
    password varchar(255)        not null,
    primary key (id)
);

create table t_users_roles
(
    users_id bigint not null,
    roles_id bigint not null
);

alter table t_users_roles
    add constraint roles_users_fk foreign key (roles_id) references t_roles (id);
alter table t_users_roles
    add constraint users_roles_fk foreign key (users_id) references t_users (id);

create table t_surveys
(
    id    bigint       not null auto_increment,
    title varchar(255) not null,
    primary key (id)
);

create table t_questions
(
    id        bigint       not null auto_increment,
    question  varchar(255) not null,
    survey_id bigint       not null,
    foreign key (survey_id) references t_surveys (id),
    primary key (id)
);
