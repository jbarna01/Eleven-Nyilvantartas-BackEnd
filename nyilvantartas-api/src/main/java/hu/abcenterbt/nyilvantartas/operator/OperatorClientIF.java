package hu.abcenterbt.nyilvantartas.operator;

import java.util.List;
import java.util.Optional;

import hu.abcenterbt.nyilvantartas.domain.Operatorok;

public interface OperatorClientIF {

    Operatorok elsoOperator();

    Optional<Operatorok> getOperator(Long id);

    List<Operatorok> getOperatorok();

    Operatorok saveOperator(Operatorok operatorok);

    List<Operatorok> getOperatorByVezeteknev(String vezeteknev);

    Operatorok updateOperator(Operatorok operatorok);

    void deleteOperator(Long id);

}
