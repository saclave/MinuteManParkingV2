create table car (id integer generated by default as identity, brand varchar(255), color varchar(255), plate_number varchar(255), user_id integer, primary key (id));
create table parking_lot (id integer generated by default as identity, name varchar(255), address varchar(255), latitude double, longitude double, price double, img varchar(1000), primary key (id));
create table parking_slot (id integer generated by default as identity, availability boolean, name varchar(255), parking_lot_id integer, primary key (id));
create table ticket (id integer generated by default as identity, amount double, car_id integer, name varchar(255), parking_slot_id integer, time_in varchar(255), time_out varchar(255), primary key (id));
create table user (id integer generated by default as identity, birthdate varchar(255), cash double, email varchar(255), first_name varchar(255), gender varchar(255), last_name varchar(255), password varchar(255), username varchar(255),  img varchar(1000), primary key (id));
create table hazard (id integer generated by default as identity, type varchar(255), longitude double, latitude double, address varchar(255), primary key (id));
alter table car add foreign key (user_id) references user;
alter table parking_slot add foreign key (parking_lot_id) references parking_lot;
alter table ticket add foreign key (parking_slot_id) references parking_slot;
alter table ticket add foreign key (car_id) references car;
