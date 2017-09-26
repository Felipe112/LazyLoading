/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyloading;

/**
 *
 * @author fray
 */
public class Julie {
    
    public Julie(){
    }
    
    /**
     * Metodo encargado de examinar las bolsas y retornar si estas cumplen o no con lo establecido por julie
     * @param bolsa
     * @return 
     */
    public boolean examinarBolsa(Bolsa bolsa){
        
        int w = bolsa.getPunyado().get(0).getPeso(); //peso del elemento que esta en la parte superior.
        int k = bolsa.numElemento(); //numero de elementos de la bolsa
        int pesoTotal = 0;
        pesoTotal = k * w;
        
        if(pesoTotal < 50){
            return false;
        }              
        return true;
    }
            
}
