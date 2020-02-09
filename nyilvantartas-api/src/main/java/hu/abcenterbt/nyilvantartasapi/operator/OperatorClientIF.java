package hu.abcenterbt.nyilvantartasapi.operator;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import hu.abcenterbt.nyilvantartasapi.domain.Operator;

public interface OperatorClientIF {

    Optional<Operator> getOperator(Long id);

    Operator getOperatorUserName(String username);

    List<Operator> getOperatorok();

    Operator saveOperator(Operator operator);

    Operator updateOperator(Operator operator, Long id);

    void deleteOperator(Long id);

    Operator loginOperator(Map<String, String> params);

}
