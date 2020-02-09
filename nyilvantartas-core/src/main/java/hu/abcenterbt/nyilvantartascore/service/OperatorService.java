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

    public List<Operator> getOperatorok() {
        return operatorRepository.findAll();
    }

    public Optional<Operator> getOperator(final Long id) {
        return operatorRepository.findById(id);
    }

    public Operator getOperatorUserName(final String username) {
        return operatorRepository.findByUsername(username);
    }

    public Operator ujOperator(final Operator operator) {
        return operatorRepository.save(operator);
    }

    public Operator updateOperator(final Operator operator, final Long id) {
        final Operator _operator = operatorRepository.findById(id)
                .map(updateOperator -> {
                    updateOperator = operator;
                    return operatorRepository.save(updateOperator);
                })
                .orElseGet(() -> {
                    operator.setId(id);
                    return operatorRepository.save(operator);
                });
        return _operator;
    }

    public void deleteOperator(final Long id) {
        operatorRepository.deleteById(id);
    }

    public Operator loginOperator(final String username, final String password) {
        return operatorRepository.findByUsernameAndPassword(username, password);
    }

}
