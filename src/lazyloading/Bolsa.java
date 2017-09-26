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
public class Bolsa {
    
    private List<Elemento> punyado;//Puñado de elementos

    public Bolsa() {
        if (this.punyado == null) {
            this.punyado = new ArrayList<Elemento>();
        }
    }
    
//    public Bolsa(List<Elemento> elementos) {
//        try {
//            if (elementos.size() > 0) {
//                for (Elemento _elemento : elementos) {
//                    this.addElemento(_elemento);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(String.format("Problema con la lista de Elemento: %s", e.getMessage()));
//        }
//    }
    
    public List<Elemento> getPunyado() {
        return punyado;
    }
    
    public void setPunyado(List<Elemento> _elemento) {
        this.punyado = _elemento;
    }
    
    public int numElemento() {
        return this.punyado.size();
    }
    
    public void addElemento(Elemento elem) {
        if (this.punyado == null) {
            this.punyado = new ArrayList<Elemento>();
        }
        this.punyado.add(elem);
        
    }
    
}