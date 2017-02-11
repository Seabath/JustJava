CREATE DATABASE JustJava
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE USER 'java'@'localhost' identified by 'java';

GRANT ALL ON JustJava.* TO 'java'@localhost identified by 'java';
