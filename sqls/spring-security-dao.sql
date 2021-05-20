-- drop table user_authority;
-- drop table user_role;
-- drop table authority;
-- drop table "role";
-- drop table "user";

create table "user" (
                        id bigserial,
                        username varchar(50) not null,
                        password varchar(256),
                        enabled boolean not null,
                        primary key (id)
);

create table "role" (
                        id bigserial,
                        name varchar(50) not null,
                        primary key (id)
);

create table user_role (
                           user_id bigint not null,
                           role_id bigint not null,
                           primary key (user_id, role_id),
                           foreign key (user_id) references "user" (id),
                           foreign key (role_id) references "role" (id)
);

create table authority (
                           id bigserial,
                           name varchar(50) not null,
                           primary key (id)
);

create table user_authority (
                                user_id bigint not null,
                                authority_id bigint not null,
                                primary key (user_id, authority_id),
                                foreign key (user_id) references "user" (id),
                                foreign key (authority_id) references "authority" (id)
);

insert into "user" (username, "password", enabled) values
('alex', '$2y$12$81QSh5KS7amYFMazHvTg4eAb2SRlq8Oc7/qysZwZ1h1jFxphDwHe6', true),
('bob', '$2y$12$JOxxmvFnDugZ.K7rdgp2Ae0MFQjN.oQiBFIgDfKoXnTKZ/l9v3ntW', true);

insert into "role" (name) values
('ROLE_USER'),
('ROLE_ADMIN');

insert into user_role (user_id, role_id) values
(1, 1),
(1, 2),
(2, 1)
;

insert into authority (name) values
('READ_INFO')
;

insert into user_authority (user_id, authority_id) values
(2, 1)
;