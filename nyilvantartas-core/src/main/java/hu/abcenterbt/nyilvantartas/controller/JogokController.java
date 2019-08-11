package hu.abcenterbt.nyilvantartas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartas.domain.Jogok;
import hu.abcenterbt.nyilvantartas.operator.JogokClientIF;
import hu.abcenterbt.nyilvantartas.service.JogokService;

@RestController
public class JogokController implements JogokClientIF {

    @Autowired
    private JogokService jogokService;

    @GetMapping("/jogok")
    public List<Jogok> getJogok() {
        return jogokService.getJogok();
    }

    @PostMapping("/jog")
    public Jogok saveJog(@RequestBody final Jogok jog) {
        return jogokService.saveJog(jog);
    }

    @PutMapping("/jog")
    public Jogok updateJog(@RequestBody final Jogok jog) {
        return jogokService.updateJog(jog);
    }

    @DeleteMapping("/jog/{id}")
    public void deleteJog(@PathVariable(value = "id") final Long id) {
        jogokService.deleteJog(id);
    }
}
