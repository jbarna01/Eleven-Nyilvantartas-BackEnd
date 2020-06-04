CREATE TABLE nyt_verzio(
	id              bigint IDENTITY(1,1)    NOT NULL,
	idopont         datetime                NOT NULL,
	script_nev      varchar(255)            NOT NULL,
 CONSTRAINT pk_nyt_verzio PRIMARY KEY CLUSTERED
    (
        id ASC
    )
)
GO

ALTER TABLE nyt_verzio ADD  CONSTRAINT DF_nyt_verzio_date  DEFAULT (getdate()) FOR idopont
GO
