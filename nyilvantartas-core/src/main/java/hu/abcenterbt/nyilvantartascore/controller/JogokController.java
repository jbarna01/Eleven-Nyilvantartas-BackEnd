package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartasapi.domain.Jogok;
import hu.abcenterbt.nyilvantartasapi.operator.JogokClientIf;
import hu.abcenterbt.nyilvantartascore.service.JogokService;

@RestController
@RequestMapping("jog")
public class JogokController implements JogokClientIf {

    @Autowired
    private JogokService jogokService;

    /**
     * Visszaadja az összes jogot.
     * @return Jogok lista.
     */
    @CrossOrigin
    @GetMapping("/jogok")
    public List<Jogok> getJogok() {
        return jogokService.getJogok();
    }

    /**
     * Visszaadja az ID által meghatározott jogot.
     * @param id a kereset jog ID-ja.
     * @return Jog objektum.
     */
    @CrossOrigin
    @GetMapping("/")
    public Optional<Jogok> getJog(@RequestParam(value = "id") final Long id) {
        return jogokService.getJog(id);
    }

    /**
     * Menti a paraméterben megadott Jog objektumot.
     * @param jog mentendő objektum.
     * @return Mentett JOG objektum.
     */
    @PostMapping("/")
    public Jogok saveJog(@RequestBody final Jogok jog) {
        return jogokService.saveJog(jog);
    }

    /**
     * Törli az ID-val meghatározott jog rekordot.
     * @param id a törlendő rekord ID-ja.
     */
    @DeleteMapping("/")
    public void deleteJog(@PathVariable(value = "id") final Long id) {
        jogokService.deleteJog(id);
    }
}
