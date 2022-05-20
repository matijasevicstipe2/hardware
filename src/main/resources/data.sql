insert into hardwares(id,name,code,price,type,count) values(1,'Intel Core i9','ic9-770',615,'CPU',9872);
insert into hardwares(id,name,code,price,type,count) values(2,'NVIDIA GEFORCE RTX 3070','nrtx4-3000',500,'GPU',1000);
insert into hardwares(id,name,code,price,type,count) values(3,'ASUS PRIME TRX40-PRO','sTRX4amd',818,'MBU',7022);
insert into hardwares(id,name,code,price,type,count) values(4,'Corsair Vengeance LPX','ddr4ven',80,'RAM',17897);

insert into reviews(review_id,title,info,evaluation,hardware_id) values ( 1,'Sretan kupac','Potpuno sam zadovoljan',5,4);
insert into reviews(review_id,title,info,evaluation,hardware_id) values ( 2,'Uzasna maticna','Potpuno sam sokiran',1,3);
insert into reviews(review_id,title,info,evaluation,hardware_id) values ( 3,'Dosta lose','Ovo je u skoro nekoristiva graficka',2,2);
insert into reviews(review_id,title,info,evaluation,hardware_id) values ( 4,'Dosta dobar procesor','Zadovoljio moja ocekivanja',4,1);
insert into reviews(review_id,title,info,evaluation,hardware_id) values ( 5,'Jako zadovoljan','Sve jako dobro radi',5,4);

insert into user(id, username, password)
values
(1, 'user', '$2a$12$xe/depqeG4hj46FeBdH.2uo/AUjLJx0hiBzPtMoIYgAtBriAoFW3.'), -- password = user
(2, 'admin', '$2a$12$SsB9AwaRAt7FktSudqoXyeqO4/CsyqmoE5qpKrxE6IkRRH9B7UWq6'),-- password = admin
(3,'deleter', '$2a$12$CVB7sGWzmrG21v4wCWmyh.G2lw.0Y.FPc/UN8dj1QqvKkdXE.thuG'); --password = deleter
insert into authority (id, authority_name)
values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3,'ROLE_DELETER');
insert into user_authority (user_id, authority_id)
values
(1, 2),
(2, 1),
(3,3);