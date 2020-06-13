package hu.abcenterbt.nyilvantartascore.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartasapi.hitelesites.dto.OperatorDTO;
import hu.abcenterbt.nyilvantartasapi.hitelesites.entity.Operator;
import hu.abcenterbt.nyilvantartascore.repository.OperatorRepository;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    /**
     * Visszaadja az összes Operátort.
     * @return Operátor lista.
     */
    public List<Operator> getOperatorok() {
        return operatorRepository.findAll();
    }

    /**
     * Visszaadja az ID által meghatározott Operátor-t.
     * @param id a kért operátos ID-ja.
     * @return Operátor objektum.
     */
    public Optional<Operator> getOperator(final Long id) {
        return operatorRepository.findById(id);
    }

    /**
     * Visszaadja az username által meghatározott Operátor-t.
     * @param username a kért operátos username-ja.
     * @return Operátor objektum.
     */
    public Optional<Operator> getOperatorUserName(final String username) {
        return operatorRepository.findByUsername(username);
    }

    /**
     * Menti a paraméterben megadott Operátort.
     * @param operatorDTO mentendő operátor.
     * @return mentett Operátor objektum.
     */
    public Operator saveOperator(final OperatorDTO operatorDTO) {
        final Operator operator = new Operator();
        BeanUtils.copyProperties(operatorDTO, operator);
        operator.setModositoId(1L);
        operator.setModositas(Instant.now());
        return operatorRepository.save(operator);
    }

    /**
     * Visszaadja a username és a password által meghatározott operátort.
     * @param username a belépő felhasználó username.
     * @param password abelépő felhasználó jelszava.
     * @return a feltételnek megfelelő Operátor objektum.
     */
    public Operator loginOperator(final String username, final String password) {
        return operatorRepository.findByUsernameAndPassword(username, password);
    }

}
