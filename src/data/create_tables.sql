-- create database
CREATE DATABASE "farm-registry-db"
    WITH
    OWNER = admin
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- create tables
create table farm(id serial, name varchar, customer_id bigint);
create table customer(id serial, name varchar);
create table "user"(id serial, email varchar, password varchar, is_admin boolean);
create table user_farm(user_id bigint, farm_id bigint, primary key(user_id, farm_id));

-- insert sample data
insert into customer(name) values('Old McDonald'), ('Dorothy');
insert into farm(name, customer_id) values('Old McDonald''s farm', 1), ('Uncle Owen''s moisture farm', 1), ('Dorothy''s farm', 2);
                                                                          -- 123                                                                                        -- 234
insert into "user"(email, password, is_admin) values('test@example.com', '$2a$12$XrJE4UO6n53r3dDUaOf4Ce0N0NZIvRKnGyA7iLgecpJI.kuVXZ.z2', false), ('test1@example.com', '$2a$12$P6Fnf/48lRHunxV7t1VlWO6ywH70u9BLULUwsRVTS0PLZhtL0JjU.', false);
insert into user_farm(user_id, farm_id) values(1, 1), (2, 2), (3, 2);