CREATE TABLE FormaEnvioCobranca (
 codigo INT NOT NULL,
 descricao VARCHAR(100)
);

ALTER TABLE FormaEnvioCobranca ADD CONSTRAINT PK_FormaEnvioCobranca PRIMARY KEY (codigo);


CREATE TABLE FormaPagamento (
 codigo INT NOT NULL,
 descricao VARCHAR(100)
);

ALTER TABLE FormaPagamento ADD CONSTRAINT PK_FormaPagamento PRIMARY KEY (codigo);


CREATE TABLE NaturezaDivida (
 codigo INT NOT NULL,
 descricao VARCHAR(100)
);

ALTER TABLE NaturezaDivida ADD CONSTRAINT PK_NaturezaDivida PRIMARY KEY (codigo);


CREATE TABLE TipoPessoa (
 codigo INT NOT NULL,
 descricao VARCHAR(100)
);

ALTER TABLE TipoPessoa ADD CONSTRAINT PK_TipoPessoa PRIMARY KEY (codigo);


CREATE TABLE Pessoa (
 cpfCnpj INT NOT NULL,
 tipoPessoa INT NOT NULL,
 nome VARCHAR(100) NOT NULL,
 telefone INT,
 dataNascimento DATE
);

ALTER TABLE Pessoa ADD CONSTRAINT PK_Pessoa PRIMARY KEY (cpfCnpj);


CREATE TABLE Cliente (
 cpf INT NOT NULL
);

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente PRIMARY KEY (cpf);


CREATE TABLE Credor (
 cnpj INT NOT NULL
);

ALTER TABLE Credor ADD CONSTRAINT PK_Credor PRIMARY KEY (cnpj);


CREATE TABLE Funcionario (
 cpf INT NOT NULL,
 matricula INT NOT NULL,
 cargo VARCHAR(100)
);

ALTER TABLE Funcionario ADD CONSTRAINT PK_Funcionario PRIMARY KEY (cpf,matricula);


CREATE TABLE RegistroPendencias (
 cliente INT NOT NULL,
 credor INT NOT NULL,
 dataInsercao DATE WITH TIME ZONE NOT NULL,
 naturezaDivida INT NOT NULL,
 valorDivida DOUBLE PRECISION,
 observacoes VARCHAR(100),
 situacao CHAR(10)
);

ALTER TABLE RegistroPendencias ADD CONSTRAINT PK_RegistroPendencias PRIMARY KEY (cliente,credor,dataInsercao);


CREATE TABLE AnaliseNegociacao (
 cliente INT NOT NULL,
 credor INT NOT NULL,
 dataInsercao DATE WITH TIME ZONE NOT NULL,
 formaPagamento INT NOT NULL,
 formaEnvio INT NOT NULL,
 parcelamento INT
);

ALTER TABLE AnaliseNegociacao ADD CONSTRAINT PK_AnaliseNegociacao PRIMARY KEY (cliente,credor,dataInsercao);


ALTER TABLE Pessoa ADD CONSTRAINT FK_Pessoa_0 FOREIGN KEY (tipoPessoa) REFERENCES TipoPessoa (codigo);


ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_0 FOREIGN KEY (cpf) REFERENCES Pessoa (cpfCnpj);


ALTER TABLE Credor ADD CONSTRAINT FK_Credor_0 FOREIGN KEY (cnpj) REFERENCES Pessoa (cpfCnpj);


ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario_0 FOREIGN KEY (cpf) REFERENCES Pessoa (cpfCnpj);


ALTER TABLE RegistroPendencias ADD CONSTRAINT FK_RegistroPendencias_0 FOREIGN KEY (cliente) REFERENCES Cliente (cpf);
ALTER TABLE RegistroPendencias ADD CONSTRAINT FK_RegistroPendencias_1 FOREIGN KEY (credor) REFERENCES Credor (cnpj);
ALTER TABLE RegistroPendencias ADD CONSTRAINT FK_RegistroPendencias_2 FOREIGN KEY (naturezaDivida) REFERENCES NaturezaDivida (codigo);


ALTER TABLE AnaliseNegociacao ADD CONSTRAINT FK_AnaliseNegociacao_0 FOREIGN KEY (cliente,credor,dataInsercao) REFERENCES RegistroPendencias (cliente,credor,dataInsercao);
ALTER TABLE AnaliseNegociacao ADD CONSTRAINT FK_AnaliseNegociacao_1 FOREIGN KEY (formaPagamento) REFERENCES FormaPagamento (codigo);
ALTER TABLE AnaliseNegociacao ADD CONSTRAINT FK_AnaliseNegociacao_2 FOREIGN KEY (formaEnvio) REFERENCES FormaEnvioCobranca (codigo);


