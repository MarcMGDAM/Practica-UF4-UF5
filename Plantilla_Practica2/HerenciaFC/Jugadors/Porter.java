package HerenciaFC.Jugadors;

import java.time.LocalDate;

import HerenciaFC.Plantilla;

public class Porter extends Jugador {

    private int gols_aturats;
    private int gols_rebuts;
    private int souFinal;
    private static int incentiu = 500;
    
    

    public Porter(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int gols_aturats,
            int gols_rebuts) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.gols_aturats = gols_aturats;
        this.gols_rebuts = gols_rebuts;
        calcularSouVariable();
    }

    @Override
    public void calcularSouVariable() {
        // TODO Auto-generated method stub
        
        souFinal = getSou_base() + (gols_aturats * incentiu);
    }

    public Porter(){

    }

    public Porter altaPorter(){

        Porter p = new Porter("98372300B", "Gianluigi", "Buffon", "Winner", LocalDate.parse("1982-10-11"), 633789275, "luigi@gmail.com", "MESI9937814812", 50000, true, 327, 103);
        return p;

    }

    

}
