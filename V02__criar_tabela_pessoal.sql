CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(20),
	logradouro VARCHAR(10),
	numero VARCHAR(10),
	bairro VARCHAR(10),
	cep VARCHAR(150),
	cidade VARCHAR(10),
	estado VARCHAR(10),
	activo VARCHAR(8) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	

/*INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Marcia Jamal', 'Rua das flores','100','Amilcar Cabral','33.212-12','Belo Horizonte','Maputo-Provincia',true);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Ivandro Mauro','Rua da Namaacha','200','Boane','33.212-13','Campoane','Maputo-Provincia',false);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Gladys Michelle','Rua de Poetas','300','24 de Julho','33.212-14','Pandora','Maputo-Cidade',true);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Letizia Paula','Rua da fortaleza','400','Mozal','33.212-15','Boane','Maputo-Provincia',true);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Edna Vanessa','Rua da paz','500','Eduardo Mondlane','33.212-16','Campo alto','Inhambane',false);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Claudio Pereira', 'Rua da independencia','600','Amilcar Cabral','33.212-17','Belo Horizonte','Nampula',true);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Ivanilde Rosa', 'Rua da guerra','700','Guerra Popular','33.212-18','Belo Horizonte','Tete',true);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Nelio Francisco','Rua da luz','800','25 de Setembro','33.212-19','Belo Horizonte','Gaza',false);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Nuno Abreu','Rua da patrice','900','Amilcar Cabral','33.212-20','Belo Horizonte','Manica',true);
INSERT INTO pessoa (nome, logradouro,numero,bairro,cep, cidade, estado,activo) values ('Gigy Alegria', 'Rua das flores','950','Amilcar Cabral','33.212-21','Belo Horizonte','Beira',true);*/

