CREATE DATABASE JustJava
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE USER 'java'@'localhost'
  IDENTIFIED BY 'java';
GRANT ALL ON JustJava.* TO 'java'@'localhost'
IDENTIFIED BY 'java';

CREATE TABLE USER (
  id       INT                NOT NULL AUTO_INCREMENT,
  login    VARCHAR(20) UNIQUE NOT NULL,
  password VARCHAR(20)        NOT NULL,
  PRIMARY KEY (id)
);

DROP FUNCTION IF EXISTS insert_user;
CREATE FUNCTION insert_user(p_login VARCHAR(20), p_password VARCHAR(20))
  RETURNS INT
  BEGIN
    INSERT INTO USER (login, PASSWORD)
    VALUES (p_login, p_password);
    RETURN LAST_INSERT_ID();
  END;