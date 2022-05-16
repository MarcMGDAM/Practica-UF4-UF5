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

    
    public Plantilla(){

    }

    public Plantilla(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.num_seguretatSocial = num_seguretatSocial;
        this.sou_base = sou_base;
    }

    public abstract void calcularSouVariable();

    public int getSou_base() {
        return sou_base;
    }

    public void setSou_base(int sou_base) {
        this.sou_base = sou_base;
    }

    
    

}