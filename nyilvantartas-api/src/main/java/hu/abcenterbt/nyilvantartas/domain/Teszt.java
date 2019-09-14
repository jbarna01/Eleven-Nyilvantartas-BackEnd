package hu.abcenterbt.nyilvantartas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TESZT")
@Access(value = AccessType.FIELD)
public class Teszt {

    @GeneratedValue
    @Id
    private Long Id;

    private String nev;

    private Long kor;
}
