package hu.abcenterbt.nyilvantartas.service;

import hu.abcenterbt.nyilvantartas.domain.Teszt;
import hu.abcenterbt.nyilvantartas.repository.TesztRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesztService {

    @Autowired
    private TesztRepository tesztRepository;

    public List<Teszt> getTeszt() {
        List<Teszt> a = tesztRepository.findAll();
        return a;
    }
}
