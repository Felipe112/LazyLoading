/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyloading;

import java.util.List;

/**
 *
 * @author fray
 */
public class Camion {
    
  private List<Integer> numViajes;
    
    public Camion(){
    }
    
    public void cargarCamion(){
        try {
            //se carga el camion con los elementos y se cuentan los numeros de viajes.
        } catch (Exception e) {
            System.out.println(String.format("Problema con la lista de Elemento: %s", e.getMessage()));
        }        
    }
    
    
}
