package Program;

import PesmaiKompilacija.*;
import java.lang.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Program {
    public static void main(String[] args) {
        String putanjafajla = "kompilacija.bin";
        int opcija = 0;
        String ime;
        String naziv;
        int vreme;
        int br;
        Kompilacija k = new Kompilacija(20);
        do {
            System.out.println("\n---------------------");
            System.out.println("[MENI]: ");
            System.out.println("---------------------");
            System.out.println("1. Unesi pesmu");
            System.out.println("2. Obrisi pesmu");
            System.out.println("3. Sacuvaj kompilaciju");
            System.out.println("4. Izlistaj kompilaciju");
            System.out.println("5. Izlaz");
            System.out.println("-----------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Izaberite opciju(1-5): ");
            if (scanner.hasNextInt()) {
                opcija = scanner.nextInt();
            }
            switch (opcija) {
                case 1:
                    System.out.println("\nUnesite ime izvodjaca pesme: ");
                    ime = scanner.next();
                    System.out.println("Unesite naziv pesme");
                    naziv = scanner.next();
                    System.out.println("Unesite koliko pesma traje u sekundama: ");
                    vreme = scanner.nextInt();
                    Pesma p = new Pesma(ime, naziv, vreme);
                    k.dodajPesmu(p);
                    break;
                case 2:
                    System.out.println("\nUnesite redni broj pesme koju brisete: ");
                    br = scanner.nextInt();
                    k.ukloniPesmu(br);
                    break;
                case 3:
                    try {
                        FileOutputStream fos = new FileOutputStream(putanjafajla);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(k);
                        fos.close();
                        oos.close();
                    }
                    catch (IOException ex) {
                        System.err.println("IO Exception: " + ex);
                    }
                    break;
                case 4:
                    try {
                        File f = new File(putanjafajla);
                        if(f.exists() == false) {
                            System.out.println("Ne postoji kompilacija pesama. Sacuvajte je prvo!");
                            break;
                        }
                        FileInputStream fis = new FileInputStream(putanjafajla);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        k = (Kompilacija) ois.readObject();
                        System.out.println("\nIzlistana kompilacija: ");
                        k.ispisKompilacije();
                    }
                    catch (IOException ex) {
                        System.err.println("IO Exception: " + ex);
                    }
                    catch (ClassNotFoundException ex) {
                        System.err.println("Class not found: " + ex);
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    break;
            }
        }
        while (opcija < 5 || opcija > 0);
    }
}
