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


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    

}