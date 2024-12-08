CREATE TABLE clazz
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50)        NULL,
    CONSTRAINT pk_clazz PRIMARY KEY (id)
);

CREATE TABLE student
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(50)        NULL,
    score DOUBLE             NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);
