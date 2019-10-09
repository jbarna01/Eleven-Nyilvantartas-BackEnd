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

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @JsonBackReference
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

    public List<Operator> getOperator() {
        return operator;
    }

    public void setOperator(List<Operator> operator) {
        this.operator = operator;
    }
}
