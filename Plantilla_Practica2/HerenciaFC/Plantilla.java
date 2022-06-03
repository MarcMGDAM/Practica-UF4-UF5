package HerenciaFC;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import HerenciaFC.Tecnics.Entrenador;

public abstract class Plantilla extends Persona {

    private static int empleatsTotals;
    private int num_empleat;
    private String num_seguretatSocial;
    private int sou_base;
    // private int souVariable;

    public Plantilla(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.num_seguretatSocial = num_seguretatSocial;
        this.sou_base = sou_base;
        this.empleatsTotals = ++num_empleat;
    }

    public Plantilla() {
    }

    // Metode que recorrer el HashMap de socis
    private void recorrerColecioPlantilla(HashMap plantilla) {

        Iterator it = plantilla.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Plantilla> entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    public void VisualitzarPlantilla(HashMap plantilla) {
        recorrerColecioPlantilla(plantilla);
    }

    public abstract void calcularSouVariable();

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

}