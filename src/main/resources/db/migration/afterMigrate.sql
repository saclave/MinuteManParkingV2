delete from car;
delete from parking_lot;
delete from parking_slot;
delete from ticket;
delete from user;

insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (1,120.9862,14.5352,'Parkwise','Sunrise Drive Cor Edsa Extension Moa Complex, Pasay, 1300 Metro Manila', 'Pasay', 100, 'https://images.summitmedia-digital.com/topgear/images/2019/08/23/parking-lot-parking-area-1566554056.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (2,120.9843,14.5323,'Mall of Asia Arena','Mall of Asia Complex, J.W. Diokno Blvd, Pasay, 1300 Metro Manila', 'Pasay', 110, 'https://sportsmatik.com/uploads/wiki-venues/Mall-of-Asia-Arena_1494308140_87564.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (3,120.9828,14.5373,'SM Mall of Asia North Parking', 'Sunset Ave, Pasay, Metro Manila', 'Pasay', 120, 'https://images.summitmedia-digital.com/sap/images/2019/10/25/batch--1190047-1571983229.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (4,120.9827,14.5310,'MAAX Parking Bldg.','Pasay, Metro Manila', 'Pasay', 130, 'https://mapio.net/images-p/63403215.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (5,120.9809,14.5318,'S Maison','Marina Way Seaside Boulevard Mall of Asia Complex, Pasay, 1300 Metro Manila', 'Pasay', 140, 'https://images.summitmedia-digital.com/preview/images/2017/06/19/Snm.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (6,120.9817,14.5333,'SM Mall of Asia South Parking','Pasay, Metro Manila', 'Pasay', 150, 'https://images.summitmedia-digital.com/spotph/images/2019/12/18/pitx-parking-1-1576663789.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (7,120.9817,14.5327,'SMX Convention Center Manila','Mall of Asia Complex, Seashell Ln, Pasay, 1300 Metro Manila', 'Pasay', 160, 'https://www.terrapinn.com/conference/retail-world-philippines/Img/smxvenueimage.jpg');

insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (1,false,'A1',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (2,true,'A2',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (3,true,'A3',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (4,true,'A4',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (5,true,'A5',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (6,true,'B1',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (7,true,'B2',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (8,true,'B3',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (9,true,'B4',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (10,true,'B5',1);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (11,false,'A1',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (12,true,'A2',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (13,true,'A3',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (14,true,'A4',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (15,true,'B1',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (16,true,'B2',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (17,true,'B3',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (18,true,'B4',2);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (19,false,'A1',3);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (20,true,'A2',3);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (21,true,'A3',3);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (22,true,'B1',3);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (23,true,'B2',3);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (24,true,'B3',3);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (25,true,'A1',4);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (26,true,'A2',4);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (27,true,'B1',4);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (28,true,'B2',4);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (29,true,'A1',5);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (30,true,'B1',5);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (31,true,'A1',6);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (32,false,'B1',7);


