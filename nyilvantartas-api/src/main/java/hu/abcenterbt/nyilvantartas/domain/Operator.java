package hu.abcenterbt.nyilvantartas.domain;

public class Operator {

    private String vezetekNev;
    private String keresztNev;

    public Operator() {
    }

    public Operator(String vezetekNev, String keresztNev) {
        this.vezetekNev = vezetekNev;
        this.keresztNev = keresztNev;
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
}
