package HerenciaFC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import HerenciaFC.Jugadors.Defensa;
import HerenciaFC.Jugadors.Delanter;
import HerenciaFC.Jugadors.Jugador;
import HerenciaFC.Jugadors.Migcampista;
import HerenciaFC.Jugadors.Porter;
import HerenciaFC.Tecnics.Entrenador;
import HerenciaFC.Tecnics.PreparadorFisic;

public class ClubFC implements Serializable {

    private String cif;
    private String nom;
    private String adreça;
    private int telèfon;
    private String email;
    private String www;
    // Col·lecció de socis, String es la clau: DNI del soci i després li diem que
    // volem guardar a la col·lecció socis
    private HashMap<String, Soci> socis = new HashMap();
    private HashMap<String, Plantilla> plantilla = new HashMap();

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
        return "ClubFC [CIF=" + cif + ", nom= " + nom + ", adreça= " + adreça + ", email= " + email
                + ", telèfon= " + telèfon + ", www= " + www + "]";
    }

    // File fichero = new File("E:/DAM 1r/M3/Plantilla_Practica2/DadesClub.dat");
    // File fichero = new File("D:/DAM 1r/M3/Plantilla_Practica2/DadesClub.dat");

    private void llegirFitxer() throws IOException, ClassNotFoundException {

        File fichero = new File("E:/DAM 1r/M3/Plantilla_Practica2/DadesClub.dat");

        FileInputStream flujoFichero = new FileInputStream(fichero);
        // ObjectInputStream deserializador = new ObjectInputStream(flujoFichero);

        // Creem un objecte clubFC biut per després posar-li les dades del this
        ClubFC club = new ClubFC();

        if (new File("E:/DAM 1r/M3/Plantilla_Practica2/DadesClub.dat").exists()) {
            System.out.println("El fitxer existeix");
            try (ObjectInputStream inFitxer = new ObjectInputStream(flujoFichero)){

                // Afegim al club les dades guardades de L'Objecte ClubFC
                club = (ClubFC) inFitxer.readObject();

                this.socis = club.socis;

                this.plantilla = club.plantilla;

                // Llegir els numero de socis totals, i fem un cast de int ja que la dada que ha de llegir es un int
                Soci.setTotalsocis( (int) inFitxer.readObject());

                Soci.setLocalitat((int) inFitxer.readObject());

                Plantilla.setEmpleatsTotals((int) inFitxer.readObject());

                Jugador.setNum_dorsal((int) inFitxer.readObject());


            }  catch (Exception e) {
            }
        }

    }

    private void guardarFitxer() throws IOException {

        File fichero = new File("E:/DAM 1r/M3/Plantilla_Practica2/DadesClub.dat");

        FileOutputStream flujoFicheroO = new FileOutputStream(fichero);

        try (ObjectOutputStream outfitxer = new ObjectOutputStream(flujoFicheroO)) {

            // Afegim totes les dades de ClubFC
            outfitxer.writeObject(this);

            // Afegim al fitxer el numero de socis
            outfitxer.writeObject(Soci.getTotalsocis());

            // Afegim el numero de Localitat final dels jugadors
            outfitxer.writeObject(Plantilla.getEmpleatsTotals());

            // Afegim el numero de Localitat final dels jugadors
            outfitxer.writeObject(Plantilla.getEmpleatsTotals());

            // Afegim el numero de Localitat final dels jugadors
            outfitxer.writeObject(Jugador.getNum_dorsal());


        } catch (IOException e) {
            System.out.println(e);

        }

        // ficar les coleccions a dins del fitxer
        // outfitxer.writeObject(socis);
        // outfitxer.writeObject(plantilla);

    }

    public void gestionarMembres() throws IOException, ClassNotFoundException {

        Scanner teclat = new Scanner(System.in);

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
                    guardarFitxer();
                    sortir = true;
                    break;
                default:
                    System.out.println("L'opció " + opció + " no existeix.");
            }

        } while (!sortir);

    }

    private void consultaDadesClub() {

        ClubFC c = new ClubFC("L89349201", "F.C.DAM", "Avinguda hospitalet", 931445783, "damFC@gmail.com",
                "https://damfc.com");

        System.out.println(c);
    }

    public void visualitzarEconomia() {

        // Bucle per calcular els ingressos
        int ingressos = 0;
        Iterator it = socis.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Soci> entry = (Map.Entry) it.next();
            // vaig agafant les quotes de cada un dels socis
            ingressos += entry.getValue().getQuotaAnual();
        }
        System.out.println("Ingressos del ClubFC: " + ingressos);

        // Bucle per calcular les despeses
        int despeses = 0;
        Iterator id = plantilla.entrySet().iterator();
        while (id.hasNext()) {
            Map.Entry<String, Plantilla> entry = (Map.Entry) id.next();
            // vaig agafant les quotes de cada un dels socis
            despeses += entry.getValue().calcularSouVariable();
        }
        System.out.println("Despeses del ClubFC: " + despeses);

        // Operació per calcular el balanç de diners del club
        int balanç = 0;

        balanç = ingressos - despeses;

        System.out.println("Balanç del ClubFC: "+ balanç);

    }

    public void gestionarSocis() throws IOException, ClassNotFoundException {

        Scanner teclat = new Scanner(System.in);

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
                    modificarSoci(socis);
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

    private void altaSoci(HashMap socis) {
        Soci s = new Soci();
        s.altaSocis(socis);
    }

    private void modificarSoci(HashMap socis) {

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix el dni del soci que vol modificar");
        String clau_soci = teclat.next();
        // Li passem el HashMap de socis i el dni del soci que volem modificar
        Soci s = new Soci();
        s = (Soci) identificarPersona(socis, clau_soci);
        s.modificarSoci();
        socis.put(clau_soci, s);
    }

    private Persona identificarPersona(HashMap<String, Persona> clubPersones, String dni ){

        // El hashMap de clubPersones al ser Pare de la Socis i Plantilla, depen de qui volem modificar li passarem el HashMap de socis o el de Plantilla
        if (clubPersones.containsKey(dni)) {
            // Retorna el objecte Soci que de clau te aquell DNI
            return clubPersones.get(dni);
        } else {
            System.out.println("No hi ha cap persona del ClubFC amb aquest DNI.");
            return null;
        }


    }

    private void baixaSoci(HashMap socis) {
        Soci s = new Soci();
        s.baixarSocis(socis);
    }

    private void visualitzarSocis() throws IOException, ClassNotFoundException {

        Scanner teclat = new Scanner(System.in);

        boolean sortir = false;
        do {

            System.out.println("***********___VISUALITZAR SOCIS___***********");
            System.out.println("1. Per cognom i nom");
            System.out.println("2. Per localitat");
            System.out.println("3. Per quota");
            System.out.println("4. Tornar al menú anterior");
            System.out.println("***************************************");

            int opció = teclat.nextInt();
            // Et demana posar un valor a la terminal per executar X comanda
            switch (opció) {
                case 1:
                    consultaNom(socis);
                    break;
                case 2:
                    consultaLocalitat();
                    break;
                case 3:
                    consultaQuota();
                    break;
                case 4:
                    sortir = true;
                    break;
                default:
                    System.out.println("L'opció " + opció + " no existeix.");
            }

        } while (!sortir);
    }

    private void consultaNom(HashMap socis) {
        Soci s = new Soci();
        s.consultaPerNom(socis);
    }

    private void consultaLocalitat() {
        Soci s = new Soci();
        s.consultaPerLocalitat(socis);
    }

    private void consultaQuota() {
        Soci s = new Soci();
        s.consultaPerQuotaAnual(socis);
    }

    public void gestionarPlantilla() {

        Scanner teclat = new Scanner(System.in);

        boolean sortir = false;
        do {

            System.out.println("***********___MENU GESTIONAR PLANTILLAS___***********");
            System.out.println("1. Donar de alta a un Entrenador");
            System.out.println("2. Donar de alta a un PreparadorFisic");
            System.out.println("3. Donar de alta a un Porter");
            System.out.println("4. Donar de alta a un Defensa");
            System.out.println("5. Donar de alta a un MigCampista");
            System.out.println("6. Donar de alta a un Delanter");
            System.out.println("7. Modificar dades de un treballador");
            System.out.println("8. Dona de baixar un treballador");
            System.out.println("9. Visualitzar els treballadors per Classes");
            System.out.println("10. Visualitzar els treballadors per SouIncentivat");
            System.out.println("11. Tornar al primer menú");
            System.out.println("***************************************");

            int opció = teclat.nextInt();
            // Et demana posar un valor a la terminal per executar X comanda
            switch (opció) {
                case 1:
                    altaEntrenador();
                    break;
                case 2:
                    altaPreparadorFisic();
                    break;
                case 3:
                    altaPorter();
                    break;
                case 4:
                    altaDefensa();
                    break;
                case 5:
                    altaMigcampista();
                    break;
                case 6:
                    altaDelanter();
                    break;
                case 7:
                    modificarPlantilla(plantilla);
                    break;
                case 8:
                    baixaPlantilla();
                    break;
                case 9:
                    VisualitzarPlantilla(plantilla);
                    break;
                case 10:
                    VisualitzarPlantillaSouIncentiu(plantilla);
                    break;
                case 11:
                    sortir = true;
                    break;
                default:
                    System.out.println("L'opció " + opció + " no existeix.");
            }

        } while (!sortir);

    }

    // al retornar el entrenador no fa falta passar el hashMap, el pots incerir a la
    // col·lecció directament
    private void altaEntrenador() {
        Entrenador e = new Entrenador();
        e = e.altaEntrenador();
        // getDni m'agafa el dni del entrenador que tinc creat com a clau i el valor e
        // que te l'altaEntrenador
        plantilla.put(e.getDni(), e);
    }

    private void altaPreparadorFisic() {
        PreparadorFisic p = new PreparadorFisic();
        p = p.altaPreparadorFisic();
        plantilla.put(p.getDni(), p);
    }

    private void altaPorter() {
        Porter p = new Porter();
        p = p.altaPorter();
        plantilla.put(p.getDni(), p);
    }

    private void altaDefensa() {
        Defensa d = new Defensa();
        d = d.altaDefensa();
        plantilla.put(d.getDni(), d);
    }

    private void altaMigcampista() {
        Migcampista m = new Migcampista();
        m = m.altaMigcampista();
        plantilla.put(m.getDni(), m);
    }

    private void altaDelanter() {
        Delanter p = new Delanter();
        p = p.altaDelanter();
        plantilla.put(p.getDni(), p);
    }

    private void baixaPlantilla() {

        Plantilla.baixaPlantilla(plantilla);
    }

    private void modificarPlantilla(HashMap plantilla){
        
        Scanner teclat = new Scanner(System.in);

        System.out.println("Introdueix el dni del soci que vol modificar");
        String clau_plantilla = teclat.next();
        // Li passem el HashMap de socis i el dni del soci que volem modificar
        identificarPersona(plantilla, clau_plantilla);
        // plantilla.put(clau_plantilla, Plantilla.modificarPlantilla());
    }

    private void VisualitzarPlantilla(HashMap plantilla) {
        
        Plantilla.VisualitzarPlantilla(plantilla);
    }

    private void VisualitzarPlantillaSouIncentiu(HashMap plantilla) {
        
        Plantilla.VisualitzarPlantillaSouIncentiu(plantilla);
    }

}