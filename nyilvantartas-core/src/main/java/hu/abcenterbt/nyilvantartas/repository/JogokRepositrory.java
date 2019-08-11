package hu.abcenterbt.nyilvantartas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.abcenterbt.nyilvantartas.domain.Jogok;

public interface JogokRepositrory extends JpaRepository<Jogok, Long> {

    List<Jogok> findAll();

    Jogok save(Jogok jog);

}
