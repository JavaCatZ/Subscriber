create user msg_user with login password '777';
create database msg_db with owner msg_user allow_connections true;
create schema if not exists messages authorization msg_user;