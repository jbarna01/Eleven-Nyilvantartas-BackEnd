package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartasapi.hitelesites.JogokClientIf;
import hu.abcenterbt.nyilvantartasapi.hitelesites.dto.JogokDTO;
import hu.abcenterbt.nyilvantartasapi.hitelesites.entity.Jogok;
import hu.abcenterbt.nyilvantartasapi.response.NyilvantartasError;
import hu.abcenterbt.nyilvantartasapi.response.Result;
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
    public Result<List<Jogok>> getJogok() {
        return new Result<>(jogokService.getJogok());
    }

    /**
     * Visszaadja az ID által meghatározott jogot.
     * @param id a kereset jog ID-ja.
     * @return Jog objektum.
     */
    @CrossOrigin
    @GetMapping("/")
    public Result<Jogok> getJog(@RequestParam(value = "id") final Long id) {
        return jogokService.getJog(id)
                .map(Result::new)
                .orElseGet(() -> Result.error(NyilvantartasError.ct201(Jogok.class.getName(), id)));
    }

    /**
     * Menti a paraméterben megadott Jog objektumot.
     * @param jog mentendő objektum.
     * @return Mentett JOG objektum.
     */
    @PostMapping("/")
    public Result<Jogok> saveJog(@RequestBody @Valid final JogokDTO jog) {
        return new Result<>(jogokService.saveJog(jog));
    }

    /**
     * Törli az ID-val meghatározott jog rekordot.
     * @param id a törlendő rekord ID-ja.
     * @return Result
     */
    @DeleteMapping("/")
    public Result deleteJog(@RequestParam(value = "id") final Long id) {
        jogokService.deleteJog(id);
        return Result.ok();
    }
}
