package hu.abcenterbt.nyilvantartas.service;

import java.util.List;
import java.util.Optional;

import hu.abcenterbt.nyilvantartas.domain.Jogok;
import hu.abcenterbt.nyilvantartas.repository.JogokRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartas.domain.Operator;
import hu.abcenterbt.nyilvantartas.repository.OperatorRepository;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private JogokRepositrory jogokRepositrory;

    public Operator elsoOperator() {
        return operatorRepository.findFirstByOrderByVezetekNev();
    }

    public Optional<Operator> getOperator(final Long id) {
        return operatorRepository.findById(id);
    }

    public List<Operator> getOperatorok() {
        return operatorRepository.findAll();
    }

    public Operator ujOperator(final Operator operator) {
        return operatorRepository.save(operator);
    }

    public List<Operator> getOperatorVezeteknev(final String vezeteknev) {
        return operatorRepository.findByVezetekNev(vezeteknev);
    }

    public Operator updateOperator(final Operator operator) {
        return operatorRepository.save(operator);
    }

    public void deleteOperator(final Long id) {
        operatorRepository.deleteById(id);
    }

    public Operator addJogOperator(Long operatorId, Long jogId) {
        Optional<Operator> operator = operatorRepository.findById(operatorId);
        Optional<Jogok> jogok = jogokRepositrory.findById(jogId);

        return null;
    }
}
