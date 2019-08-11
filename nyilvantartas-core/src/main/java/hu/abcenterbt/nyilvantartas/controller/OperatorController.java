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

import hu.abcenterbt.nyilvantartas.domain.Operatorok;
import hu.abcenterbt.nyilvantartas.operator.OperatorClientIF;
import hu.abcenterbt.nyilvantartas.service.OperatorService;

@RestController
public class OperatorController implements OperatorClientIF {

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/operator")
    public Operatorok elsoOperator() {
        return operatorService.elsoOperator();
    }

    @GetMapping("/operator/{id}")
    public Optional<Operatorok> getOperator(@PathVariable(value = "id") final Long id) {
        return operatorService.getOperator(id);
    }

    @GetMapping("/operatorok")
    public List<Operatorok> getOperatorok() {
        return operatorService.getOperatorok();
    }

    @PostMapping("/operator")
    public Operatorok saveOperator(@RequestBody final Operatorok operatorok) {
        return operatorService.ujOperator(operatorok);
    }

    @GetMapping("/vezeteknev/{vezeteknev}")
    public List<Operatorok> getOperatorByVezeteknev(@PathVariable(value = "vezeteknev") final String vezeteknev) {
        return operatorService.getOperatorVezeteknev(vezeteknev);
    }

    @PutMapping("/operator")
    public Operatorok updateOperator(@RequestBody final Operatorok operatorok) {
        return operatorService.updateOperator(operatorok);
    }

    @DeleteMapping("/operator/{id}")
    public void deleteOperator(@PathVariable(value = "id") final Long id) {
        operatorService.deleteOperator(id);
    }
}
