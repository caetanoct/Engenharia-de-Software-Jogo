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
        protected int creditos;
        protected int janela;
	protected boolean jogadorDaVez= false;
	protected boolean vencedor;
        
	public Jogador(String nome, int posicao, int vida, int ataque, int block, int creditos, int janela){
            this.nome = nome;
            this.vida =  vida;
            this.ataque = ataque;
            this.block = block;
            this.creditos = creditos;
            this.janela = janela;
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

    /**
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(int block) {
        this.block = block;
    }

    /**
     * @return the janela
     */
    public int getJanela() {
        return janela;
    }

    /**
     * @param janela the janela to set
     */
    public void setJanela(int janela) {
        this.janela = janela;
    }



	
	
}
