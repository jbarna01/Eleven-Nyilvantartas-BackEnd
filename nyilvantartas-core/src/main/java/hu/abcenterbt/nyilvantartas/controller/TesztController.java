package hu.abcenterbt.nyilvantartas.controller;


import hu.abcenterbt.nyilvantartas.domain.Teszt;
import hu.abcenterbt.nyilvantartas.operator.TesztIF;
import hu.abcenterbt.nyilvantartas.service.TesztService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TesztController implements TesztIF {

    @Autowired
    private TesztService tesztService;

    @CrossOrigin
    @GetMapping("/teszt")
    public List<Teszt> getTeszt() {
        return tesztService.getTeszt();
    }
}
