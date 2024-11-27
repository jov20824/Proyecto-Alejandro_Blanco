
insert into usuario(email,username,password,rol) values ('alejandrobp2004@gmail.com','jandro','$2a$12$PYUpifu7G2NfFE3peSoy7OIywY4fytGKHcJHoGidtfQYV1lJjwqTW','ADMIN');
insert into usuario(email,username,password,rol) values ('maribalo043@gmail.com','mario','$2a$12$ZNJVVpCuZHLMgSMPRoMa1eJSajHEyWTfBUEw6VEQVOhmo0O/TScG6','USER');
insert into usuario(email,username,password,rol) values ('fifaplj2003@gmail.com','pablo','$2a$12$qGNAI1N4UIF4.GYLCsxGMOrWpzIfTQUdIpEBM9pxfxLmg41/GeF.W','USER');
insert into usuario(email,username,password,rol) values ('luisfelguera9@gmail.com','luis','$2a$12$EaTPCG3PUhoozm1ImcB.bevHXZEsWzdFvqqx3SAHDLWOgTRHRKSdO','USER');

insert into cliente(nombre,telefono,usuario_id) values ('Jandro',684232323,1);
insert into cliente(nombre,telefono,usuario_id) values ('Mario',684232324,2);
insert into cliente(nombre,telefono,usuario_id) values ('Pablo',684232325,3);
insert into cliente(nombre,telefono,usuario_id) values ('Luis',684232326,4);


insert into pedido(fecha_realizado,hora_reserva,cliente_id) values ('2024-06-15','2022-07-02 00:00:00',2);
insert into pedido(fecha_realizado,hora_reserva,cliente_id) values ('2024-05-01','2022-07-02 00:00:00',3);
insert into pedido(fecha_realizado,hora_reserva,cliente_id) values ('2024-02-21','2022-07-02 00:00:00',4);
insert into pedido(fecha_realizado,hora_reserva,cliente_id) values ('2024-06-12','2022-07-02 00:00:00',1);


insert into plato(nombre,descripcion,precio,foto) values 
('Bowl de la casa','Fideos, carne, apio y revuelto',6.99,'/src/img/1.jpg');
insert into plato(nombre,descripcion,precio,foto) values 
('Patatinas La Felguera','Patatas gajo acompañadas de salsa secreta',2.50,'https://live.staticflickr.com/6091/6253543127_82d49e26a1_b.jpg');
insert into plato(nombre,descripcion,precio,foto) values 
('Gambas Yakitori','Gambas a la plancha con salsa yakitori y semillas de sésamo',9.95,'/src/img/3.jpg');
insert into plato(nombre,descripcion,precio,foto) values 
('Tortitas con fruta y sirope','Tortitas acompañadas de frutos del bosque y sirope de arce',5.00,'/src/img/4.jpg');
insert into plato(nombre,descripcion,precio,foto) values 
('Hamburguesa especial','Pan brioche, carne de ternera asturiana, bacon desmenuzado, mayonesa, cheddar y BBQ',5.00,'/src/img/5.jpg');
insert into plato(nombre,descripcion,precio,foto) values 
('Wrap PP','Wrap relleno de pulled pork y acompañado de patatas',5.00,'https://images.pexels.com/photos/18177329/pexels-photo-18177329/free-photo-of-pan-comida-carne-bandeja.jpeg');
insert into plato(nombre,descripcion,precio,foto) values 
('Carne asada con verduras','Carne de ternera asturiana asada con verduras asadas',5.00,'https://images.pexels.com/photos/16845334/pexels-photo-16845334/free-photo-of-comida-plato-vegetales-cena.jpeg');

insert into contiene(pedido_id,plato_id,cantidad) values (1,1,3);
insert into contiene(pedido_id,plato_id,cantidad) values (1,2,1);
insert into contiene(pedido_id,plato_id,cantidad) values (1,3,2);
insert into contiene(pedido_id,plato_id,cantidad) values (3,4,1);
insert into contiene(pedido_id,plato_id,cantidad) values (2,2,2);
insert into contiene(pedido_id,plato_id,cantidad) values (4,1,3);
insert into contiene(pedido_id,plato_id,cantidad) values (4,2,1);

