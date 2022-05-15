package HerenciaFC;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Socis extends Persona{
    
    private static int totalsocis;
    private int numeroLocalitat = 500;
    private int quotaAnual;
    private int idSocis;

    


    public Socis(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon, String email, int quotaAnual) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.quotaAnual = quotaAnual;
        // idSocis no ho passem a parametre ja que creara el numero automaticament sense fer-ho manualment jo
        this.idSocis = ++totalsocis;
        this.numeroLocalitat = numeroLocalitat++;
    }

    public Socis(){

    }

    private Scanner teclat = new Scanner(System.in);

    

    @Override
    public String toString() {
        return nom + " [quotaAnual=" + quotaAnual + "]";
    }

    // Metode que recorrer el HashMap de socis
    private void recorrerColecio(HashMap socis){

        Iterator it = socis.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Socis> entry = (Map.Entry)it.next();
	        System.out.println(entry.getKey() + " = " + entry.getValue());
	    }

    }

    public void altaSocis(HashMap socis){

        socis.put("12345678L", new Socis("12345678L", "Joel", "Abstral", "Carvales", LocalDate.parse("1987-10-22"), 678898123, "joel@gmail.com", 987));
        socis.put("23456789P", new Socis("23456789P", "Marc", "Martin", "Guerra", LocalDate.parse("2003-11-14"), 654898111, "marc@gmail.com", 1000));
        socis.put("87692347K", new Socis("87692347K", "Pol", "Segura", "Abidal", LocalDate.parse("1999-02-09"), 664575298, "pol@gmail.com", 1123));
        socis.put("78495672M", new Socis("78495672M", "Paula", "Serra", "Condal", LocalDate.parse("2010-09-11"), 664279434, "paula@gmail.com", 1893));
        socis.put("87047290Q", new Socis("87047290Q", "Judit", "Porta", "Sarrias", LocalDate.parse("1983-03-28"), 644302001, "judit@gmail.com", 756));

    }

    public void baixarSocis(HashMap socis){

        recorrerColecio(socis);
        System.out.println("Introdueix el dni del soci que vol eliminar");
        String clau_soci = teclat.next();
        if (socis.containsKey(clau_soci)){
            socis.remove(clau_soci);
            System.out.println("Soci eliminat correctament");
        } else{
            System.out.println("DNI malament introduit o no existeix");
        }

    }

    
}
