CREATE
OR REPLACE VIEW endereco_pessoa_view AS
select e.id,
       e.rua,
       e.complemento,
       e.numero,
       e.bairro,
       e.cidade,
       e.estado    sigla_estado,
       e.cep,
       e.id_pessoa id_pessoa,
       e.created,
       e.updated,
       p.nome,
       p.sobrenome,
       parent.id   id_titular,
       parent.nome nome_titular
from endereco e
         inner join pessoa p on
    p.id = e.id_pessoa
         left join pessoa parent on
    parent.id = p.id_parent;