-- adicinar novas colunas
ALTER TABLE endereco
    ADD id_pessoa uuid not null;
ALTER TABLE endereco
    ADD cep varchar(8) not null;


-- adincionar constraints
alter table if exists endereco
    add constraint FK_ENDERECO_PESSOA foreign key (id_pessoa) references pessoa (id);