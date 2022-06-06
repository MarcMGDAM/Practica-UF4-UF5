package HerenciaFC.Tecnics;

import java.time.LocalDate;
import java.util.Scanner;

import HerenciaFC.Plantilla;

public class Entrenador extends Tecnic{

    private int num_trofeus;
    private static int incentiu = 100;

    public Entrenador(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, int anys_exp, int num_trofeus) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, anys_exp);
        this.num_trofeus = num_trofeus;
        calcularSouVariable();
    }

    @Override
    public int calcularSouVariable() {

        setSouFinal(getSou_base() + (num_trofeus * incentiu));

        return getSouFinal();
        
    }

    public Entrenador(){

    }

    public Entrenador altaEntrenador(){

        Entrenador e = new Entrenador("98372836M", "Pep", "Guardiola", "Hucha", LocalDate.parse("1971-10-23"), 633789275, "pep@gmail.com", "TASA1733114050", 77, 5, 2);
        System.out.println("Entrenador afegit correctament");
        return e;
    }

    @Override
    public Plantilla modificarPlantilla() {
        Scanner teclat = new Scanner(System.in);

        modificarDadesPersona();
        System.out.println("Introdueix la nou num_trofeus gunyats del Entrenador");
        String num_trofeus = teclat.nextLine();
        if (!num_trofeus.isEmpty()) {
            setNum_trofeus(Integer.parseInt(num_trofeus));
        }
        System.out.println("Dades del Entrenador modificat correctament");

        return this;
        
    }

    public int getNum_trofeus() {
        return num_trofeus;
    }

    public void setNum_trofeus(int num_trofeus) {
        this.num_trofeus = num_trofeus;
    } 

}
