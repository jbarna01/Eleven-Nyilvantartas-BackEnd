package hu.abcenterbt.nyilvantartas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.abcenterbt.nyilvantartas.domain.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Long> {

    Optional<Operator> findById(Long id);

    Operator findFirstByOrderByVezetekNev();

    List<Operator> findAll();

    Operator save(Operator operator);

    List<Operator> findByVezetekNev(String vezeteknev);

    void deleteById(Long id);
}
