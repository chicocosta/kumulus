FROM postgres
LABEL Author="Chico Costa"
COPY ./init.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
VOLUME create pg_data