package hu.abcenterbt.nyilvantartas.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "JOGOK")
@Access(value = AccessType.FIELD)
public class Jogok {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String megnevezes;

    public Jogok() {
    }

    public Jogok(@NotNull final String code, @NotNull final String megnevezes) {
        this.code = code;
        this.megnevezes = megnevezes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

}

