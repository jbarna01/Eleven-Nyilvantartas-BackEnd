package hu.abcenterbt.nyilvantartas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.abcenterbt.nyilvantartas.domain.Operatorok;
import hu.abcenterbt.nyilvantartas.repository.OperatorRepository;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    public Operatorok elsoOperator() {
        return operatorRepository.findFirstByOrderByVezetekNev();
    }

    public Optional<Operatorok> getOperator(final Long id) {
        return operatorRepository.findById(id);
    }

    public List<Operatorok> getOperatorok() {
        return operatorRepository.findAll();
    }

    public Operatorok ujOperator(final Operatorok operatorok) {
        return operatorRepository.save(operatorok);
    }

    public List<Operatorok> getOperatorVezeteknev(final String vezeteknev) {
        return operatorRepository.findByVezetekNev(vezeteknev);
    }

    public Operatorok updateOperator(final Operatorok operatorok) {
        return operatorRepository.save(operatorok);
    }

    public void deleteOperator(final Long id) {
        operatorRepository.deleteById(id);
    }
}
