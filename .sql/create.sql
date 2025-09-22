
create table autos(
    id BIGINT auto_increment PRIMARY KEY,
    brand VARCHAR(20),
    color VARCHAR(20),
    category VARCHAR(20),
    n_doors INT
);

create table motos(
    id BIGINT auto_increment PRIMARY KEY,
    brand VARCHAR(20),
    color VARCHAR(20),
    category VARCHAR(20),
    speed INT
);
    
create table garage (
    id BIGINT auto_increment PRIMARY KEY,
    auto_id BIGINT,
    FOREIGN KEY (auto_id) REFERENCES autos(id),
    moto_id BIGINT,
    FOREIGN KEY (moto_id) REFERENCES motos(id)
);

ALTER TABLE autos
ADD COLUMN garage_id BIGINT,
ADD CONSTRAINT fk_auto_garage
FOREIGN KEY (garage_id) REFERENCES garage(id);

ALTER TABLE motos
ADD COLUMN garage_id BIGINT,
ADD CONSTRAINT fk_moto_garage
FOREIGN KEY (garage_id) REFERENCES garage(id);

ALTER TABLE garage DROP FOREIGN KEY garage_ibfk_1;
ALTER TABLE garage DROP FOREIGN KEY garage_ibfk_2;


ALTER TABLE garage
DROP COLUMN auto_id,
DROP COLUMN moto_id;


ALTER TABLE garage
ADD COLUMN name_garage VARCHAR(20);
