/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniminuto.areaImagen;

import com.uniminuto.utilidades.Utilidades;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author kvargas
 */
public class AreaImagen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            String semilla = JOptionPane.showInputDialog("Ingrese la semilla");

            int periodo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el periodo"));
            final JFileChooser chooser = new JFileChooser();
            int returnValue = chooser.showOpenDialog(chooser);
            String filePath = chooser.getSelectedFile().getAbsolutePath();

            BufferedImage img = null;
            img = ImageIO.read(new File(filePath));
            int altura = img.getHeight();
            int anchor = img.getWidth();
            int contadorPuntosNegros = 0;

            if (semilla.length() > 1) {
                for (int i = 0; i < periodo; i++) {
                    Utilidades utilidades = new Utilidades();

                    semilla = utilidades.muestraSemilla(Double.parseDouble(semilla), semilla.length());
                    int sem = Integer.parseInt(semilla);
                    if (sem <= anchor && sem <= altura) {
                        Color color = new Color(img.getRGB(sem, sem));
                        if (color.equals(Color.BLACK)) {
                            contadorPuntosNegros++;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El punto esta feura de la imagen Periodo:" + i);
                    }

                }
                double anchorAltura = (anchor * altura);
                double divison = Double.parseDouble("" + contadorPuntosNegros) / Double.parseDouble("" + periodo);
                JOptionPane.showMessageDialog(null, (anchorAltura * divison));

            } else {
                System.out.println("Recuerde que debe ingresar un numero de mas de dos digitos.");
            }
        } catch (Exception ex) {
            System.out.println("Recuerde que no se pueden ingresar numeros decimales ni letras!");
        }
    }

}
