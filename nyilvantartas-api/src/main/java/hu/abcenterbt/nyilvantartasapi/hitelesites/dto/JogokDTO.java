package hu.abcenterbt.nyilvantartasapi.hitelesites.dto;

import java.time.Instant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogokDTO {

    private Long id;

    @NotNull
    @NotEmpty(message = "Hiányzó code paraméter")
    private String code;

    @NotNull
    @NotEmpty(message = "Hiányzó megnevezes paraméter")
    private String megnevezes;

    private String status;

    private Long modositoId;

    private Instant modositas;

}
