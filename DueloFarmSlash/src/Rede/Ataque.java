/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rede;

import br.ufsc.inf.leobr.cliente.Jogada;

/**
 *
 * @author kire
 */
public class Ataque implements Jogada {

    protected int ataque;
    
    public Ataque (int ataque) {
        super();
        this.ataque = ataque;
    }
    
    public int getAtaque() {
        return ataque;
    }
    
    
}
