package hu.abcenterbt.nyilvantartasapi.hitelesites.dto;

import java.time.Instant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import hu.abcenterbt.nyilvantartasapi.hitelesites.entity.Jogok;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperatorDTO {

    private Long id;

    @NotNull
    @NotEmpty(message = "Hiányzó vezetekNev paraméter")
    private String vezetekNev;

    @NotNull
    @NotEmpty(message = "Hiányzó keresztNev paraméter")
    private String keresztNev;

    @NotNull
    @NotEmpty(message = "Hiányzó username paraméter")
    private String username;

    private String password;

    private String status;

    private Long modositoId;

    private Instant modositas;

    private Jogok jogok;

}
