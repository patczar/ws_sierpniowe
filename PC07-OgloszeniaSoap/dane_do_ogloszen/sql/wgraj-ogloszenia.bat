set PG_HOME=C:\Program Files\PostgreSQL\11
set Path=%Path%;%PG_HOME%\bin

psql -h localhost -p 5432 -d postgres -U postgres -f 0-admin.sql

psql -h localhost -p 5432 -d ogloszenia -U ogloszenia -f ogloszenia_postgresql.sql

pause
