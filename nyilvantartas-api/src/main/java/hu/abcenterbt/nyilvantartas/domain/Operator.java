package hu.abcenterbt.nyilvantartas.domain;

import java.time.Instant;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OPERATOR")
@Access(value = AccessType.FIELD)
public class Operator {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    private String vezetekNev;

    @NotNull
    private String keresztNev;

    @NotNull
    private String username;

    private String password;

    @Column(columnDefinition = "VARCHAR default 'A'")
    private String aktiv;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Instant modositas;

    @ManyToMany
    @JoinTable(name = "OperatorJogok", joinColumns = @JoinColumn(name = "operatorFk"),
    inverseJoinColumns = @JoinColumn(name = "jogokFk"))
    private List<Jogok> jogok;

}
