package hu.abcenterbt.nyilvantartas.operator;

import hu.abcenterbt.nyilvantartas.domain.Operator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface OperatorClientIF {

    public Operator operator();

    public List<Operator> addOperator(Operator operator);

}
