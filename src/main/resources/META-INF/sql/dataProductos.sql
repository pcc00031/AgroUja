
--> Productos
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Aceite', 'El mejor aceite', 'AgroUja', 'aceite.png', 'Nuevo', 'Comestible', 'Venta', true, 10.4);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Pala', 'La mejor pala', 'AgroUja', 'pala.png', 'Nuevo', 'Maquinaria', 'Venta', false, 5.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Tractor', 'El mejor tractor', 'AgroUja', 'tractor.png', 'Nuevo', 'Maquinaria', 'Alquiler', false, 50000.7); 
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Malla Agrícola', 'La mejor malla agrícola', 'AgroUja', 'malla.jpg', 'Nuevo', 'Maquinaria', 'Venta', false, 5000.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Excavadora', 'La mejor excavadora', 'AgroUja', 'excavadora.png', 'Nuevo', 'Maquinaria', 'Alquiler', true, 50000.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Motosierra', 'La mejor motosierra', 'AgroUja', 'motosierra.png', 'Usado', 'Maquinaria', 'Venta', false, 250.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Azada', 'La mejor azada', 'AgroUja', 'azada.png', 'Nuevo', 'Maquinaria', 'Venta', false, 50.7);
insert into Producto (nombre, descripcion, marca, imagen, estado, categoria, ventAlq, destacado, precio) values ('Mejor aceite', 'El mejor aceite del mundo', 'AgroUja', 'mejoraceite.jpg', 'Nuevo', 'Comestible', 'Venta', true, 50.7);

UPDATE producto SET idUsuario = '1' WHERE categoria = 'Comestible';
UPDATE producto SET idUsuario = '2' WHERE categoria = 'Maquinaria';

--> Formularios de contacto
insert into Formulario (email, nombre, telefono, pais, asunto, mensaje) values ('Trolololo@yopmail.com', 'Trol', '123456789', 'Alemania', 'Tractor roto', 'Tractor no furula');

--> Usuarios
insert into Usuario (nombre, apellidos, nickname, password, sexo, correo, fnac, avatar) values ('Pedro', 'Corpas Cuesta', 'pcc00031', 'pedromejor', 'Masculino', 'pcc00031@red.ujaen.es', '1997-04-04', 'pedro.png' );
insert into Usuario (nombre, apellidos, nickname, password, sexo, correo, fnac, avatar) values ('Cristian', 'Muñoz Partido', 'cmp00070', 'cristian', 'Masculino', 'cmp00070@red.ujaen.es', '1995-12-10', 'Cristian.jpg' );
insert into Usuario (nombre, apellidos, nickname, password, sexo, correo, fnac, avatar) values ('Carlos', 'Garrido Alcántara', 'cga00037', 'carlos', 'Masculino', 'cga00037@red.ujaen.es', '0000-00-00', 'Carlo.png' );
insert into Usuario (nombre, apellidos, nickname, password, sexo, correo, fnac, avatar) values ('Jesús', 'García Rodríguez', 'jgr00059', 'jesusg', 'Masculino', 'jgr00059@red.ujaen.es', '0000-00-00', 'jesus.jpeg' );
