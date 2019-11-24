/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rede;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import duelofarmslash.AtorJogador;
import duelofarmslash.Partida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kire
 */
public class AtorNetGames implements OuvidorProxy {

	private static final long serialVersionUID = 0L;
	protected AtorJogador atorJogador;
	protected Proxy proxy;

	public AtorNetGames(AtorJogador ator) {
            atorJogador = ator;
            proxy = Proxy.getInstance();
            proxy.addOuvinte(this);
	}

	public void conectar(String idJogador, String servidor) throws Exception {
            proxy.conectar(servidor, idJogador);
	}

	public void desconectar() throws NaoConectadoException {
            proxy.desconectar();
	}

	public void iniciarPartida() throws NaoConectadoException {
            proxy.iniciarPartida(2);
	}

	public void reiniciarPartida() throws NaoConectadoException, NaoJogandoException {
            proxy.reiniciarPartida();
	}

	public void iniciarNovaPartida(Integer posicao) {
		atorJogador.iniciarNovaPartida(posicao);
	}

	public void finalizarPartidaComErro(String message) {
		this.atorJogador.notificarErro("O seu adversario se desconectou da partida.");
	}

	public void receberMensagem(String msg) {
		atorJogador.notificar(msg);
	}

	public void receberJogada(Jogada jogada) {
		Partida partida = (Partida) jogada;
		try {
                    this.atorJogador.receberJogada(partida);
		} catch (NaoConectadoException e) {
			e.printStackTrace();
		} catch (NaoJogandoException e) {
			e.printStackTrace();
		}
               
	}

	public void tratarConexaoPerdida() {
		atorJogador.notificar("A Conexao foi perdida. Voce foi desconectado do servidor.");
	}

	public void tratarPartidaNaoIniciada(String message) {
		this.atorJogador.notificarErro(
				"Nao foi possivel iniciar um duelo.\n"
                              + "Nao existem outros jogadores conectados ao servidor.");
	}

	public String getNomeAdversario(int posicao) {
		return proxy.obterNomeAdversarios().get(0);
	}

	public void enviarJogada(Partida tab) throws NaoJogandoException {
		Jogada jogada = (Jogada) tab;
		proxy.enviaJogada(jogada);
	}

}