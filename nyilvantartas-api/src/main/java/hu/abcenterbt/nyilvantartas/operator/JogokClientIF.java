package hu.abcenterbt.nyilvantartas.operator;

import java.util.List;
import java.util.Optional;

import hu.abcenterbt.nyilvantartas.domain.Jogok;

public interface JogokClientIF {

    Optional<Jogok> getJog(Long id);

    List<Jogok> getJogok();

    Jogok saveJog(Jogok jog);

//    Jogok updateJog(Jogok jog);

    void deleteJog(Long id);
}
