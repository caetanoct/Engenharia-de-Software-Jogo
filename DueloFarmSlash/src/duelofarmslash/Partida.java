package duelofarmslash;

import java.util.*;

import br.ufsc.inf.leobr.cliente.Jogada;


public class Partida implements Jogada {

	protected Jogador jogador1;
	protected Jogador jogador2;
	protected boolean partidaEmAndamento;
	protected AtorJogador jogador;


	public Partida() {
			
	}
	
	public void criarJogadores(String idJogador, String adversario, int posicao) {
                // param idJogador, posicao(vez), vida, ataque(5), block,creditos.
		jogador1 = new Jogador(idJogador, posicao, 50, 5, 0,0);
		jogador2 = new Jogador(adversario, posicao == 1 ? 2 : 1, 100, 5,0,0);

	}

	public boolean informaSePartidaEmAndamento() {
		return this.partidaEmAndamento;
	}

	
	public void realizaJogada() throws Exception{
         jogador1.setJogadorDaVez(false);
         
	}



	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public boolean isPartidaEmAndamento() {
		return partidaEmAndamento;
	}

	public void setPartidaEmAndamento(boolean partidaEmAndamento) {
		this.partidaEmAndamento = partidaEmAndamento;
	}



}