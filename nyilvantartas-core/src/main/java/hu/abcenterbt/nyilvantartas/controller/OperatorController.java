package hu.abcenterbt.nyilvantartas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hu.abcenterbt.nyilvantartas.domain.Operator;
import hu.abcenterbt.nyilvantartas.operator.OperatorClientIF;
import hu.abcenterbt.nyilvantartas.service.OperatorService;

@RestController
public class OperatorController implements OperatorClientIF {

    @Autowired
    private OperatorService operatorService;

    @CrossOrigin
    @GetMapping("/operator/{id}")
    public Optional<Operator> getOperator(@PathVariable(value = "id") final Long id) {
        return operatorService.getOperator(id);
    }

    @CrossOrigin
    @GetMapping("/operatorok")
    public List<Operator> getOperatorok() {
        return operatorService.getOperatorok();
    }

    @CrossOrigin
    @GetMapping("/adminOperatorok/{code}")
    public List<Operator> getAdminOperatorok(@PathVariable(value = "code") final String code) {
        return operatorService.getAdminOperatorok(code);
    }

    @CrossOrigin
    @GetMapping("/loginOperator/{username}/{password}")
    public Operator loginOperator(@PathVariable String username, @PathVariable String password) {
        return operatorService.loginOperator(username, password);
    }

    @CrossOrigin
    @PostMapping("/operator")
    public Operator saveOperator(@RequestBody final Operator operator) {
        return operatorService.ujOperator(operator);
    }

    @CrossOrigin
    @PutMapping("/operator/{id}")
    public Operator updateOperator(@RequestBody final Operator operator, @PathVariable Long id) {
        return operatorService.updateOperator(operator, id);
    }

    @CrossOrigin
    @DeleteMapping("/operator/{id}")
    public void deleteOperator(@PathVariable(value = "id") final Long id) {
        operatorService.deleteOperator(id);
    }

    @CrossOrigin
    @PostMapping("/addJogOperator")
    public Operator addJogOperator(@RequestParam(value = "operatorId") final Long operatorId, @RequestParam(value = "jogId") final Long jogId) {
        return operatorService.addJogOperator(operatorId, jogId);
    }
}
