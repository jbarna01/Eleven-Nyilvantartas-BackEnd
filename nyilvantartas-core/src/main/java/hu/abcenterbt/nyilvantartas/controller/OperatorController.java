package hu.abcenterbt.nyilvantartas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartas.domain.Operator;
import hu.abcenterbt.nyilvantartas.operator.OperatorClientIF;
import hu.abcenterbt.nyilvantartas.service.OperatorService;

@RestController
public class OperatorController implements OperatorClientIF {

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/operator")
    public Operator elsoOperator() {
        return operatorService.elsoOperator();
    }

    @GetMapping("/operator/{id}")
    public Optional<Operator> getOperator(@PathVariable(value = "id") final Long id) {
        return operatorService.getOperator(id);
    }

    @GetMapping("/operatorok")
    public List<Operator> getOperatorok() {
        return operatorService.getOperatorok();
    }

    @PostMapping("/operator")
    public Operator saveOperator(@RequestBody final Operator operator) {
        return operatorService.ujOperator(operator);
    }

    @GetMapping("/vezeteknev/{vezeteknev}")
    public List<Operator> getOperatorByVezeteknev(@PathVariable(value = "vezeteknev") final String vezeteknev) {
        return operatorService.getOperatorVezeteknev(vezeteknev);
    }

    @PutMapping("/operator")
    public Operator updateOperator(@RequestBody final Operator operator) {
        return operatorService.updateOperator(operator);
    }

    @DeleteMapping("/operator/{id}")
    public void deleteOperator(@PathVariable(value = "id") final Long id) {
        operatorService.deleteOperator(id);
    }

//    @PutMapping
//    public Operator addJogOperator(@PathVariable(value = "operatorId") final Long operatorId, @PathVariable(value = "jogId") final Long jogId) {
//        return operatorService.addJogOperator(operatorId, jogId);
//    }
}
