create table users (
  id            uuid     not null UNIQUE,
  handle        char(10) not null UNIQUE,
  password_hash varchar  not null
);
