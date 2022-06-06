package HerenciaFC.Tecnics;

import java.time.LocalDate;

import HerenciaFC.*;

public class PreparadorFisic extends Tecnic{

    private static int incentiu = 100;

    public PreparadorFisic(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, int anys_exp) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, anys_exp);
        calcularSouVariable();
    }

    @Override
    public int calcularSouVariable() {
        
        setSouFinal(getSou_base() + (getAnys_exp() * incentiu));

        return getSouFinal();
    }

    public PreparadorFisic(){

    }

    public PreparadorFisic altaPreparadorFisic(){

        PreparadorFisic p = new PreparadorFisic("93748557Q", "Josep", "Camps", "Fuste", LocalDate.parse("1988-01-01"), 664589001, "josep@gmail.com", "PESE1739911230", 8, 4);
        System.out.println("PreparadorFisic afegit correctament");
        return p;

    }

    @Override
    public Plantilla modificarPlantilla() {

        modificarDadesPersona();
        System.out.println("Dades del PreparadorFisic modificat correctament");

        return this;
        
    }   

}
