package hu.abcenterbt.nyilvantartas.controller.operator;

import hu.abcenterbt.nyilvantartas.domain.Operator;
import hu.abcenterbt.nyilvantartas.operator.OperatorClientIF;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OperatorController implements OperatorClientIF {

    @GetMapping("/operator")
    public Operator operator() {
        return new Operator("Barna","József");
    }

    @PostMapping
    public List<Operator> addOperator(Operator operator) {
        List<Operator> operatorok = new ArrayList<>();
        operatorok.add( new Operator("Barna","József"));
        operatorok.add( new Operator("Barna","Ákos"));
        return operatorok;
    }
}
