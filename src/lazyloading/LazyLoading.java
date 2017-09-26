/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyloading;

import DB.Conectar;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fray
 */
public class LazyLoading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conectar conn= new Conectar();
        
        Wilson wilson = new Wilson();
        wilson.trabajar();
    }
    
}
