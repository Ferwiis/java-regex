package controlador;

import static javax.swing.JFrame.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class Controlador_ExpReg implements ActionListener {

    private final ExpReg validador;
    private final VExpReg vista;

    public Controlador_ExpReg(ExpReg validador, VExpReg vista) {
        this.validador = validador;
        this.vista = vista;
        registrarOyentes();
    }

    private void registrarOyentes() {
        this.vista.jTbBorrar.addActionListener(this);
        this.vista.jbValidarReal.addActionListener(this);
        this.vista.jbValidarEntero.addActionListener(this);
        this.vista.jbValidarNotCient.addActionListener(this);
        this.vista.jbValidarBinario.addActionListener(this);
        this.vista.jbValidarEmail.addActionListener(this);
    }

    public void iniciarVentanaPrincipal() {
        vista.setResizable(false);
        vista.setDefaultCloseOperation(EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.jCbReal.setEnabled(false);
        vista.jCbEntero.setEnabled(false);
        vista.jCbNotCient.setEnabled(false);
        vista.jCbBinario.setEnabled(false);
        vista.jCbEmail.setEnabled(false);
        vista.jbValidarReal.setFocusPainted(false);
        vista.jbValidarEntero.setFocusPainted(false);
        vista.jbValidarNotCient.setFocusPainted(false);
        vista.jbValidarBinario.setFocusPainted(false);
        vista.jbValidarEmail.setFocusPainted(false);
        vista.jTbBorrar.setFocusPainted(false);
        vista.setVisible(true);
    }

    public void ejecutarExpresionRegular(JCheckBox check, JTextField campo_texto, String msg, int tipoCadena) {
        validador.setCadenaIngresada(campo_texto.getText());
        if (validador.verificarCadena(tipoCadena) == true) {
            JOptionPane.showMessageDialog(vista, "¡La cadena ingresada " + msg + "!");
            check.setSelected(true);
        } else {
            JOptionPane.showMessageDialog(vista, "¡La cadena ingresada NO " + msg + "!");
            if (check.isSelected()) {
                check.setSelected(false);
            }
        }
        validador.setCadenaIngresada(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.jTbBorrar)) {
            vista.txReal.setText("");
            vista.txEntero.setText("");
            vista.txNotCient.setText("");
            vista.txBinario.setText("");
            vista.txEmail.setText("");
            vista.jCbReal.setSelected(false);
            vista.jCbEntero.setSelected(false);
            vista.jCbNotCient.setSelected(false);
            vista.jCbBinario.setSelected(false);
            vista.jCbEmail.setSelected(false);
            vista.jTbBorrar.setSelected(false);
            JOptionPane.showMessageDialog(vista, "¡TODOS LOS CAMPOS BORRADOS!");
        }

        if (e.getSource().equals(vista.jbValidarReal)) {
            ejecutarExpresionRegular(vista.jCbReal, vista.txReal, "ES REAL", 1);
        }
        if (e.getSource().equals(vista.jbValidarEntero)) {
            ejecutarExpresionRegular(vista.jCbEntero, vista.txEntero, "ES ENTERA", 2);
        }
        if (e.getSource().equals(vista.jbValidarNotCient)) {
            ejecutarExpresionRegular(vista.jCbNotCient, vista.txNotCient, "ES DE NOTACIÓN CIENTÍFICA", 3);
        }
        if (e.getSource().equals(vista.jbValidarBinario)) {
            ejecutarExpresionRegular(vista.jCbBinario, vista.txBinario, "ES BINARIA", 4);
        }
        if (e.getSource().equals(vista.jbValidarEmail)) {
            ejecutarExpresionRegular(vista.jCbEmail, vista.txEmail, "ES EMAIL", 5);
        }
    }
}
