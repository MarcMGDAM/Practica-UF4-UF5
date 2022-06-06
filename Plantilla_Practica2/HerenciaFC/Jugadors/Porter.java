package HerenciaFC.Jugadors;

import java.time.LocalDate;
import java.util.Scanner;

import HerenciaFC.Plantilla;

public class Porter extends Jugador {

    private int gols_aturats;
    private int gols_rebuts;
    private static int incentiu = 100;

    public Porter(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular, int gols_aturats,
            int gols_rebuts) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, titular);
        this.gols_aturats = gols_aturats;
        this.gols_rebuts = gols_rebuts;
        calcularSouVariable();
    }

    @Override
    public int calcularSouVariable() {
        // TODO Auto-generated method stub

        setSouFinal(getSou_base() + (gols_aturats * incentiu));

        return getSouFinal();
    }

    public Porter() {

    }

    public Porter altaPorter() {

        Porter p = new Porter("98372300B", "Gianluigi", "Buffon", "Winner", LocalDate.parse("1982-10-11"), 633789275,
                "luigi@gmail.com", "MESI9937814812", 50, true, 32, 10);
        System.out.println("Porter afegit correctament");
        return p;

    }

    public int getGols_aturats() {
        return gols_aturats;
    }

    public void setGols_aturats(int gols_aturats) {
        this.gols_aturats = gols_aturats;
    }

    public int getGols_rebuts() {
        return gols_rebuts;
    }

    public void setGols_rebuts(int gols_rebuts) {
        this.gols_rebuts = gols_rebuts;
    }

    @Override
    public Plantilla modificarPlantilla() {
        Scanner teclat = new Scanner(System.in);

        modificarDadesPersona();
        System.out.println("Introdueix la nou numero de gols Aturats del Porter");
        String golsAturats = teclat.nextLine();
        if (!golsAturats.isEmpty()) {
            setGols_aturats(Integer.parseInt(golsAturats));
        }
        System.out.println("Introdueix la nou numero de gols Rebuts del Porter");
        String golsRebuts = teclat.nextLine();
        if (!golsRebuts.isEmpty()) {
            setGols_rebuts(Integer.parseInt(golsRebuts));
        }

        System.out.println("Dades del Porter modificat correctament");

        return this;
    }

}
