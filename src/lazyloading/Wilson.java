/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyloading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fray
 */
public class Wilson extends Cotero {

    public Wilson() {
    }

    public void trabajar() {
        /**
         * Cargar el documento
         */
        ArrayList<Integer> datosDocumento = null;
        String archivo = "/home/fray/NetBeansProjects/LazyLoading/src/Resource/carga.txt";
        Proceso proceso = new Proceso(archivo);
        try {
            datosDocumento = proceso.procesarDocumento();
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }

        int T = datosDocumento.get(0);
        datosDocumento.remove(0);

        List<Elemento> elementos = new ArrayList<Elemento>();
        proceso.recorrerDatos(T,datosDocumento, elementos);

        //System.out.print("Elementos: " + elementos.size());
        this.cargarElementos(elementos);
    }

    @Override
    public void cargarElementos(List<Elemento> _elementos) {
        //logica para cargar los elementos en la bolsa de forma que cumpla las validaciones requeridas

        int iteraciones = 0;
        int i = 0;
        for (Elemento elemento : _elementos) {
            
            iteraciones = elemento.getLinea();
            
            int mayor;
            int menor=0;
            for (int j = 0; j < iteraciones; j++) {
                if (_elementos.get(j).getPeso() >= 50) {
                    this.cargarBolsa(elemento, true);
                    this.moverElementos();
                    continue;
                }
                mayor = _elementos.get(j).getPeso();
              //  if()
                
                
                
            }

            i++;
        }

        
        
        
        
        
        
        
        
        
        
        
//        int linea = 0;
//        this.bolsa = new Bolsa();
//        for (Elemento elemento : _elementos) {
//            System.out.print("\nElemento: ");
//            System.out.print("\n--Linea: " + elemento.getLinea());
//            System.out.print("\n--peso: " + elemento.getPeso());
//
//            //  linea = elemento.getLinea();            
//            //mientras linea == elemento.getLinea() while
//            if (elemento.getPeso() >= 50) {
//                this.cargarBolsa(elemento, true);
//                this.moverElementos();
//                continue;
//            }
//
//        }
    }

    private void cargarBolsa(Elemento elemento, boolean bolsaNueva) {
        if (bolsaNueva) {
            this.bolsa = new Bolsa();
        }
        this.bolsa.addElemento(elemento);
    }

    @Override
    public void moverElementos() {
        //se deben mover los elementos de la bolsa al camion
        //ordenar
        this.ordenarElementos(this.bolsa.getPunyado());
        Camion camion = new Camion();
        camion.cargarCamion();
    }

    /**
     * metodo encargado de ordenar los registros de la bolsa para que estos
     * siempre queden de mayor a menor
     *
     * @param _elementos
     * @return
     */
    private List<Elemento> ordenarElementos(List<Elemento> _elementos) {

        int i = 0;
        for (Elemento _elemento : _elementos) {
            int max = _elemento.getPeso();
            int posicion = i;
            //buscamos el mayor peso
            for (int j = i + 1; j < _elementos.size(); j++) {
                if (_elementos.get(j).getPeso() > max) {
                    max = _elementos.get(j).getPeso();    //encontramos el mayor número
                    posicion = j;
                }
            }

            if (i != posicion) {
                //permutamos los valores
                int aux = _elementos.get(i).getPeso();
                _elementos.get(i).setPeso(max);
                _elementos.get(posicion).setPeso(aux);
            }
            i++;
        }
         return _elementos;

    }

}
