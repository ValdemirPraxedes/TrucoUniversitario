package jun.truco.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

	
	private int manilha;
	private Carta[] mesa;
	private int numerosCartas = 1;
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private Turno turno;
	private int rodadeJogador = 0;
	
	private ForcaDasCartas forcaDasCartas;
	
	public Mesa(Jogador... j){
		
		for(Jogador jogador : j)
			jogadores.add(jogador);
			
			mesa = new Carta[jogadores.size()];
			turno = new Turno(factoryTurno(rodadeJogador));
	}

	
	public void addJogador(Jogador... j){
		for(Jogador jogador : j)
		jogadores.add(jogador);
		
		mesa = new Carta[jogadores.size()];
		turno = new Turno(factoryTurno(rodadeJogador));
		
	}
	
	
	public int NumerosJogadores(){
		return jogadores.size();
	}

	
	public void DarAsCartas(){
		
		factoryTurno(rodadeJogador);
		Baralho b = new Baralho();
		jogadores.get(rodadeJogador).embaralhar(b);
		for(Jogador j : turno.getJogador())
		jogadores.get(rodadeJogador).DarAsCartas(b, j, numerosCartas);
	
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

	
	
	private Jogador[] factoryTurno(int posicao){
		Jogador[] j = new Jogador[jogadores.size()];
		if(jogadores.size() <= 0)return null;
		int x = posicao+1;
		int index = 0;
		while( x != posicao){
			if(x == jogadores.size()){
				x = 0;
				j[index] = jogadores.get(x);
				index++;
				continue;
			}
			j[index] = jogadores.get(x);
			x++; index++;
		}
		return j;
	}


	/**
	 * @return the forcaDasCartas
	 */
	public ForcaDasCartas getForcaDasCartas() {
		return forcaDasCartas;
	}



}
