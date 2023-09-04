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
