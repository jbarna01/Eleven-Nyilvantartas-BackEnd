package hu.abcenterbt.nyilvantartascore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.abcenterbt.nyilvantartasapi.domain.Jogok;
import org.springframework.stereotype.Repository;

@Repository
public interface JogokRepositrory extends JpaRepository<Jogok, Long> {

    List<Jogok> findAll();

    Optional<Jogok> findById(Long id);

    Jogok save(Jogok jog);

    void deleteById(Long id);
}
