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
	protected boolean jogadorDaVez= false;
	protected boolean vencedor;

	public Jogador(String nome, int posicao){
		this.nome = nome;

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



	
	
}
