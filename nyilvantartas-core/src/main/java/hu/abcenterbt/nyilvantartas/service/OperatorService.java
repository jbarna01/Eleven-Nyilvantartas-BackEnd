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

    public Optional<Operator> getOperator(final Long id) {
        return operatorRepository.findById(id);
    }

    public List<Operator> getOperatorok() {
        return operatorRepository.findAll();
    }

    public List<Operator> getAdminOperatorok(final String code) {
        return operatorRepository.findAllByJogokCodeIgnoreCaseOrderByVezetekNev(code);
    }

    public Operator loginOperator(final String username, String password) {
        return operatorRepository.findByUsernameAndPassword(username, password );
    }

    public Operator ujOperator(final Operator operator) {
        return operatorRepository.save(operator);
    }

    public Operator updateOperator(final Operator operator, final Long id) {
        Operator _operator = operatorRepository.findById(id)
                .map(updateOperator -> {
                    updateOperator.setPassword(operator.getPassword());
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

    public Operator addJogOperator(final Long operatorId, final Long jogId) {
        final Optional<Operator> operator = operatorRepository.findById(operatorId);
        final List<Jogok> jogLista = new ArrayList<>();
        jogLista.add(jogokRepositrory.findById(jogId).get());
//        operator.get().setJogok(jogLista);
        return operatorRepository.save(operator.get());
    }
}
