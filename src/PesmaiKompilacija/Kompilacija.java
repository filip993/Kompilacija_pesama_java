package PesmaiKompilacija;

import java.lang.*;
import java.util.*;
import java.io.Serializable;

public class Kompilacija implements Serializable {
    private ArrayList<Pesma> p;
    int i;

    public Kompilacija(int brPesama) {
        p = new ArrayList<>(brPesama);
    }

    public void dodajPesmu(Pesma p) {
        this.p.add(p);
    }

    public void ukloniPesmu(int b) {
        b=b-1;
        p.remove(b);
    }

    public void ispisKompilacije() {
        System.out.println("Kompilacija: \n");
        for(int i = 0; i < this.p.size(); i++) {
            int j = i+1;
            System.out.println(j + ". pesma: " + this.p.get(i));
        }
        if(this.p.size()==0) {
            System.out.println("Kompilacija je prazna.");
        }
    }

}
