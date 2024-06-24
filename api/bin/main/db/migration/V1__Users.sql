create table users (
  id            uuid     not null,
  handle        char(10) not null,
  password_hash varchar  not null
);
