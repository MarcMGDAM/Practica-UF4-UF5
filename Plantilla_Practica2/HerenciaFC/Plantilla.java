package HerenciaFC;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plantilla extends Persona {

    protected int empleatsTotals;
    protected String num_seguretatSocial;
    protected int souBase;

    public Plantilla(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, int empleatsTotals, String num_seguretatSocial, int souBase) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.empleatsTotals = empleatsTotals;
        this.num_seguretatSocial = num_seguretatSocial;
        this.souBase = souBase;
    }

    ArrayList plantilla = new ArrayList<>();
    // for(Plantilla p:plantilla){
    // p.calcularSouVariable();
    // }

}