package hu.abcenterbt.nyilvantartas.operator;

import java.util.List;
import java.util.Optional;

import hu.abcenterbt.nyilvantartas.domain.Operator;

public interface OperatorClientIF {

    Operator elsoOperator();

    Optional<Operator> getOperator(Long id);

    List<Operator> getOperatorok();

    List<Operator> getAdminOperatorok(String code);

    Operator saveOperator(Operator operator);

    List<Operator> getOperatorByVezeteknev(String vezeteknev);

    Operator updateOperator(Operator operator);

    void deleteOperator(Long id);

    Operator addJogOperator(Long operatorId, Long jogId);

}
