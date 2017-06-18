package jun.truco.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

	
	private int manilha;
	private Carta[] mesa;
	private int numerosCartas = 1;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Turno turno;
	private int JogadorQueComecaPartida = 0;
	private int partidas = 0;
	private int rodadasPorPartidas = 1;
	private int rodada = 0;
	private int maximoDeNumerosDeCarta = 10;
	
	private ForcaDasCartas forcaDasCartas;
	
	public Mesa(Jogador... j){
		
		for(Jogador jogador : j)
			jogadores.add(jogador);
			
			mesa = new Carta[jogadores.size()];
			turno = new Turno(factoryTurno(JogadorQueComecaPartida));
	}

	public void limpaMesa(){
		mesa = new Carta[jogadores.size()];
		forcaDasCartas.setMesa(mesa);
		forcaDasCartas.clear();
	}
	public void addJogador(Jogador... j){
		for(Jogador jogador : j)
		jogadores.add(jogador);
		
		mesa = new Carta[jogadores.size()];
		turno = new Turno(factoryTurno(JogadorQueComecaPartida));
		
	}
	
	
	public int NumerosJogadores(){
		return jogadores.size();
	}

	
	public void DarAsCartas(){
		
		factoryTurno(JogadorQueComecaPartida);
		Baralho b = new Baralho();
		jogadores.get(JogadorQueComecaPartida).embaralhar(b);
		for(Jogador j : turno.getJogador())
		jogadores.get(JogadorQueComecaPartida).DarAsCartas(b, j, numerosCartas);
	
	}
	
	
	public void vira(Carta c){
		int valor = c.getValor();
		if(valor < 0 || valor > 9)throw new ArrayIndexOutOfBoundsException();
		
		if(valor == 9)valor = 0;
		else
			valor++;
		
		manilha = valor;
		
	}
	
	public void ComeçarTurno(){
		forcaDasCartas = new ForcaDasCartas(mesa, manilha);
	}
	
	public String getManilha(){
		return Carta.Valor[manilha];
	}
	
	public void setNumerosCartas(int numerosCartas) {
		this.numerosCartas = numerosCartas;
	}
	
	public boolean hasRodada(){
		
		if(rodada == 0){
			turno = new Turno(factoryTurno(JogadorQueComecaPartida));
			rodada++;
			return true;
		}
		else if(rodada < rodadasPorPartidas){
			
			Jogador j	= forcaDasCartas.getJogadorFez();
			int posicaoDeQuemFez  = jogadores.indexOf(j);
			
			if(posicaoDeQuemFez == 0)posicaoDeQuemFez = jogadores.size()-1;
			else posicaoDeQuemFez--;
			turno = new Turno(factoryTurno(posicaoDeQuemFez));
			rodada++;
			
			return true;
		}
		else {
			partidas++;
			numerosCartas++;
			rodada = 0;
			if(numerosCartas == maximoDeNumerosDeCarta)numerosCartas = 2;
			JogadorQueComecaPartida++;
			if(JogadorQueComecaPartida == jogadores.size())JogadorQueComecaPartida = 0;
			
			return false;
		}
	}
	
	
	public int getPartidas() {
		return partidas;
	}


	public void setPartidas(int partidas) {
		this.partidas = partidas;
	}


	public int getRodadasPorPartidas() {
		return rodadasPorPartidas;
	}


	public void setRodadasPorPartidas(int rodadasPorPartidas) {
		this.rodadasPorPartidas = rodadasPorPartidas;
	}


	public int getRodada() {
		return rodada;
	}


	public void setRodada(int rodada) {
		this.rodada = rodada;
	}


	public int getNumerosCartas() {
		return numerosCartas;
	}


	private Jogador[] factoryTurno(int posicao){
		Jogador[] j = new Jogador[jogadores.size()];
		if(jogadores.size() <= 0)return null;
		int x = posicao+1;
		int index = 0;
		while(index < jogadores.size()){
			if(x == jogadores.size()){
				x = 0;
				j[index] = jogadores.get(x);
				index++; x++;
				continue;
			}
			j[index] = jogadores.get(x);
			x++; index++;
		}
		return j;
	}


	public Turno getTurno() {
		return turno;
	}


	/**
	 * @return the forcaDasCartas
	 */
	public ForcaDasCartas getForcaDasCartas() {
		return forcaDasCartas;
	}



}
