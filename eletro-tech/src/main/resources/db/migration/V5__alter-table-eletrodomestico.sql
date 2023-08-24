-- adicinar novas colunas
ALTER TABLE eletrodomestico
    ADD id_pessoa uuid not null;

ALTER TABLE eletrodomestico
    ADD id_endereco uuid not null;

-- adincionar constraints
alter table if exists eletrodomestico
    add constraint fk_eletrodomentico_pessoa foreign key (id_pessoa) references pessoa (id);

alter table if exists eletrodomestico
    add constraint fk_eletrodomentico_endereco foreign key (id_endereco) references endereco (id);