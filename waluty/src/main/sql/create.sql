DROP TABLE IF EXISTS rates;
DROP TABLE IF EXISTS tables;

CREATE TABLE tables (
	"table" CHAR(1) NOT NULL,
	"no" VARCHAR(20) NOT NULL PRIMARY KEY,
	"effective_date" DATE NOT NULL
);

CREATE TABLE rates (
	"no" VARCHAR(20) NOT NULL,
	"currency" VARCHAR(50) NOT NULL,
	"code" CHAR(3) NOT NULL,
	"mid" DECIMAL(12, 10) NOT NULL,
	PRIMARY KEY("no", "code"),
	FOREIGN KEY("no") REFERENCES tables("no")
);

CREATE INDEX effective_date ON tables(effective_date);
