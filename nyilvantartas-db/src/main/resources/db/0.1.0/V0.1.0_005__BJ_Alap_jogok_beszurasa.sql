
    INSERT INTO NYT_VERZIO (ID, IDOPONT, SCRIPT_NEV) VALUES (nextval('seq_nyt_verzio'), CURRENT_TIMESTAMP, 'V0.1.0_005__BJ_Alap_jogok_beszurasa.sql');

    INSERT INTO jog (id, code, megnevezes)
        VALUES (nextval('seq_jog'), 'ADMIN', 'Rendszergazda');
    INSERT INTO n_jog (id, code, megnevezes, status, modositas, id_verzio, verzio_tipus)
        SELECT id, code, megnevezes, status, modositas, currval('seq_nyt_verzio'), 0 from jog where id = currval('seq_jog');

    INSERT INTO jog (id, code, megnevezes)
    VALUES (nextval('seq_jog'), 'OPER', 'Operátor');
    INSERT INTO n_jog (id, code, megnevezes, status, modositas, id_verzio, verzio_tipus)
    SELECT id, code, megnevezes, status, modositas, currval('seq_nyt_verzio'), 0 from jog where id = currval('seq_jog');
