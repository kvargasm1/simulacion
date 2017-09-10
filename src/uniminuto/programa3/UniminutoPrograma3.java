/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniminuto.programa3;

import com.uniminuto.utilidades.Utilidades;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author osahenao
 */
public class UniminutoPrograma3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
           
            String semilla = JOptionPane.showInputDialog("Ingrese la semilla");            
            int periodo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el periodo"));

            if (semilla.length() > 1) {
                for (int i = 0; i < periodo; i++) {
                    Utilidades utilidades = new Utilidades();

                    semilla = utilidades.muestraSemilla(Double.parseDouble(semilla),semilla.length());
                    JOptionPane.showConfirmDialog(null, "Resultado: " + semilla);
                }
            } else {
                System.out.println("Recuerde que debe ingresar un numero de mas de dos digitos.");
            }
        } catch (Exception ex) {
            System.out.println("Recuerde que no se pueden ingresar numeros decimales ni letras!");
        }
    }

}
