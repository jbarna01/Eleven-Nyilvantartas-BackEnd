CREATE TABLE jogok(
    id              bigint IDENTITY(1,1) NOT NULL,
    code            varchar(20)      NOT NULL,
    megnevezes      varchar(100)    NOT NULL,
    status          varchar(1)      NULL,
    modosito_id     bigint          NULL,
    modositas       datetime       NULL,
    CONSTRAINT pk_jogok PRIMARY KEY CLUSTERED
    (
        id ASC
    )
)
GO

ALTER TABLE jogok ADD  CONSTRAINT DF_jogok_date  DEFAULT (getdate()) FOR modositas
GO

CREATE TABLE n_jogok(
    id              bigint          NOT NULL,
    id_verzio       bigint          NOT NULL,
    verzio_tipus    int,
    code            varchar(20),
    megnevezes      varchar(100),
    status          varchar(1),
    modosito_id     bigint,
    modositas       datetime,
    CONSTRAINT pk_n_jogok PRIMARY KEY CLUSTERED
    (
        id_verzio, id
    )
)
GO
