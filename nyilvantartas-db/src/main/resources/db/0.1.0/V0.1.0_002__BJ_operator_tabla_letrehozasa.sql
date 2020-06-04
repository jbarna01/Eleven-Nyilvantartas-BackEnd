CREATE TABLE operatorok(
    id              bigint IDENTITY(1,1) NOT NULL,
    vezetek_nev     varchar(100)    NOT NULL,
    kereszt_nev     varchar(100)    NOT NULL,
    username        varchar(100)    NOT NULL,
    password        varchar(100)    NULL,
    status          varchar(1)      NULL,
    modosito_id     bigint          NULL,
    modositas       datetime       NULL,
    jogok_fk        bigint          NOT NULL,
    CONSTRAINT pk_operatorok PRIMARY KEY CLUSTERED
    (
        id ASC
    )
)
GO

ALTER TABLE operatorok ADD  CONSTRAINT DF_operatorok_date  DEFAULT (getdate()) FOR modositas
GO

CREATE TABLE n_operatorok(
   id               bigint          NOT NULL,
   id_verzio        bigint          NOT NULL,
   verzio_tipus     int,
   vezetek_nev      varchar(100),
   kereszt_nev      varchar(100),
   username         varchar(100),
   password         varchar(100),
   status           varchar(1),
   modosito_id      bigint,
   modositas        datetime,
   jogok_fk         bigint,
   CONSTRAINT pk_n_operatorok PRIMARY KEY CLUSTERED
    (
        id_verzio, id
    )
)
GO
