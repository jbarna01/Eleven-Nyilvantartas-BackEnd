package hu.abcenterbt.nyilvantartas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.abcenterbt.nyilvantartas.domain.Operatorok;

public interface OperatorRepository extends JpaRepository<Operatorok, Long> {

    Optional<Operatorok> findById(Long id);

    Operatorok findFirstByOrderByVezetekNev();

    List<Operatorok> findAll();

    Operatorok save(Operatorok operatorok);

    List<Operatorok> findByVezetekNev(String vezeteknev);

    void deleteById(Long id);
}
