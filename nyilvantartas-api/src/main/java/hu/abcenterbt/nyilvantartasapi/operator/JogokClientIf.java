package hu.abcenterbt.nyilvantartasapi.operator;

import java.util.List;
import java.util.Optional;

import hu.abcenterbt.nyilvantartasapi.domain.Jogok;

public interface JogokClientIf {

    List<Jogok> getJogok();

    Optional<Jogok> getJog(Long id);

    Jogok saveJog(Jogok jog);

    void deleteJog(Long id);
}
