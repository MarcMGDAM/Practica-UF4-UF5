package HerenciaFC.Jugadors;

import java.time.LocalDate;
import java.util.Scanner;

import HerenciaFC.Plantilla;

public class Delanter extends Jugador {

    private int gols_marcats;
    private static int incentiu_golsMarcats = 100;
    private int pilotes_Recuperades;
    private static int incentiu_pilotesRecuperades = 100;

    public Delanter(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int gols_marcats,
            int pilotes_Recuperades) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.gols_marcats = gols_marcats;
        this.pilotes_Recuperades = pilotes_Recuperades;
        calcularSouVariable();
    }

    @Override
    public int calcularSouVariable() {

        setSouFinal(getSou_base() + (gols_marcats * incentiu_golsMarcats)
        + (pilotes_Recuperades + incentiu_pilotesRecuperades));
        
        return getSouFinal();

    }

    public Delanter() {

    }    

    public int getGols_marcats() {
        return gols_marcats;
    }

    public void setGols_marcats(int gols_marcats) {
        this.gols_marcats = gols_marcats;
    }

    public int getPilotes_Recuperades() {
        return pilotes_Recuperades;
    }

    public void setPilotes_Recuperades(int pilotes_Recuperades) {
        this.pilotes_Recuperades = pilotes_Recuperades;
    }

    public Delanter altaDelanter() {

        Delanter d = new Delanter("32980015H", "Cristiano", "Ronaldo", "Aveiro", LocalDate.parse("1985-02-05"),
                633789275, "luigi@gmail.com", "BICH4047814111", 90, true, 87, 2);
        System.out.println("Delanter afegit correctament");
        return d;

    }

    @Override
    public Plantilla modificarPlantilla() {
        Scanner teclat = new Scanner(System.in);

        modificarDadesPersona();
        System.out.println("Introdueix la nou numero de pilotes recuperades del Delanter");
        String PilotesRecuperades = teclat.nextLine();
        if (!PilotesRecuperades.isEmpty()) {
            setPilotes_Recuperades(Integer.parseInt(PilotesRecuperades));
        }
        System.out.println("Introdueix la nou numero de gols marcats del Delanter");
        String GolsMarcats = teclat.nextLine();
        if (!GolsMarcats.isEmpty()) {
            setGols_marcats(Integer.parseInt(GolsMarcats));
        }

        System.out.println("Dades del Delanter modificat correctament");

        return this;
    }

}
