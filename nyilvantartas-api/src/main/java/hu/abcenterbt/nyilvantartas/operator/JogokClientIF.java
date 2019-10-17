package hu.abcenterbt.nyilvantartas.operator;

import java.util.List;
import java.util.Optional;

import hu.abcenterbt.nyilvantartas.domain.Jogok;

public interface JogokClientIF {

    List<Jogok> getJogok();

    Optional<Jogok> getJog(Long id);

    Jogok saveJog(Jogok jog);

    void deleteJog(Long id);
}
