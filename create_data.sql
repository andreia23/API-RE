CREATE TABLE Categoria(
	idCat SERIAL,
    categoria  VARCHAR(255) NOT NULL,
	CONSTRAINT idcategoria_pk PRIMARY KEY (idCat)
);

// Inserindo sem o id
INSERT INTO Categoria (categoria) VALUES ('Bebidas')

// Inserindo com o id
INSERT INTO Categoria (id,categoria) VALUES (2,'Higiene')

CREATE TABLE Produto(
	idPro SERIAL,
        id_categoria INTEGER NOT NULL,
	descricao  VARCHAR(255) NOT NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (idPro),
	CONSTRAINT produto_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES Categoria
);