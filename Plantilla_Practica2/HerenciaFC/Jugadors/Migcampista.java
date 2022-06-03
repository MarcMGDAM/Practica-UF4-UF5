package HerenciaFC.Jugadors;

import java.time.LocalDate;

public class Migcampista extends Jugador {

    private int assistencies_gol;
    private int pilotes_recuperades;
    private int souFinal;
    private static int incentiu_assitenciagols = 150;
    private static int incentiu_pilotesrecuperades = 100;

    public Migcampista(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int assistencies_gol,
            int pilotes_recuperades) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.assistencies_gol = assistencies_gol;
        this.pilotes_recuperades = pilotes_recuperades;
        calcularSouVariable();
    }

    @Override
    public void calcularSouVariable() {
        // TODO Auto-generated method stub

        souFinal = getSou_base() + (assistencies_gol * incentiu_assitenciagols)
                + (pilotes_recuperades + incentiu_pilotesrecuperades);

    }

    public Migcampista() {

    }

    public Migcampista altaMigcampista() {

        Migcampista m = new Migcampista("11372054T", "Pedro ", "González ", "López", LocalDate.parse("2002-11-25"),
                64209007, "pedro@gmail.com", "GUYI9672814070", 30000, true, 129, 32);
        return m;

    }

    public int getSouFinal() {
        return souFinal;
    }

    public void setSouFinal(int souFinal) {
        this.souFinal = souFinal;
    }

}
