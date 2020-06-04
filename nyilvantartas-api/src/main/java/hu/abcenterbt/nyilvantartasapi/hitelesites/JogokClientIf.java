package hu.abcenterbt.nyilvantartasapi.hitelesites;

import java.util.List;

import hu.abcenterbt.nyilvantartasapi.hitelesites.dto.JogokDTO;
import hu.abcenterbt.nyilvantartasapi.hitelesites.entity.Jogok;
import hu.abcenterbt.nyilvantartasapi.response.Result;

public interface JogokClientIf {

    Result<List<Jogok>> getJogok();

    Result<Jogok> getJog(Long id);

    Result<Jogok> saveJog(JogokDTO jog);

    Result deleteJog(Long id);
}
