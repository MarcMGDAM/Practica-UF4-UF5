package HerenciaFC.Jugadors;

import java.time.LocalDate;

import HerenciaFC.Plantilla;

public class Porter extends Plantilla {

    private int gols_aturats;
    private int gols_rebuts;
    private int souFinal;
    private static int incentiu = 5000;
    
    public Porter(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, int gols_aturats, int gols_rebuts) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base);
        this.gols_aturats = gols_aturats;
        this.gols_rebuts = gols_rebuts;
    }

    @Override
    public void calcularSouVariable() {
        // TODO Auto-generated method stub
        
        souFinal = getSou_base() + (gols_aturats * incentiu);
    }

    public Porter(){

    }

    public Porter altaPorter(){

        Porter p = new Porter("98372836M", "Pep", "Guardiola", "Hucha", LocalDate.parse("1971-10-23"), 633789275, "pep@gmail.com", "TASA1733114050", 20177, 25, 12);
        return p;

    }

    

}
