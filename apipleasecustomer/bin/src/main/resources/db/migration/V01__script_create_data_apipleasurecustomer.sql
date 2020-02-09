
CREATE TABLE CLIENTE(
	idcliente LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(14) UNIQUE NOT NULL,
	sexo ENUM('MASCULINO','FEMININO') NOT NULL,
	data_nasc DATE NOT NULL,
	email VARCHAR(30) UNIQUE
);

CREATE TABLE LOJA(
	idloja LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR (50),
	cnpj VARCHAR (20) UNIQUE,
	insc_estadual VARCHAR (15) UNIQUE,
	categoria VARCHAR (20),
	data_cadast DATE
);

CREATE TABLE ENDERECO(
	idendereco LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
	logradouro VARCHAR(100) NOT NULL,
	bairro VARCHAR(20) NOT NULL,
	cep VARCHAR (10) NOT NULL,
	cidade VARCHAR (20) NOT NULL,
	estado VARCHAR (2) NOT NULL,
	obs VARCHAR (100),
	id_cliente LONG
);

CREATE TABLE TELEFONE(
	idtelefone LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
	tipo ENUM ('CELULAR', 'COMERCIAL', 'RESIDENCIAL') NOT NULL,
	numero VARCHAR (15) UNIQUE NOT NULL,
	id_cliente LONG
);

CREATE TABLE PREFERENCIA(
	idpreferencia LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
	categoria VARCHAR (15) NOT NULL,
	descricao VARCHAR (50) NOT NULL,
	id_cliente LONG
);

CREATE TABLE BRINDE(
	idbrinde LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome VARCHAR (30) NOT NULL,
	descricao VARCHAR (50) NOT NULL, 
	data_retir DATE,
	prod_retir BOOLEAN,
	id_cliente LONG,
	id_loja LONG
);

ALTER TABLE ENDERECO ADD CONSTRAINT ID_ENDERECO_FK_CLIENTE FOREIGN KEY(id_cliente) REFERENCES CLIENTE (idcliente);
ALTER TABLE TELEFONE ADD CONSTRAINT ID_TELEFONE_FK_CLIENTE FOREIGN KEY(id_cliente) REFERENCES CLIENTE (idcliente);
ALTER TABLE PREFERENCIA ADD CONSTRAINT ID_PREFERENCIA_FK_CLIENTE FOREIGN KEY(id_cliente) REFERENCES CLIENTE (idcliente);
ALTER TABLE BRINDE ADD CONSTRAINT ID_BRINDE_FK_CLIENTE FOREIGN KEY(id_cliente) REFERENCES CLIENTE (idcliente);
ALTER TABLE BRINDE ADD CONSTRAINT ID_FK_LOJA FOREIGN KEY(id_loja) REFERENCES LOJA (idloja);

INSERT INTO CLIENTE (idcliente, nome, cpf, sexo, data_nasc, email) VALUES (1,'Mário Levi Souza','930.021.057-24','MASCULINO','1992-05-08','mmariosouza@mnproducoes.com');
INSERT INTO CLIENTE (idcliente, nome, cpf, sexo, data_nasc, email) VALUES (2,'Eduarda Letícia Silveira','902.609.397-73','FEMININO','1992-06-09','ed@tribunaimpressa.com.br');
INSERT INTO CLIENTE (idcliente, nome, cpf, sexo, data_nasc, email) VALUES (3,'Victor Kevin Assunção','304.723.097-81','MASCULINO','1992-06-06','victor@prestec.com.br');

INSERT INTO LOJA (idloja, nome, cnpj, insc_estadual, categoria, data_cadast) VALUES (1,'ESPORTE E CIA LTDA','47583873000138','66102483','ESPORTE','2018-06-21');
INSERT INTO LOJA (idloja, nome, cnpj, insc_estadual, categoria, data_cadast) VALUES (2,'CINEMA ESPECIAL LTDA','03527944000100','86339706','CINEMA','2018-04-24');
INSERT INTO LOJA (idloja, nome, cnpj, insc_estadual, categoria, data_cadast) VALUES (3,'CHOCOLATE MANIA LTDA','06359495000126','37000078','ALIMENTICIO','2018-07-26');

INSERT INTO ENDERECO (idendereco, logradouro, bairro, cep, cidade, estado, obs, id_cliente) VALUES (1,'Rua Soter de Araújo, 285','Senador Camará','21832-010','Rio de Janeiro','RJ','no',1);
INSERT INTO ENDERECO (idendereco, logradouro, bairro, cep, cidade, estado, obs, id_cliente) VALUES (2,'Avenida Horácio Macedo 950','Cidade Universitária','21941-915','Rio de Janeiro','RJ','no',2);
INSERT INTO ENDERECO (idendereco, logradouro, bairro, cep, cidade, estado, obs, id_cliente) VALUES (3,'Avenida Presidente Wilson 165','Centro','20030-904','Rio de Janeiro','RJ','no',3);

INSERT INTO TELEFONE (idtelefone, tipo, numero, id_cliente) VALUES (1,'RESIDENCIAL','(21)3832-7097',1);
INSERT INTO TELEFONE (idtelefone, tipo, numero, id_cliente) VALUES (2,'CELULAR','(21)99707-6819',1);
INSERT INTO TELEFONE (idtelefone, tipo, numero, id_cliente) VALUES (3,'RESIDENCIAL','(21)2552-3235',2);
INSERT INTO TELEFONE (idtelefone, tipo, numero, id_cliente) VALUES (4,'COMERCIAL','(21)2551-7213',2);
INSERT INTO TELEFONE (idtelefone, tipo, numero, id_cliente) VALUES (5,'CELULAR','(21)99932-9193',3);

INSERT INTO PREFERENCIA (idpreferencia, categoria, descricao, id_cliente) VALUES (1,'ESPORTE','Destinado a esportes em geral.',1);
INSERT INTO PREFERENCIA (idpreferencia, categoria, descricao, id_cliente) VALUES (2,'CINEMA','Destinado a filmes em geral.',2);
INSERT INTO PREFERENCIA (idpreferencia, categoria, descricao, id_cliente) VALUES (3,'ALIMENTICIO','Destinado a alimenticio em geral.',3);
INSERT INTO PREFERENCIA (idpreferencia, categoria, descricao, id_cliente) VALUES (4,'FITNESS','Destinado a fitness em geral.',2);
INSERT INTO PREFERENCIA (idpreferencia, categoria, descricao, id_cliente) VALUES (5,'TECNOLOGIA','Destinado a tecnologia em geral.',2);
INSERT INTO PREFERENCIA (idpreferencia, categoria, descricao, id_cliente) VALUES (6,'CARRO','Destinado a carro em geral.',3);

INSERT INTO BRINDE (idbrinde, nome, descricao, data_retir, prod_retir, id_cliente, id_loja) VALUES (1,'MEIÃO','Meião de futebol','2020-01-10',TRUE, 1, 1);
INSERT INTO BRINDE (idbrinde, nome, descricao, data_retir, prod_retir, id_cliente, id_loja) VALUES (2,'INGRESSO','Ingresso para o filme DarkMan','2019-10-11',TRUE, 1, 2);
INSERT INTO BRINDE (idbrinde, nome, descricao, data_retir, prod_retir, id_cliente, id_loja) VALUES (3,'BALDE DE PIPOCA','Balde de pipoca para a sessão das 14 hs','2019-10-11', TRUE,2,3);
INSERT INTO BRINDE (idbrinde, nome, descricao, data_retir, prod_retir, id_cliente, id_loja) VALUES (4,'TRUFFA','Conjunto com 03 truffas de chocolate','2019-06-12',TRUE,3,1);
INSERT INTO BRINDE (idbrinde, nome, descricao, data_retir, prod_retir, id_cliente, id_loja) VALUES (5,'CAMISA','Camisa do filme X-Mem','2019-10-11',TRUE,2,2);
INSERT INTO BRINDE (idbrinde, nome, descricao, data_retir, prod_retir, id_cliente, id_loja) VALUES (6,'INGRESSO','Ingresso para o filme Pica pau','2020-01-15',TRUE,2,1);



