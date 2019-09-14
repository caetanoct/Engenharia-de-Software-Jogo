/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author caetano
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        INTERFACE2 i2 = new INTERFACE2();
        NewJFrame i1 = new NewJFrame(i2);
        i2.frameAssociado = i1;
        i1.setVisible(true);
    }
    
}
