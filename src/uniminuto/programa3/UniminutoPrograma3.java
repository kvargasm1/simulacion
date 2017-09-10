/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniminuto.programa3;

import com.uniminuto.utilidades.Utilidades;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
            String[][] semillas = new String[periodo][1];
            if (semilla.length() > 1) {
                for (int i = 0; i < periodo; i++) {
                    Utilidades utilidades = new Utilidades();

                    semilla = utilidades.muestraSemilla(Double.parseDouble(semilla), semilla.length());
                    semillas[i][0] = semilla;
                }
                String[] columnas = {"semilla"};
                JTable table = new JTable(semillas, columnas);
                table.setVisible(true);

                JFrame frame = new JFrame("JTable Test Display");

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JScrollPane tableContainer = new JScrollPane(table);

                panel.add(tableContainer, BorderLayout.CENTER);
                frame.getContentPane().add(panel);

                frame.pack();
                frame.setVisible(true);

            } else {
                System.out.println("Recuerde que debe ingresar un numero de mas de dos digitos.");
            }
        } catch (Exception ex) {
            System.out.println("Recuerde que no se pueden ingresar numeros decimales ni letras!");
        }
    }

}
