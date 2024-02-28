CREATE TABLE IF NOT EXISTS client (
    PK_ID     INTEGER PRIMARY KEY,
    name      TEXT NOT NULL,
    cpf       TEXT NOT NULL,
    sex       TEXT NOT NULL,
    birthDate INTEGER NOT NULL,
);

CREATE TABLE IF NOT EXISTS employee (
    PK_ID     INTEGER PRIMARY KEY,
    name      TEXT NOT NULL,
    cpf       TEXT NOT NULL,
    sex       TEXT NOT NULL,
    birthDate INTEGER NOT NULL,
);

CREATE TABLE IF NOT EXISTS computer (
    PK_ID      INTEGER PRIMARY KEY,
    mark       TEXT NOT NULL,
    model      TEXT NOT NULL,
    processor  TEXT NOT NULL,
    ram        INTEGER NOT NULL,
    storage    INTEGER NOT NULL,
    type       TEXT NOT NULL,
    color      TEXT NOT NULL,
    screenSize REAL NOT NULL
);

INSERT INTO
    client(name, cpf, sex, birthDate)
VALUES
    (),
    (),
    ();

INSERT INTO
    employee(name, cpf, sex, birthDate)
VALUES
    (),
    (),
    ();

INSERT INTO
    computer(mark, model, processor, ram, storage, type, color, screenSize)
VALUES
    (),
    (),
    ();