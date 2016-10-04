INSERT INTO Membro (id, nome, tipo_perfil) VALUES (1, 'Mateus', 'AL'), (2, 'Fulano', 'AL'), (3, 'Beltrano', 'AL'), (4, 'Ciclano', 'AL'), (5, 'Professor Fulano', 'PF'), (6, 'Professor Beltrano', 'PF');

INSERT INTO Turma (id, nome, reponsavel_id) VALUES (1, 'Sistemas de Informação', 5), (2, 'Engenharia de Software', 6);

INSERT INTO Presenca (id, data_cadastro, tipo_presenca, membro_id, turma_id) VALUES (1, '2016-01-01', 'PR', 1, 1), (2, '2016-01-02', 'PR', 1, 1), (3, '2016-01-03', 'PR', 1, 1), (4, '2016-01-01', 'PR', 1, 2), (5, '2016-01-02', 'PR', 1, 2), (6, '2016-01-03', 'PR', 1, 2), (7, '2016-01-01', 'FL', 2, 1), (8, '2016-01-02', 'FL', 2, 1), (9, '2016-01-03', 'FL', 2, 1), (10, '2016-01-01', 'FL', 2, 2), (11, '2016-01-02', 'FL', 2, 2), (12, '2016-01-03', 'FL', 2, 2), (13, '2016-01-01', 'AT', 3, 1), (14, '2016-01-02', 'AT', 3, 1), (15, '2016-01-03', 'AT', 3, 1), (16, '2016-01-01', 'AT', 3, 2), (17, '2016-01-02', 'AT', 3, 2), (18, '2016-01-03', 'AT', 3, 2);

INSERT INTO MEMBRO_HAS_TURMAS (membro_id, turma_id) VALUES (1, 1), (2, 1), (3, 1), (4, 1), (1, 2), (2, 2), (5, 1), (6, 2);
