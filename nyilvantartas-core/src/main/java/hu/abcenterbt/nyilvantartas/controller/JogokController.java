package hu.abcenterbt.nyilvantartas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartas.domain.Jogok;
import hu.abcenterbt.nyilvantartas.operator.JogokClientIF;
import hu.abcenterbt.nyilvantartas.service.JogokService;

@RestController
public class JogokController implements JogokClientIF {

    @Autowired
    private JogokService jogokService;

    @GetMapping("/jog")
    public List<Jogok> getJogok() {
        return jogokService.getJogok();
    }

    @PostMapping("/jog")
    public Jogok saveJog(@RequestBody final Jogok jog) {
        return jogokService.saveJog(jog);
    }
}
