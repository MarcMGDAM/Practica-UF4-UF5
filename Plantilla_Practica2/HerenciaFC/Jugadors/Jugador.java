package HerenciaFC.Jugadors;

import java.time.LocalDate;

import HerenciaFC.Plantilla;

public abstract class Jugador extends Plantilla {

    private static int num_dorsal;
    private int dorsal;
    private boolean titular;

    public Jugador(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, boolean titular) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base);
        this.titular = titular;
        this.dorsal = ++num_dorsal;

    }

    public Jugador() {

    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public static int getNum_dorsal() {
        return num_dorsal;
    }

}
