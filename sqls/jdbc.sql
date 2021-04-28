create table users (
                       username varchar(50) not null,
                       password varchar(256),
                       enabled boolean not null,
                       primary key (username)
);

create table authorities (
                             username varchar(50) not null,
                             authority varchar(255) not null,
                             foreign key (username) references users (username), unique (username, authority)
);

insert into users (username, "password", enabled) values
('alex', '{bcrypt}$2y$12$xkiuac97NTnlIh8QmOOjYeVdGYDcxuw9iCanuuVBPxHBdd4ahDAW6', true),
('bob', '{bcrypt}$2y$12$bWmoc/QDn.l1TP4Focqc7u29a.bn7.UffozYsJbd0vEOEQ/1BiBsK', true)
;

insert into authorities (username, authority) values
('alex', 'ROLE_USER'),
('alex', 'ROLE_ADMIN'),
('bob', 'ROLE_USER'),
('bob', 'ROLE_ADMIN')
;
