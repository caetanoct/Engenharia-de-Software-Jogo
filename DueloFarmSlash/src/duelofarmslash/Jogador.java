/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duelofarmslash;

import java.util.Random;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador implements Jogada {

	protected String nome;
        protected int vida;
        protected int ataque;
        protected int block;
	protected boolean jogadorDaVez= false;
	protected boolean vencedor;
        
	public Jogador(String nome, int posicao, int vida, int ataque, int block){
		this.nome = nome;
                this.vida =  vida;
                this.ataque = ataque;
                this.block = block;
                
		if (posicao == 1 ){
			this.jogadorDaVez = true;
		}
	}
	

	public void notificarAtaque(){
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public boolean isJogadorDaVez() {
		return jogadorDaVez;
	}


	public void setJogadorDaVez(boolean jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}


	public boolean isVencedor() {
		return vencedor;
	}


	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @return the block
     */
    public int getBlock() {
        return block;
    }



	
	
}
