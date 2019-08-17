package hu.abcenterbt.nyilvantartas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartas.domain.Jogok;
import hu.abcenterbt.nyilvantartas.domain.Operator;
import hu.abcenterbt.nyilvantartas.repository.JogokRepositrory;
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

    public List<Operator> getAdminOperatorok(final String code) {
        return operatorRepository.findAllByJogokCodeIgnoreCaseOrderByVezetekNev(code);
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

    public Operator addJogOperator(final Long operatorId, final Long jogId) {
        final Optional<Operator> operator = operatorRepository.findById(operatorId);
        final List<Jogok> jogLista = new ArrayList<>();
        jogLista.add(jogokRepositrory.findById(jogId).get());
        operator.get().setJogok(jogLista);
        return operatorRepository.save(operator.get());
    }
}
