package hu.abcenterbt.nyilvantartas.operator;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import hu.abcenterbt.nyilvantartas.domain.Operator;

public interface OperatorClientIF {

    Optional<Operator> getOperator(Long id);

    List<Operator> getOperatorok();

    Operator saveOperator(Operator operator);

    Operator updateOperator(Operator operator, Long id);

    void deleteOperator(Long id);

    Operator loginOperator(Map<String, String> params);

}
