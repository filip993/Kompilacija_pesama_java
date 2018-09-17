package PesmaiKompilacija;

import java.lang.*;
import java.io.Serializable;

public class Pesma implements Serializable {
    private String imeIzvodjaca;
    private String nazivPesme;
    private int trajanje;

    public Pesma(String ime, String naziv, int trajanje) {
        this.imeIzvodjaca = ime;
        this.nazivPesme = naziv;
        this.trajanje = trajanje;
    }

    @Override
    public String toString() {
        return this.imeIzvodjaca + " - " + this.nazivPesme + " [" + this.trajanje + "].";
    }

}


