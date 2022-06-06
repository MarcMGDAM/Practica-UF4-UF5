package HerenciaFC;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Persona implements Serializable {

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
        return "MembreClubFC: [DNI= " + getDni() + ", Nom= " + getNom() + ", Cognom1= " + getCognom1() + "]";
    }

    // TO STRING amb totes les dades dels socis
    // @Override
    // public String toString() {
    //     return "MembresClub [dni=" + dni + "nom=" + nom + "cognom1=" + cognom1 + ", cognom2=" + cognom2 + ", data_naix=" + data_naix +
    //             ", email=" + email + ", telefon=" + telefon + "]";
    // }

    public void modificarDadesPersona(){

        // Apartat de Modifica dades de la persona:
        // Solament deixo modificar les dades que jo cregui que es poden modificar
        Scanner teclat = new Scanner(System.in);

        System.out.println("Si no es vol fer un canvi de una dada, deixi l'espai en blanc");
        System.out.println("Introdueix el nou nom de la persona");
        String nom_persona = teclat.nextLine();
        // Si la dada ha modficar el usuari ho ha deixat buit, al passar-li un Objecte Soci es quedara amb la dada que conté
        if (!nom_persona.isEmpty()) {
            setNom(nom_persona);
        }
        System.out.println("Introdueix el nou primer cognom de la persona");
        String congom1_persona = teclat.nextLine();
        if (!congom1_persona.isEmpty()) {
            setCognom1(congom1_persona);
        }
        System.out.println("Introdueix el nou segon cognom de la persona");
        String cognom2_perosna = teclat.nextLine();
        if (!cognom2_perosna.isEmpty()) {
            setCognom2(cognom2_perosna);
        }
        System.out.println("Introdueix el nou telèfon de la persona");
        String telefon_persona = teclat.nextLine();
        if (!telefon_persona.isEmpty()) {
            setTelefon(Integer.parseInt(telefon_persona));
        }
        System.out.println("Introdueix el nou email de la persona");
        String email_persona = teclat.nextLine();
        if (!email_persona.isEmpty()) {
            setEmail(email_persona);
        }



    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public LocalDate getData_naix() {
        return data_naix;
    }

    public void setData_naix(LocalDate data_naix) {
        this.data_naix = data_naix;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    

}