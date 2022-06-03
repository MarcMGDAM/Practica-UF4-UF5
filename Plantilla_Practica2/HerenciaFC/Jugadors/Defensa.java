package HerenciaFC.Jugadors;

import java.time.LocalDate;

import HerenciaFC.Tecnics.Tecnic;

public class Defensa extends Jugador {

    private int atacs_aturats;
    private static int incentiu_atacsAturats = 200;
    private int pilotes_recuperades;
    private static int incentiu_pilotesRecuperades = 20;
    private int souFinal;

    public Defensa(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int atacs_aturats,
            int pilotes_recuperades) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.atacs_aturats = atacs_aturats;
        this.pilotes_recuperades = pilotes_recuperades;
        calcularSouVariable();
    }

    @Override
    public void calcularSouVariable() {
        // TODO Auto-generated method stub

        souFinal = getSou_base() + (atacs_aturats * incentiu_atacsAturats)
                + (pilotes_recuperades + incentiu_pilotesRecuperades);

    }

    public Defensa() {

    }

    public Defensa altaDefensa() {

        Defensa d = new Defensa("40024887F", "Gerard ", "Piqué ", "Bernabeu ", LocalDate.parse("1987-02-02"), 664538990,
                "gerard@gmail.com", "GEPI9937814123", 25000, true, 98, 13);
        return d;

    }

    public int getSouFinal() {
        return souFinal;
    }

    public void setSouFinal(int souFinal) {
        this.souFinal = souFinal;
    }

}
