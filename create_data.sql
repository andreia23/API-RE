CREATE TABLE Categoria(
	id SERIAL,
    categoria  VARCHAR(255) NOT NULL,
	CONSTRAINT idcategoria_pk PRIMARY KEY (id)
);

// Inserindo sem o id
INSERT INTO Categoria (categoria) VALUES ('Bebidas')

// Inserindo com o id
INSERT INTO Categoria (id,categoria) VALUES (2,'Higiene')