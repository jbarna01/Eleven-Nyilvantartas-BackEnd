package hu.abcenterbt.nyilvantartas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartas.domain.Operator;
import hu.abcenterbt.nyilvantartas.repository.JogokRepositrory;
import hu.abcenterbt.nyilvantartas.repository.OperatorRepository;

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

    public Operator ujOperator(final Operator operator) {
        return operatorRepository.save(operator);
    }

    public Operator updateOperator(final Operator operator, final Long id) {
        Operator _operator = operatorRepository.findById(id)
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

    public Operator loginOperator(final String username, String password) {
        return operatorRepository.findByUsernameAndPassword(username, password );
    }

}
