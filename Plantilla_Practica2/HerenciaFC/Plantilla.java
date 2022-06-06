package HerenciaFC;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import HerenciaFC.Tecnics.Entrenador;

public abstract class Plantilla extends Persona {

    private static int empleatsTotals;
    private int num_empleat;
    private String num_seguretatSocial;
    private int sou_base;
    private int souFinal;

    public Plantilla(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.num_seguretatSocial = num_seguretatSocial;
        this.sou_base = sou_base;
        this.num_empleat = ++empleatsTotals;
    }

    public Plantilla() {
    }

    

    @Override
    public String toString() {
        return super.toString() + ", SouFinal= " + getSouFinal() + " euros";
    }

    // Metode que recorrer el HashMap de socis
    private static void recorrerColecioPlantilla(HashMap plantilla) {

        Iterator it = plantilla.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Plantilla> entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    public static void baixaPlantilla(HashMap plantilla) {

        Scanner teclat = new Scanner(System.in);

        recorrerColecioPlantilla(plantilla);
        System.out.println("Introdueix el dni del membre de la plantilla que vol eliminar");
        String clau_soci = teclat.next();
        if (plantilla.containsKey(clau_soci)) {
            plantilla.remove(clau_soci);
            System.out.println("Membre de la Plantilla eliminat correctament");
        } else {
            System.out.println("DNI malament introduit o no existeix");
        }

    }

    public abstract Plantilla modificarPlantilla();

    public static void VisualitzarPlantilla(HashMap plantilla) {
        
        ArrayList<Plantilla> arrayPlantilla = new ArrayList<>();

        Iterator it = plantilla.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Plantilla> entry = (Map.Entry) it.next();
            // Per àssar de un HashMap a un ArrayList
            arrayPlantilla.add(entry.getValue());
        }
        
        arrayPlantilla.sort( new Comparator<Plantilla>() {
            
            @Override
            public int compare(Plantilla p1, Plantilla p2){

                // Fem getClass per identificar si es Entreandor, Defensa...
                // I el comparem amb els altres membres del HashMap de plantilla
                // M'ho ordenar alfabeticament per classes
                return p1.getClass().getSimpleName().compareToIgnoreCase(p2.getClass().getSimpleName());

            }
        });


        for (Plantilla i : arrayPlantilla) {
            System.out.println(i);
        }
    }

    public static void VisualitzarPlantillaSouIncentiu(HashMap plantilla) {
        
        ArrayList<Plantilla> arrayPlantilla = new ArrayList<>();

        Iterator it = plantilla.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Plantilla> entry = (Map.Entry) it.next();
            // Per àssar de un HashMap a un ArrayList
            arrayPlantilla.add(entry.getValue());
        }
        
        arrayPlantilla.sort( new Comparator<Plantilla>() {
            
            @Override
            public int compare(Plantilla p1, Plantilla p2){

                return p1.getSouFinal() - (p2.getSouFinal());

            }
        });


        for (Plantilla i : arrayPlantilla) {
            System.out.println(i);
        }
    }

    public abstract int calcularSouVariable();

    public int getSou_base() {
        return sou_base;
    }

    public void setSou_base(int sou_base) {
        this.sou_base = sou_base;
    }

    public static int getEmpleatsTotals() {
        return empleatsTotals;
    }

    public static void setEmpleatsTotals(int empleatsTotals) {
        Plantilla.empleatsTotals = empleatsTotals;
    }

    public int getSouFinal() {
        return souFinal;
    }

    public void setSouFinal(int souFinal) {
        this.souFinal = souFinal;
    }

    

}