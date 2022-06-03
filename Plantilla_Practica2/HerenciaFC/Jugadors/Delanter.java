package HerenciaFC.Jugadors;

import java.time.LocalDate;

public class Delanter extends Jugador {

    private int gols_marcats;
    private static int incentiu_golsMarcats = 250;
    private int pilotes_Recuperades;
    private static int incentiu_pilotesRecuperades = 35;
    private int souFinal;

    public Delanter(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int gols_marcats,
            int pilotes_Recuperades) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.gols_marcats = gols_marcats;
        this.pilotes_Recuperades = pilotes_Recuperades;
        calcularSouVariable();
    }

    @Override
    public void calcularSouVariable() {
        // TODO Auto-generated method stub

        souFinal = getSou_base() + (gols_marcats * incentiu_golsMarcats)
                + (pilotes_Recuperades + incentiu_pilotesRecuperades);

    }

    public Delanter() {

    }

    public Delanter altaDelanter() {

        Delanter d = new Delanter("32980015H", "Cristiano", "Ronaldo", "Aveiro", LocalDate.parse("1985-02-05"),
                633789275, "luigi@gmail.com", "BICH4047814111", 90000, true, 877, 9);
        return d;

    }

    public int getSouFinal() {
        return souFinal;
    }

    public void setSouFinal(int souFinal) {
        this.souFinal = souFinal;
    }

}
