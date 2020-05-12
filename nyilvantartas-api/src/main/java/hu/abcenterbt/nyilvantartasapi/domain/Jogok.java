package hu.abcenterbt.nyilvantartasapi.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Audited
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
}

