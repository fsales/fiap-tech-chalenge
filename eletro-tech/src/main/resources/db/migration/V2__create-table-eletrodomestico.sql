create table eletrodomestico
(
    id              uuid         not null,
    created         timestamp(6) with time zone,
    updated         timestamp(6) with time zone,
    nome            varchar(255) not null,
    modelo          varchar(255) not null,
    potencia        integer      not null,
    fabricante      varchar(255) not null,
    voltagem        integer      not null,
    tempo_uso_diario  integer      not null,
    primary key (id)
);