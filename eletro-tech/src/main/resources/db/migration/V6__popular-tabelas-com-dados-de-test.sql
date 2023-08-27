-- TABELA DE PESSOA
INSERT INTO pessoa (id, id_parent, nome, sobrenome, cpf, data_nascimento, sexo, parentesco, created, updated)
values ('6bdfe9d7-b8ca-48db-b1b9-8c1e58573cf2', NULL, 'Marcos', 'Andrade', '85148748028', '1995-03-13', 'M', NULL,
        '2023-08-27 11:22:48.170109-03', '2023-08-27 11:22:48.170109-03'),
       ('6fa80853-cb18-4696-8a37-4ba59a6962a0', '6bdfe9d7-b8ca-48db-b1b9-8c1e58573cf2', 'Anderson', 'Andrade',
        '84483706004', '1965-06-22', 'M', 'P', '2023-08-27 11:22:48.226109-03', '2023-08-27 11:22:48.226109-03'),
       ('6aaefc80-b9dc-4512-bbed-6dbebe396636', '6bdfe9d7-b8ca-48db-b1b9-8c1e58573cf2', 'Ana', 'Andrade', '08062364003',
        '1965-01-01', 'F', 'M', '2023-08-27 11:22:48.227107-03', '2023-08-27 11:22:48.227107-03');


-- TABELA DE ENDEREÇO
INSERT INTO endereco (id, rua, complemento, numero, bairro, cidade, estado, created, updated, id_pessoa, cep,
                      nome_endereco)
VALUES ('4bc6b235-84ae-40fe-8930-0ee0530fc170', 'SIA Trecho 2', 'até 768 - lado par', 104, 'Zona Industrial (Guará)',
        'Brasília', 'DF', '2023-08-27 11:26:35.31364-03', '2023-08-27 11:26:35.31364-03',
        '6bdfe9d7-b8ca-48db-b1b9-8c1e58573cf2', '71200021', 'Minha Casa'),
       ('5c9c3a33-83d3-4ab6-9941-4fda40d9034b', 'SIA Trecho 2', 'até 768 - lado par', 104, 'Zona Industrial (Guará)',
        'Brasília', 'DF', '2023-08-27 11:31:08.446684-03', '2023-08-27 11:31:08.446684-03',
        '6fa80853-cb18-4696-8a37-4ba59a6962a0', '71200021', 'Casa do meu filho'),
       ('ccef0c99-baa8-4362-8858-397703d31688', 'SIA Trecho 2', 'até 768 - lado par', 104, 'Zona Industrial (Guará)',
        'Brasília', 'DF', '2023-08-27 11:31:27.274412-03', '2023-08-27 11:31:27.274412-03',
        '6aaefc80-b9dc-4512-bbed-6dbebe396636', '71200021', 'Casa do meu filho');
