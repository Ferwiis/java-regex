package modelo;

import java.util.regex.*;

public class ExpReg {

    private String cadena_ingresada;

    public String getCadenaIngresada() {
        return cadena_ingresada;
    }

    public void setCadenaIngresada(String cadena_ingresada) {
        this.cadena_ingresada = cadena_ingresada;
    }

    public boolean verificarCadena(int tipoCadena) {
        Pattern patron;
        Matcher validacion = null;
        switch (tipoCadena) {
            case 1:
                String REALNUMBER_PATTERN = "^[-+]?[0-9]+\\.{1}[0-9]+$";
                patron = Pattern.compile(REALNUMBER_PATTERN);
                validacion= patron.matcher(cadena_ingresada);
                break;
            case 2:
                String INTEGERNUMBER_PATTERN = "^[-+]?[0-9]+";
                patron = Pattern.compile(INTEGERNUMBER_PATTERN);
                validacion= patron.matcher(cadena_ingresada);
                break;
            case 3:
                String CIENTNOTATION_PATTERN = "^[+-]?[0-9][0-9]*(\\.([0-9])+)?[eE][+-]?([0-9](([0-9])*))$";
                patron = Pattern.compile(CIENTNOTATION_PATTERN);
                validacion= patron.matcher(cadena_ingresada);
                break;
            case 4:
                String BINARYNUMBER_PATTERN = "^[01]+$";
                patron = Pattern.compile(BINARYNUMBER_PATTERN);
                validacion = patron.matcher(cadena_ingresada);
                break;
            case 5:
                String EMAIL_PATTERN = "[a-zA-Z0-9.]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
                patron = Pattern.compile(EMAIL_PATTERN);
                validacion = patron.matcher(cadena_ingresada);
                break;
        }
        return validacion.matches();
    }
}
