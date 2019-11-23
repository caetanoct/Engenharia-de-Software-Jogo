/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duelofarmslash;

import Rede.AtorNetGames;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;

/**
 *
 * @author kire
 */
public class AtorJogador {

	protected Partida Partida;
	protected AtorNetGames rede;
	protected String idUsuario;
	protected TelaPrincipalDuel tela;
        protected TelaPrincipalDuel telaAtualizada;
	
	public AtorJogador() {
                this.Partida = new Partida();
		this.tela = new TelaPrincipalDuel(this);
		this.rede = new AtorNetGames(this);
                
	}

   
	
	public void conectar(String idUsuario, String servidor) throws Exception {
		this.idUsuario = idUsuario;
		rede.conectar(idUsuario, servidor);
	}
	
	
	public void realizaJogada (int tipoMovimento, int posicao) throws Exception{;

	}

        	
	public void notificar(String mensagem) {
		tela.notificar(mensagem);
	}

	public void desconectar() throws NaoConectadoException {
		rede.desconectar();
	}
	
	
	public void notificarErro(String erro) {
		this.Partida.setPartidaEmAndamento(false);
		tela.notificar(erro);
	}

	public void IniciarPartida() throws NaoConectadoException {
		rede.iniciarPartida();
	}

	public void enviarJogada() throws NaoJogandoException{
		this.rede.enviarJogada(this.Partida);
	}


	
        public Partida getPartida() {
		return this.Partida;
	}
        


	public void receberJogada(Partida tab) throws NaoConectadoException, NaoJogandoException{

	}

	public void iniciarNovaPartida(Integer posicao) {
     
		Partida = new Partida();
                
		String idAdversario = rede.getNomeAdversario(posicao);
		Partida.criarJogadores(idUsuario, idAdversario, posicao);
		Partida.setPartidaEmAndamento(true);
                tela.VidaBarra1.setValue(100);
                tela.VidaBarra2.setValue(100);
                if (posicao == 1) {
                    this.tela.notificar("Um duelo foi encontrado! O seu oponente eh:" + idAdversario);
                    tela.iniciarPartida.setEnabled(false);
                    tela.Perso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/person1.gif"))); // NOI18N
                    tela.Perso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/person2.gif"))); // NOI18N
                    tela.Perso1.setVisible(true);
                    tela.Perso2.setVisible(true);
                } else {
                    this.tela.notificar("Um duelo foi encontrado! O seu oponente eh:"+ Partida.getJogador2().getNome() );
                    tela.iniciarPartida.setEnabled(false);
                    tela.Perso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/personMirror2.gif"))); // NOI18N
                    tela.Perso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/personMirror1.gif"))); // NOI18N
                    tela.Perso1.setVisible(true);
                    tela.Perso2.setVisible(true);
                } 
		

		tela.ServidorItem.setEnabled(true);
		if (Partida.getJogador1().isJogadorDaVez()){
                    this.tela.notificar(Partida.getJogador1().getNome()+", eh sua vez de atacar.");
		} else{
                    this.tela.notificar("Agora eh a vez do jogador: " +idAdversario);
		}
		
	}
	

}

