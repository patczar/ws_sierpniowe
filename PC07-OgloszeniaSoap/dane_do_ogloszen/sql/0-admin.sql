-- Wykonac jako administrator postgresa (postgres)

DROP DATABASE IF EXISTS ogloszenia;
DROP USER IF EXISTS ogloszenia;

CREATE USER ogloszenia PASSWORD 'abc123';
CREATE DATABASE ogloszenia OWNER ogloszenia ENCODING 'utf-8';
