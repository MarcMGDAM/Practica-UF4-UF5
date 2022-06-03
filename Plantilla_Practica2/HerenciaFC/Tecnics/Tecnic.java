package HerenciaFC.Tecnics;

import java.time.LocalDate;

import HerenciaFC.Plantilla;

public abstract class Tecnic extends Plantilla{

    private int anys_exp;

    

    public Tecnic(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, int anys_exp) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base);
        this.anys_exp = anys_exp;
    }

    public Tecnic(){

    }

    public int getAnys_exp() {
        return anys_exp;
    }

    public void setAnys_exp(int anys_exp) {
        this.anys_exp = anys_exp;
    }

    
    
    
}
