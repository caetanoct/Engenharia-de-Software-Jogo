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
        protected InterfaceFarm telaFarm;
	protected InterfaceLoja telaLoja;
        
	public AtorJogador() {
            this.Partida = new Partida();
            this.tela = new TelaPrincipalDuel(this);
            this.rede = new AtorNetGames(this);
            
	}

	public void conectar(String idUsuario, String servidor) throws Exception {
            this.idUsuario = idUsuario;
            rede.conectar(idUsuario, servidor);
	}
	
	// Quem esta atacando
	public void realizaJogada () throws Exception{
            
            if (Partida.getJogador1().isJogadorDaVez()) {
                
                Partida.realizaJogada(Partida.getJogador1().getAtaque());
                tela.VidaBarra2.setValue(Partida.getJogador2().getVida());
                
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
             
            // Setando o proximo jogador.
            
            this.Partida.setJogador1(partida.getJogador2());
            this.Partida.setJogador2(partida.getJogador1());
            this.Partida.getJogador1().setJogadorDaVez(true);
            
            // Atualizando a barra de vida quando o jogador recebe um ataque.;
            
            tela.VidaBarra1.setValue(Partida.getJogador1().getVida());
            tela.Status.setText("Vida: "+Partida.getJogador1().getVida());
            
            // Verificando se o adversario venceu.
            
            if (this.Partida.getJogador2().isVencedor()) {
                this.notificar("Derrota!");
		this.Partida.setPartidaEmAndamento(false);
            }
            this.tela.notificar("É sua vez, "+this.Partida.getJogador1().getNome());
            
	}

	public void iniciarNovaPartida(Integer posicao) {
            
            String idAdversario = rede.getNomeAdversario(posicao);
            Partida = new Partida();
            Partida.criarJogadores(idUsuario, idAdversario, posicao);
            Partida.setPartidaEmAndamento(true);
            tela.ServidorItem.setEnabled(false);
            
            if (posicao == 1) {
                initJogador1(idAdversario);
            } else {
                initJogador2();
            } 

            
            if (Partida.getJogador1().isJogadorDaVez()){
                this.tela.notificar(Partida.getJogador1().getNome()+", eh sua vez de atacar.");
            } else{
                this.tela.notificar("Agora eh a vez do jogador: " +idAdversario);
            }

	}
        
    // Configuracao inicial do jogador1
    public void initJogador1(String idAdversario) {
        this.tela.notificar("Um duelo foi encontrado! O seu oponente eh:" + idAdversario);
        tela.iniciarPartida.setEnabled(false);
        tela.Perso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/person1.gif"))); // NOI18N
        tela.Perso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/person2.gif"))); // NOI18N
        tela.Perso1.setVisible(true);
        tela.Perso2.setVisible(true);
        tela.VidaBarra1.setValue(Partida.getJogador1().getVida());
        tela.VidaBarra2.setValue(Partida.getJogador2().getVida());
        tela.Ataque.setText("Ataque: "+Partida.getJogador1().getAtaque());
        tela.Status.setText("Vida: "+Partida.getJogador1().getVida());
        tela.Block.setText("Block: "+Partida.getJogador1().getBlock()+"%");
        tela.Creditos.setText("Creditos: "+Partida.getJogador1().getCreditos());
    }
    
    // Configuracao inicial do jogador2
    public void initJogador2() {
        this.tela.notificar("Um duelo foi encontrado! O seu oponente eh:"+ Partida.getJogador2().getNome() );
        tela.iniciarPartida.setEnabled(false);
        tela.Perso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/personMirror2.gif"))); // NOI18N
        tela.Perso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duelofarmslash/personMirror1.gif"))); // NOI18N
        tela.Perso1.setVisible(true);
        tela.Perso2.setVisible(true);
        tela.VidaBarra1.setValue(Partida.getJogador2().getVida());
        tela.VidaBarra2.setValue(Partida.getJogador1().getVida());
        tela.Ataque.setText("Ataque: "+Partida.getJogador2().getAtaque());
        tela.Status.setText("Vida: "+Partida.getJogador2().getVida());
        tela.Block.setText("Block: "+Partida.getJogador2().getBlock()+"%");
        tela.Creditos.setText("Creditos: "+Partida.getJogador2().getCreditos());
    }
    
    // Falta corrigir bugs
    public void iniciarFarm() {
        this.telaFarm = new InterfaceFarm(Partida.getJogador1());
        if(telaFarm == null) {
            System.out.println("Teste");
        }
    }
    // Falta terminar de implementar
    public void iniciarLoja() {
        this.telaLoja = new InterfaceLoja(Partida.getJogador1());
        if(telaLoja == null) {
            System.out.println("Teste");
        }
    }
    
    // Falta terminar de implementar
    public void atualizaStatus() {
        
    }
    
}

