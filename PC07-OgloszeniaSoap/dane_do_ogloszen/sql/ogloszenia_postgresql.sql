SET client_encoding = 'UTF8';

CREATE SEQUENCE seq_sprzedawcy MINVALUE 100 START WITH 101;
CREATE SEQUENCE seq_ogloszenia MINVALUE 100 START WITH 101;

CREATE TABLE sprzedawcy (
  id_sprzedawcy INTEGER,
  nazwa VARCHAR(60) NOT NULL,
  ulica VARCHAR(60),
  kod_pocztowy VARCHAR(6),
  miasto VARCHAR(50),
  email VARCHAR(50),
  telefon VARCHAR(20),

  PRIMARY KEY (id_sprzedawcy)
);

CREATE TABLE ogloszenia (
  id_ogloszenia INTEGER,
  id_sprzedawcy INTEGER,
  wystawione TIMESTAMP WITH TIME ZONE,
  cena NUMERIC(9,2) NOT NULL CHECK (cena >= 0),
  lokalizacja VARCHAR(50),
  tytul VARCHAR(40),
  opis TEXT,
  
  PRIMARY KEY (id_ogloszenia),
  FOREIGN KEY (id_sprzedawcy) REFERENCES sprzedawcy(id_sprzedawcy)
);

CREATE TABLE samochodowe (
  id_ogloszenia INTEGER,
  marka VARCHAR(50) NOT NULL,
  model VARCHAR(50) NOT NULL,
  generacja VARCHAR(10),
  kolor VARCHAR(30),
  rocznik INTEGER,
  przebieg INTEGER,
  pojemnosc FLOAT,
  moc FLOAT,
  paliwo VARCHAR(10),
  
  PRIMARY KEY (id_ogloszenia),
  FOREIGN KEY (id_ogloszenia) REFERENCES ogloszenia(id_ogloszenia)
);
BEGIN TRANSACTION;

INSERT INTO sprzedawcy(id_sprzedawcy, nazwa, ulica, kod_pocztowy, miasto, email, telefon)
VALUES (1, 'Komis Bolka', 'Starocmentarna 5', '77-777', 'Wólka', NULL, '771231234');

INSERT INTO sprzedawcy(id_sprzedawcy, nazwa, ulica, kod_pocztowy, miasto, email, telefon)
VALUES (2, 'Auto jak nowe', 'Graniczna 13', '12-345', 'Pruszków', 'auto@jaknowe.pl', '666444333');

INSERT INTO sprzedawcy(id_sprzedawcy, nazwa, ulica, kod_pocztowy, miasto, email, telefon)
VALUES (3, 'Janusz Januszowski', 'Smutna', '56-654', 'Łódź', NULL, '987654321');


INSERT INTO ogloszenia(
     id_ogloszenia, id_sprzedawcy, wystawione, cena, lokalizacja, tytul, opis)
    VALUES (1, 1, '2019-10-10 20:20:00', 5500, 'Wólka', 'Sprzedam Opla', 'Opel Astra II 1.4 jak nowy');

INSERT INTO samochodowe(
       id_ogloszenia, marka, model, generacja, kolor, rocznik, przebieg, pojemnosc, moc, paliwo)
    VALUES (1, 'Opel', 'Astra', 'G', 'srebrny', 2005, 150000, 1.4, 90, 'PB');

INSERT INTO ogloszenia(
     id_ogloszenia, id_sprzedawcy, wystawione, cena, lokalizacja, tytul, opis)
    VALUES (2, 2, '2019-10-20 07:21:12', 12000, 'Warszawa Ursus', 'Passat niebity igła', 'Srebrny Passat TDI - będziesz królem swojej wsi');

INSERT INTO samochodowe(
       id_ogloszenia, marka, model, generacja, kolor, rocznik, przebieg, pojemnosc, moc, paliwo)
    VALUES (2, 'Volkswagen', 'Passat', 'C', 'srebrny', 2003, 179000, 2.0, 125, 'ON');

INSERT INTO ogloszenia(
     id_ogloszenia, id_sprzedawcy, wystawione, cena, lokalizacja, tytul, opis)
    VALUES (3, 3, '2019-11-03 8:18:00', 3300, 'Łódź', 'Złoty Matiz', NULL);

INSERT INTO samochodowe(
       id_ogloszenia, marka, model, generacja, kolor, rocznik, przebieg, pojemnosc, moc, paliwo)
    VALUES (3, 'Dewoo', 'Matiz', NULL, 'złoty', 1999, 123300, 1.0, 75, 'LPG');

INSERT INTO ogloszenia(
     id_ogloszenia, id_sprzedawcy, wystawione, cena, lokalizacja, tytul, opis)
    VALUES (4, 1, '2019-10-29 12:12:00', 17000, 'Zbytkowice', 'Meganka prosto z Francji', 'Mało jeżdżone, niepalone, opłaca się!');

INSERT INTO samochodowe(
       id_ogloszenia, marka, model, generacja, kolor, rocznik, przebieg, pojemnosc, moc, paliwo)
    VALUES (4, 'Renault', 'Megane', 'II', 'biały', 2009, 130000, 1.9, 130, 'ON');

INSERT INTO ogloszenia(
     id_ogloszenia, id_sprzedawcy, wystawione, cena, lokalizacja, tytul, opis)
    VALUES (5, 1, '2019-10-27 12:12:00', 99999, 'Warszawa', 'Mazda szósteczka nówka', 'Prosto z warszawskiej ulicy...');

INSERT INTO samochodowe(
       id_ogloszenia, marka, model, generacja, kolor, rocznik, przebieg, pojemnosc, moc, paliwo)
    VALUES (5, 'Mazda', '6', 'III', 'czerwony', 2015, 8000, 2.0, 150, 'PB');
    
COMMIT;
