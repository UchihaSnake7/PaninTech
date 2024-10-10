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
    comment 'Tabla donde s eguardan los insumos de panin';

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


