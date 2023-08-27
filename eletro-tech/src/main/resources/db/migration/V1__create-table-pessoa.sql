create table pessoa
(
    id              uuid         not null,
    id_parent       uuid,
    nome      varchar(100) not null,
    sobrenome varchar(100) not null,
    cpf       varchar(11)  not null,
    data_nascimento date not null,
    sexo            varchar(1) not null,
    parentesco varchar(1),
    created         timestamp(6) with time zone,
    updated         timestamp(6) with time zone,
    primary key (id)
);


alter table if exists pessoa
    add constraint FK_PARENT_PESSOA foreign key (id_parent) references pessoa