DO $$
DECLARE
  p_jogok_id  INT;
BEGIN

    INSERT INTO NYT_VERZIO (ID, IDOPONT, SCRIPT_NEV) VALUES (nextval('seq_nyt_verzio'), CURRENT_TIMESTAMP, 'V0.1.0_006__BJ_Alap_operatorok_beszurasa.sql');

    SELECT ID INTO p_jogok_id FROM jogok WHERE CODE = 'ADMIN';
    INSERT INTO operator (id, vezetek_nev, kereszt_nev, username, password, jogok_fk)
        VALUES (nextval('seq_operator'), 'Teszt', 'Admin', 'admin', 'admin', p_jogok_id);
    INSERT INTO n_operator (id, vezetek_nev, kereszt_nev, username, password, jogok_fk, modositas, id_verzio, verzio_tipus)
        SELECT id, vezetek_nev, kereszt_nev, username, password, jogok_fk,  modositas, currval('seq_nyt_verzio'), 0 from operator where id = currval('seq_operator');

    SELECT ID INTO p_jogok_id FROM jogok WHERE CODE = 'OPER';

    INSERT INTO operator (id, vezetek_nev, kereszt_nev, username, password, jogok_fk)
        VALUES (nextval('seq_operator'), 'Teszt', 'Operátor', 'oper', 'oper', p_jogok_id);
    INSERT INTO n_operator (id, vezetek_nev, kereszt_nev, username, password, jogok_fk, modositas, id_verzio, verzio_tipus)
        SELECT id, vezetek_nev, kereszt_nev, username, password, jogok_fk, modositas, currval('seq_nyt_verzio'), 0 from operator where id = currval('seq_operator');

END $$;
