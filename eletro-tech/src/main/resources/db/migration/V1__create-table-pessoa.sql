create table pessoa
(
    id              uuid         not null,
    data_nascimento date,
    created         timestamp(6) with time zone,
    updated         timestamp(6) with time zone,
    id_parent       uuid,
    cpf             varchar(255),
    nome            varchar(255),
    parentesco      varchar(255) not null,
    sexo            varchar(1) not null,
    sobrenome       varchar(255),
    primary key (id)
);


alter table if exists pessoa
    add constraint FK_PARENT_PESSOA foreign key (id_parent) references pessoa