package hu.abcenterbt.nyilvantartascore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartasapi.domain.Jogok;
import hu.abcenterbt.nyilvantartascore.repository.JogokRepositrory;

@Service
public class JogokService {

    @Autowired
    private JogokRepositrory jogokRepositrory;

    /**
     * Visszaadja az összes jogot.
     *
     * @return Jogok lista.
     */
    public List<Jogok> getJogok() {
        return jogokRepositrory.findAll();
    }

    /**
     * Visszaadja az ID által meghatározott jogot.
     *
     * @param id a kereset jog ID-ja.
     * @return Jog objektum.
     */
    public Optional<Jogok> getJog(final Long id) {
        return jogokRepositrory.findById(id);
    }

    /**
     * Menti a paraméterben megadott Jog objektumot.
     *
     * @param jog mentendő objektum.
     * @return Mentett JOG objektum.
     */
    public Jogok saveJog(final Jogok jog) {
        return jogokRepositrory.save(jog);
    }

    /**
     * Törli az ID-val meghatározott jog rekordot.
     *
     * @param id a törlendő rekord ID-ja.
     */
    public void deleteJog(final Long id) {
        jogokRepositrory.deleteById(id);
    }
}
