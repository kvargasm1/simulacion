/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.utilidades;

/**
 *
 * @author osahenao
 */
public class Utilidades {

    public double elevacuadrado(double semilla) {
        semilla = Math.pow(semilla, 2);
        return semilla;
    }
    
    public String muestraSemilla(double semilla,int cantidadDigitos){
        String semi = "" + (int)elevacuadrado(semilla);
        
        if(semi.length()%2!=0){
            semi = "0" + semi;
        }
        
        int posnumero1 = (int)Math.round(cantidadDigitos/2);
        int posnumero2 = posnumero1 + cantidadDigitos;
        
        return semi.substring(posnumero1, posnumero2);
        
    }

}
