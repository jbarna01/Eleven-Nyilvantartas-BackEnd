BEGIN
    DECLARE @NY_VERZIO_ID BIGINT;
    DECLARE @OPERATOR_ID BIGINT;

    INSERT INTO nyt_verzio (SCRIPT_NEV) VALUES ('V0.1.0_006__BJ_alap_operator_beszurasa.sql');
    SET @NY_VERZIO_ID = @@IDENTITY;

    INSERT INTO operatorok (vezetek_nev, kereszt_nev, username, password, status, modosito_id, jogok_fk) VALUES ('Barna', 'József', 'barna', '111', 'A', 1, 1);
    SET @OPERATOR_ID = @@IDENTITY;
    INSERT INTO n_operatorok (id, vezetek_nev, kereszt_nev, username, password, status, modosito_id, jogok_fk, modositas, id_verzio, verzio_tipus)
        SELECT id, vezetek_nev, kereszt_nev, username, password, status, modosito_id, jogok_fk, modositas, @NY_VERZIO_ID, 0 from operatorok where id = @OPERATOR_ID;

END;
