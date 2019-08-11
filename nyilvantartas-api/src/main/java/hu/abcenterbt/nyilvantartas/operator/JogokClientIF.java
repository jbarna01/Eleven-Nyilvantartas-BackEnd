package hu.abcenterbt.nyilvantartas.operator;

import java.util.List;

import hu.abcenterbt.nyilvantartas.domain.Jogok;

public interface JogokClientIF {

    List<Jogok> getJogok();

    Jogok saveJog(Jogok jog);
}
