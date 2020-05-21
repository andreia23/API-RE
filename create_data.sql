CREATE TABLE Categoria(
	id_categoria SERIAL,
    categoria  VARCHAR(255) NOT NULL,
	CONSTRAINT idcategoria_pk PRIMARY KEY (id_categoria)
);


CREATE TABLE Produto(
	idpro Serial,
    id_categoria INTEGER NOT NULL,
	descricao  VARCHAR(255) NOT NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (idpro),
	CONSTRAINT produto_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES Categoria
);

// Inserindo sem o id
INSERT INTO Categoria (categoria) VALUES ('Bebidas')

// Inserindo com o id
INSERT INTO Categoria (id_categoria,categoria) VALUES (2,'Higiene')


INSERT INTO Produto(idpro, descricao) VALUES (1,'Computador')
INSERT INTO Produto(idpro, descricao) VALUES (2,'Café')
CREATE TABLE Produto(
	idpro Serial,
        descricao  VARCHAR(255) NOT NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (idpro)
);
