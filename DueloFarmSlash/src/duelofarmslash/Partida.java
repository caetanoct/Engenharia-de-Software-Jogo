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
		jogador1 = new Jogador(idJogador, posicao, 100, 30, 0,0,1);
		jogador2 = new Jogador(adversario, posicao == 1 ? 2 : 1, 100, 50,0,0,2);

	}

	public boolean informaSePartidaEmAndamento() {
		return this.partidaEmAndamento;
	}

	
	public void realizaJogada(int Ataque) throws Exception {
         jogador2.setVida(jogador2.getVida() - Ataque);
         if (jogador2.getVida() <= 0) {
             jogador1.setVencedor(true);
         }
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