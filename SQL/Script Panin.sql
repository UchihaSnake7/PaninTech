

create table insumo
(
    id             int auto_increment,
    descripcion    VARCHAR(100) not null comment 'La descripcion del insumo',
    fecha_creacion DATE         null,
    hora_creacion  TIME         null,
    activo         boolean      not null,
    constraint insumo_pk
        primary key (id)
)
    comment 'Tabla donde s eguardan los insumos de panin';


create table insumo_precio
(
    id                    int auto_increment comment 'La primary key',
    id_insumo             int     not null comment 'La foreign key con la tabla ínsumo',
    precio                decimal null comment 'El precio del insumo en divisa  USD',
    fecha_inicio_vigencia date    null comment 'El inicio del periodo de vigencia para el precio del insumo',
    fecha_fin_vigencia    date    null comment 'El final del periodo de vigencia para el precio del insumo',
    activo                boolean not null,
    constraint insumo_precio_pk
        primary key (id),
    constraint insumo_precio_insumo_id_fk
        foreign key (id_insumo) references insumo (id)
)
    comment 'La tabla que relaciona los insumos con el precio';


    create table categoria
(
    id              int          not null,
    descripcion     VARCHAR(100) not null,
    peso            decimal      null,
    volumen         decimal      null,
    unidades        int          null,
    longitud        decimal      null,
    unidad_especial int          null,
    constraint categoria_pk
        primary key (id)
);

create table medida
(
    id           int          not null,
    descripcion  varchar(100) not null,
    id_categoria int          not null comment 'La foreign key de la tabla categoria',
    constraint medida_pk
        primary key (id),
    constraint medida_categoria_id_fk
        foreign key (id_categoria) references categoria (id)
);

create table insumo_cantidad
(
    id        int  not null,
    id_insumo int  not null comment 'La foreign key de la tabla insumo',
    cantidad  int  not null,
    id_medida int  not null comment 'La foreign key de la tabla medida',
    fecha     date null,
    constraint insumo_cantidad_pk
        primary key (id),
    constraint insumo_cantidad_insumo_id_fk
        foreign key (id_insumo) references insumo (id),
    constraint insumo_cantidad_medida_id_fk
        foreign key (id_medida) references medida (id)
);

create table producto
(
    id                int auto_increment comment 'El primary key de la tabla producto',
    descripcion       varchar(100) not null,
    precio_produccion decimal      null comment 'El precio de produccion en $',
    precio_venta      DECIMAL      null comment 'El precio de venta estimado en $',
    ruta_imagen       varchar(200)

    constraint producto_pk
        primary key (id)
);

alter table producto
    add tipo ENUM ('Çomprado', 'Elaborado') null;

alter table producto
    add id_receta int null;

alter table producto
    add constraint producto_recetas_id_receta_fk
        foreign key (id_receta) references recetas (id_receta);

INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (1, 'Pan frances', 0, 0, '/imagenes/productos/pan_frances.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (2, 'Pan piñita', 0, 0, '/imagenes/productos/pan_piñita.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (3, 'Pan canilla', 0, 0, '/imagenes/productos/pan_canilla.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (5, 'Pan campesino', 0, 0, '/imagenes/productos/pan_campesino.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (6, 'Pan de arequipe', 0, 0, '/imagenes/productos/pan_arequipe.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (7, 'Pan de guayaba', 0, 0, '/imagenes/productos/pan_guayaba.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (8, 'Pan de queso', 0, 0, '/imagenes/productos/pan_queso.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (9, 'Golfeado', 0, 0, '/imagenes/productos/golfeado.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (10, 'Pasta seca', 0, 0, '/imagenes/productos/pan_frances.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (11, 'Queso', 0, 0, '/imagenes/productos/quesito.png');
INSERT INTO panin.producto (id, descripcion, precio_produccion, precio_venta, ruta_imagen) VALUES (12, 'Torta', 0, 0, '/imagenes/productos/torta.png');

  CREATE TABLE tipo_medida (
  id_tipo_medida INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL
);

INSERT INTO tipo_medida (nombre)
VALUES
  ('Masa'),
  ('Longitud'),
  ('Unidad'),
  ('Volumen');


CREATE TABLE unidad_medida (
  id_unidad INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  abreviatura VARCHAR(10),
  sistema VARCHAR(20),
  id_tipo INT,
     FOREIGN KEY (id_tipo) REFERENCES tipo_medida(id_tipo_medida)
);

INSERT INTO unidad_medida (nombre, abreviatura, sistema, id_tipo)
VALUES
  ('Gramo', 'g', 'métrico', 1),
  ('Litro', 'L', 'métrico', 4),
  ('Metro', 'm', 'métrico', 2),
  ('Unidad', 'un', 'unidad', 3);

CREATE TABLE conversion (
  id_conversion INT PRIMARY KEY AUTO_INCREMENT,
  unidad_base_id INT,
  unidad_derivada_id INT,
  factor_conversion DECIMAL(10,5) NOT NULL,
  FOREIGN KEY (unidad_base_id) REFERENCES unidad_medida(id_unidad),
  FOREIGN KEY (unidad_derivada_id) REFERENCES unidad_medida(id_unidad)
);


INSERT INTO unidad_medida (nombre, abreviatura, sistema, id_tipo)
VALUES
  ('kilogramo', 'Kg', 'métrico', 1),
  ('hectogramo', 'Hg', 'métrico', 1),
  ('decagramo', 'dag', 'métrico', 1),
  ('decigramo', 'dg', 'métrico', 1),
  ('centigramo', 'cg', 'métrico', 1),
  ('miligramo', 'mg', 'métrico', 1);

INSERT INTO conversion (unidad_base_id, unidad_derivada_id, factor_conversion)
VALUES
  (1, 5, 0.001),  -- 1 gramo = 0.001 kilogramos
  (1, 6, 0.01),  -- 1 gramo = 0.01 hectogramos
  (1, 7, 0.1),   -- 1 gramo = 0.1 decagramos
  (1, 8, 10),   -- 1 gramo = 10 decigramos
  (1, 9, 100),  -- 1 gramo = 100 centigramos
  (1, 10, 1000); -- 1 gramo = 1000 miligramos

alter table insumo
    add ruta_imagen varchar(30) null;
alter table insumo
    add id_tipo_medida int null;

alter table insumo
    add constraint insumo_tipo_medida_fk
        foreign key (id_tipo_medida) references tipo_medida(id_tipo_medida) ;

alter table insumo
    modify ruta_imagen varchar(100) null;

alter table insumo
    modify id_tipo_medida int not null;

drop table insumo_cantidad;
drop table insumo_precio;



CREATE TABLE recetas (
  id_receta INT PRIMARY KEY AUTO_INCREMENT,
  nombre_receta VARCHAR(100),
  tiempo_preparacion TIME,
  instrucciones TEXT
);

CREATE TABLE insumo_recetas (
  id_insumo_receta INT PRIMARY KEY AUTO_INCREMENT,
  id_receta INT,
  id_insumo INT,
  cantidad DECIMAL(10,2),
  FOREIGN KEY (id_receta) REFERENCES recetas(id_receta),
  FOREIGN KEY (id_insumo) REFERENCES insumo(id)
);

alter table insumo_recetas
    add unidad_medida int null;

alter table insumo_recetas
    add constraint insumo_recetas_unidad_medida_id_unidad_fk
        foreign key (unidad_medida) references unidad_medida (id_unidad);