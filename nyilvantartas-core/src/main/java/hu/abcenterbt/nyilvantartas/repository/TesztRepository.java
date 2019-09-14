package hu.abcenterbt.nyilvantartas.repository;

import hu.abcenterbt.nyilvantartas.domain.Teszt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TesztRepository extends JpaRepository<Teszt, Long> {

    List<Teszt> findAll();
}
