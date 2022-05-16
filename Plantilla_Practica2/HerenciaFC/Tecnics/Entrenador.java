package HerenciaFC.Tecnics;

import java.time.LocalDate;

import HerenciaFC.Plantilla;

public class Entrenador extends Tecnic{

    private int num_trofeus;
    private int souFinal;
    private static int incentiu = 1500;

    public Entrenador(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email, String num_seguretatSocial, int sou_base, int anys_exp, int num_trofeus) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email, num_seguretatSocial, sou_base, anys_exp);
        this.num_trofeus = num_trofeus;
        calcularSouVariable();
    }

    @Override
    public void calcularSouVariable() {
        // TODO Auto-generated method stub

        souFinal = getSou_base() + (num_trofeus * incentiu);
        
    }

    public Entrenador(){

    }

    public Entrenador altaEntrenador(){

        Entrenador e = new Entrenador("98372836M", "Pep", "Guardiola", "Hucha", LocalDate.parse("1971-10-23"), 633789275, "pep@gmail.com", "TASA1733114050", 20177, 25, 12);
        return e;

    }



    

    

    

    

    

    

}
