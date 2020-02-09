package hu.abcenterbt.nyilvantartascore.service;

import java.util.List;
import java.util.Optional;

import hu.abcenterbt.nyilvantartascore.repository.JogokRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartasapi.domain.Jogok;

@Service
public class JogokService {

    @Autowired
    private JogokRepositrory jogokRepositrory;

    public List<Jogok> getJogok() {
        return jogokRepositrory.findAll();
    }

    public Optional<Jogok> getJog(final Long id) {
        return jogokRepositrory.findById(id);
    }

    public Jogok saveJog(final Jogok jog) {
        return jogokRepositrory.save(jog);
    }

    public void deleteJog(final Long id) {
        jogokRepositrory.deleteById(id);
    }
}
