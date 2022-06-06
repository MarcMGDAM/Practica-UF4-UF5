package HerenciaFC.Jugadors;

import java.time.LocalDate;
import java.util.Scanner;

import HerenciaFC.Plantilla;

public class Migcampista extends Jugador {

    private int assistencies_gol;
    private int pilotes_recuperades;
    private static int incentiu_assitenciagols = 10;
    private static int incentiu_pilotesrecuperades = 10;

    public Migcampista(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int assistencies_gol,
            int pilotes_recuperades) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.assistencies_gol = assistencies_gol;
        this.pilotes_recuperades = pilotes_recuperades;
        calcularSouVariable();
    }

    @Override
    public int calcularSouVariable() {

        setSouFinal(getSou_base() + (assistencies_gol * incentiu_assitenciagols)
        + (pilotes_recuperades + incentiu_pilotesrecuperades));

        return getSouFinal();
    }

    public Migcampista() {

    }

    public Migcampista altaMigcampista() {

        Migcampista m = new Migcampista("11372054T", "Pedro ", "González ", "López", LocalDate.parse("2002-11-25"),
                64209007, "pedro@gmail.com", "GUYI9672814070", 3, true, 12, 3);
        System.out.println("MigCampista afegit correctament");
        return m;

    }  

    public int getAssistencies_gol() {
        return assistencies_gol;
    }

    public void setAssistencies_gol(int assistencies_gol) {
        this.assistencies_gol = assistencies_gol;
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
        System.out.println("Introdueix la nou numero de gols Assistits del MigCampista");
        String AssistenciesGol = teclat.nextLine();
        if (!AssistenciesGol.isEmpty()) {
            setAssistencies_gol(Integer.parseInt(AssistenciesGol));
        }
        System.out.println("Introdueix la nou numero de pilotes recuperades del MigCampista");
        String PilotesRecuperades = teclat.nextLine();
        if (!PilotesRecuperades.isEmpty()) {
            setPilotes_recuperades(Integer.parseInt(PilotesRecuperades));
        }

        System.out.println("Dades del MigCampista modificat correctament");

        return this;
    }

}
