package HerenciaFC;

import java.io.IOException;
import java.io.Serializable;

public class ClubApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ClubFC c = new ClubFC();

        c.gestionarMembres();

    }
}
