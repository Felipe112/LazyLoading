/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyloading;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author fray
 */
public class Camion {

    File fichero = null;
    BufferedWriter bw;
    private static String output = "/home/fray/NetBeansProjects/LazyLoading/src/Resource/Lazy_loading_example_output.txt";

    public Camion() {
    }

    public void crearArchivo() {

        try {
            this.fichero = new File(output);
            if (!this.fichero.exists()) {
                FileWriter archivo = new FileWriter(output);
                this.fichero = new File(output);
            }
            this.bw = new BufferedWriter(new FileWriter(this.fichero));
            //pw = new PrintWriter(fichero);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void cargarCamion(int caso,int k) {
        try {
            bw.write("Case # "+caso+": "+ k + "\n");
        } catch (Exception e) {
            System.out.println(String.format("Problema con la Creacion del archivo: %s", e.getMessage()));
        } 
    }
    
    public void cerrar(){
         try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != this.fichero)
               this.bw.close();
              this.fichero.exists();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
    }

}
