package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Jogok> getJog(@PathVariable(value = "id") final Long id) {
        return jogokService.getJog(id);
    }

    @PostMapping("/jog")
    public Jogok saveJog(@RequestBody final Jogok jog) {
        return jogokService.saveJog(jog);
    }

    @DeleteMapping("/jog/{id}")
    public void deleteJog(@PathVariable(value = "id") final Long id) {
        jogokService.deleteJog(id);
    }
}
