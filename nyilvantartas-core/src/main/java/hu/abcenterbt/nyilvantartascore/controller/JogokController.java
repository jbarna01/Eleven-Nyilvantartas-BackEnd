package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartasapi.domain.Jogok;
import hu.abcenterbt.nyilvantartasapi.operator.JogokClientIF;
import hu.abcenterbt.nyilvantartascore.service.JogokService;

@RestController
public class JogokController implements JogokClientIF {

    @Autowired
    private JogokService jogokService;

    @CrossOrigin
    @GetMapping("/jog")
    public List<Jogok> getJogok() {
        return jogokService.getJogok();
    }

    @CrossOrigin
    @GetMapping("/jog/{id}")
    public Optional<Jogok> getJog(@RequestParam(value = "id") final Long id) {
        return jogokService.getJog(id);
    }

    @PostMapping("/jog")
    public Jogok saveJog(@RequestBody final Jogok jog) {
        return jogokService.saveJog(jog);
    }

    @DeleteMapping("/jog/{id}")
    public void deleteJog(@RequestParam(value = "id") final Long id) {
        jogokService.deleteJog(id);
    }
}
