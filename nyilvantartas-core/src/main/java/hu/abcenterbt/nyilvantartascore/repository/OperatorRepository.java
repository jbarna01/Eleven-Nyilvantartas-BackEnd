package hu.abcenterbt.nyilvantartascore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.abcenterbt.nyilvantartasapi.domain.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

    Optional<Operator> findById(Long id);

    List<Operator> findAll();

    Operator findByUsernameAndPassword(String username, String password);

    Operator findByUsername(String username);

    Operator save(Operator operator);

    void deleteById(Long id);
}
