package hu.abcenterbt.nyilvantartasapi.domain;

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
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Audited
@Table(name = "OPERATOR")
@Access(value = AccessType.FIELD)
public class Operator {

    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "jog_id")
    private Jogok jogok;
}
