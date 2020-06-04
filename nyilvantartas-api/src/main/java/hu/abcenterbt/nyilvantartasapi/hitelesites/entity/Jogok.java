package hu.abcenterbt.nyilvantartasapi.hitelesites.entity;

import java.time.Instant;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "JOGOK")
@Access(value = AccessType.FIELD)
public class Jogok {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    @NotEmpty(message = "Hiányzó code paraméter")
    private String code;

    @NotNull
    @NotEmpty(message = "Hiányzó megnevezes paraméter")
    private String megnevezes;

    @Column(columnDefinition = "VARCHAR default 'A'")
    private String status;

    @Column
    private Long modositoId;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Instant modositas;

}

