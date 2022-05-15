package HerenciaFC;

import java.time.LocalDate;
import java.util.Scanner;

public class Persona {

    protected String dni;
    protected String nom;
    protected String cognom1;
    protected String cognom2;
    protected LocalDate data_naix;
    protected int telefon;
    protected String email;
    

    public Persona(String dni, String nom, String cognom1, String cognom2, LocalDate data_naix, int telefon,
            String email) {
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.data_naix = data_naix;
        this.telefon = telefon;
        this.email = email;
    }

    public Persona(){

    }

    @Override
    public String toString() {
        return "MembresClub [dni=" + dni + "nom=" + nom + "cognom1=" + cognom1 + ", cognom2=" + cognom2 + ", data_naix=" + data_naix +
                ", email=" + email + ", telefon=" + telefon + "]";
    }



    private Scanner teclat = new Scanner(System.in);

    // public void gestionarSocis() {

    //     boolean sortir = false;
    //     do {

    //         System.out.println("***********___MENU GESTIONAR SOCIS___***********");
    //         System.out.println("1. Donar de alta un soci");
    //         System.out.println("2. Modificar dades de un soci");
    //         System.out.println("3. Dona de baixar un soci");
    //         System.out.println("4. Visualitzar els socis");
    //         System.out.println("5. Tornar al primer menú");
    //         System.out.println("***************************************");

    //         int opció = teclat.nextInt();
    //         // Et demana posar un valor a la terminal per executar X comanda
    //         switch (opció) {
    //             case 1:
    //                 altaSoci();
    //                 break;
    //             case 2:
    //                 modificarSoci();
    //                 break;
    //             case 3:
    //                 baixaSoci();
    //                 break;
    //             case 4:
    //                 visualitzarSocis();
    //             break;
    //             case 5:
    //                 sortir = true;
    //                 break;
    //             default:
    //                 System.out.println("L'opció " + opció + " no existeix.");
    //         }

    //     } while (!sortir);

    // }

    // private void altaSoci(){
    //     Socis s = new Socis();
    //     // donar error ja que altaSocis es private
    //     // s.altaSocis();    
    // }

    // private void modificarSoci() {
    // }

    // private void baixaSoci() {
    //     Socis s = new Socis();
    //     s.baixarSocis();
    // }

    // private void visualitzarSocis() {
    // }

    // public void gestionarPlantilla() {

    //     boolean sortir = false;
    //     do {

    //         System.out.println("***********___MENU GESTIONAR PLANTILLAS___***********");
    //         System.out.println("1. Donar de alta a un treballador");
    //         System.out.println("2. Modificar dades de un treballador");
    //         System.out.println("3. Dona de baixar un treballador");
    //         System.out.println("4. Visualitzar els treballador");
    //         System.out.println("5. Tornar al primer menú");
    //         System.out.println("***************************************");

    //         int opció = teclat.nextInt();
    //         // Et demana posar un valor a la terminal per executar X comanda
    //         switch (opció) {
    //             case 1:
    //                 // consultaDadesClub();
    //                 break;
    //             case 2:
    //                 gestionarSocis();
    //                 break;
    //             case 3:
    //                 gestionarPlantilla();
    //                 break;
    //             case 4:
    //                 // visualitzarEconomia();
    //             break;
    //             case 5:
    //                 sortir = true;
    //                 break;
    //             default:
    //                 System.out.println("L'opció " + opció + " no existeix.");
    //         }

    //     } while (!sortir);

    // }

}