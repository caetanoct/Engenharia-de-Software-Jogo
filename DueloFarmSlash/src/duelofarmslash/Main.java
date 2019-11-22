/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duelofarmslash;

/**
 *
 * @author caetano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AtorJogador ator = new AtorJogador(); 
        TelaPrincipalDuel janela = new TelaPrincipalDuel(ator);
        janela.setVisible(true);
        InterfaceFarm farm = new InterfaceFarm();
        farm.setVisible(true);
      //  INTERFACE2 i2 = new INTERFACE2();
      //  TelaPrincipal i1 = new TelaPrincipal(ator);
      //  i2.frameAssociado = i1;
      //  i1.setVisible(true);
    }
    
}
