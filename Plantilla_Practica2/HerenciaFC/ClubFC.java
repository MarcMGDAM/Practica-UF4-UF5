package HerenciaFC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class ClubFC {

    private String cif;
    private String nom;
    private String adreça;
    private int telèfon;
    private String email;
    private String www;
    // Col·lecció de socis, String es la clau: DNI del soci i després li diem que volem guardar a la col·lecció socis
    private HashMap<String, Socis> socis = new HashMap();
    private HashMap plantilla = new HashMap();


    public ClubFC(String cif, String nom, String adreça, int telèfon, String email, String www) {
        this.cif = cif;
        this.nom = nom;
        this.adreça = adreça;
        this.telèfon = telèfon;
        this.email = email;
        this.www = www;
    }

    public ClubFC() {
    }

    @Override
    public String toString() {
        return "ClubFC [CIF=" + cif + ", nom=" + nom + ", adreça=" + adreça + ", email=" + email
        + ", telèfon=" + telèfon + ", www=" + www + "]";
    }

    File fichero = new File("E:/DAM 1r/M3/Plantilla_Practica2/DadesClub.dat");

    private void llegirFitxer() throws IOException{

        FileInputStream flujoFichero = new FileInputStream(fichero);
        ObjectInputStream deserializador = new ObjectInputStream(flujoFichero);
    }

    private void guardarFitxer() throws IOException{

        FileOutputStream flujoFicheroO = new FileOutputStream(fichero);
        ObjectOutputStream serialitzador = new ObjectOutputStream(flujoFicheroO);

        // ficar les coleccions a dins del fitxer
        // serialitzador.writeObject();
        serialitzador.close();
    }



    private Scanner teclat = new Scanner(System.in);

    public void gestionarMembres() throws IOException {

        llegirFitxer();
        boolean sortir = false;
        do {

            System.out.println("***********___MENU CLUB___***********");
            System.out.println("1. Consulta dades del CLUB");
            System.out.println("2. Gestionar els socis");
            System.out.println("3. Gestiona la plantilla");
            System.out.println("4. Visualitzar les dades econòmiques");
            System.out.println("5. Sortir de l'aplicació");
            System.out.println("***************************************");

            int opció = teclat.nextInt();
            // Et demana posar un valor a la terminal per executar X comanda
            switch (opció) {
                case 1:
                    consultaDadesClub();
                    break;
                case 2:
                    gestionarSocis();
                    break;
                case 3:
                    gestionarPlantilla();
                    break;
                case 4:
                    visualitzarEconomia();
                break;
                case 5:
                    sortir = true;
                    guardarFitxer();
                    break;
                default:
                    System.out.println("L'opció " + opció + " no existeix.");
            }

        } while (!sortir);

    }

    private void consultaDadesClub(){

        ClubFC c = new ClubFC("L89349201", "F.C.DAM", "Avinguda hospitalet", 931445783, "damFC@gmail.com", "https://damfc.com");

        System.out.println(c);
    }

    public void visualitzarEconomia(){

    }

    public void gestionarSocis() {

        boolean sortir = false;
        do {

            System.out.println("***********___MENU GESTIONAR SOCIS___***********");
            System.out.println("1. Donar de alta un soci");
            System.out.println("2. Modificar dades de un soci");
            System.out.println("3. Dona de baixar un soci");
            System.out.println("4. Visualitzar els socis");
            System.out.println("5. Tornar al primer menú");
            System.out.println("***************************************");

            int opció = teclat.nextInt();
            // Et demana posar un valor a la terminal per executar X comanda
            switch (opció) {
                case 1:
                    altaSoci(socis);
                    break;
                case 2:
                    modificarSoci();
                    break;
                case 3:
                    baixaSoci(socis);
                    break;
                case 4:
                    visualitzarSocis();
                break;
                case 5:
                    sortir = true;
                    break;
                default:
                    System.out.println("L'opció " + opció + " no existeix.");
            }

        } while (!sortir);

    }

    private void altaSoci(HashMap socis){
        Socis s = new Socis();
        s.altaSocis(socis);
    }

    private void modificarSoci() {
    }

    private void baixaSoci(HashMap socis) {
        Socis s = new Socis();
        s.baixarSocis(socis);
    }

    private void visualitzarSocis() {

        boolean sortir = false;
        do {

            System.out.println("***********___VISUALITZAR SOCIS___***********");
            System.out.println("1. Per cognom i nom");
            System.out.println("2. Per localitat");
            System.out.println("3. Per quota");
            System.out.println("***************************************");

            int opció = teclat.nextInt();
            // Et demana posar un valor a la terminal per executar X comanda
            switch (opció) {
                case 1:
                    // consultaDadesClub();
                    break;
                case 2:
                    gestionarSocis();
                    break;
                case 3:
                    gestionarPlantilla();
                    break;
                case 4:
                    // visualitzarEconomia();
                break;
                case 5:
                    sortir = true;
                    break;
                default:
                    System.out.println("L'opció " + opció + " no existeix.");
            }

        } while (!sortir);
    }

    public void gestionarPlantilla() {

        boolean sortir = false;
        do {

            System.out.println("***********___MENU GESTIONAR PLANTILLAS___***********");
            System.out.println("1. Donar de alta a un treballador");
            System.out.println("2. Modificar dades de un treballador");
            System.out.println("3. Dona de baixar un treballador");
            System.out.println("4. Visualitzar els treballador");
            System.out.println("5. Tornar al primer menú");
            System.out.println("***************************************");

            int opció = teclat.nextInt();
            // Et demana posar un valor a la terminal per executar X comanda
            switch (opció) {
                case 1:
                    // consultaDadesClub();
                    break;
                case 2:
                    gestionarSocis();
                    break;
                case 3:
                    gestionarPlantilla();
                    break;
                case 4:
                    // visualitzarEconomia();
                break;
                case 5:
                    sortir = true;
                    break;
                default:
                    System.out.println("L'opció " + opció + " no existeix.");
            }

        } while (!sortir);

    }
    

}