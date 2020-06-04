package hu.abcenterbt.nyilvantartasapi.hitelesites.entity;

import java.time.Instant;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Audited
@Table(name = "OPERATOROK")
@Access(value = AccessType.FIELD)
public class Operator {

    @Id
    @GeneratedValue
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

    @Column(columnDefinition = "VARCHAR default 'A'")
    private String status;

    @Column
    private Long modositoId;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Instant modositas;

    @ManyToOne
    @JoinColumn(name = "jogok_fk")
    private Jogok jogok;
}
