package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartasapi.domain.Operator;
import hu.abcenterbt.nyilvantartasapi.operator.OperatorClientIf;
import hu.abcenterbt.nyilvantartascore.service.OperatorService;

@RestController
@RequestMapping("operator")
public class OperatorController implements OperatorClientIf {

    @Autowired
    private OperatorService operatorService;

    /**
     * Visszaadja az összes Operátort.
     * @return Operátor lista.
     */
    @CrossOrigin
    @GetMapping("/operatorok")
    public List<Operator> getOperatorok() {
        return operatorService.getOperatorok();
    }

    /**
     * Visszaadja az ID által meghatározott Operátor-t.
     * @param id a kért operátos ID-ja.
     * @return Operátor objektum.
     */
    @CrossOrigin
    @GetMapping("/")
    public Optional<Operator> getOperator(@RequestParam(value = "id") final Long id) {
        return operatorService.getOperator(id);
    }

    /**
     * Visszaadja az username által meghatározott Operátor-t.
     * @param username a kért operátos username-ja.
     * @return Operátor objektum.
     */
    @CrossOrigin
    @GetMapping("/username")
    public Operator getOperatorUserName(@RequestParam(value = "username") final String username) {
        return operatorService.getOperatorUserName(username);
    }

    /**
     * Menti a paraméterben megadott Operátort.
     * @param operator mentendő operátor.
     * @return mentett Operátor objektum.
     */
    @CrossOrigin
    @PostMapping("/operator")
    public Operator saveOperator(@RequestBody final Operator operator) {
        return operatorService.ujOperator(operator);
    }

    /**
     * Módosítja az ID által meghatározott Operátort.
     * @param operator új operátor objektum
     * @param id módosítandó operátor Id-ja.
     * @return módosított Operátor objektum.
     */
    @CrossOrigin
    @PutMapping("/")
    public Operator updateOperator(@RequestBody final Operator operator, @RequestParam final Long id) {
        return operatorService.updateOperator(operator, id);
    }

    /**
     * Törli az ID által meghatározott Operátort.
     * @param id Törölni kívánt operárátor ID-ja.
     */
    @CrossOrigin
    @DeleteMapping("/")
    public void deleteOperator(@RequestParam(value = "id") final Long id) {
        operatorService.deleteOperator(id);
    }

    /**
     * Visszaadja a username és a password által meghatározott operátort.
     * @param username a belépő felhasználó username.
     * @param password abelépő felhasználó jelszava.
     * @return a feltételnek megfelelő Operátor objektum.
     */
    @CrossOrigin
    @GetMapping("/loginOperator")
    public Operator loginOperator(@RequestParam (value = "username") final String username,
                                  @RequestParam (value = "password") final String password) {
        return operatorService.loginOperator(username, password);
    }
}
