package hu.abcenterbt.nyilvantartas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartas.domain.Jogok;
import hu.abcenterbt.nyilvantartas.repository.JogokRepositrory;

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
