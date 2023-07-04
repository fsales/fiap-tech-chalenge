create table endereco
(
    id              uuid         not null,
    created         timestamp(6) with time zone,
    updated         timestamp(6) with time zone,
    rua             varchar(255)  not null,
    complemento     varchar(255),
    numero          integer  not null,
    bairro          varchar(255) not null,
    cidade          varchar(255) not null,
    estado          varchar(2)  not null,
    primary key (id)
);