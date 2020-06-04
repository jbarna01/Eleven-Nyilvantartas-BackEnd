package hu.abcenterbt.nyilvantartascore.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartasapi.hitelesites.dto.JogokDTO;
import hu.abcenterbt.nyilvantartasapi.hitelesites.entity.Jogok;
import hu.abcenterbt.nyilvantartascore.repository.JogokRepositrory;

@Service
public class JogokService {

    @Autowired
    private JogokRepositrory jogokRepository;

    /**
     * Visszaadja az összes jogot.
     * @return Jogok lista.
     */
    public List<Jogok> getJogok() {
        return jogokRepository.findAll();
    }

    /**
     * Visszaadja az ID által meghatározott jogot.
     * @param id a kereset jog ID-ja.
     * @return Jog objektum.
     */
    public Optional<Jogok> getJog(final Long id) {
        return jogokRepository.findById(id);
    }

    /**
     * Menti a paraméterben megadott Jog objektumot.
     * @param jogDTO mentendő objektum.
     * @return Mentett JOG objektum.
     */
    public Jogok saveJog(final JogokDTO jogDTO) {
        final Jogok jog = new Jogok();
        BeanUtils.copyProperties(jogDTO, jog);
        jog.setModositas(Instant.now());
        return jogokRepository.save(jog);
    }

    /**
     * Törli az ID-val meghatározott jog rekordot.
     *
     * @param id a törlendő rekord ID-ja.
     */
    public void deleteJog(final Long id) {
        jogokRepository.findById(id).ifPresent(deleteJog -> {
            deleteJog.setModositas(Instant.now());
            jogokRepository.save(deleteJog);
        });
        jogokRepository.deleteById(id);
    }
}
