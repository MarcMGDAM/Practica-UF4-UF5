package HerenciaFC;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class Soci extends Persona implements Serializable {

    private static int totalsocis;
    private static int localitat;
    private int numeroLocalitat = 500;
    private int quotaAnual;
    private int idSocis;

    public Soci(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon, String email,
            int quotaAnual) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.quotaAnual = quotaAnual;
        // idSocis no ho passem a parametre ja que creara el numero automaticament sense
        // fer-ho manualment jo
        this.idSocis = ++totalsocis;
        this.numeroLocalitat = localitat++;
    }

    public Soci() {

    }

    private Scanner teclat = new Scanner(System.in);

    // @Override
    // public String toString() {
    // return nom + " [quotaAnual=" + quotaAnual + "]";
    // }

    // Metode que recorrer el HashMap de socis
    private void recorrerColecio(HashMap socis) {

        Iterator it = socis.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Soci> entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    public void altaSocis(HashMap socis) {

        socis.put("12345678L", new Soci("12345678L", "Joel", "Abstral", "Carvales", LocalDate.parse("1987-10-22"),
                678898123, "joel@gmail.com", 987));
        socis.put("23456789P", new Soci("23456789P", "Marc", "Martin", "Guerra", LocalDate.parse("2003-11-14"),
                654898111, "marc@gmail.com", 1000));
        socis.put("87692347K", new Soci("87692347K", "Pol", "Segura", "Abidal", LocalDate.parse("1999-02-09"),
                664575298, "pol@gmail.com", 1123));
        socis.put("78495672M", new Soci("78495672M", "Paula", "Serra", "Condal", LocalDate.parse("2010-09-11"),
                664279434, "paula@gmail.com", 1893));
        socis.put("87047290Q", new Soci("87047290Q", "Judit", "Porta", "Sarrias", LocalDate.parse("1983-03-28"),
                644302001, "judit@gmail.com", 756));

    }

    public void modificarSoci(HashMap socis) {

    }

    public void baixarSocis(HashMap socis) {

        recorrerColecio(socis);
        System.out.println("Introdueix el dni del soci que vol eliminar");
        String clau_soci = teclat.next();
        if (socis.containsKey(clau_soci)) {
            socis.remove(clau_soci);
            System.out.println("Soci eliminat correctament");
        } else {
            System.out.println("DNI malament introduit o no existeix");
        }

    }

    public void consultaNomCognom(HashMap socis) {

        // Collections.sort(socis, new Comparator<Soci>() {

        // @Override
        // public int compare(Soci o1, Soci o2) {
        // if ()
        // return 0;
        // }

        // });
        System.out.println("Socis sense ordenació");
        recorrerColecio(socis);
        TreeMap<String, Integer> ordenacio = new TreeMap<>();

        ordenacio.putAll(socis);

        System.out.println("Socis ordenats per nom i cognom");
        for (String key : ordenacio.keySet()) {
            System.out.println("Clau: " + key + ", Nom: " + ordenacio.get(key) + ", Cognom: " + ordenacio.get(key));
        }

    }

    public int getQuotaAnual() {
        return quotaAnual;
    }

    public void setQuotaAnual(int quotaAnual) {
        this.quotaAnual = quotaAnual;
    }

    public static int getTotalsocis() {
        return totalsocis;
    }

    public static void setTotalsocis(int totalsocis) {
        Soci.totalsocis = totalsocis;
    }

}
