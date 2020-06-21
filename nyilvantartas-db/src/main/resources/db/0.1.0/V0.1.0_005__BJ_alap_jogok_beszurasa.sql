BEGIN
    DECLARE @NY_VERZIO_ID BIGINT;
    DECLARE @JOGOK_ID BIGINT;

    INSERT INTO nyt_verzio (SCRIPT_NEV) VALUES ('V0.1.0_005__BJ_alap_jogok_beszurasa.sql');
    SET @NY_VERZIO_ID = @@IDENTITY;

    INSERT INTO jogok (code, megnevezes, status, modosito_id) VALUES ('ADMIN', 'Rendszergazda', 'A', 1);
    SET @JOGOK_ID = @@IDENTITY;
    INSERT INTO n_jogok (id, code, megnevezes, status, modosito_id, modositas, id_verzio, verzio_tipus)
        SELECT id, code, megnevezes, status, modosito_id, modositas, @NY_VERZIO_ID, 0 from jogok where id = @JOGOK_ID;


    INSERT INTO jogok (code, megnevezes, status, modosito_id) VALUES ('SALES', 'Értékesítő', 'A', 1);
    SET @JOGOK_ID = @@IDENTITY;
    INSERT INTO n_jogok (id, code, megnevezes, status, modosito_id, modositas, id_verzio, verzio_tipus)
    SELECT id, code, megnevezes, status, modosito_id, modositas, @NY_VERZIO_ID, 0 from jogok where id = @JOGOK_ID;

    INSERT INTO jogok (code, megnevezes, status, modosito_id) VALUES ('OPER', 'Operátor', 'A', 1);
    SET @JOGOK_ID = @@IDENTITY;
    INSERT INTO n_jogok (id, code, megnevezes, status, modosito_id, modositas, id_verzio, verzio_tipus)
    SELECT id, code, megnevezes, status, modosito_id, modositas, @NY_VERZIO_ID, 0 from jogok where id = @JOGOK_ID;
END;
