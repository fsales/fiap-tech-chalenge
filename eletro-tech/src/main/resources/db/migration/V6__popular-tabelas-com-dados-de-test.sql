-- INSERT PESSOA
INSERT INTO pessoa (id, id_parent, nome, sobrenome, cpf, data_nascimento, sexo, parentesco, created, updated)
VALUES ('fed3f974-3b1e-449d-bcd6-3a8450b09fb9', null, 'Luiz', 'Silva de Castro', '89004516000', '1975-05-01', 'M', null,
        '2023-09-04 21:56:38.362334 +00:00', '2023-09-04 21:56:38.362334 +00:00');
INSERT INTO pessoa (id, id_parent, nome, sobrenome, cpf, data_nascimento, sexo, parentesco, created, updated)
VALUES ('608f3f7d-67da-4ea6-ba56-55d9a3721dd2', 'fed3f974-3b1e-449d-bcd6-3a8450b09fb9', 'Maria', 'Silva de Castro',
        '64630752056', '2001-06-22', 'F', 'F', '2023-09-04 21:56:38.363460 +00:00',
        '2023-09-04 21:56:38.363460 +00:00');
INSERT INTO pessoa (id, id_parent, nome, sobrenome, cpf, data_nascimento, sexo, parentesco, created, updated)
VALUES ('f490d55b-a411-4b9b-85d0-f81157dba97f', 'fed3f974-3b1e-449d-bcd6-3a8450b09fb9', 'Andre', 'Silva de Castro',
        '66547968022', '2015-07-22', 'M', 'F', '2023-09-04 21:56:38.364011 +00:00',
        '2023-09-04 21:56:38.364011 +00:00');
INSERT INTO pessoa (id, id_parent, nome, sobrenome, cpf, data_nascimento, sexo, parentesco, created, updated)
VALUES ('5f45e907-a9d8-4455-8c98-54970d66f60d', 'fed3f974-3b1e-449d-bcd6-3a8450b09fb9', 'Livia', 'Silva de Castro',
        '90663099030', '1985-01-01', 'F', 'M', '2023-09-04 21:56:38.364571 +00:00',
        '2023-09-04 21:56:38.364571 +00:00');


-- INSERT ENDEREÇO
INSERT INTO endereco (id, rua, complemento, numero, bairro, cidade, estado, created, updated, id_pessoa, cep,
                             nome_endereco)
VALUES ('3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0', 'Praça da Sé', 'lado ímpar', 1024, 'Sé', 'São Paulo', 'SP',
        '2023-09-04 22:37:45.774856 +00:00', '2023-09-04 22:37:45.774856 +00:00',
        'fed3f974-3b1e-449d-bcd6-3a8450b09fb9', '01001000', 'Minha casa');
INSERT INTO endereco (id, rua, complemento, numero, bairro, cidade, estado, created, updated, id_pessoa, cep,
                             nome_endereco)
VALUES ('d86a5f0d-3145-496c-bc9c-1eff2ad89fca', 'Praça da Sé', 'lado ímpar', 1024, 'Sé', 'São Paulo', 'SP',
        '2023-09-04 22:41:08.932746 +00:00', '2023-09-04 22:41:08.932746 +00:00',
        '608f3f7d-67da-4ea6-ba56-55d9a3721dd2', '01001000', 'Casa da família');
INSERT INTO endereco (id, rua, complemento, numero, bairro, cidade, estado, created, updated, id_pessoa, cep,
                             nome_endereco)
VALUES ('2d36a19d-45fb-4126-aa44-727c68ba5042', 'Praça da Sé', 'lado ímpar', 1024, 'Sé', 'São Paulo', 'SP',
        '2023-09-04 22:41:23.323809 +00:00', '2023-09-04 22:41:23.323809 +00:00',
        'f490d55b-a411-4b9b-85d0-f81157dba97f', '01001000', 'Casa da família');
INSERT INTO endereco (id, rua, complemento, numero, bairro, cidade, estado, created, updated, id_pessoa, cep,
                             nome_endereco)
VALUES ('5bb73f66-7d62-444f-85da-9c988569e093', 'Praça da Sé', 'lado ímpar', 1024, 'Sé', 'São Paulo', 'SP',
        '2023-09-04 22:41:34.791215 +00:00', '2023-09-04 22:41:34.791215 +00:00',
        '5f45e907-a9d8-4455-8c98-54970d66f60d', '01001000', 'Casa da família');

-- INSERT ELETRODOMESTICOS
INSERT INTO eletrodomestico (id, nome, modelo, fabricante, potencia, voltagem, tempo_uso_diario, created, updated,
                             id_pessoa, id_endereco)
VALUES ('afd74beb-eeca-47b0-8cf5-1e16a7fa40a5', 'Micro-ondas 20L', 'MT30S', 'Electrolux', 1150, 220, 1,
        '2023-09-04 23:06:59.086986 +00:00', '2023-09-04 23:06:59.086986 +00:00',
        'fed3f974-3b1e-449d-bcd6-3a8450b09fb9', '3d02f4c7-91d5-4f46-9ecd-5da4254cf5b0');
INSERT INTO eletrodomestico (id, nome, modelo, fabricante, potencia, voltagem, tempo_uso_diario, created, updated,
                             id_pessoa, id_endereco)
VALUES ('c9dbd0c4-bb7b-4903-8f84-841d5a8644df', 'Chuveiro Elétrico', 'MT30S', 'LORENZETTI', 7800, 220, 1,
        '2023-09-04 23:09:30.097234 +00:00', '2023-09-04 23:09:30.097234 +00:00',
        '608f3f7d-67da-4ea6-ba56-55d9a3721dd2', 'd86a5f0d-3145-496c-bc9c-1eff2ad89fca');
INSERT INTO eletrodomestico (id, nome, modelo, fabricante, potencia, voltagem, tempo_uso_diario, created, updated,
                             id_pessoa, id_endereco)
VALUES ('54aa3218-0896-4a01-91de-10e3de90a619', 'Smart TV 55', 'UHD 55UQ8050', 'LG', 135, 220, 1,
        '2023-09-04 23:12:54.366500 +00:00', '2023-09-04 23:12:54.366500 +00:00',
        'f490d55b-a411-4b9b-85d0-f81157dba97f', '2d36a19d-45fb-4126-aa44-727c68ba5042');
INSERT INTO eletrodomestico (id, nome, modelo, fabricante, potencia, voltagem, tempo_uso_diario, created, updated,
                             id_pessoa, id_endereco)
VALUES ('7d0607d3-f2a3-4d53-b0e4-a8fc963be117', 'Lava e seca', 'WD11M', 'Samsung ', 1100, 220, 1,
        '2023-09-04 23:17:01.109397 +00:00', '2023-09-04 23:17:01.109397 +00:00',
        '5f45e907-a9d8-4455-8c98-54970d66f60d', '5bb73f66-7d62-444f-85da-9c988569e093');

