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
        
	
	public AtorJogador() {
                this.Partida = new Partida();
		this.tela = new TelaPrincipalDuel(this);
		this.rede = new AtorNetGames(this);
                
	}

   
	
	public void conectar(String idUsuario, String servidor) throws Exception {
		this.idUsuario = idUsuario;
		rede.conectar(idUsuario, servidor);
	}
	
	
	public void realizaJogada () throws Exception{
        
            if (Partida.getJogador1().isJogadorDaVez()) {
                
                Partida.realizaJogada();
                tela.VidaBarra2.setValue(tela.VidaBarra2.getValue() - Partida.getJogador1().getAtaque());

                if (Partida.getJogador1().isVencedor()) {
                    this.notificar("Você venceu o duelo!");
                }

                this.enviarJogada();
                
            } else {
                throw new Exception("Não é sua vez de atacar");
            }
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
        


	public void receberJogada(Partida partida) throws NaoConectadoException, NaoJogandoException{
            this.Partida.setJogador1(partida.getJogador2());
            this.Partida.setJogador2(partida.getJogador1());
            this.Partida.getJogador1().setJogadorDaVez(true);
            if (this.Partida.getJogador2().isVencedor()) {
			this.notificar("Derrota!");
			this.Partida.setPartidaEmAndamento(false);
		}
            this.tela.notificar("É sua vez, "+this.Partida.getJogador1().getNome());
	}

	public void iniciarNovaPartida(Integer posicao) {
     
		Partida = new Partida();
                
		String idAdversario = rede.getNomeAdversario(posicao);
		Partida.criarJogadores(idUsuario, idAdversario, posicao);
		Partida.setPartidaEmAndamento(true);
              
                if (posicao == 1) {
                    initJogador1(idAdversario);
                } else {
                    initJogador2();
                } 
		

		tela.ServidorItem.setEnabled(false);
		if (Partida.getJogador1().isJogadorDaVez()){
                    this.tela.notificar(Partida.getJogador1().getNome()+", eh sua vez de atacar.");
		} else{
                    this.tela.notificar("Agora eh a vez do jogador: " +idAdversario);
		}
		
	}
        
    public void initJogador1(String idAdversario) {
        this.tela.notificar("Um duelo foi encontrado! O seu oponente eh:" + idAdversario);
        tela.iniciarPartida.setEnabled(false);
        tela.Perso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/person1.gif"))); // NOI18N
        tela.Perso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/person2.gif"))); // NOI18N
        tela.Perso1.setVisible(true);
        tela.Perso2.setVisible(true);
        tela.VidaBarra1.setValue(Partida.getJogador1().getVida());
        tela.VidaBarra2.setValue(Partida.getJogador2().getVida());
    }
    
    public void initJogador2() {
        this.tela.notificar("Um duelo foi encontrado! O seu oponente eh:"+ Partida.getJogador2().getNome() );
        tela.iniciarPartida.setEnabled(false);
        tela.Perso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/personMirror2.gif"))); // NOI18N
        tela.Perso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/personMirror1.gif"))); // NOI18N
        tela.Perso1.setVisible(true);
        tela.Perso2.setVisible(true);
        tela.VidaBarra1.setValue(Partida.getJogador2().getVida());
        tela.VidaBarra2.setValue(Partida.getJogador1().getVida());
    }
    
}

