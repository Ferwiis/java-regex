package modelo;

import vista.*;
import controlador.*;

public class Main {

    public static void main(String args[]) {
        ExpReg validador = new ExpReg();
        VExpReg vista = new VExpReg();
        Controlador_ExpReg control = new Controlador_ExpReg(validador, vista);
        control.iniciarVentanaPrincipal();
    }
}
