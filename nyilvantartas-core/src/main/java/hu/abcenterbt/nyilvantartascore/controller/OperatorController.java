package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartasapi.hitelesites.OperatorClientIf;
import hu.abcenterbt.nyilvantartasapi.hitelesites.dto.OperatorDTO;
import hu.abcenterbt.nyilvantartasapi.hitelesites.entity.Operator;
import hu.abcenterbt.nyilvantartasapi.response.NyilvantartasError;
import hu.abcenterbt.nyilvantartasapi.response.Result;
import hu.abcenterbt.nyilvantartascore.service.OperatorService;

@RestController
@RequestMapping("operator")
public class OperatorController implements OperatorClientIf {

    @Autowired
    private OperatorService operatorService;

    /**
     * Visszaadja az összes Operátort.
     *
     * @return Operátor lista.
     */
    @CrossOrigin
    @GetMapping("/operatorok")
    public Result<List<Operator>> getOperatorok() {
        return new Result<>(operatorService.getOperatorok());
    }

    /**
     * Visszaadja az ID által meghatározott Operátor-t.
     *
     * @param id a kért operátos ID-ja.
     * @return Operátor objektum.
     */
    @CrossOrigin
    @GetMapping("/")
    public Result<Operator> getOperator(@RequestParam(value = "id") final Long id) {
        return operatorService.getOperator(id)
                .map(Result::new)
                .orElseGet(() -> Result.error(NyilvantartasError.ct201(Operator.class.getName(), id)));

    }

    /**
     * Visszaadja az username által meghatározott Operátor-t.
     * @param username a kért operátos username-ja.
     * @return Operátor objektum.
     */
    @CrossOrigin
    @GetMapping("/username")
    public Result<Operator> getOperatorUserName(@RequestParam(value = "username") final String username) {
        return operatorService.getOperatorUserName(username)
                .map(Result::new)
                .orElseGet(() -> Result.error(NyilvantartasError.ct201(Operator.class.getName(), "username", username)));
    }

    /**
     * Menti a paraméterben megadott Operátort.
     * @param operatorDTO mentendő operátor.
     * @return mentett Operátor objektum.
     */
    @CrossOrigin
    @PostMapping("/")
    public Result<Operator> saveOperator(@RequestBody final OperatorDTO operatorDTO) {
        return new Result<>(operatorService.saveOperator(operatorDTO));
    }

    /**
     * Visszaadja a username és a password által meghatározott operátort.
     *
     * @param username a belépő felhasználó username.
     * @param password abelépő felhasználó jelszava.
     * @return a feltételnek megfelelő Operátor objektum.
     */
    @CrossOrigin
    @GetMapping("/loginOperator")
    public Result<Operator> loginOperator(@RequestParam final String username, final String password) {
        return new Result<>(operatorService.loginOperator(username, password));
    }
}
