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
public class Elemento {

    private int peso;
    private int linea;

    public Elemento() {
    }
    
    public Elemento(int _linea,int _peso) {
        this.linea = _linea;
        this.peso = _peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
     public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }
    
}
