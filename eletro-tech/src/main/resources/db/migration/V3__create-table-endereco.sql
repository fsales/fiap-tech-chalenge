create table endereco
(
    id              uuid         not null,
    rua         varchar(100) not null,
    complemento varchar(100),
    numero          integer  not null,
    bairro      varchar(100) not null,
    cidade      varchar(100) not null,
    estado          varchar(2)  not null,
    created         timestamp(6) with time zone,
    updated         timestamp(6) with time zone,
    primary key (id)
);