INSERT INTO Membro (id, nome, tipo_perfil) VALUES (nextval('MEMBRO_SEQUENCE'), 'Mateus', 'AL'),(nextval('MEMBRO_SEQUENCE'), 'Fulano', 'AL'),(nextval('MEMBRO_SEQUENCE'), 'Beltrano', 'AL'),(nextval('MEMBRO_SEQUENCE'), 'Ciclano', 'AL'),(nextval('MEMBRO_SEQUENCE'), 'Professor Fulano', 'PF'),(nextval('MEMBRO_SEQUENCE'), 'Professor Beltrano', 'PF');

INSERT INTO Turma (id, nome, reponsavel_id) VALUES (nextval('TURMA_SEQUENCE'), 'Sistemas de Informação', 5),(nextval('TURMA_SEQUENCE'), 'Engenharia de Software', 6);

INSERT INTO Presenca (id, data_cadastro, tipo_presenca, membro_id, turma_id) VALUES (nextval('PRESENCA_SEQUENCE'), '2016-01-01', 'PR', 1, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-02', 'PR', 1, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-03', 'PR', 1, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-01', 'PR', 1, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-02', 'PR', 1, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-03', 'PR', 1, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-01', 'FL', 2, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-02', 'FL', 2, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-03', 'FL', 2, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-01', 'FL', 2, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-02', 'FL', 2, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-03', 'FL', 2, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-01', 'AT', 3, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-02', 'AT', 3, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-03', 'AT', 3, 1), (nextval('PRESENCA_SEQUENCE'), '2016-01-01', 'AT', 3, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-02', 'AT', 3, 2), (nextval('PRESENCA_SEQUENCE'), '2016-01-03', 'AT', 3, 2);

INSERT INTO TURMA_HAS_MEMBROS (membro_id, turma_id) VALUES (1, 1);
INSERT INTO TURMA_HAS_MEMBROS (membro_id, turma_id) VALUES (2, 1);
INSERT INTO TURMA_HAS_MEMBROS (membro_id, turma_id) VALUES (3, 1);
INSERT INTO TURMA_HAS_MEMBROS (membro_id, turma_id) VALUES (4, 1);
INSERT INTO TURMA_HAS_MEMBROS (membro_id, turma_id) VALUES (1, 2);
INSERT INTO TURMA_HAS_MEMBROS (membro_id, turma_id) VALUES (2, 2);
INSERT INTO TURMA_HAS_MEMBROS (membro_id, turma_id) VALUES (3, 2);