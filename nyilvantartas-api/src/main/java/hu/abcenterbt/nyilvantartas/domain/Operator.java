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
import javax.validation.constraints.NotNull;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVezetekNev() {
        return vezetekNev;
    }

    public void setVezetekNev(String vezetekNev) {
        this.vezetekNev = vezetekNev;
    }

    public String getKeresztNev() {
        return keresztNev;
    }

    public void setKeresztNev(String keresztNev) {
        this.keresztNev = keresztNev;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAktiv() {
        return aktiv;
    }

    public void setAktiv(String aktiv) {
        this.aktiv = aktiv;
    }

    public Instant getModositas() {
        return modositas;
    }

    public void setModositas(Instant modositas) {
        this.modositas = modositas;
    }

    public List<Jogok> getJogok() {
        return jogok;
    }

    public void setJogok(List<Jogok> jogok) {
        this.jogok = jogok;
    }
}
