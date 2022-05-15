package HerenciaFC.Tecnics;

import java.time.LocalDate;

import HerenciaFC.*;

public class Entrenador extends Plantilla{

    protected int num_trofeus;

    public Entrenador(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, int empleatsTotals, String num_seguretatSocial, int souBase, int num_trofeus) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, empleatsTotals, num_seguretatSocial, souBase);
        this.num_trofeus = num_trofeus;
    }

    

    

    

}
