package HerenciaFC.Jugadors;

import java.time.LocalDate;
import java.util.Scanner;

import HerenciaFC.Plantilla;
import HerenciaFC.Tecnics.Tecnic;

public class Defensa extends Jugador {

    private int atacs_aturats;
    private static int incentiu_atacsAturats = 100;
    private int pilotes_recuperades;
    private static int incentiu_pilotesRecuperades = 100;

    public Defensa(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int atacs_aturats,
            int pilotes_recuperades) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.atacs_aturats = atacs_aturats;
        this.pilotes_recuperades = pilotes_recuperades;
        calcularSouVariable();
    }

    @Override
    public int calcularSouVariable() {

        setSouFinal(getSou_base() + (atacs_aturats * incentiu_atacsAturats)
        + (pilotes_recuperades + incentiu_pilotesRecuperades));

        return getSouFinal();
    }

    public Defensa() {

    }

    public Defensa altaDefensa() {

        Defensa d = new Defensa("40024887F", "Gerard ", "Piqué ", "Bernabeu ", LocalDate.parse("1987-02-02"), 664538990,
                "gerard@gmail.com", "GEPI9937814123", 25, true, 18, 3);
        System.out.println("Defensa afegit correctament");
        return d;

    }

    public int getAtacs_aturats() {
        return atacs_aturats;
    }

    public void setAtacs_aturats(int atacs_aturats) {
        this.atacs_aturats = atacs_aturats;
    }

    public int getPilotes_recuperades() {
        return pilotes_recuperades;
    }

    public void setPilotes_recuperades(int pilotes_recuperades) {
        this.pilotes_recuperades = pilotes_recuperades;
    }

    @Override
    public Plantilla modificarPlantilla() {
        Scanner teclat = new Scanner(System.in);

        modificarDadesPersona();
        System.out.println("Introdueix la nou numero de atacts aturats del Defensa");
        String AtacsAturats = teclat.nextLine();
        if (!AtacsAturats.isEmpty()) {
            setAtacs_aturats(Integer.parseInt(AtacsAturats));
        }
        System.out.println("Introdueix la nou numero de pilotes recuperades del Defensa");
        String PilotesRecuperades = teclat.nextLine();
        if (!PilotesRecuperades.isEmpty()) {
            setPilotes_recuperades(Integer.parseInt(PilotesRecuperades));
        }
        System.out.println("Dades del defensa modificat correctament");

        return this;
    }

}
