CREATE TABLE conta(

    numero_conta INTEGER NOT NULL UNIQUE,
    saldo FLOAT NOT NULL,

    PRIMARY KEY(numero_conta)
);