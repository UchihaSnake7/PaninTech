create table if not exists categoria
(
    id              int          not null
        primary key,
    descripcion     varchar(100) not null,
    peso            decimal      null,
    volumen         decimal      null,
    unidades        int          null,
    longitud        decimal      null,
    unidad_especial int          null
);

create table if not exists marca_insumo
(
    id     int auto_increment
        primary key,
    nombre varchar(200) not null,
    activo tinyint(1)   null
);

create table if not exists medida
(
    id           int          not null
        primary key,
    descripcion  varchar(100) not null,
    id_categoria int          not null comment 'La foreign key de la tabla categoria',
    constraint medida_categoria_id_fk
        foreign key (id_categoria) references categoria (id)
);

create table if not exists recetas
(
    id_receta          int auto_increment
        primary key,
    nombre_receta      varchar(100) null,
    tiempo_preparacion time(6)      null,
    instrucciones      text         null
);

create table if not exists producto
(
    id                int auto_increment comment 'El primary key de la tabla producto'
        primary key,
    descripcion       varchar(100)                   not null,
    precio_produccion double                         null,
    precio_venta      double                         null,
    ruta_imagen       varchar(255)                   null,
    id_receta         int                            null,
    tipo              enum ('Comprado', 'Elaborado') null,
    constraint producto_recetas_id_receta_fk
        foreign key (id_receta) references recetas (id_receta)
);

create table if not exists tasa
(
    id    int auto_increment
        primary key,
    fecha date  not null,
    tasa  float not null
);

create table if not exists tipo_medida
(
    id_tipo_medida int auto_increment
        primary key,
    nombre         varchar(50) not null
);

create table if not exists insumo
(
    id             int auto_increment
        primary key,
    descripcion    varchar(100) not null comment 'La descripcion del insumo',
    fecha_creacion date         null,
    hora_creacion  time(6)      null,
    activo         tinyint(1)   not null,
    ruta_imagen    varchar(30)  null,
    id_tipo_medida int          not null,
    constraint insumo_tipo_medida_fk
        foreign key (id_tipo_medida) references tipo_medida (id_tipo_medida)
)
    comment 'Tabla donde se guardan los insumos de panin';

create table if not exists unidad_medida
(
    id_unidad   int auto_increment
        primary key,
    nombre      varchar(50) not null,
    abreviatura varchar(10) null,
    sistema     varchar(20) null,
    id_tipo     int         null,
    unidad_base tinyint(1)  null,
    constraint unidad_medida_ibfk_1
        foreign key (id_tipo) references tipo_medida (id_tipo_medida)
);

create table if not exists compras_insumo
(
    id               int auto_increment
        primary key,
    fecha            date           not null,
    insumo           int            not null,
    cantidad         decimal(38, 2) not null,
    precio           decimal(10, 6) not null,
    unidad_medida_id int            not null,
    hora             time(6)        null,
    marca_insumo     int            null,
    constraint compras_insumo_ibfk_1
        foreign key (insumo) references insumo (id),
    constraint compras_insumo_ibfk_2
        foreign key (unidad_medida_id) references unidad_medida (id_unidad),
    constraint compras_insumo_marca_insumo_id_fk
        foreign key (marca_insumo) references marca_insumo (id)
);

create index insumo
    on compras_insumo (insumo);

create index unidad_medida_id
    on compras_insumo (unidad_medida_id);

create table if not exists conversion
(
    id_conversion      int auto_increment
        primary key,
    unidad_base_id     int            null,
    unidad_derivada_id int            null,
    factor_conversion  decimal(10, 5) not null,
    constraint conversion_ibfk_1
        foreign key (unidad_base_id) references unidad_medida (id_unidad),
    constraint conversion_ibfk_2
        foreign key (unidad_derivada_id) references unidad_medida (id_unidad)
);

create index unidad_base_id
    on conversion (unidad_base_id);

create index unidad_derivada_id
    on conversion (unidad_derivada_id);

create table if not exists insumo_recetas
(
    id_insumo_receta int auto_increment
        primary key,
    id_receta        int            null,
    id_insumo        int            null,
    cantidad         decimal(38, 2) null,
    unidad_medida    int            null,
    constraint FKgqreox5gupcojl2ga6v43juyt
        foreign key (unidad_medida) references unidad_medida (id_unidad),
    constraint insumo_recetas_ibfk_1
        foreign key (id_receta) references recetas (id_receta),
    constraint insumo_recetas_ibfk_2
        foreign key (id_insumo) references insumo (id)
);

create index id_insumo
    on insumo_recetas (id_insumo);

create index id_receta
    on insumo_recetas (id_receta);

create index id_tipo
    on unidad_medida (id_tipo);


INSERT INTO panin.tipo_medida (id_tipo_medida, nombre) VALUES (1, 'Masa');
INSERT INTO panin.tipo_medida (id_tipo_medida, nombre) VALUES (2, 'Longitud');
INSERT INTO panin.tipo_medida (id_tipo_medida, nombre) VALUES (3, 'Unidad');
INSERT INTO panin.tipo_medida (id_tipo_medida, nombre) VALUES (4, 'Volumen');


INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (1, 'Harina de Trigo', '2024-10-03', '19:48:23', 1, '/imagenes/insumos/harina.png', 1);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (2, 'Azucar', '2024-10-05', '17:08:58.640000', 0, '/imagenes/insumos/default.png', 1);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (3, 'Huevos', '2024-10-05', '17:15:28.405000', 0, '/imagenes/insumos/default.png', 3);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (4, 'Leche líquida', '2024-10-05', '17:26:00.237000', 1, '/imagenes/insumos/default.png', 4);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (5, 'Leche en Polvo', '2024-10-05', '17:30:40.700000', 1, '/imagenes/insumos/default.png', 1);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (6, 'Levadura', '2024-10-05', '20:39:05.623000', 1, '/imagenes/insumos/default.png', 1);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (7, 'Mantequilla', '2024-10-05', '20:39:19.840000', 1, '/imagenes/insumos/default.png', 1);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (8, 'Sal', '2024-10-05', '20:39:28.438000', 1, '/imagenes/insumos/default.png', 1);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (9, 'Vainilla', '2024-10-05', '20:39:35.848000', 1, '/imagenes/insumos/default.png', 4);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (10, 'Queso', '2024-10-05', '20:39:53.557000', 1, '/imagenes/insumos/default.png', 1);
INSERT INTO panin.insumo (id, descripcion, fecha_creacion, hora_creacion, activo, ruta_imagen, id_tipo_medida) VALUES (11, 'Dulce Arequipe', '2024-10-06', '10:36:11.276000', 1, '/imagenes/insumos/default.png', 4);

INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (1, 'gramo', 'g', 'métrico', 1, 1);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (2, 'litro', 'L', 'métrico', 4, 1);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (3, 'metro', 'm', 'métrico', 2, 1);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (4, 'unidad', '1', 'unidad', 3, 1);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (5, 'kilogramo', 'Kg', 'métrico', 1, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (6, 'hectogramo', 'Hg', 'métrico', 1, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (7, 'decagramo', 'dag', 'métrico', 1, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (8, 'decigramo', 'dg', 'métrico', 1, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (9, 'centigramo', 'cg', 'métrico', 1, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (10, 'miligramo', 'mg', 'métrico', 1, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (11, 'Kilolitro', 'Kl', 'métrico', 4, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (12, 'Hectolitro', 'hl', 'métrico', 4, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (13, 'Decalitro', 'dal', 'métrico', 4, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (14, 'Decilitro', 'dl', 'métrico', 4, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (15, 'Centilitro', 'cl', 'métrico', 4, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (16, 'Mililitro', 'ml', 'métrico', 4, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (17, 'Media Docena', '6', 'métrico', 3, 0);
INSERT INTO panin.unidad_medida (id_unidad, nombre, abreviatura, sistema, id_tipo, unidad_base) VALUES (18, 'Docena', '12', 'métrico', 3, 0);

INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (1, 'Pan frances', 0, 0, '/imagenes/productos/pan_frances.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (2, 'Pan piñita', 0, 0, '/imagenes/productos/pan_piñita.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (3, 'Pan canilla', 0, 0, '/imagenes/productos/pan_canilla.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (5, 'Pan campesino', 0, 0, '/imagenes/productos/pan_campesino.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (6, 'Pan de arequipe', 0, 0, '/imagenes/productos/pan_arequipe.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (7, 'Pan de guayaba', 0, 0, '/imagenes/productos/pan_guayaba.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (8, 'Pan de queso', 0, 0, '/imagenes/productos/pan_queso.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (9, 'Golfeado', 0, 0, '/imagenes/productos/golfeado.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (10, 'Pasta seca', 0, 0, '/imagenes/productos/pan_frances.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (11, 'Queso', 0, 0, '/imagenes/productos/quesito.png', null, null);
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen, id_receta, tipo) VALUES (12, 'Torta', 0, 0, '/imagenes/productos/torta.png', null, null);

INSERT INTO panin.marca_insumo (id, nombre, activo) VALUES (1, 'NA', 1);
INSERT INTO panin.marca_insumo (id, nombre, activo) VALUES (2, 'La Hacienda', 1);

<<<<<<< HEAD



create table compras_producto
(
    id            int auto_increment,
    fecha         date           null,
    producto      int            not null,
    cantidad      decimal(20, 6) null,
    unidad_medida int            not null,
    precio        decimal(10, 6) null,
    hora          time(6)        null,
    marca         int            not null,
    constraint compras_producto_pk
        primary key (id),
    constraint compras_producto_marca_insumo_id_fk
        foreign key (marca) references marca_insumo (id),
    constraint compras_producto_producto_id_fk
        foreign key (producto) references producto (id),
    constraint compras_producto_unidad_medida_id_unidad_fk
        foreign key (unidad_medida) references unidad_medida (id_unidad)
)
    comment 'Tabla dondese almacenan los daos d elos productos comprados';
=======
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (1, 5, 0.00100);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (1, 6, 0.01000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (1, 7, 0.10000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (1, 8, 10.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (1, 9, 100.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (1, 10, 1000.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (5, 1, 1000.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (6, 1, 100.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (7, 1, 10.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (8, 1, 0.10000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (9, 1, 0.01000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (10, 1, 0.00100);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (2, 11, 0.00100);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (2, 12, 0.01000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (2, 13, 0.10000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (2, 14, 10.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (2, 15, 100.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (2, 16, 1000.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (11, 2, 1000.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (12, 2, 100.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (13, 2, 10.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (14, 2, 0.10000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (15, 2, 0.01000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (16, 2, 0.00100);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (4, 17, 0.16670);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (4, 18, 0.08330);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (17, 4, 6.00000);
INSERT INTO panin.conversion (unidad_base_id, unidad_derivada_id, factor_conversion) VALUES (18, 4, 12.00000);

CREATE TABLE configuracion (
  id INT AUTO_INCREMENT PRIMARY KEY,
  clave VARCHAR(100) NOT NULL UNIQUE,
  valor TEXT,
  descripcion TEXT
);
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    activo TINYINT(1) NOT NULL
);
INSERT INTO usuarios (username, correo_electronico, contrasena, activo)
VALUES ('admin', 'admin@example.com', '81dc9bdb52d04dc20036dbd8313ed055', 1);

INSERT INTO panin.configuracion (clave, valor, descripcion)
VALUES ('PORCANTAJE_GANANCIA', '0.3', 'Porcentaje de ganancia');

INSERT INTO panin.configuracion (clave, valor, descripcion)
VALUES ('NOMBRE_EMPRESA', 'Panin', 'Nombre de la empresa');

IN  SERT INTO panin.configuracion (clave, valor, descripcion)
VALUES ('DIRECCION_EMPRESA', 'Urbanización Chucho Briceño, Cabudare Edo. Lara', 'Dirección de la empresa');

>>>>>>> 6fe517b305f75a7467d97e4e0e6fcac1626b448b
