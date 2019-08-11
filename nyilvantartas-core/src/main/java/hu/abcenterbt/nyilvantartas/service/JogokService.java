package hu.abcenterbt.nyilvantartas.service;

import java.util.List;

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

    public Jogok saveJog(final Jogok jog) {
        return jogokRepositrory.save(jog);
    }

    public Jogok updateJog(final Jogok jog) {
        return jogokRepositrory.save(jog);
    }

    public void deleteJog(final Long id) {
        jogokRepositrory.deleteById(id);
    }
}
