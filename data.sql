INSERT INTO blacklists(blacklistId) VALUES (1);

INSERT INTO accounts(uid,username, email) VALUES (100001, 'Random','Random@person.com');
INSERT INTO accounts(uid,username, email) VALUES (100002, 'Kelvin','kelvin@wong.com');

INSERT INTO cameras(cid, resolution, f_number, optical_zoom, digital_zoom) VALUES(201, '12MP','f1.6','2x','5x');
INSERT INTO cameras(cid, resolution, f_number, optical_zoom, digital_zoom) VALUES(202, '12MP','f1.5','2x','5x');
INSERT INTO cameras(cid, resolution, f_number, optical_zoom, digital_zoom) VALUES(203, '12MP','f1.8','none','5x');
INSERT INTO cameras(cid, resolution, f_number, optical_zoom, digital_zoom) VALUES(204, '48MP','f1.6','2x optical zoom in, 2x optical zoom out; 4x optical zoom range','10x');
INSERT INTO cameras(cid, resolution, f_number, optical_zoom, digital_zoom) VALUES(205, '48MP','f1.78','3x optical zoom in, 2x optical zoom out; 6x optical zoom range','15x');
INSERT INTO cameras(cid, resolution, f_number, optical_zoom, digital_zoom) VALUES(206, '48MP','f1.78','5x optical zoom in, 2x optical zoom out; 10x optical zoom range','25x');

INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (801, 'A15 Bionic chip', '4GB RAM', '6.1 inches', 'Video playback: Up to 19 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (802, 'A15 Bionic chip', '4GB RAM', '6.1 inches', 'Video playback: Up to 20 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (803, 'A15 Bionic chip', '4GB RAM', '6.7 inches', 'Video playback: Up to 26 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (804, 'A15 Bionic chip', '4GB RAM', '4.7 inches', 'Video playback: Up to 15 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (805, 'A16 Bionic chip', '6GB RAM', '6.1 inches', 'Video playback: Up to 20 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (806, 'A16 Bionic chip', '6GB RAM', '6.7 inches', 'Video playback: Up to 26 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (807, 'A17 Pro chip', '8GB RAM', '6.1 inches', 'Video playback: Up to 23 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (808, 'A17 Pro chip', '8GB RAM', '6.7 inches', 'Video playback: Up to 29 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (809, 'Qualcomm Snapdragon 8 Gen 2', '8GB RAM', '6.1 inches', 'Video playback: Up to 22 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (810, 'Qualcomm Snapdragon 8 Gen 2', '8GB RAM', '6.6 inches', 'Video playback: Up to 27 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (811, 'Qualcomm Snapdragon 8 Gen 2', '8/12GB RAM', '6.8 inches', 'Video playback: Up to 26 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (812, 'Qualcomm Snapdragon 8 Gen 2', '12GB RAM', '7.6/6.2 inches', 'Video playback: Up to 21 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (813, 'Qualcomm Snapdragon 8 Gen 2', '8GB RAM', '6.7/3.4 inches', 'Video playback: Up to 20 hours');
INSERT INTO specs(specid, processor, memory, display, battery)
VALUES (814, 'Exynos 138', '6GB RAM', '6.4 inches', 'Video playback: Up to 20 hours');

INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(101,'iPhone 13', 849, 201, 801, 999, 4351);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(102,'iPhone 14', 999, 202, 802, 0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(103,'iPhone 14 Plus', 1149, 202, 803,0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(104,'iPhone SE (3rd Generation)', 579, 203, 804,0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(105,'iPhone 15', 1129, 204, 805,0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(106,'iPhone 15 Plus', 1279, 204, 806, 0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(107,'iPhone 15 Pro', 1449, 205, 807, 0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(108,'iPhone 15 Pro Max', 1749, 206, 808, 0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(109,'Galaxy S23', 880, 202, 809, 0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(110,'Galaxy S23+', 1180, 202,  810,0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(111,'Galaxy S23 Ultra', 1430, 202, 811, 0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(112,'Galaxy Z Fold5', 2400, 202, 812, 0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(113,'Galaxy Z Flip5', 1300, 202,  813,0, 0);
INSERT INTO products(pid, pname, price, cid, specid, num, total) VALUES(114,'Galaxy A54 5G', 590, 202, 814, 0, 0);

INSERT INTO comments(uid, pid, detail, edited) VALUES (100001, 101, 'Overpriced, not recommend', 0);
INSERT INTO comments(uid, pid, detail, edited) VALUES (100001, 102, 'Cool', 0);

INSERT INTO storages(sid, store, price, pid) VALUES (3001,'128GB',849, 101);
INSERT INTO storages(sid, store, price, pid) VALUES (3002,'256GB',999, 101);
INSERT INTO storages(sid, store, price, pid) VALUES (3003,'512GB',1299, 101);

INSERT INTO storages(sid, store, price, pid) VALUES (3011,'128GB',999, 102);
INSERT INTO storages(sid, store, price, pid) VALUES (3012,'256GB',1149, 102);
INSERT INTO storages(sid, store, price, pid) VALUES (3013,'512GB',1449, 102);

INSERT INTO storages(sid, store, price, pid) VALUES (3031,'64GB', 1149, 103);
INSERT INTO storages(sid, store, price, pid) VALUES (3032,'128GB',1299, 103);
INSERT INTO storages(sid, store, price, pid) VALUES (3033,'256GB',1599, 103);

INSERT INTO storages(sid, store, price, pid) VALUES (3041,'128GB',579, 104);
INSERT INTO storages(sid, store, price, pid) VALUES (3042,'256GB',649, 104);
INSERT INTO storages(sid, store, price, pid) VALUES (3043,'512GB',789, 104);

INSERT INTO storages(sid, store, price, pid) VALUES (3051,'128GB',1129, 105);
INSERT INTO storages(sid, store, price, pid) VALUES (3052,'256GB',1279, 105);
INSERT INTO storages(sid, store, price, pid) VALUES (3053,'512GB',1579, 105);

INSERT INTO storages(sid, store, price, pid) VALUES (3061,'128GB',1279, 106);
INSERT INTO storages(sid, store, price, pid) VALUES (3062,'256GB',1429, 106);
INSERT INTO storages(sid, store, price, pid) VALUES (3063,'512GB',1729, 106);

INSERT INTO storages(sid, store, price, pid) VALUES (3071,'128GB',1449, 107);
INSERT INTO storages(sid, store, price, pid) VALUES (3072,'256GB',1599, 107);
INSERT INTO storages(sid, store, price, pid) VALUES (3073,'512GB',1899, 107);
INSERT INTO storages(sid, store, price, pid) VALUES (3074,'1TB',2199, 107);

INSERT INTO storages(sid, store, price, pid) VALUES (3081,'256GB',1749, 108);
INSERT INTO storages(sid, store, price, pid) VALUES (3082,'512GB',2049, 108);
INSERT INTO storages(sid, store, price, pid) VALUES (3083,'1TB',2349, 108);

INSERT INTO storages(sid, store, price, pid) VALUES (3091,'128GB',880, 109);
INSERT INTO storages(sid, store, price, pid) VALUES (3092,'256GB',960, 109);

INSERT INTO storages(sid, store, price, pid) VALUES (3101,'256GB',1180, 110);
INSERT INTO storages(sid, store, price, pid) VALUES (3102,'512GB',1340, 110);

INSERT INTO storages(sid, store, price, pid) VALUES (3111,'256GB',1430, 111);
INSERT INTO storages(sid, store, price, pid) VALUES (3112,'512GB',1670, 111);
INSERT INTO storages(sid, store, price, pid) VALUES (3113,'1TB',1990, 111);

INSERT INTO storages(sid, store, price, pid) VALUES (3121,'256GB',2050, 112);
INSERT INTO storages(sid, store, price, pid) VALUES (3122,'512GB',2210, 112);
INSERT INTO storages(sid, store, price, pid) VALUES (3123,'1TB',2530, 112);

INSERT INTO storages(sid, store, price, pid) VALUES (3131,'256GB',1080, 113);
INSERT INTO storages(sid, store, price, pid) VALUES (3132,'512GB',1240, 113);

INSERT INTO storages(sid, store, price, pid) VALUES (3141,'128GB',590, 114);

