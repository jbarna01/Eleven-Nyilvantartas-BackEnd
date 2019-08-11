package hu.abcenterbt.nyilvantartas.domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @ManyToMany
    @JoinTable(name = "OperatorJogok", joinColumns = @JoinColumn(name = "jogokFk"),
            inverseJoinColumns = @JoinColumn(name = "operatorFk"))
    private List<Operator> operator;

    public Jogok() {
    }

    public Jogok(@NotNull final String code, @NotNull final String megnevezes) {
        this.code = code;
        this.megnevezes = megnevezes;
    }
}
