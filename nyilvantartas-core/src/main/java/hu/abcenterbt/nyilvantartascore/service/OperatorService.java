package hu.abcenterbt.nyilvantartascore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartasapi.domain.Operator;
import hu.abcenterbt.nyilvantartascore.repository.OperatorRepository;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    /**
     * Visszaadja az összes Operátort.
     *
     * @return Operátor lista.
     */
    public List<Operator> getOperatorok() {
        return operatorRepository.findAll();
    }

    /**
     * Visszaadja az ID által meghatározott Operátor-t.
     *
     * @param id a kért operátos ID-ja.
     * @return Operátor objektum.
     */
    public Optional<Operator> getOperator(final Long id) {
        return operatorRepository.findById(id);
    }

    /**
     * Visszaadja az username által meghatározott Operátor-t.
     *
     * @param username a kért operátos username-ja.
     * @return Operátor objektum.
     */
    public Operator getOperatorUserName(final String username) {
        return operatorRepository.findByUsername(username);
    }

    /**
     * Menti a paraméterben megadott Operátort.
     *
     * @param operator mentendő operátor.
     * @return mentett Operátor objektum.
     */
    public Operator ujOperator(final Operator operator) {
        return operatorRepository.save(operator);
    }

    /**
     * Módosítja az ID által meghatározott Operátort.
     *
     * @param operator új operátor objektum
     * @param id       módosítandó operátor Id-ja.
     * @return módosított Operátor objektum.
     */
    public Operator updateOperator(final Operator operator, final Long id) {
        final Operator oper = operatorRepository.findById(id)
                .map(updateOperator -> {
                    updateOperator = operator;
                    return operatorRepository.save(updateOperator);
                })
                .orElseGet(() -> {
                    operator.setId(id);
                    return operatorRepository.save(operator);
                });
        return oper;
    }

    /**
     * Törli az ID által meghatározott Operátort.
     *
     * @param id Törölni kívánt operárátor ID-ja.
     */
    public void deleteOperator(final Long id) {
        operatorRepository.deleteById(id);
    }

    /**
     * Visszaadja a username és a password által meghatározott operátort.
     *
     * @param username a belépő felhasználó username.
     * @param password abelépő felhasználó jelszava.
     * @return a feltételnek megfelelő Operátor objektum.
     */
    public Operator loginOperator(final String username, final String password) {
        return operatorRepository.findByUsernameAndPassword(username, password);
    }

}
