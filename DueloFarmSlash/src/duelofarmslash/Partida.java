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
		jogador1 = new Jogador(idJogador, posicao);
		jogador2 = new Jogador(adversario, posicao == 1 ? 2 : 1);

	}

	public boolean informaSePartidaEmAndamento() {
		return this.partidaEmAndamento;
	}

	
	public void realizaJogada(int tipoMovimento, int posicaoClicada) throws Exception{

		
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