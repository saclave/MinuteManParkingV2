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

insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (8,120.9996,14.5012, 'Duty Free FiestaMall', 'Columbia Complex, 1700 Ninoy Aquino Ave, Parañaque, 1700 Metro Manila', 'Parañaque', 100, 'https://d24chjhol3kq77.cloudfront.net/trbusiness.com/wp-content/uploads/2018/05/Fiesta-Mall.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (9,120.9978,14.5019,'S&R Membership Shopping', 'Parañaque, Metro Manila', 'Parañaque', 50, 'https://photos.wikimapia.org/p/00/02/21/38/23_big.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (10,120.9970,14.5011, 'PureGold Parañaque', 'Ninoy Aquino Ave, Parañaque, Metro Manila', 'Parañaque', 30, 'https://www.affordablecebu.com/_ld/131/94323697.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (11,120.0330,14.5088, 'Balagbag Wet & Dry Market', 'Balagbag Wet & Dry Market, Merville Access Road, Parañaque, Metro Manila', 'Parañaque', 20, 'https://upload.wikimedia.org/wikipedia/commons/1/13/CSFLU_Dry_Market_%28San_Fernando%2C_La_Union%29%282018-11-25%29.jpg');
insert into parking_lot(ID,LONGITUDE,LATITUDE,NAME,ADDRESS, CITY, PRICE, IMG_SRC) values (12,121.0336,14.5087, 'Merville Arcade', 'Merville Park Subdivision Daily Rd Parañaque. Drive', 'Parañaque', 60, 'https://www.santosknightfrank.com/wp-content/uploads/2020/04/MS.jpg');

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
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (33,false,'A1',8);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (34,false,'A2',8);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (35,false,'A3',8);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (36,false,'A4',8);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (37,false,'B1',9);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (38,false,'B2',9);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (39,false,'B3',9);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (40,false,'B4',9);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (41,false,'C1',10);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (42,false,'C2',10);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (43,false,'C3',10);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (44,false,'C4',10);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (45,false,'D1',11);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (46,false,'D2',11);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (47,false,'E1',12);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (48,false,'E2',12);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (49,false,'E3',12);
insert into parking_slot(ID,AVAILABILITY,NAME,PARKING_LOT_ID) values (50,false,'E4',12);


insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (1, 'TRAFFIC', 120.9884, 14.5329, 'Pasay');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (2, 'STOP', 120.9886, 14.5317, 'Pasay');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (3, 'TOWAWAY', 120.9848, 14.5354, 'Pasay');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (4, 'TOWAWAY', 120.9843, 14.5373, 'Pasay');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (5, 'ROUNDABOUT', 120.9843, 14.5332, 'Pasay');

insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (6, 'PARKING', 120.9855, 14.5311, 'Pasay');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (7, 'PARKING', 120.9863, 14.5311, 'Pasay');

insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (8, 'NOPARK', 121.0170,14.5030, 'Parañaque');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (9, 'OVERTAKE', 121.0238,14.5058, 'Parañaque');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (10, 'TOWAWAY',121.0171, 14.5026, 'Parañaque');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (11, 'NORIGHT', 121.0189, 14.4998, 'Parañaque');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (12, 'TOWAWAY', 121.0234, 14.4999, 'Parañaque');

insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (13, 'PARKING', 121.0349, 14.4938, 'Parañaque');
insert into hazard(ID, TYPE, LONGITUDE, LATITUDE, ADDRESS) values (14, 'PARKING', 121.0375, 14.4887, 'Parañaque');
