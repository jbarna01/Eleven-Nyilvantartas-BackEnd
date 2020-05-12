
    INSERT INTO NYT_VERZIO (ID, IDOPONT, SCRIPT_NEV) VALUES (nextval('seq_nyt_verzio'), CURRENT_TIMESTAMP, 'V0.1.0_005__BJ_Alap_jogok_beszurasa.sql');

    INSERT INTO jogok (id, code, megnevezes)
        VALUES (nextval('seq_jogok'), 'ADMIN', 'Rendszergazda');
    INSERT INTO n_jogok (id, code, megnevezes, status, modositas, id_verzio, verzio_tipus)
        SELECT id, code, megnevezes, status, modositas, currval('seq_nyt_verzio'), 0 from jogok where id = currval('seq_jogok');

    INSERT INTO jogok (id, code, megnevezes)
    VALUES (nextval('seq_jogok'), 'OPER', 'Operátor');
    INSERT INTO n_jogok (id, code, megnevezes, status, modositas, id_verzio, verzio_tipus)
    SELECT id, code, megnevezes, status, modositas, currval('seq_nyt_verzio'), 0 from jogok where id = currval('seq_jogok');
