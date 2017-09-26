/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyloading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase diseñada para manipular y procesar el trabajo especializado que wilson requiere.
 * @author fray
 */
public class Proceso {

    private String archivo;
    private ArrayList<Integer> datosDocumento;

    public Proceso(String _archivo) {
        this.archivo = _archivo;
        this.datosDocumento = new ArrayList<Integer>();
    }

    /**
     * Cargar el documento
     */
    public ArrayList<Integer> procesarDocumento() {
        try {
            // Cargamos el buffer con el contenido del archivo
            BufferedReader br = new BufferedReader(new FileReader(this.archivo));
            String bfRead;
            while ((bfRead = br.readLine()) != null) {
                if (this.esEntero(bfRead)) {
                    this.datosDocumento.add(Integer.parseInt(bfRead));
                }
            }

            if (!this.restriccionT(this.datosDocumento.get(0))) {
                System.out.print("Problema con el número de dias a trabajar");
                // throws new Exception("Problema");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.datosDocumento;
    }

    /**
     * Metodo encargado de llenar la lista elementos con toda la información del
     * documento.
     *
     * @param datos
     * @param elementos
     */
    public int[] recorrerDatos(int T, ArrayList<Integer> datos) {
        Julie julie = new Julie();
        
        int posicion = 0;
        int[] resultado = new int[T]; 
        for (int i = 0; i < T; i++) {
            int N = datos.get(posicion);
            int[] arrayN = new int[N];
            int posicion2 = posicion + 1;
            for (int j = 0; j < N; j++) {
                arrayN[j] = datos.get((posicion2));
                posicion2++;
            }
            this.ordenar(arrayN);

            int suma = 0;
            int contador = 0;
            while (arrayN.length != 0) {
                if (arrayN[0] >= 50) {
                    System.out.println("Mover elemento mayor a 50:" + arrayN[0]);
                    contador++;
                    arrayN = this.remover(0, arrayN);
                    continue;
                }

                int item, mayor, menor=0;
                item = this.mayor(arrayN);
                mayor = arrayN[item];
                arrayN = this.remover(item, arrayN);

                if (arrayN.length > 0) {
                item = this.menor(arrayN);
                menor = arrayN[item];
                arrayN = this.remover(item, arrayN);
                }
                
                
                suma = suma + mayor + menor;

                if (arrayN.length == 1) {
                    suma = suma + arrayN[0];
                    arrayN = this.remover(0, arrayN);
                }

                if (suma >= 30) //pruebas
                {
                    System.out.println("Mover elemento:" + suma);
                    contador++;
                    suma = 0;
                }
            }
            resultado[i]=contador;
            posicion = posicion + N + 1;
        }
        return resultado;
    }

    private void ordenar(int[] arreglo) {
        //iteramos sobre los elementos del arreglo
        for (int i = 0; i < arreglo.length - 1; i++) {
            int max = i;

            //buscamos el mayor número
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] > arreglo[max]) {
                    max = j;    //encontramos el mayor número
                }
            }

            if (i != max) {
                //permutamos los valores
                int aux = arreglo[i];
                arreglo[i] = arreglo[max];
                arreglo[max] = aux;
            }
        }
    }

    private int mayor(int[] vector) {
        int mayor = vector[0];
        int posicion = 0;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > mayor) {
                mayor = vector[i];
                posicion = i;
            }
        }
        return posicion;
    }

    private int menor(int[] vector) {
        int menor = vector[0];
        int posicion = 0;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < menor) {
                menor = vector[i];
                posicion = i;
            }
        }
        return posicion;
    }

    private int[] remover(int posicion, int[] vector) {

        int[] nuevoArray = new int[vector.length - 1];
        if (posicion > 0) {
            System.arraycopy(vector, 0, nuevoArray, 0, posicion);
        }
        if (nuevoArray.length > posicion) {
            System.arraycopy(vector, posicion + 1, nuevoArray, posicion, nuevoArray.length - posicion);
        }
        return nuevoArray;
    }

    /**
     * Funcion encargada de validar si el dato que se esta validando es un
     * numero
     *
     * @param dato
     * @return
     */
    private boolean esEntero(String dato) {
        for (int i = 0; i < dato.length(); i++) {
            if (!Character.isDigit(dato.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Primera restricción del sistema el archivo de datos no puede tener mas de
     * 500 elementos y menos a 1
     *
     * @param numeroDatos
     * @return
     */
    private boolean restriccionT(int numeroDatos) {

        if (1 <= numeroDatos && numeroDatos <= 500) {
            return true;
        }
        return false;
    }

    /**
     * Segunda restriccion del sistema el valor no puede ser menor a 1 ni mayor
     * a 100
     *
     * @param linea
     * @return
     */
    private boolean restriccionNW(int valor) {
        if (1 <= valor && valor <= 100) {
            return true;
        }
        return false;
    }
      
    

}
