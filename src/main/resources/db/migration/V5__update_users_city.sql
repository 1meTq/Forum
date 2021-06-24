alter table t_users add constraint users_city_fk foreign key (city_id) references t_users(id);
