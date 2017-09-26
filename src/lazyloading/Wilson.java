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

    private Proceso procesar;
    private static String archivo = "/home/fray/NetBeansProjects/LazyLoading/src/Resource/carga.txt";
    
    public Wilson() {
        this.procesar = new Proceso(archivo);
    }

    /**
     * Metodo encargado de inicializar el trabajo de Wilson
     */
    public void trabajar() {
        
        ArrayList<Integer> datosDocumento = null;
        
        try {
            datosDocumento = this.procesar.procesarDocumento();
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        
        this.cargarElementos(datosDocumento);
    }

    @Override
    public void cargarElementos(ArrayList<Integer> datosDocumento) {
        
        int T = datosDocumento.get(0);
        datosDocumento.remove(0);
        
       int[] resultado = this.procesar.recorrerDatos(T,datosDocumento);
       
       for (int i=0;i<resultado.length;i++) {
           
            this.moverElementos(resultado);
        }
       
       
    }

    @Override
    public void moverElementos(int[] casos) {
        Camion camion = new Camion();
        camion.crearArchivo();
        
        for (int i=0;i<casos.length;i++) {
            camion.cargarCamion(i+1, casos[i]);
        }
        camion.cerrar();
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
