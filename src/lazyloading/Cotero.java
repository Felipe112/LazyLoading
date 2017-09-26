/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyloading;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fray
 */
public abstract class Cotero {

    protected Bolsa bolsa;

    /**
     * Se utiliza para cargar los elementos en la bolsa
     * @param _elemento 
     */
    public abstract void cargarElementos(ArrayList<Integer> elementos);


    public abstract void moverElementos(int[] datos);

}
