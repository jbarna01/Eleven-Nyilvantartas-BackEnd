BEGIN
    DECLARE @NY_VERZIO_ID BIGINT;
    DECLARE @JOGOK_ID BIGINT;

    INSERT INTO nyt_verzio (SCRIPT_NEV) VALUES ('V0.1.0_005__BJ_alap_jogok_beszurasa.sql');
    SET @NY_VERZIO_ID = @@IDENTITY;

    INSERT INTO jogok (code, megnevezes) VALUES ('ADMIN', 'Rendszergazda');
    SET @JOGOK_ID = @@IDENTITY;
    INSERT INTO n_jogok (id, code, megnevezes, status, modositas, id_verzio, verzio_tipus)
        SELECT id, code, megnevezes, status, modositas, @NY_VERZIO_ID, 0 from jogok where id = @JOGOK_ID;


    INSERT INTO jogok (code, megnevezes) VALUES ('SALES', 'Értékesítő');
    SET @JOGOK_ID = @@IDENTITY;
    INSERT INTO n_jogok (id, code, megnevezes, status, modositas, id_verzio, verzio_tipus)
    SELECT id, code, megnevezes, status, modositas, @NY_VERZIO_ID, 0 from jogok where id = @JOGOK_ID;

    INSERT INTO jogok (code, megnevezes) VALUES ('OPER', 'Operátor');
    SET @JOGOK_ID = @@IDENTITY;
    INSERT INTO n_jogok (id, code, megnevezes, status, modositas, id_verzio, verzio_tipus)
    SELECT id, code, megnevezes, status, modositas, @NY_VERZIO_ID, 0 from jogok where id = @JOGOK_ID;
END;
